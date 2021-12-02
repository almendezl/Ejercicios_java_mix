package client.mundo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

import client.controlador.Controlador;
import complementos.Transaction;

public class TuLlave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// relaciones
	private SocketClient socketC;
	private Controlador ctrl;
	private User user;

	// atributos

	public TuLlave(Controlador ctrl)  {
		this.ctrl = ctrl;
		socketC = new SocketClient(this.ctrl);
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream("data/user.dat"));
			user = (User)stream.readObject();
			stream.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error leyendo .dat");
		}
		
	}

	public void writeUser() {// escribir el usuario
		try {
			ObjectOutputStream userOutput = new ObjectOutputStream(new FileOutputStream("data/user.dat"));
			userOutput.writeObject(user);
			userOutput.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo dat");
		}

	}

	public User getUser() {
		return user;
	}
	public void  envSocket(String msg, Transaction reg) {
		socketC.socket(msg, reg);
	}

}
