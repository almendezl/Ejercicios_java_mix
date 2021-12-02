package InterfazApp;

import mundo.A;

public class InterfazApp {
//relaciones
	private A mia;
	
	public InterfazApp() {
		mia = new A(20);
		System.out.println("Var de A: "+mia.getVar());
		System.out.println("Var de B: "+ mia.mostrarVarB());
	}
	public static void main(String[] args) {
		InterfazApp i = new InterfazApp();
	}
}
