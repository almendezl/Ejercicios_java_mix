package mundo;

public class A {
	private B mib[];
public A() {
	mib = new B[15];
	for (int i = 0; i < mib.length; i++) {
		mib[i] = new B(i+1); 
	}
	
}

public int accederADatosDeB(int pos) {
	return mib[pos].getVar();
}
public void cambiarDatoDeB(int var, int pos) {
	mib[pos].setVar(var);
}

public B[] datosDeB() {
	return mib;
}
public void imprimirB() {
	for (int i = 0; i < mib.length; i++) {
		System.out.print(mib[i].getVar()+ "\t");
	}
	System.out.println();
}
}
