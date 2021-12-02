package client.mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import client.controlador.Controlador;
import complementos.PlainText;
import complementos.Transaction;

public class SocketClient implements Runnable {

	// relaciones
	private Controlador ctrl;

	// atributos
	private static PlainText dir;

	public SocketClient(Controlador ctrl) {
		this.ctrl = ctrl;
		Thread treadListener = new Thread(this);
		treadListener.start();

		try {
			dir = new PlainText();
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo de texto plano");
		}
	}

	/* Client:Data >> Socket >> Server */
	public void socket(String msg, Transaction trans) {
		try {
			String ip = dir.getServer();
			String ipCliente = dir.getCliente();
			Socket client = new Socket(ip, 5000); // portSend 5000
			DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());
			ObjectOutputStream outBuffer2 = new ObjectOutputStream(client.getOutputStream());

			outBuffer.writeUTF(ipCliente);
			outBuffer.writeUTF(msg);
			outBuffer2.writeObject(trans);
			
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
				inDataBuffer = new DataInputStream(socket.getInputStream()); // datos
				String msg = inDataBuffer.readUTF();
				// System.out.println(msg);
				if (msg.equals("Recarga exitosa")) {
					actRecarga();
					//JOptionPane.showMessageDialog(null, "Recarga Exitosa!!!");

				} else if (msg.equals("p1") || msg.equals("p2")) {
					actPago(msg);
					//JOptionPane.showMessageDialog(null, "Pago zonal exitoso!!!");
				}else if(msg.equals("p3") || msg.equals("p4") || msg.equals("p5") || msg.equals("p6")) {
					actPago(msg);
					//JOptionPane.showMessageDialog(null, "Pago complementario exitoso!!!");
				}
				socket.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
		}
	}

	public void actRecarga() {
		ctrl.actDatRecarga();
	}

	public void actPago(String op) {
		ctrl.actPago(op);
	}
}
