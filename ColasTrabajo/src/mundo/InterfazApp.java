/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import cosas.Persona;
import java.util.Scanner;
import tdas.GenericQueue;


/**
 *
 * @author ShirleyCamargo
 */
public  class InterfazApp {
    GenericQueue <Persona> queue;
    
    public InterfazApp (){
        queue = new GenericQueue<Persona> ();
    }
    
public static void main (String [] args){
    Scanner sc = new Scanner(System.in);
    //System.out.println("Indique el tamaño de la cola: ");
    //int capacidad = sc.nextInt();
    //sc.nextLine();
    InterfazApp iApp = new InterfazApp();
    
    int opcion;
    Persona elemento;
    String id,nombre,genero;
    int edad;
    
    while(true){
        System.out.println("Seleccione una opcion: \n"
                    + "1. Insertar datos de una persona\n"
                    + "2. Remover \n"
                    + "3. ¿Esta vacia?\n"
                    + "4. Mostrar \n"
                    + "5. Salir  ");
            opcion =sc.nextInt();
            sc.nextLine();
            
        switch(opcion){
                case 1:
                System.out.print("Ingrese los datos de la persona \n Identificacion: ");
                 id = sc.nextLine();
                 System.out.print("Nombre:");
                 nombre= sc.nextLine();
                 System.out.print("Seleccione el genero (Hombre/Mujer): ");
                 genero = sc.nextLine();
                 System.out.print("Edad: ");
                 edad = sc.nextInt();
                 elemento = new Persona(id, nombre, genero,edad);
                 iApp.queue.enqueue(elemento);
                 
                 break;
                case 2:
                    if(!iApp.queue.isEmpty()){
                        elemento = iApp.queue.dequeue();
                        System.out.println("El dato removido es: " + elemento);
                         }
                    else
                        System.out.println("La pila esta vacia");
                    break;
                 case 3:
                     if(iApp.queue.isEmpty())
                         System.out.println("La pila esta vacia. ");
                     else
                         System.out.println("La pila no esta vacia.");
                    break;
                case 4:
                    System.out.println("Contador actual: " + iApp.queue.size() + "personas");
                    for (Persona personas : iApp.queue) {
    					System.out.println(personas.toString() + "\n");
    				}
                    break;
                case 5:
                    System.out.println("!Hasta Pronto¡");
                    System.exit(0);
                default: System.out.println("ERROR. Opcion no valida");     
        }
    }
}
    
}
