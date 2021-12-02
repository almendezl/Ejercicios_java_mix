package complementos;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class PlainText {
	//atributos 
	private String server;
	private String cliente;
	private static FileReader file;
	private BufferedReader buffer;
	
	
	public PlainText(){
		try {
			file = new FileReader("data/ip.txt");
			buffer = new BufferedReader(file);
			getContent();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error leyendo el txt");
		}
		
		
	}
	public void getContent() {
		try {
			server = buffer.readLine(); // la primera linea
			cliente = buffer.readLine(); // la segunda linea
			buffer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error leyendo el txt");
		}
		
	}

	public String getServer() {
		return server;
	}	
	public String getCliente() {
		return cliente;
	}	
}
