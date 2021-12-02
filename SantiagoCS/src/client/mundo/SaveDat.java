package client.mundo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class SaveDat {

	public static void saveDat(User user) {
		try {
			ObjectOutputStream userOutput = new ObjectOutputStream(new FileOutputStream("data/user.dat"));
			userOutput.writeObject(user);
			userOutput.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido guardar el .dat");
		}
		
	}

}
