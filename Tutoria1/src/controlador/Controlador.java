package controlador;

import interfaz.Panel2;
import mundo.A;

public class Controlador {

	private A mia;
	private Panel2 pnlPanel2;
	
	public Controlador() {//constructor
		mia = new A(20);
		System.out.println("Se creo el controlador");
	}

	public A getMia() {
		return mia;
	}

	public void setMia(A mia) {
		this.mia = mia;
	}
	
	public void conectar(Panel2 pnlPanel2) {
		this.pnlPanel2 = pnlPanel2;
	}


	public Panel2 getPnlPanel2() {
		return pnlPanel2;
	}

	public void setPnlPanel2(Panel2 pnlPanel2) {
		this.pnlPanel2 = pnlPanel2;
	}
	
	
}
