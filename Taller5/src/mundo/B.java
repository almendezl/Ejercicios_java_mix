package mundo;

public class B {
	//Atributos
	private int varB;
	//Relaciones 
	private A mia;
	
	public B(int varB) {
		this.varB = varB;
	}
	public int getVar() {
		return varB;
	}
	public void setVar(int varB) {
		this.varB = varB;
	}
	public void connect(A mia) {
		this.mia = mia;
	}
}
