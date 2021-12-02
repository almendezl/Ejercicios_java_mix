package complementos;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class PlainText {
	//atributos 
	private String server;
	private String cliente;
	private String nickOrigen;
	private String nickDestino;
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
			server = buffer.readLine();
			cliente = buffer.readLine();
			nickOrigen = buffer.readLine();
			nickDestino = buffer.readLine();
			buffer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error leyendo el txt");
		}
		
	}
	

	public String getNickOrigen() {
		return nickOrigen;
	}
	public void setNickOrigen(String nickOrigen) {
		this.nickOrigen = nickOrigen;
	}
	public String getNickDestino() {
		return nickDestino;
	}
	public void setNickDestino(String nickDestino) {
		this.nickDestino = nickDestino;
	}
	public String getServer() {
		return server;
	}	
	public String getCliente() {
		return cliente;
	}	
}
