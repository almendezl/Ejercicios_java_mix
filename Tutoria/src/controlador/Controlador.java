package controlador;

import mundo.Suma;
import vista.InterfazSuma;

public class Controlador {
	
	private InterfazSuma pnlSuma;
	private Suma suma;
	
	public Controlador() {
		suma = new Suma(0, 0);
	}
	
	public void conectar(InterfazSuma pnlSuma) {
		this.pnlSuma = pnlSuma;
	}

	public InterfazSuma getPnlSuma() {
		return pnlSuma;
	}

	public void setPnlSuma(InterfazSuma pnlSuma) {
		this.pnlSuma = pnlSuma;
	}

	public Suma getSuma() {
		return suma;
	}

	public void setSuma(Suma suma) {
		this.suma = suma;
	}
	
	

}
