/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Scanner;
import tdas.FixedCapacityStack;
import tdas.FixedCapacityStackOfIntegers;
import cosas.Persona;
import tdas.RedimencionableArrayStack;

/**
 *
 * @author Nicole D Torres
 */
public class InterfazApp { //Cuando instancio la pila especifico el elemento que se va a utilizar 

//SI DESEO QUE LEA OTRO ELEMENTO LE CAMBIO EN STRING POR UN INTEGER EN TODOS LOS CASOS QEU SE NECESITA, DEPENDIENDO EL DATO QUE SE DESEA 
//SI SE VA A LEER UNA PERSONA SE DEBE IMPORTAR LA CALSE PERSONA Y CAMBIAR LOS TIPOS DE DATO POR EL NOMBRE DE LA CLASE 
//FixedCapacityStackOfIntegers stack; //Stack = Pila 
//FixedCapacityStack <String> stack; // una pila con arreglo generico 
//FixedCapacityStack<Persona> stack;
    RedimencionableArrayStack<String> stack; //redimencionamiento 

//Constructor dde la clase 
    public InterfazApp() {
        //stack = new FixedCapacityStackOfIntegers(cap);
        //stack = new FixedCapacityStack(cap); // arreglos genericos
        stack = new RedimencionableArrayStack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Indique el tamaño de la pila ");
        //int capacidad = sc.nextInt(); //el usuario indica el tamaño que va a tener la pila 
        //sc.nextLine(); //Limpia el buffer
        InterfazApp iApp = new InterfazApp();

        int opcion;
        //Integer elemento; // arreglo fijo 
        String elemento; // arreglo generico 
        //Persona elemento; //esto para hacerlo con la persona 
        //String id, nombre, genero;
        //int edad;

//se deben colocar los datos de la persona para poder pasarlo al caso 1 
        while (true) {
            System.out.println("\n Seleccioneuna opcción:\n"
                    + "1. Insertar un dato. \n"
                    + "2. Consultar el tope. \n"
                    + "3. Remover un dato. \n"
                    + "4. ¿Esta vacia la pila? \n"
                    + "5. Imprimir los elementos \n"
                    + "6. Salir.");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    //Para insertar primero debo preguntar cual es el dato 
                    System.out.println("Ingrese el dato que desea insertar: ");
                    //elemento = sc.nextInt(); // lee un entero 
                    elemento = sc.nextLine(); //Lee la cadena de caracteres
                    iApp.stack.push(elemento); //para que el usuario lo ingrese*/

                    //Se realiza el caso 1 para el tipo de persona 
                    /*System.out.println("***INGRESE EL ID DE LA PERSONA*** \n Identificacion: ");
                    id = sc.nextLine();
                    System.out.println("***INGRESE EL NOMBRE*** \n Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("***SELECCIONE EL GENERO (HOMBRE/MUJER)*** \n Genero: ");
                    genero = sc.nextLine();
                    System.out.print("***DIGITE LA EDAD*** \n Edad:");
                    edad = sc.nextInt();

                    elemento = new Persona(nombre, edad, id, genero);
                     
                    iApp.stack.push(elemento);*/
                    break;

                case 2:
                    //Devuelve un dato de tipo integer 

                    if (!iApp.stack.isEmpty()) {
                        elemento = iApp.stack.peek();
                        System.out.println(elemento != null ? "El tope es: " + elemento : "No hay elementos en la pila");
                    } else 
                        System.out.println("No hay datos en la pila");
                    break;

                case 3:
                    //para retirar el dato se llama el metodo pop 
                    if (!iApp.stack.isEmpty()) {
                        elemento = iApp.stack.pop();
                        System.out.println(elemento != null ? "El dato que se removio es: " + elemento : " No hay elementos en la pila ");
                    } else 
                        System.out.println("No hay datos en la pila");
                    break;

                case 4:
                    //Es un metodo booleano isEmpty 
                    if (iApp.stack.isEmpty()) {
                        System.out.println("La pila esta vacia. ");
                    } else {
                        System.out.println("La pila no esta vacia. ");
                    }
                    break;

                case 5:
                    //al imprimir el stack va a buscar un metodo toString 
                    System.out.println("El contador actual es: " + iApp.stack.size() + " elementos ");
                    for (String str : iApp.stack) {
                        System.out.println(str + "\n");
                    }
                    break;

                case 6:
                    System.out.println("¡ADIOS INMUNDO ANIMAL!");
                    System.exit(0);
                default:
                    System.out.println("ERRORO, LA OPCIÓN NO ES VALIDA");
                    break;
            }
        }
    }

}
