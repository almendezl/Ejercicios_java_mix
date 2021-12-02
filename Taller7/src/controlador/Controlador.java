package controlador;

import interfaz.PanelOperadores;
import interfaz.PanelOperandos;
import interfaz.PanelResultado;
import mundo.Dividir;

public class Controlador {
	//Relaciones
	private Dividir dividir;
	private PanelOperandos pnlOperandos;
	private PanelOperadores pnlOperadores;
	private PanelResultado pnlResultado;
	
public Controlador(PanelOperandos pnlOperandos) {
	dividir = new Dividir();
	this.pnlOperandos = pnlOperandos;
}
public void conectar(PanelOperadores pnlOperadores, PanelResultado pnlResultado) {
	this.pnlOperadores = pnlOperadores;
	this.pnlResultado = pnlResultado;
}

}
