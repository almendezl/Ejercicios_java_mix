/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Scanner;
import stack.FixedCapacityStack;

/**
 *
 * @author Angie Mendez
 */
public class Interfaz {

    public static void main(String[] args) {
        try {// estructura que nos permite manejar las excepciones que pueden surgir en un programa
            Scanner datos = new Scanner(System.in);// esto nos permite capturar los datos que ingresa el usuario
            String operacion = datos.nextLine(); //guardamos lo que ingresa el usuario en una cadena de caracteres
            String[] arr; 
            arr = operacion.split(" ");// separamos en un arreglo los datos ingresados por espacios
            int parentesis = 0; // creamos una variable contadora de los parentesis para identificar si estan completos o no mas abajo con un condicional

            FixedCapacityStack<String> ops = new FixedCapacityStack();//creamos la pila de Strings
            FixedCapacityStack<Double> vals = new FixedCapacityStack();//creamos la pila de Doubles

            for (String s : arr) { //for each ya que no se necesita saber la posicion, ya que se hara para todos los datos almacenados en el arreglo
                //for each porque no usaremos posiciones especificas
                if (s.equals("(")) {
                    parentesis++; //cada vez que sea un parentesis abierto se aumentara en uno la variable contadora
                } else if (s.equals("+")) { 
                    ops.push(s);
                } else if (s.equals("-")) {
                    ops.push(s);
                } else if (s.equals("*")) {
                    ops.push(s);
                } else if (s.equals("/")) {
                    ops.push(s);
                } else if (s.equals("sqrt")) {
                    ops.push(s);
                } else if (s.equals(")")) {
                    parentesis++; //cada vez que sea un parentesis cerrado se aumentara en uno la variable contadora
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) {
                        v = vals.pop() + v;
                    } else if (op.equals("-")) {
                        v = vals.pop() - v;
                    } else if (op.equals("*")) {
                        v = vals.pop() * v;
                    } else if (op.equals("/")) {
                        v = vals.pop() / v;
                    } else if (op.equals("sqrt")) {
                        v = Math.sqrt(v);
                    }
                    vals.push(v);
                } else {
                    vals.push(Double.parseDouble(s));
                }
            }
            /**
             * el siguiente condicional evalua  el contador de los parentesis, ya que debe ser un numero par, 
             *1.-> la primer condicion es que si el valor de esa variable dividido dos tiene un reciduo de uno es decir que sea impar ( por lo tanto esta mal), muestre un aviso de error
             * 2.->la segunda condicion es en caso de que no ingresen ningun parentesis, es decir la variable es igual a cero, tambien muestre aviso de error
             * 3.->la tercera condicion doble es para que identifique si al finalizar todo el proceso solo queda en la pila el resultado, es decir cuando el tamaño es = 1, y en la otra pila de los 
             * operadores no debe quedar nada, si esto no se cumple muestre un aviso de error
             * 
             * Si ninguno de esas condiciones se cumple se pasa al "else" y se muestra el resultado que se encuentra la pila llamada vals
             */
            if (parentesis % 2 == 1 || parentesis == 0 || (ops.size() != 0 || vals.size() != 1)) {//cuando no se ingresan parentesis completos de abre y cierra

                System.out.println("ERROR SINTAXIS");
            } else {
                System.out.println(vals.pop());
            }
/**
 * esta parte es el complemento de try que se vio al inicio para manejar las excepciones, en este caso las que se pueden presentar son 2, 
 * la primera es cuando no se puede convertir ese String a numero, es decir porque es una letra u otro caracter no valido
 * la segunda es cuando la posicion en la que se busca un dato se sale del tamaño, es decir una posicion negativa o una posicion mayor al tamaño
 *  cuando esto pasa se va a mostrar un aviso de error
 */
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR SINTAXIS");
        }
        /**
         * El primero es por error si ingresan algo distinto a numeros lanza
         * esta excepcion cuando se ingresa por ejemplo ( 4 + ) o incompleto
         * porque la pila para hacer la operacion, cuando busca el otro operando
         * llega a una posicion N negativa es decir se sale del arreglo
         */
    }
}
