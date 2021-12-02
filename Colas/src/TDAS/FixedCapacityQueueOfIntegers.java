package TDAS;


public class FixedCapacityQueueOfIntegers { //ESTA OK
	
	private Integer[] array; //Arreglo 
    private int count; //Contador 
    
    
    
    public FixedCapacityQueueOfIntegers(int cap) {
        array = new Integer[cap]; 
        count = 0; //Es preferible inicializarlo
        
    }

    //Enqueue permite insertar en la estructura de datos.
    
    public void enqueue(Integer item) { //se inserta una cosa en la cola
        array[count++] = item; //coloca el elemento en el arreglo en la posicion e incrementa el contador 
    }

    //Dequeue desencola los elementos, retorna el dato que este en el tope el mas arriba de la posiion 
    //
    public Integer dequeue() {
        if (!isEmpty()) {
        	Integer aux = array[0]; //copia del primer elemento
        	
        	for (int i = 0; i < count-1; i++) { //mover los elementos hacia la izquierda, ya que se desencola el primero
				array[i] = array[i+1];
			}
        	
        	array[--count] = null; // primero se decrementa el contador y luego borra
            return aux; //primero se usa y luego incrementa el valor de la posicion de salida
            
        } else {
            return null;
        }
    }

    //metodo que retorna el dato inicial de la cola 
    public Integer peek() {
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

    // retorna el valor del contador para el tamanio 
    public int size() {
        return count;
    }

    //Iterador para ir de poscicion en posicion 
    public String toString() {
        String salida = "";
        for (int i = 0; i < count; i++)//Para cada entero en el arreglo 
        {
            salida += array[i] + " ";
        }

        return salida;
    }
}
