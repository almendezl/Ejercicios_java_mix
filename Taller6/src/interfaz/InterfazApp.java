package interfaz;

import controlador.Controlador;

public class InterfazApp {
//Relaciones
	private Panel1 p1;
	private Panel2 p2;
	private Controlador ctrl;
	
	public InterfazApp(Controlador ctrl) {//recibe un controlaror
		this.ctrl = ctrl;
		p2 = new Panel2();
		p1 = new Panel1(this.ctrl);
		
		System.out.println("Se creo interfaz");
	}
	public static void main(String[] args) {
		
		InterfazApp i = new InterfazApp(new Controlador()); //pasarlo como parametro
	}
}
