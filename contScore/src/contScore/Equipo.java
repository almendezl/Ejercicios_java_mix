package contScore;

public class Equipo implements Comparable<Equipo>{
	private int equipo;
	private int problema;
	private int tiempo;
	private String letra;
	
	public Equipo (int equipo, int problema, int tiempo, String letra) {
		this.equipo = equipo;
		this.problema = problema;
		this.tiempo = tiempo;
		this.letra = letra;
	}
	
	public int getEquipo() {
		return equipo;
	}


	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}


	public int getProblema() {
		return problema;
	}


	public void setProblema(int problema) {
		this.problema = problema;
	}


	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}


	public String getLetra() {
		return letra;
	}


	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return equipo + " "+problema + " " + tiempo;
	}

	@Override
	public int compareTo(Equipo that) {
		if(this.equipo > that.equipo) {
			return 1;
		}
		if(this.equipo < that.equipo) {
			return -1;
		}
		return 0;
	}
	
	
	public int compareToF(Equipo that) { //en caso de no ordenarse correctamente revisar aqui o en la clase
		//equipo revisar el metodo ordenar
		
		if(this.problema > that.problema) {
			return 1;
		}
		if(this.problema < that.problema) {
			return -1;
		}
		if(this.tiempo > that.tiempo) {
			return 1;
		}
		if(this.tiempo < that.tiempo) {
			return -1;
		}
		if(this.equipo > that.equipo) {
			return 1;
		}
		if(this.equipo < that.equipo) {
			return -1;
		}
		return 0;
	}

}
