package interfaz;

import java.util.Scanner;
import stack.FixedCapacityStack;

public class InterApp {

	public static void main(String[] args) {
		
		Scanner datos = new Scanner(System.in);// esto nos permite capturar los datos que ingresa el usuario
        String operacion = datos.nextLine(); //guardamos lo que ingresa el usuario en una cadena de caracteres
        String[] arr; 
        arr = operacion.split(" ");
        
        FixedCapacityStack<String> ops = new FixedCapacityStack();//creamos la pila de Strings
        FixedCapacityStack<Double> vals = new FixedCapacityStack();
        
        for (String s : arr) {
        	
        }
	}
}
