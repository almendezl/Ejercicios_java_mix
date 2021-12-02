package controlador;

import mundo.Calculos;
import vista.InterfazApp;

public class Controlador {

	private Calculos calculos;
	private InterfazApp interfazApp;
	
	public Controlador(Calculos calculo, InterfazApp interfazApp) {
		this.calculos = calculo;
		this.interfazApp = interfazApp;
	}
	
	 public void iniciar() {
	        interfazApp.setTitle("Calcular Enlace Satelital");
	        interfazApp.setVisible(true);
	    }
	
	 //aqui se implementan los action listener
}
