package InterfazApp;

import NotacionPostfijo.NotacionPostfijo;
import java.util.Scanner;
import listaCola.Queue;


public class InterfazApp {

    public static void main(String[] args) {
        try {
            //creacion de variables
            Queue<String> colaEntrada = new Queue();
            NotacionPostfijo notacionPostfija;

            //entrada de datos  se deben ingresar con espacios
            Scanner datos = new Scanner(System.in);
            System.out.println("Ingrese la expresion a evaluar:");
            String entrada = datos.nextLine(); //para separar por el split
            String separar[] = entrada.split(" ");

            for (String separarDatos : separar) {
                //agrega cada dato separado en la cola de entrada
                colaEntrada.enqueue(separarDatos);
            }
            notacionPostfija = new NotacionPostfijo(colaEntrada);
            notacionPostfija.infijoPostfijo();

            
            notacionPostfija.evaluarPostfijo();
            
            if(notacionPostfija.getPila().size() > 1){ //si quedan mas datos en la pila ademas del resultado es error
                System.out.println("SINTAXIS ERROR");
            }else{
                System.out.println("La notacion en postfijo es: ");
            for (String s : notacionPostfija.getColaSalida()) {
                System.out.print(s + " ");
            }
            System.out.println("\nEl resultado es :");
            System.out.println(notacionPostfija.getPila().pop());
            }
            
        } catch (NumberFormatException n) {
            System.out.println("SINTAXIS ERROR");
        }
    }
}
