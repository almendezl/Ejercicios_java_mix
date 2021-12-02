package mundo;

public class A {
	//Relaciones
	private B mib;
public A() {
	mib = new B(15);
}

public int varDeB() {
	return mib.getVar();
}
public void cambiarVarDeB(int var) {
	mib.setVar(var);
}

}
