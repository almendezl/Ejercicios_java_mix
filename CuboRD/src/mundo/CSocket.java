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

	/* Constructor */
	public CSocket(Controlador ctrl) {
		// conectar el controlador
		this.ctrl = ctrl;

		Thread treadListener = new Thread(this);
		treadListener.start();

	}

	/* Client:Data >> Socket >> Server */
	public void socket(String msg) {
		try {

			Socket client = new Socket("192.168.1.59", 5050); // portSend 5000
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
					ctrl.setContinuar(false);
					ctrl.borrar();
				} else if (mensaje.getOpcion() == 1) {

					ctrl.setCuboRubik(mensaje.getCuboRubik());
					ctrl.setMovInicial(mensaje.getMovimiento());
					ctrl.setContinuar(true);
					ctrl.buscar();
				}
				socket.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
		}
	}

}