package server.mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import complementos.Conexiondb;
import complementos.Transaction;
import server.controlador.Controlador;

public class SocketServer implements Runnable {

	// atributos
	private Controlador ctrl;
	private Transaction trans;
	private Conexiondb db;
	private String query;
	private static String ipCliente;
	private int contadorZ;
	private int contadorC;
	private boolean trasbordo;
	private int prestamo;
	// constantes
	private final int ZON = 2400;
	private final int COM = 2200;

	public SocketServer(Controlador ctrl) {
		this.ctrl = ctrl;
		Thread treadListener = new Thread(this);
		treadListener.start();
		ipCliente = "";
	}

	/* Server:Data >> Socket >> Client */
	public static void socket(String msg) {
		try {
			Socket server = new Socket(ipCliente, 5050); // portSend 5050
			DataOutputStream outBuffer = new DataOutputStream(server.getOutputStream());
			outBuffer.writeUTF(msg);
			server.close();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Server : socket() : UnknownHostException: " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server : socket() : IOException: " + e.getMessage());
		}
	}

	@Override
	/* Server: Listen */
	public void run() {
		ServerSocket serverSocket;
		Socket socket;
		DataInputStream inDataBuffer; // recibir string
		ObjectInputStream inObBuffer; // recibir objeto

		try {
			serverSocket = new ServerSocket(5000); // portListen 5000

			while (true) {
				socket = serverSocket.accept();
				inDataBuffer = new DataInputStream(socket.getInputStream()); // datos
				inObBuffer = new ObjectInputStream(socket.getInputStream()); // objetos
				ipCliente = inDataBuffer.readUTF();
				String msg = inDataBuffer.readUTF();
				Object myObject = inObBuffer.readObject();
				trans = (Transaction) myObject;
				if (msg.equals("0")) {
					recargar();
					response("Recarga exitosa");
				} else if (msg.equals("1")) {

				} else if (msg.equals("2")) {
					pagar(0); // para pago zonal
				} else if (msg.equals("3")) {
					pagar(1); // para pago complementario
				} else {
					socket.close();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server : run (): IOException: " + e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void response(String msg) {
		socket(msg);
	}

	public void recargar() throws SQLException {
		db = new Conexiondb();

		query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
				+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , "
				+ trans.getValor() + " , '" + trans.getFecha() + "', '" + trans.getHora() + "'," + trans.getBalance()
				+ " )";
		db.setValues(query);
		//ctrl.actPnlTr(trans.getId());
		db.update(trans.getId(), "p", 0);
		
	    prestamo = 0;// db.update(trans.getId(), "p", 0);
	}

	public boolean compPago(int valor) { //para verificar si hay saldo y si hace prestamo
		/**
		 * Si no se tiene el saldo completo para iniciar el servicio de transporte
		 * “Zonal o Complementario / SITP”, el sistema le presta la primera vez, si
		 * vuelve a pasar por otra máquina de pago, el sistema vuelve y le presta por
		 * segunda vez. La tercera vez es obligado a recargar como mínimo, el valor
		 * pendiente más el valor de un tiquete.
		 **/
		db = new Conexiondb();
		prestamo = db.consultan(trans.getId(), "p");
		boolean rta = false;
		if(trans.getBalance()-valor >= 0) {
			rta = true;
		}else if(trans.getBalance()-valor < 0 && prestamo <= 1) {
			prestamo++; db.update(trans.getId(), "p", prestamo);
			rta = true; 
		}else if(trans.getBalance()-valor < 0 && prestamo == 2) {
			rta = false;
			//no hay saldo
		}
		return rta;
	}
	public void pagar(int opcion) {
		db = new Conexiondb();
		contadorZ = db.consultan(trans.getId(), "Z");
		contadorC = db.consultan(trans.getId(), "C");
		trasbordo = db.consultan(trans.getId(), "t") == 1?true:false;
		if(opcion == 0){ //para el zonal
			if(contadorC > 0 && compPago(ZON-COM) && trasbordo == true) {
				/**
				 * Si se toma el servicio “Zonal” después de haber tomado anteriormente el
				 * servicio “Complementario / SITP”, el sistema descontara el valor del
				 * transbordo, es decir $200. REGLA 4.
				 **/
				query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , "
						+ (ZON - COM) + " , '" + trans.getFecha() + "', '" + trans.getHora() + "',"
						+ (trans.getBalance() - (ZON - COM)) + " )";
				response("p1");
				sendDataDB();
				trasbordo = false; db.update(trans.getId(), "t", 0);
			}else if(((contadorC == 0 && trasbordo == false) || (trasbordo==true && contadorZ == 1)) && compPago(ZON)) {
				/**
				 * Si se toma el servicio “Zonal” sin haber tomado anteriormente el servicio
				 * “Complementario / SITP”, el sistema descontara el valor total del tiquete, es
				 * decir $2.400. REGLA 1
				 **/
				query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , " + ZON
						+ " , '" + trans.getFecha() + "', '" + trans.getHora() + "'," + (trans.getBalance() - ZON)
						+ " )";
				response("p2");
				sendDataDB(); trasbordo = true; db.update(trans.getId(), "t", 1);
				
			}
			db.update(trans.getId(), "Z",1);
			db.update(trans.getId(), "C",0);
			contadorZ = 1; contadorC = 0;
		}else if(opcion == 1){  //para el complementario 
			/**
			 * Si se toma el servicio “Complementario / SITP” y después se vuelve a tomar
			 * nuevamente el servicio “Complementario / SITP”, pueden ocurrir dos
			 * situaciones:  La segunda vez, el sistema no cobra ningún cargo.  La tercera
			 * vez, el sistema cobrará $2.200.
			 **/
			if((trasbordo == true && contadorZ == 1) || (contadorC==1 && trasbordo==true)) {
				/**
				 * Si se toma el servicio “Complementario / SITP” después de haber tomado
				 * anteriormente el servicio “Zonal”, el sistema le descontara $0.
				 * REGLA 2
				 **/
				query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , " + 0
						+ " , '" + trans.getFecha() + "', '" + trans.getHora() + "'," + trans.getBalance() + " )";
				response("p3");
				sendDataDB();
				contadorC = 1;
				db.update(trans.getId(), "C",1); trasbordo = false; db.update(trans.getId(), "t", 0);
				
			}else if( compPago(COM) && trasbordo == false) {
				/**
				 * Si se toma el servicio “Complementario / SITP” sin haber tomado anteriormente
				 * el servicio “Zonal”, el sistema le descontara el valor del tiquete menos el
				 * valor del transbordo, es decir $2.200.
				 **/
				query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , " + COM
						+ " , '" + trans.getFecha() + "', '" + trans.getHora() + "'," + (trans.getBalance() - COM)
						+ " )";
				response("p6");
				sendDataDB();
				db.update(trans.getId(), "C",1);
				contadorC = 1;
				trasbordo = true; db.update(trans.getId(), "t", 1);
			}else if(contadorC == 1 && trasbordo==true) {
				/**
				 * Regla 5 a, no coba la segunda vez el sitp
				 * **/
				query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , " + 0
						+ " , '" + trans.getFecha() + "', '" + trans.getHora() + "'," + trans.getBalance() + " )";
				response("p3");
				sendDataDB();
				contadorC = 1;
				db.update(trans.getId(), "C",1); trasbordo = false; db.update(trans.getId(), "t", 0);
			}else if(contadorC == 1 && trasbordo== false && compPago(COM)) {
				/**
				 * Regla 5 b, cobra la tercera vez
				 * **/
				query = "INSERT INTO transactions (idCard, id, TransactionType, vlrTransaction, date , time, balance) VALUES ("
						+ "'" + trans.getIdCard() + "', '" + trans.getId() + "', '" + trans.getTipo() + "' , " + COM
						+ " , '" + trans.getFecha() + "', '" + trans.getHora() + "'," + (trans.getBalance() - COM)
						+ " )";
				response("p6");
				sendDataDB();
				db.update(trans.getId(), "C",1);
				contadorC = 1;
				trasbordo = true; db.update(trans.getId(), "t", 1);
			}
		}
	}



	public void sendDataDB() {
		db = new Conexiondb();
		db.setValues(query);
		//ctrl.actPnlTr(trans.getId());
	}
}
