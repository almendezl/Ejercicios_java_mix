package mundo;

import java.util.Scanner;

import tdas.RedimensionableArrayQueue;
import tdas.RedimensionableArrayStack;

 public class InterfazApp {

	private RedimensionableArrayQueue<String> colaEntrada; // aqui se almacena la entrada del usuario
	private RedimensionableArrayQueue<String> colaSalida; // aqui se reorganizan los datos ingresados
	private RedimensionableArrayStack<String> pila; // sirve para ordenar los operadores

	public InterfazApp(RedimensionableArrayQueue<String> colaEntrada) { // se pide la cola de entrada ya que es la que
																		// el usuario ingresa
		this.colaEntrada = colaEntrada;
		colaSalida = new RedimensionableArrayQueue<>();
		pila = new RedimensionableArrayStack();
	}

	public static void main(String[] args) {
		RedimensionableArrayQueue<String> colaEntrada = new RedimensionableArrayQueue<>();
		InterfazApp interfazApp;

		// entrada de datos se deben ingresar con espacios
		Scanner datos = new Scanner(System.in);
		System.out.println("Ingrese la expresion a evaluar:");
		String entrada = datos.nextLine(); // para separar por el split
		String separar[] = entrada.split("");

		for (String separarDatos : separar) {
			// agrega cada dato separado en la cola de entrada
			colaEntrada.enqueue(separarDatos);
		}
		interfazApp = new InterfazApp(colaEntrada);
		interfazApp.infijoPostfijo();

		interfazApp.evaluarPostfijo();

		if (interfazApp.getPila().size() > 1) { // si quedan mas datos en la pila ademas del resultado es error
			System.out.println("SINTAXIS ERROR");
		} else {
			System.out.println("La notacion en postfijo es: ");
			for (String s : interfazApp.getColaSalida()) {
				System.out.print(s + " ");
			}
			System.out.println("\nEl resultado es :");
			System.out.println(interfazApp.getPila().peek());
		}

	}

	public void infijoPostfijo() {

		for (String cE : colaEntrada) { // un ciclo para cada dato de la cola de entrada ordenarlo adecuadamente
			if (cE.equals("+") || cE.equals("-") || cE.equals("*") || cE.equals("/") || cE.equals("%")
					|| cE.equals("^")) {// identifica si son operadores
				if (pila.isEmpty()) {// cuando la pila esta vacia agrega el operador en la pila
					pila.push(cE);
				} else { // cuando no esta vacia
					String p = pila.pop(); // sacar el ultimo dato de la pila para comparar si es de mayor jerarquia que
											// el que se va a asignar o no
					int valorCE = asignarJerarquia(cE);
					if (valorCE > asignarJerarquia(p)) {
						pila.push(p);
						pila.push(cE);
					} else { // si es de menor jerarquia
						colaSalida.enqueue(p);
						while (!pila.isEmpty()) {
							p = pila.pop();
							if (asignarJerarquia(p) >= valorCE) {
								colaSalida.enqueue(p);
							} else {
								pila.push(cE);// casos cuando la pila ya esta vacia
								break;
							}
						}
						pila.push(cE);// casos cuando la pila ya esta vacia
					}
				}
			} else {// si no es ninguno de los operadores, quiere decir que es un numero
				colaSalida.enqueue(cE);
			}
		}

		for (String p : pila) {// pasa todo lo de la pila a la cola de salida
			colaSalida.enqueue(pila.pop());
		}
	}

	public void evaluarPostfijo() {
		for (String cS : colaSalida) {
			if (cS.equals("+") || cS.equals("-") || cS.equals("*") || cS.equals("/") || cS.equals("%")
					|| cS.equals("^")) {
				double y = Double.parseDouble(pila.pop());
				double x = Double.parseDouble(pila.pop());
				pila.push(String.valueOf(evaluar(x, y, cS)));
			} else {
				pila.push(cS);
			}

		}

	}

	private double evaluar(double x, double y, String cS) {
		double oper = 0;
		switch (cS) {
		case "+":
			oper = x + y;
			break;
		case "-":
			oper = x - y;
			break;
		case "*":
			oper = x * y;
			break;
		case "/":
			oper = x / y;
			break;
		case "%":
			oper = x % y;
			break;
		case "^":
			oper = Math.pow(x, y);
			break;

		}
		return oper;
	}

	private int asignarJerarquia(String dato) {
		int num = 0;
		if (dato.equals("+") || dato.equals("-")) {
			num = 1;
		} else if (dato.equals("*") || dato.equals("/") || dato.equals("%")) {
			num = 2;
		} else if (dato.equals("^")) {
			num = 3;
		}
		return num; //papomudas
	}

	public RedimensionableArrayQueue<String> getColaEntrada() {
		return colaEntrada;
	}

	public RedimensionableArrayQueue<String> getColaSalida() {
		return colaSalida;
	}

	public RedimensionableArrayStack<String> getPila() {
		return pila;
	}

	public void setColaEntrada(RedimensionableArrayQueue<String> colaEntrada) {
		this.colaEntrada = colaEntrada;
	}

}
