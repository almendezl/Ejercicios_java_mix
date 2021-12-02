/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadepersonas;
import TDA.Lista;
import Persona.Persona;
import java.util.Scanner;
/**
 *
 * @author FelixCamargo
 */
public class ListaDePersonas {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista ldp = new Lista (10);
        
        int opcion;
        String id, nombre, genero;
        int edad;
        int posencontrado, pos;
        Persona p;
        int clientesCreados = 0;
        while(true){
         System.out.println("Seleccione una opcion: \n"+ 
                 "1. Insertar una persona  \n"+
                 "2. Buscar  \n"+
                 "3. Actualizar \n "+
                 "4. Eliminar \n" +
                 "5. Consultar tamaño de la lista \n"+
                 "6. Consultar si la lista esta vacia \n"+
                 "7. Mostrar la lista \n"+
                 "8. Salir ");  
         opcion = sc.nextInt();
         
         sc.nextLine();
         
         switch (opcion){
             case 1:
                 System.out.print("Ingrese los datos de la persona \n Identificacion: ");
                 id = sc.nextLine();
                 for(int n=0; n < clientesCreados; n++)
                     
                 System.out.print("Nombre:");
                 nombre= sc.nextLine();
                 System.out.print("Seleccione el genero (Hombre/Mujer");
                 genero = sc.nextLine();
                 System.out.print("Edad: ");
                 edad = sc.nextInt();
                 p = new Persona(id, nombre, genero,edad);
                 if (ldp.insertar(p))
                     System.out.println("Insercion exitosa");
                 else
                     System.out.println("No hay espacio para insertar ");
                 break;
             case 2:
                 System.out.print("Ingrese el numero de identificacion que desea buscar: ");
                 id = sc.nextLine();
                 posencontrado = ldp.buscar(new Persona(id, null, null,0 ));
                 if(posencontrado != -1)
                     System.out.println("La persona fue encontrada en la posicion" + posencontrado);
                 else System.out.println("La persona buscada no fue encontrada ");
                 break;
             case 3:
                 System.out.println("Seleccione: \n "
                         + "1. Actualizar posicion \n"+
                         "2.Actualizar persona ");
                 opcion = sc.nextInt();
                 sc.nextLine();
                 
                 System.out.print("Ingrese los datos de la persona \n Identificacion: ");
                 id = sc.nextLine();
                 System.out.print("Nombre:");
                 nombre= sc.nextLine();
                 System.out.print("Seleccione el genero (Hombre/Mujer");
                 genero = sc.nextLine();
                 System.out.print("Edad: ");
                 edad = sc.nextInt();
                 p = new Persona(id, nombre, genero,edad);
                 
                 sc.nextLine();
                 switch (opcion){
                     case 1:
                         System.out.print("Indique el numero de la posicion: ");
                         pos = sc.nextInt();
                         sc.nextLine();
                         if(ldp.actualizar(p, pos))
                            System.out.println("Actualizacion satisfactoria");
                         else 
                                    System.out.println("ERROR. Posicion no existe");
                         break;
                     case 2:
                         if (ldp.actualizar(p))
                             System.out.println("Actualizacion satisfactoria");
                         else 
                                    System.out.println("ERROR. Persona no encontrada");
                         break;
                     default: System.out.println("Opcion no valida ");
                 }
                 break;
             case 4:  
                 System.out.println("Seleccione: \n "
                         + "1. Eliminar posicion \n"+
                         "2. Eliminar  persona ");
                 opcion = sc.nextInt();
                 sc.nextLine();
                 
                 switch (opcion ){
                     case 1:
                        System.out.print("Indique el numero de la posicion: ");
                         pos = sc.nextInt();
                         sc.nextLine();
                         if(ldp.eliminar(pos))
                            System.out.println("Eliminacion exitosa");
                         else 
                                    System.out.println("ERROR. Posicion no existe");
                         break;
                     case 2:
                     System.out.print("Ingrese la identificacion de la persona a eliminar: ");
                     id = sc.nextLine();
                     p = new Persona (id, null, null, 0);
                     if(ldp.eliminar(p))
                             System.out.println("Eliminacion exitosa ");
                     else
                             System.out.println("ERROR. La persona que desea eliminar no se encontr en la lista");
                     break;
                     default: System.out.println("Ocion no valida");
                 }
                 break;
             case 5:
                 System.out.println("Actualmete existen: " + ldp.tamanioLista() + "personas en la lista");
                 break;
                 
             case 6:
                 if(ldp.listaVacia())
                     System.out.println("La lista esta vacia");
                 else
                     System.out.println("Lalista no esta vacia");
                 break;
                 
             case 7:
                 System.out.println(ldp.mostrar());
                 break;
                 
             case 8: System.exit(0);
             default: System.out.println("Opcion no valida. ");
                 break;
                 
         }
        }
        
    }
    
}
