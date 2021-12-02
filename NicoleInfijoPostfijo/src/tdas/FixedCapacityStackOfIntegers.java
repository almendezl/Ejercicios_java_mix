/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

/**
 *
 * @author Daniela
 */
public class FixedCapacityStackOfIntegers {
    //Stack es una pila, la cual implmeneta LIFO, el ultimo en entrar es el primero en entrar 
    //Lo mas facil es con un arreglo, integer para construir estructura con objetos 

    private Integer[] array; //Arreglo 
    private int count; //Contador 

    //Constructor de capacidad fija ya que se trabaja con un arreglo 
    //Si se quiere de capacidad no fija toca redimensionar el arreglo, con otro arreglo 
    public FixedCapacityStackOfIntegers(int cap) {
        array = new Integer[cap];
        count = 0; //Es preferible inicializarlo 
    }

    //Push permite colocar en la estructura de datos. 
    public void push(Integer item) { //se inserta una cosa 
        array[count++] = item; //coloca el elemento en el arreglo en la posicion e incrementa el contador 
    }

    //Pop desapilar los elementos, retorna el dato que este en el tope el mas arriba de la posiion 
    //
    public Integer pop() {
        if (!isEmpty()) {
            return array[--count];
        } else {
            return null;
        }
    }

    //metodo de tope 
    public Integer peek() {
        //me retorna lo que hay en la ultima posicion sin sacarlo,ya que solo contiene un menos 
        if (!isEmpty()) {
            return array[count - 1];
        } else {
            return null;
        }
    }

    //Metodo booleano, no se debe modificar si se desea cambiar el tipo de dato que se debe almacenar o retornar  
    public boolean isEmpty() {
        return count == 0;
    }

    // retorna el valor del contador para el tamaño 
    public int size() {
        return count;
    }

    //Iterador para ir de poscición en posición 
    public String toString() {
        String salida = "";
        for (int i = 0; i < count; i++)//Para cada entero en el arreglo 
        {
            salida += array[i] + " ";
        }

        return salida;
    }
}
