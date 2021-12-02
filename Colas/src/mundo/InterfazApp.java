package mundo;

import java.util.Queue;
import java.util.Scanner;

import TDAS.FixedCapacityQueue;
import TDAS.FixedCapacityQueueOfIntegers;
import TDAS.RedimensionableArrayQueue;
import cosas.Persona;

public class InterfazApp {

	
	RedimensionableArrayQueue<Persona> queuePersonas;

	public InterfazApp() {
		// stack = new FixedCapacityStackOfIntegers(cap);
		// stack = new FixedCapacityStack(cap); // arreglos genericos
		queuePersonas = new RedimensionableArrayQueue();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		InterfazApp iApp = new InterfazApp();

		int opcion;

		// se deben colocar los datos de la persona para poder pasarlo al caso 1
		while (true) {
			System.out.println("\n Seleccioneuna opccion:\n" + "1. Insertar una Persona. \n" + "2. Consultar la primer Persona. \n"
					+ "3. Remover una Persona. \n" + "4. ¿Esta vacia la cola? \n" + "5. Imprimir los elementos de la cola \n"
					+ "6. Salir.");
			
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				// Para insertar primero debo preguntar cual es el dato
				System.out.println("Ingrese el nombre de la persona:");
				String nombre = sc.next();
				
				System.out.println("Ingrese la edad: ");
				int edad = sc.nextInt();
				
				System.out.println("Ingrese el ID de la persona:");
				String id = sc.next();
				
				System.out.println("Ingrese el genero (Hombre/Mujer)");
				String genero = sc.next();
				
				
				iApp.queuePersonas.enqueue(new Persona(nombre, edad, id, genero)); // almacena en la cola el usuario

				break;

			case 2: //muestra pero no elimina

				if (!iApp.queuePersonas.isEmpty()) {
					Persona elemento = iApp.queuePersonas.peek();
					System.out.println(elemento != null ? "El tope es: " + elemento.toString() : "No hay elementos en la cola");
				} else
					System.out.println("No hay datos en la cola");
				break;

			case 3:
				// para retirar el dato se llama el metodo dequeue
				if (!iApp.queuePersonas.isEmpty()) {
					Persona elemento = iApp.queuePersonas.dequeue();
					System.out.println(elemento != null ? "El dato que se removio es: " + elemento.toString()
							: " No hay elementos en la cola ");
				} else
					System.out.println("No hay datos en la cola");
				break;

			case 4:
				// Es un metodo booleano isEmpty
				if (iApp.queuePersonas.isEmpty()) {
					System.out.println("La cola esta vacia. ");
				} else {
					System.out.println("La cola no esta vacia. ");
				}
				break;

			case 5:
				// al imprimir la queue va a buscar un metodo toString
				System.out.println("El contador actual es: " + iApp.queuePersonas.size() + " elementos ");
				for (Persona elemento : iApp.queuePersonas) {
					System.out.println(elemento.toString() + "\n");
				}
				break;

			case 6:
				System.out.println("PROGRAMA FINALIZADO!!!");
				System.exit(0);
			default:
				System.out.println("ERROR, LA OPCION NO ES VALIDA");
				break;
			}
		}

		/*
		 * System.err.
		 * println("//-----------USANDO FixedCapacityQueueOfIntegers ---------------------"
		 * ); FixedCapacityQueueOfIntegers a = new FixedCapacityQueueOfIntegers(10);
		 * System.err.println("va a llenar"); for (int i = 0; i < 10; i++) {
		 * a.enqueue(i); } System.err.println("La cola es: "+a.toString());
		 * System.err.println("El tamanio es "+a.size());
		 * System.err.println("salio "+a.dequeue());
		 * System.err.println("salio "+a.dequeue());
		 * System.err.println("salio "+a.dequeue());
		 * 
		 * System.err.println("La cola es: "+a.toString());
		 * System.err.println("El tamanio es "+a.size());
		 * 
		 * System.err.
		 * println("//-----------USANDO FixedCapacityQueue ---------------------");
		 * FixedCapacityQueue<String> st = new FixedCapacityQueue<>(10);
		 * System.err.println("va a llenar"); for (int i = 0; i < 10; i++) { st.enqueue(
		 * i+"esto es un String"); } System.err.println("La cola es: "+st.toString());
		 * System.err.println("El tamanio es "+st.size());
		 * System.err.println("salio "+st.dequeue());
		 * System.err.println("salio "+st.dequeue()); System.err.println("salio "+
		 * st.dequeue());
		 * 
		 * System.err.println("La cola es: "+st.toString());
		 * System.err.println("El tamanio es "+st.size());
		 * 
		 * st.enqueue("Este es un dato nuevo");
		 * System.err.println("La cola es: "+st.toString());
		 * System.err.println("El tamanio es "+st.size());
		 * 
		 * 
		 * System.err.
		 * println("//-----------USANDO RedimensionableArrayQueue ---------------------"
		 * );
		 * 
		 * RedimensionableArrayQueue <String> redi = new RedimensionableArrayQueue<>();
		 * for (int i = 0; i < 20; i++) { redi.enqueue(i+""); }
		 * System.out.println("lleno la cola");
		 * 
		 * System.out.println("tamaño de la cola "+redi.size());
		 * 
		 * System.out.println("desencolo: " + redi.dequeue());
		 * System.out.println("desencolo: " + redi.dequeue());
		 * 
		 * for (String num : redi) { System.out.print(num + "\t"); }
		 * System.out.println(); System.out.println("tamaño de la cola "+redi.size());
		 * 
		 * for (int i = 20; i < 40; i++) { redi.enqueue(i+""); }
		 * System.out.println("lleno la cola");
		 * 
		 * System.out.println("tamaño de la cola "+redi.size());
		 * 
		 * for (String num : redi) { System.out.print(num + "\t"); }
		 * System.out.println(); System.out.println("tamaño de la cola "+redi.size());
		 * 
		 * for (int i = 0; i < 12; i++) { redi.dequeue(); }
		 * System.out.println("tamaño de la cola "+redi.size());
		 * 
		 * for (String num : redi) { System.out.print(num + "\t"); }
		 * System.out.println(); System.out.println("tamaño de la cola "+redi.size());
		 * 
		 * 
		 * 
		 */
	}

}
