package mundo;

import java.util.ArrayList;
import java.util.Iterator;

public class A {
//Relaciones
	private ArrayList<B> mib;
	
	public A() {
		mib = new ArrayList<B>();
	}
	//metodos funcionales
	public ArrayList<B> datosDeB() {
		return mib;
	}
	public void cambiarValorDeB(int pos, int var) {
		mib.get(pos).setVar(var);
		
	}
	public int obtenerValorDeB(int pos) {
		return mib.get(pos).getVar();
	}
	public void agregarArray(int var) {
		mib.add(new B(var));
	}
	public void imprimir() {
		for(B b: mib) {
			System.out.print(b.getVar()+"\t");
		}
		System.out.println();
	}
}
