package interfaz;

import java.util.Arrays;

import mundo.A;

public class InterfazApp {
	//Relaciones
	private A mia;
public InterfazApp() {
	mia = new A();
	
	//Agregar 5 elementos al array de tipo b
	for (int i = 0; i < 6; i++) {
		mia.agregarArray(i+10);
	}
	mia.imprimir();
	mia.cambiarValorDeB(3, 20);
	mia.imprimir();
}
public static void main(String[] args) {
	InterfazApp i = new InterfazApp();
}
}
