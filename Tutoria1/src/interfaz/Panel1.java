package interfaz;

import controlador.Controlador;

public class Panel1 {

	private Controlador ctrl;
	
	public Panel1(Controlador ctrl) {
		this.ctrl = ctrl;
		System.out.println("Se creo el panel 1");
	}

	public Controlador getCtrl() {
		return ctrl;
	}

	public void setCtrl(Controlador ctrl) {
		this.ctrl = ctrl;
	}
	
	public void modificarVar() {
		ctrl.getMia().setVar(400);
		ctrl.getPnlPanel2().visualizar(ctrl.getMia().getVar());
	}
	
	
}
