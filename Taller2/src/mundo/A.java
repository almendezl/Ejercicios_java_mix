package mundo;

public class A {
//Relaciones
private B mib;
private C mic;

public A() {
	this.mic = new C (15); //crea C
	this.mib = new B(mic); // le manda c como parametro a b
	
}
//crear mmetodo funcional para traer a la var c

public int varA1() { 
	return mic.getVar();
}
public int varA2() { //traer la var de c a traves de B 
	return mib.varA();
}
}
