package cliente.mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import cliente.controlador.Controlador;
import complementos.PlainText;
import complementos.Mensaje;

public class SocketCliente implements Runnable {
	// relaciones
	private Controlador ctrl;

	// atributos
	private static PlainText dir;
	private Mensaje mensaje;

	public SocketCliente(Controlador ctrl) {
		this.ctrl = ctrl;
		Thread treadListener = new Thread(this);
		treadListener.start();

		dir = new PlainText();

	}

	/* Client:Data >> Socket >> Server */
	public void socket(String msg) {
		try {

			String ip = dir.getServer();

			Socket client = new Socket(ip, 5000); // portSend 5000
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
			serverSocket = new ServerSocket(5050); // portListen 5050

			while (true) {
				socket = serverSocket.accept();
				inDataBuffer = new DataInputStream(socket.getInputStream());
				String msg = inDataBuffer.readUTF();
				ctrl.recibirDato(msg);
				socket.close();
				
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
		} 
	}

	public Controlador getCtrl() {
		return ctrl;
	}

	public void setCtrl(Controlador ctrl) {
		this.ctrl = ctrl;
	}

	public static PlainText getDir() {
		return dir;
	}

	public static void setDir(PlainText dir) {
		SocketCliente.dir = dir;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}


}
