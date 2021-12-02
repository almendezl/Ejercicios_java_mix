package cliente;

import java.util.Scanner;

import mundo.HeapSort;
import mundo.MaxPQ;
import mundo.Vehiculo;

public class Interfaz {

	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 MaxPQ<Vehiculo> colaPrioridad = new MaxPQ<>(200);
		 
		 while (true) {
	            
	            System.out.println("1 - Crear una cantidad de vehiculos");
	            System.out.println("2 - Tamanioo de la cola de prioridad");
	            System.out.println("3 - saber si esta vacia la cola");
	            System.out.println("4 - Imprimir la cola");
	            System.out.println("5 - Eliminar");
	            System.out.println("6 - Ordenar / Imprimir");
	            System.out.println("8 - salir");
	            String opcion = scanner.next();
	            
	            switch (opcion) {
	            
	            case "1":
	            	System.out.println("Ingrese la cantidad de vehiculos a crear");
	            	
	                int cantidad = scanner.nextInt();
	                
	                String[] colores = {"Gris","plateado","Negro", "Blanco","Cafe", "Rojo", "Amarillo", "Azul", "Verde"};
	                String[] marcas = {"mazda", "ford", "renault", "lexus", "opel", "seat"};
	                String[] letrasPlacas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	        		
	                for (int i = 0; i < cantidad; i++) {
	                	
	                	String marca = marcas[(int) (Math.random() * marcas.length)].toUpperCase();
	                	String color = colores[(int) (Math.random() * colores.length)].toUpperCase();
	                	String pla = "";
	                	
	                	String mod = ""; 
	                	for (int j = 0; j < 3; j++) {//numeros de modelo
	                		mod = 20 + ""+ (int) (Math.random() * (21-1)+1);
						}
	                	for (int j = 0; j < 3; j++) {//letras de la placa
	                		 pla += letrasPlacas[(int) (Math.random() * letrasPlacas.length)].toUpperCase();
						}
	                	
	                	for (int j = 0; j < 3; j++) { //numeros de placa
							pla += (int) (Math.random() * 9+1);
						}
	        			colaPrioridad.insert(new Vehiculo(pla, marca, color, mod));
	        		}
	                break;
	            case "2":
	            	System.out.println("tamanio =  " + colaPrioridad.size());
	                break;
	            case "3":
	            	if(colaPrioridad.isEmpty()) {
	                	System.out.println("La cola de prioridad esta vacia");
	                }else {
	                	System.out.println("La cola de prioridad no esta vacia");
					}
	                break;
	            case "4":
	            	if (colaPrioridad.isEmpty()) {
	                	System.out.println("no hay datos en la cola");
					}else {
						int tamanio = colaPrioridad.size();
	                	for (int i = 1; i < tamanio+1; i++) {
							System.out.println(colaPrioridad.obtener(i));
						}
					}
	                break;
	            case "5":
	            	if (colaPrioridad.isEmpty()) {
	            		System.out.println("la cola esta vacia");
					}else {
						System.out.println("Ingrese la placa del vehiculo que desea eliminar");
	                	String placa = scanner.next();
	                	
	                	int tamanio = colaPrioridad.size();
	                	for (int i = 1; i < tamanio+1; i++) {
							                		
	                		if(placa.equalsIgnoreCase(colaPrioridad.obtener(i).getPlaca())) {
	                			colaPrioridad.borrar(i);
	                		 break;
	                		}
						}
					}
	           break;
	            case "6":
	            	if (colaPrioridad.isEmpty()) {
	                	System.out.println("no hay datos en la cola");
					}else {
	                	Vehiculo [] copia = new Vehiculo[colaPrioridad.size()];
	                	for (int i = 1; i < copia.length+1; i++) {
	                		copia[i-1] = new Vehiculo(colaPrioridad.obtener(i).getPlaca(), colaPrioridad.obtener(i).getMarca(),
	                				colaPrioridad.obtener(i).getColor(), colaPrioridad.obtener(i).getModelo());
						}
	                	HeapSort.heapSort(copia);//se puede usar asi porque los metodos de la clase son estaticos
	                	for (int i = 0; i < copia.length; i++) {
	                		System.out.println(copia[i].toString());	
						}
	                	
	                	
					}
	                break;
	           
	            case "8":
	                System.exit(0);
	            default:
	                System.out.println("opcion equivocada");
	                break;
	        }
	            
	            
	        }
		}
	     

}