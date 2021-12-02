package mundo;

public class B {
//Relaciones
	private C mic;
	
public B(C mic) {//la relacion por parametro, suponemos que la recibe por el constructor
	this.mic = mic;
}
//metodo para mostrar la var de c a traves de la relacion con A

public int varA() {
	return mic.getVar();
}
}
