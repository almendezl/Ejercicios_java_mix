package interfaz;

import controlador.Controlador;

public class InterfazApp {
	//Relaciones 
	private static PanelOperandos pnlOperandos;
	private PanelOperadores pnlOperadores;
	private PanelResultado pnlResultado;
	
public InterfazApp(Controlador ctr) {
	pnlOperandos = new PanelOperandos();
	pnlOperadores = new PanelOperadores();
	pnlResultado = new PanelResultado();
	
}
public static void main(String[] args) {
	InterfazApp i = new InterfazApp(new Controlador(pnlOperandos));
}
}
