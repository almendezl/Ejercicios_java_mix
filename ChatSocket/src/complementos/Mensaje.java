package complementos;

public class Mensaje {
	private String nickOrigen;
	private String mensaje;
	private String nickDestino;
	
	public Mensaje(String nickOrigen, String mensaje, String nickDestino) {
		this.nickOrigen = nickOrigen;
		this.mensaje = mensaje;
		this.nickDestino = nickDestino;
	}

	public String getNickOrigen() {
		return nickOrigen;
	}

	public void setNickOrigen(String nickOrigen) {
		this.nickOrigen = nickOrigen;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNickDestino() {
		return nickDestino;
	}

	public void setNickDestino(String nickDestino) {
		this.nickDestino = nickDestino;
	}

	@Override
	public String toString() {
		return "Nick-Origen: " + nickOrigen + ", Mensaje: " + mensaje + ", Nick-Destino: " + nickDestino;
	}
	
	
}
