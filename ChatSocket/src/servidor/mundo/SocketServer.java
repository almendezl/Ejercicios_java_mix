package servidor.mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import complementos.Mensaje;
import complementos.PlainText;
import servidor.controlador.Controlador;

public class SocketServer implements Runnable {

	private static Controlador ctrl;
	// private String query;
	private static String ipCliente;
	private Mensaje mensaje;
	private static PlainText dir;

	public SocketServer(Controlador ctrl) {
		this.ctrl = ctrl;
		Thread treadListener = new Thread(this);
		treadListener.start();
		dir = new PlainText();
	}

	/* Server:Data >> Socket >> Client */
	public static void socket(String msg, String ipDestino) {
		try {
			

			Socket server = new Socket(ipDestino, 5050); // portSend 5050
			DataOutputStream outBuffer = new DataOutputStream(server.getOutputStream());
			outBuffer.writeUTF(msg);
			server.close();

		} catch (UnknownHostException e) {
			ctrl.actualizarPnlExc("Server : socket() : UnknownHostException: " + e.getMessage());
			
		} catch (IOException e) {
			ctrl.actualizarPnlExc( "Server : socket() : IOException: " + e.getMessage());
			//si llega a esta excepcion es porque el cliente no esta conectado entonces se almacena el dato
			ctrl.guardarMsj(msg);
		}
	}

	@Override
	/* Server: Listen */
	public void run() {
		ServerSocket serverSocket;
		Socket socket;
		DataInputStream inDataBuffer;

		try {
			serverSocket = new ServerSocket(5000); // portListen 5000

			while (true) {
				socket = serverSocket.accept();
				inDataBuffer = new DataInputStream(socket.getInputStream());
				String msg = inDataBuffer.readUTF();
				//System.out.println(msg);
				ctrl.recibirdato(msg);
				
				socket.close();
			}

		} catch (IOException e) {
			ctrl.actualizarPnlExc("Server : run (): IOException: " + e.getMessage());

		} 
	}

	/*public static void response(String msg) {
		socket(msg);
	}*/
}
