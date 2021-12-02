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

public class SocketCubo implements Runnable {
	// Relaciones
	private Controlador ctrl;

	/* Constructor */
	public SocketCubo(Controlador ctrl) {
		// conectar el controlador
		this.ctrl = ctrl;
		Thread treadListener = new Thread(this);
		treadListener.start();

	}

	/* Client:Data >> Socket >> Server */
	public void socket(String msg) {
		try {

			Socket client = new Socket("192.168.0.6", 5000); // portSend 5000
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
				Gson gson = new Gson();
				Mensaje mensaje = gson.fromJson(msg, Mensaje.class);
				if (mensaje.getOpcion() == 3) {
					ctrl.setContinuar(false);
					ctrl.reiniciar();
				} else if (mensaje.getOpcion() == 1) {
					ctrl.setCuboRubik(mensaje.getCuboRubik());
					ctrl.setMovInicial(mensaje.getMovimiento());
					ctrl.setContinuar(true);
					ctrl.comenzar();
				}

				socket.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
		}
	}

}