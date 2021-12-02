package interfaz;

import controlador.Controlador;

public class InterfazApp {

	private Panel1 pnlPanel1;
	private Panel2 pnlPanel2;
	private Controlador ctrl;
	
	public InterfazApp(Controlador ctrl) {
		System.out.println("se crea la interfaz App");
		this.ctrl = ctrl;
		pnlPanel1 = new Panel1(this.ctrl);
		pnlPanel2 = new Panel2();
		this.ctrl.conectar(pnlPanel2);
		pnlPanel1.modificarVar();
		
	}

	public static void main(String[] args) {
		Controlador ctrl = new Controlador();
		InterfazApp interfazApp = new InterfazApp(ctrl);

	}
	
	
	public Panel1 getPnlPanel1() {
		return pnlPanel1;
	}

	public void setPnlPanel1(Panel1 pnlPanel1) {
		this.pnlPanel1 = pnlPanel1;
	}

	public Panel2 getPnlPanel2() {
		return pnlPanel2;
	}

	public void setPnlPanel2(Panel2 pnlPanel2) {
		this.pnlPanel2 = pnlPanel2;
	}

	public Controlador getCtrl() {
		return ctrl;
	}

	public void setCtrl(Controlador ctrl) {
		this.ctrl = ctrl;
	}
	
	
	
}
