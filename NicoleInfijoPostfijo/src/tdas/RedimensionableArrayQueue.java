package tdas;
/**
 *
 * @author Daniela
 */
import java.util.Iterator;


public class RedimensionableArrayQueue <Item> implements Iterable<Item> {
	private Item[] array; //Arreglo 
    private int count; //Contador 

//Constructor de capacidad fija ya que se trabaja con un arreglo 
//Si se quiere de capacidad no fija toca redimensionar el arreglo, con otro arreglo 
    public RedimensionableArrayQueue() {

        //Se debe hacer una convercion de tipo con un casting 
        array = (Item[]) new Object[1]; // la capacidad por defecto es 1, object es del estandar de java hereda todas las clases de java 
        count = 0; //Es preferible inicializarlo 
    }

    
//Metodo para redimensionar 
    public void redimensionar(int max) {
        Item[] temp = (Item[]) new Object[max]; //se crea un temporal
        for (int i = 0; i < count; i++) {
            temp[i] = array[i]; // al temporal se le asigna lo que hay en el arreglo en la posicion i 
        }
        array = temp; //ahora cambia la referencia del arreglo apuntando al nuevo arreglo que se llama temp, copiando los datos de un arreglo a otro
    }
//Enqueue - encolar permite colocar en la estructura de datos. estos metodos cambian para poder redimencionar el arreglo 

    public void enqueue(Item item) { //se inserta una cosa 
        if (count == array.length) {
            redimensionar(2 * array.length); //Es dos veces el tamanio que tiene, redimensionando solo
        }
        array[count++] = item; //guardar el dato normal
        
        
    }

//Dequeue - Desencolar  los elementos, retorna el dato que este en la primera posicion de la cola
    public Item dequeue() { 
    	if(!isEmpty()) {
    		Item aux = array[0]; //crear copia del primer elemento
    		
    		for (int i = 0; i < count-1; i++) { //mover los elementos hacia la izquierda, ya que se desencola el primero
				array[i] = array[i+1];
			}
        	
        	array[--count] = null; // primero se decrementa el contador y luego borra

    		if (count > 0 && count == array.length/4) //si count es menor a cero e igual a el arreglo por el 25%
                redimensionar(array.length/2);
    		return aux;
    	}else {
    		return null;
    	}
    	    
    }

    
    
//metodo para mostrar el primer dato sin borrar
    public Item peek() {
        //me retorna lo que hay en la primera posicion sin sacarlo
        if (!isEmpty()) {
            return array[0];
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

/*Iterador para ir de poscicion en posicion 
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
        return new ArrayIterator(); //lo voy a recorrer de adelante hacia atras porque es una cola
    }

    //crear una clase anidada 
    private class ArrayIterator implements Iterator<Item> {

        private int i = 0; //inicia en 0 porque es la primera posicion de la cola FIFO

        @Override
        public boolean hasNext() { 
            return i<count; // menor que la longitud total de la cola
        }

        @Override
        public Item next() {
            return array[i++]; //en i++ y no count para no modificar el tamanio del arreglo y porque se recorre de izquierda a derecha 
        }

    }
}
