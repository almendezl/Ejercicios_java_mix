package mundo;

public class A {
//Atributos 
private int var;

//Relaciones
public A(int var) {
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
