package mundo;

public class A {

	private int var;
	
	public A(int var) {// constructor, inicializar los atributos
		this.var = var;
		System.out.println("Se creo A");
	}

	public int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}
	
	
}
