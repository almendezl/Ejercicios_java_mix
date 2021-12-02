package controlador;

import interfaz.Panel2;
import mundo.A;

public class Controlador {
	//relaciones
	private A mia;
	private Panel2 p2;
	
public Controlador() {
	mia = new A(10);
	System.out.println("Se creo controlador");
}
public void Conectar(Panel2 p2) { //estas conexiones porque se asocian con las clases que ya estan conectadas con el controlador
	this.p2 = p2;
}
public int mostrarVarA() {
	return mia.getVar();
}
public void cambiarVarA(int var) {
	mia.setVar(var);
}
}
