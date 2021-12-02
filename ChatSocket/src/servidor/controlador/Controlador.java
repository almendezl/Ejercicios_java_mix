package servidor.controlador;

import com.google.gson.Gson;
import complementos.Encriptar;
import complementos.Mensaje;
import servidor.interfaz.PanelConversacion;
import servidor.interfaz.PanelErrores;
import servidor.mundo.BaseDatos;
import servidor.mundo.SocketServer;

public class Controlador {

	private PanelConversacion pnlConversacion;
	private PanelErrores pnlErrores;
	private SocketServer socketS;
	private BaseDatos db;

	public Controlador() {
		socketS = new SocketServer(this);
	}

	public void conectarPaneles(PanelErrores pnlErrores, PanelConversacion pnlConversacion) {
		this.pnlConversacion = pnlConversacion;
		this.pnlErrores = pnlErrores;
	}


	public void recibirdato(String msg) { 
		//recibe un json y lo convierte a tipo mensaje
		Gson gson = new Gson();
		Mensaje msj = (Mensaje) gson.fromJson(msg, Mensaje.class);
		//desencripta el mensaje
		msj.setMensaje(Encriptar.desencriptaMensaje(msj.getMensaje()));
		//verifica si es un mensaje de estado activo del cliente
		String[] llegada = msj.getMensaje().split(" ");
		
		if (llegada[0].equalsIgnoreCase("ACTIVO")) { // es un mensaje de estado
			db = new BaseDatos(this);		
			db.consultaUsuario(msj.getNickOrigen(), llegada[1]); //consulta si ya esta o no en la db y verifica su ip

		}else { //si no es de estado, es un mensaje normal y hay que enviarlo si el user esta, si no esta se almacena 
			msj.setMensaje(Encriptar.encriptaMensaje(msj.getMensaje()));//ecripta porq estaba desencriptado
			db = new BaseDatos(this);
			String ipDestino = db.traerIp(msj.getNickDestino());
			
			//buscar si el nick de destino tiene la ip en la base de datos
			if(!ipDestino.equals("") && !ipDestino.equals("-1")) { //si la ip esta en la db envia el mensaje
				SocketServer.socket(gson.toJson(msj).toString(), ipDestino); //convierte a json y envia a su destino
				
				
			}else { //de lo contrario almacena los mensajes encriptados en la db
				db.guardaMensaje(msj.getMensaje(), msj.getNickDestino(), msj.getNickOrigen());
				System.out.println("guardo el mensaje de daniela");
			}
			
			//finalmente muestra el mensaje en el panel del servidor
			msj.setMensaje(Encriptar.desencriptaMensaje(msj.getMensaje()));
			actualizarConversacion(msj);
			//respuesta del server al cliente
			Mensaje rta = new Mensaje("Server", Encriptar.encriptaMensaje("Enviado"), msj.getNickOrigen());
			//traer la ip del nick que llego para notificarle que el mensaje fue enviado
			ipDestino = db.traerIp(rta.getNickDestino());
			if(!ipDestino.equals("") && !ipDestino.equals("-1")) {
				SocketServer.socket(gson.toJson(rta).toString(), ipDestino);
			}else {
				actualizarPnlExc("No se encontro la ip de destino");
			}
			//mostrar en el panel la respuesta del server
			rta.setMensaje("Enviado");
			actualizarConversacion(rta);
			
		}



	}

	public void guardarMsj(String msg) {
		db = new BaseDatos(this);
		Gson gson = new Gson();
		Mensaje msj = (Mensaje) gson.fromJson(msg, Mensaje.class);
		
		db.guardaMensaje(msj.getMensaje(), msj.getNickDestino(), msj.getNickOrigen());
	
	}
	
	
	
	public SocketServer getSocketS() {
		return socketS;
	}

	public void setSocketS(SocketServer socketS) {
		this.socketS = socketS;
	}

	public void actualizarPnlExc(String mensaje) {
		pnlErrores.getLblErrores().setText(pnlErrores.getLblErrores().getText()+"\n"+mensaje);
	}
	
	public void actualizarConversacion(Mensaje msj) {
		pnlConversacion.getLblConversacion().setText(pnlConversacion.getLblConversacion().getText()+ "\n"+ msj.getNickOrigen()+": "+ msj.getMensaje());
	}

	public PanelConversacion getPnlConversacion() {
		return pnlConversacion;
	}

	public void setPnlConversacion(PanelConversacion pnlConversacion) {
		this.pnlConversacion = pnlConversacion;
	}

	public PanelErrores getPnlErrores() {
		return pnlErrores;
	}

	public void setPnlErrores(PanelErrores pnlErrores) {
		this.pnlErrores = pnlErrores;
	}
	
	
}
