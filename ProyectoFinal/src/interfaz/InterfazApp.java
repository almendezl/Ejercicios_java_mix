package interfaz;

import java.util.Scanner;

import mundo.ColaPrioridad;
import mundo.Vehiculo;

public class InterfazApp {
	
	
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ColaPrioridad<Vehiculo> colaVehiculos = new ColaPrioridad<Vehiculo>(500);
        
        
        
        while (true) {
            System.out.println("Seleccione una opcion:");
            System.out.println("0. Para salir");
            System.out.println("1. Crear N vehiculos");
            System.out.println("2. Esta vacia la cola de prioridad?");
            System.out.println("3. Tamaño de la cola de prioridad");
            System.out.println("4. Ordenar e Imprimir la cola");
            System.out.println("5. Imprimir la cola sin ordenar");
            System.out.println("6. Eliminar un vehiculo");
            String opcion = sc.next();
            
            switch (opcion) {
            case "0":
                System.exit(0);
            case "1":
            	System.out.println("Ingrese la cantidad de vehiculos a crear");
            	
                int cantidad = sc.nextInt();
                String[] ma = {"maserati", "ferrari", "audi", "lamborgini", "Mercedes", "BMW"};
                String[] co = {"Negro", "Blanco", "Rojo", "Amarillo", "Azul", "Verde"};
                String[] pl = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        		String[] mode = {"01","02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21"};
        		
                for (int i = 0; i < cantidad; i++) {
                	
                	String marca = ma[(int) (Math.random() * ma.length)].toUpperCase();
                	String color = co[(int) (Math.random() * co.length)].toUpperCase();
                	String plac = "";
                	for (int j = 0; j < 3; j++) {
                		 plac += pl[(int) (Math.random() * pl.length)].toUpperCase();
					}
                	
                	for (int j = 0; j < 3; j++) {
						plac += (int) (Math.random() * 9+1);
					}
                	
                	String mod = "20"+mode[(int) (Math.random() * mode.length)];
        			colaVehiculos.insert(new Vehiculo(plac, marca, color, mod));
        			
        		}
                

                break;
            case "2":
                if(colaVehiculos.isEmpty()) {
                	System.out.println("La cola de prioridad esta vacia");
                }else {
                	System.out.println("La cola de prioridad NO esta vacia");
				}
                break;
            case "3":
                System.out.println("El tamaño de la cola de prioridad es " + colaVehiculos.size());
                break;
            case "4":
                if (!colaVehiculos.isEmpty()) {
                	int tamanio = colaVehiculos.size();
                	System.out.println(tamanio);
                	Vehiculo[] auxVehiculos = new Vehiculo[tamanio];
                	for (int i = 1; i < tamanio+1; i++) {
						auxVehiculos[i-1] = new Vehiculo(colaVehiculos.dato(i).getPlaca(), colaVehiculos.dato(i).getMarca(), colaVehiculos.dato(i).getColor(), colaVehiculos.dato(i).getModelo());
					}
                	heapZSort(auxVehiculos);
                	System.out.println("DATOS ORDENADOS CON HEAPSORT");
                	for (int i = 0; i < auxVehiculos.length; i++) {
                		
						System.out.println(auxVehiculos[i].toString());
					}
                	
				}else {
					System.out.println("No hay datos en la cola");
				}
                break;
            case "5":
            	if (!colaVehiculos.isEmpty()) {
                	int tamanio = colaVehiculos.size();
                	for (int i = 1; i < tamanio+1; i++) {
						System.out.println(colaVehiculos.dato(i));
					}
				}else {
					System.out.println("No hay datos en la cola");
				}
                break;
            case "6":
            	if (!colaVehiculos.isEmpty()) {
                	System.out.println("Ingrese la placa del vehiculo que desea eliminar");
                	String eliminar = sc.next();
                	
                	int tamanio = colaVehiculos.size();
                	Vehiculo[] auxVehiculos = new Vehiculo[tamanio];
                	for (int i = 1; i < tamanio+1; i++) {
						                		
                		if(eliminar.equalsIgnoreCase(colaVehiculos.dato(i).getPlaca())) {
                			colaVehiculos.eliminar(i);
                		 break;
                		}
                		
                		
					}
                	
                	
				}else {
					System.out.println("No hay datos en la cola");
				}
                break;
            default:
                System.out.println("Dato invalido, intente de nuevo");
                break;
        }
            
            
        }
	}
     

	
	public static void heapZSort(Comparable[] a) {
		int N = a.length;
		for (int k = N / 2; k >= 1; k--)
			sink(a, k, N);
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}

	private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
	}

	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

}
