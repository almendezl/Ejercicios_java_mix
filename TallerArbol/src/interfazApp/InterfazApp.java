package interfazApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import mundo.Nodo;

public class InterfazApp {
	private static Map<Integer, Nodo> treeMap = new TreeMap<Integer, Nodo>();
	static Scanner datos = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			File archivo = new File("data/taller.in");
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			int rep = Integer.parseInt(br.readLine());
			String line = "";

			treeMap.put(0, new Nodo(".", 0));
			int aux = 1;
			for (int i = 0; i < rep; i++) {
				line = br.readLine();
				String data[] = line.split(" ");
				for (int j = Integer.parseInt(data[1]); j <= Integer.parseInt(data[2]); j++) {
					treeMap.put(aux, new Nodo(data[0], j));
					aux++;
				}
			}
			while(true) {
			System.out.println("Ingrese el nodo a buscar: ");
			buscar(datos.nextInt());
			}
		} catch (Exception e) {
			// TODO: handle exceptio
			System.out.println("Error al extraer los datos");
		}

	}

	public static void imprimirMap() {
		Iterator<Integer> it;
		//treeMap.put(1600, new Nodo("4000", 4000));
		// Imprimimos el Map con un Iterador
		it = treeMap.keySet().iterator();
		
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			System.out.println("Clave: " + key + " -> Nodo: " + treeMap.get(key).toString());
		}
	}
	public static void buscar(int valor) {
    Integer llave = valor;
    String ruta ="";
    while(!treeMap.get(llave).getKey().equals(".")) {
    	ruta += treeMap.get(llave).getpNode()+ " ";
    	llave = Integer.parseInt(treeMap.get(llave).getKey());
    }
    System.out.println("La ruta del numero "+ valor +" es: ");
		System.out.println(ruta+ "0");
	}
}
