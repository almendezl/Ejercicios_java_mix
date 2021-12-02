package cliente.controlador;

import cliente.interfaz.PanelEnviar;
import cliente.mundo.SocketCliente;
import complementos.Encriptar;
import complementos.Mensaje;
import complementos.PlainText;

import com.google.gson.Gson;

import cliente.interfaz.PanelConversacion;

public class Controlador {

	private PanelConversacion pnlConversacion;
	private PanelEnviar pnlEnviar;
	private SocketCliente socketCl;
	private static PlainText dir;

	public Controlador() {

		socketCl = new SocketCliente(this);
		dir = new PlainText();
		
	}

	public void enviardato(String mensaje) {
		//recibe el string normal y lo pasa a json
		Gson gson = new Gson();
		Mensaje msj = new Mensaje(dir.getNickOrigen(), Encriptar.encriptaMensaje(mensaje), dir.getNickDestino());

		socketCl.socket(gson.toJson(msj).toString());
		pnlEnviar.getTxtMensaje().setText("");
		msj.setMensaje(mensaje);
		actualizarConversacion(msj);
		
	}
	
	public void actualizarConversacion(Mensaje msj) {
		pnlConversacion.getLblConversacion().setText(pnlConversacion.getLblConversacion().getText()+ "\n"+ msj.getNickOrigen()+": "+ msj.getMensaje());
	}
	
	public void recibirDato(String msg) {
		//recibe el json y lo convierte a la clase mensaje
		Gson gson = new Gson();
		Mensaje msj = (Mensaje) gson.fromJson(msg, Mensaje.class);
	
		//desencripta el mensaje
		msj.setMensaje(Encriptar.desencriptaMensaje(msj.getMensaje()));
		actualizarConversacion(msj);
		
	}
	
	public SocketCliente getSocketCl() {
		return socketCl;
	}

	public void setSocketCl(SocketCliente socketCl) {
		this.socketCl = socketCl;
	}

	public void conectarPaneles(PanelEnviar pnlEnviar, PanelConversacion pnlConversacion) {
		this.pnlConversacion = pnlConversacion;
		this.pnlEnviar = pnlEnviar;

	}

	public PanelConversacion getPnlConversacion() {
		return pnlConversacion;
	}

	public void setPnlConversacion(PanelConversacion pnlConversacion) {
		this.pnlConversacion = pnlConversacion;
	}

	public PanelEnviar getPnlEnviar() {
		return pnlEnviar;
	}

	public void setPnlEnviar(PanelEnviar pnlEnviar) {
		this.pnlEnviar = pnlEnviar;
	}

	public static PlainText getDir() {
		return dir;
	}

	public static void setDir(PlainText dir) {
		Controlador.dir = dir;
	}

	
}
