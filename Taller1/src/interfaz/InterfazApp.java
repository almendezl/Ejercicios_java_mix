package interfaz;

import mundo.A;

public class InterfazApp {
	//Relaciones
	private A mia;  
	
	public InterfazApp() { 
		mia = new A();
		System.out.println(mia.varDeB());
		mia.cambiarVarDeB(20);
		System.out.println(mia.varDeB());
	}
public static void main(String[] args) {
	InterfazApp i = new InterfazApp ();
	
	
}
}
