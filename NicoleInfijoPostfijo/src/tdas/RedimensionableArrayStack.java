/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.util.Iterator;

/**
 *
 * @author Nicole D Torres
 */
public class RedimensionableArrayStack<Item> implements Iterable<Item> {

    private Item[] array; //Arreglo 
    private int count; //Contador 

//Constructor de capacidad fija ya que se trabaja con un arreglo 
//Si se quiere de capacidad no fija toca redimensionar el arreglo, con otro arreglo 
    public RedimensionableArrayStack() {

        //Se debe hacer una convercion de tipo con un casting 
        array = (Item[]) new Object[1]; // la capacidad por defecto es 1, object es del estandar de java hereda todas las clases de java 
        count = 0; //Es preferible inicializarlo 
    }

    
//Metodo para redimencionar 
    public void redimencionar(int max) {
    	Item[] temp = (Item[]) new Object[max]; //se crea un temporal
        for (int i = 0; i < count; i++) {
            temp[i] = array[i]; // al temporal se le asigna lo que hay en el arreglo en la posicion i 
        }
        array = temp; //ahora cambia la referencia del arreglo apuntando al nuevo arreglo que se llama temp, copiando los datos de un arreglo a otro
    }
//Push permite colocar en la estructura de datos. estos metodos cambian para poder redimencionar el arreglo 

    public void push(Item item) { //se inserta una cosa 
    	if (count == array.length) {
            redimencionar(2 * array.length); //Es dos veces el tamanio que tiene, redimensionando solo
        }
        array[count++] = item; //guardar el dato normal
    }

//Pop desapilar los elementos, retorna el dato que este en el tope el mas arriba de la posiion 
    public Item pop() {//Guardar el dato que se devuelve en una variable temporal 
       if(!isEmpty()) {
    	Item item = array[--count];
        array[count] = null; //se borra del todo el dato 
        if (count > 0 && count == array.length/4) //si count es menor a cero e igual a el arreglo por el 25%
            redimencionar(array.length/2);        
        return item;
        }
       else {
    	   return null;
       }
    }

//metodo de tope 
    public Item peek() {
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

/*Iterador para ir de poscición en posición 
    public String toString() {
        String salida = "";
        for (int i = 0; i < count; i++)//Para cada entero en el arreglo 
        {
            salida += array[i] + "\n";
        }

        return salida;
    }*/

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator(); //lo voy a recorrer de atras para adelante
    }

    //crear una clase anidada 
    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = count;

        @Override
        public boolean hasNext() { 
            return i>0; // i apunta cuando paro en la ultima posicion donde tengo un dato y lo recorro de ahi hacia adelante
        }

        @Override
        public Item next() {
            return array[--i]; //en --i y no count para no modificar el tamaño del arreglo 
        }

    }
}
