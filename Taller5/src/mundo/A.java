package mundo;

public class A {
//Atributos
	private int varA;
//Relaciones
	private B mib;
	
	public A(int varA) {
		this.varA = varA;
		mib = new B(30);
	}
	public int getVar() {
		return varA;
	}
	public void setVar(int varA) {
		this.varA = varA;
	}
	public int mostrarVarB() {
		return mib.getVar();
	}
	public void cambiarVarB(int var) {
		mib.setVar(var);
	}
}
