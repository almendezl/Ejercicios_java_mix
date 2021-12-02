package interfaz;

import mundo.*;

public class InterfazApp {
	//Relaciones
private A mia;

public InterfazApp() {
	mia = new A ();
	System.out.println(mia.varA1());//llama a mic para traer su valor
	System.out.println(mia.varA2()); //llama a mib para traer el dato de c
}

public static void main(String[] args) {
	InterfazApp i = new InterfazApp();

}
}
