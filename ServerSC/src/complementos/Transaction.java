package complementos;

import java.io.Serializable;

public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// atributos
	private String tipo;
	private final String id;
	private final String idCard;
	private int valor;
	private String fecha;
	private String hora;
	private int balance;

	public Transaction(String tipo, String id, String idCard, int valor, String fecha, String hora, int balance) {
		this.tipo = tipo;
		this.id = id;
		this.idCard = idCard;
		this.valor = valor;
		this.fecha = fecha;
		this.hora = hora;
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public String getIdCard() {
		return idCard;
	}


	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
