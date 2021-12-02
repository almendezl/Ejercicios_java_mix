package client.mundo;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//relaciones
	
	//atributos
	private String nombre;
        private String apellido;
	private String cedula;
	private String idTarjeta;
	private int saldo;
	
	public User(String nombre,String apellido, String cedula, String idTarjeta, int saldo) {
		this.nombre = nombre;
                this.apellido = apellido;
		this.cedula = cedula;
		this.idTarjeta = idTarjeta;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	

}
