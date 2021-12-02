/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotacionPostfijo;

import listaCola.Queue;
import listaPila.Stack;

/**
 *
 * @author Angie Mendez
 */
public class NotacionPostfijo {

    private Queue<String> colaEntrada; //aqui se almacena la entrada del usuario
    private Queue<String> colaSalida; //aqui se reorganizan los datos ingresados
    private Stack<String> pila; //sirve para ordenar los operadores

    public NotacionPostfijo(Queue<String> colaEntrada) { //se pide la cola de entrada ya que es la que el usuario ingresa 
        this.colaEntrada = colaEntrada;
        colaSalida = new Queue();
        pila = new Stack();
    }

    public void infijoPostfijo() {
        
        for (String cE : colaEntrada) { //un ciclo para cada dato de la cola de entrada ordenarlo adecuadamente
            if (cE.equals("+") || cE.equals("-") || cE.equals("*") || cE.equals("/") || cE.equals("%") || cE.equals("^")) {//identifica si son operadores
                if (pila.isEmpty()) {//cuando la pila esta vacia agrega el operador en la pila 
                    pila.push(cE);
                } else { //cuando no esta vacia
                    String p = pila.pop(); //sacar el ultimo dato de la pila para comparar si es de mayor jerarquia que el que se va a asignar o no 
                    int valorCE = asignarJerarquia(cE); 
                    if (valorCE > asignarJerarquia(p)) {
                        pila.push(p);
                        pila.push(cE);
                    } else { //si es de menor jerarquia
                        colaSalida.enqueue(p);
                        while (!pila.isEmpty()) {
                            p = pila.pop();
                            if (asignarJerarquia(p) >= valorCE) {
                                colaSalida.enqueue(p);
                            } else {
                                pila.push(cE);//casos cuando la pila ya esta vacia
                                break;
                            }
                        }
                        pila.push(cE);//casos cuando la pila ya esta vacia
                    }
                }
            } else {//si no es ninguno de los operadores, quiere decir que es un numero
                colaSalida.enqueue(cE);
            }
        }

        for (String p : pila) {//pasa todo lo de la pila a la cola de salida
            colaSalida.enqueue(pila.pop());
        }
    }

    public void evaluarPostfijo() {
        for (String cS : colaSalida) {
            if (cS.equals("+") || cS.equals("-") || cS.equals("*") || cS.equals("/") || cS.equals("%") || cS.equals("^")) {
                double y = Double.parseDouble(pila.pop());
                double x = Double.parseDouble(pila.pop());
                pila.push(String.valueOf(evaluar(x, y, cS)));
            } else {
                pila.push(cS);
            }

        }

    }

    private double evaluar(double x, double y, String cS) {
        double oper = 0;
        switch (cS) {
            case "+":
                oper = x + y;
                break;
            case "-":
                oper = x - y;
                break;
            case "*":
                oper = x * y;
                break;
            case "/":
                oper = x / y;
                break;
            case "%":
                oper = x % y;
                break;
            case "^":
                oper = Math.pow(x, y);
                break;

        }
        return oper;
    }

    private int asignarJerarquia(String dato) {
        int num = 0;
        if (dato.equals("+") || dato.equals("-")) {
            num = 1;
        } else if (dato.equals("*") || dato.equals("/") || dato.equals("%")) {
            num = 2;
        } else if (dato.equals("^")) {
            num = 3;
        }
        return num;
    }

    public Queue<String> getColaEntrada() {
        return colaEntrada;
    }

    public Queue<String> getColaSalida() {
        return colaSalida;
    }

    public Stack<String> getPila() {
        return pila;
    }

    public void setColaEntrada(Queue<String> colaEntrada) {
        this.colaEntrada = colaEntrada;
    }

}
