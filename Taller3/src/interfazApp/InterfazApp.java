package interfazApp;
// hacerlo Revisarlo la otra clase 

import java.util.Arrays;

import mundo.A;

public class InterfazApp {
	private A mia; 
public InterfazApp() {
	mia = new A();
	mia.imprimirB();
	for (int i = 0; i < mia.datosDeB().length; i++) {
		mia.cambiarDatoDeB(i+10, i);
	}
	mia.imprimirB();
}
public static void main(String[] args) {
	InterfazApp i = new InterfazApp();
}
}
