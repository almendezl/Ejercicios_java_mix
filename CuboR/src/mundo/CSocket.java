package mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import controlador.Controlador;

public class CSocket implements Runnable {
	// Relaciones
	private Controlador ctrl;
	private String ipServer;

	/* Constructor */
	public CSocket(Controlador ctrl, String ipServer) {
		// conectar el controlador
		this.ctrl = ctrl;
		this.ipServer = ipServer;

		Thread treadListener = new Thread(this);
		treadListener.start();

	}

	/* Client:Data >> Socket >> Server */
	public void socket(String msg) {
		try {

			Socket client = new Socket(ipServer, 5050); // portSend 5000
			DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());

			outBuffer.writeUTF(msg);
			client.close();

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Client: socket(1) : UnknownHostException: " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client: socket(2) : IOException: " + e.getMessage());
		}
	}

	@Override
	/* Client: Listen */
	public void run() {
		ServerSocket serverSocket;
		Socket socket;
		DataInputStream inDataBuffer;

		try {
			serverSocket = new ServerSocket(5000); // portListen 5050

			while (true) {
				socket = serverSocket.accept();
				inDataBuffer = new DataInputStream(socket.getInputStream());
				String msg = inDataBuffer.readUTF();
				Gson gson = new Gson();
				Mensaje mensaje = gson.fromJson(msg, Mensaje.class);
				if (mensaje.getOpcion() == 3) {
					//System.out.println("El server manda stop");
					ctrl.setContinuar(false);
					ctrl.limpiar();
					ctrl.getPanel().setLblmensajes("El server manda stop");
				} else if (mensaje.getOpcion() == 1) {
					//System.out.println("llego la info del server");
					// Enviar el cubo dar inicio
					ctrl.setCuboRubik(mensaje.getCuboRubik());
					//mensaje.getCuboRubik().imprimir();
					ctrl.setMovInicial(mensaje.getMovimiento());
					//System.out.println(mensaje.getMovimiento());
					ctrl.setContinuar(true);
					ctrl.Iniciar();
					ctrl.getPanel().setLblmensajes("Llego la informacion del servidor");
				}

				//System.out.println(mensaje.getIp());
				socket.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
		}
	}
	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}

}