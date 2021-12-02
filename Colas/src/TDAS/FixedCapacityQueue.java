package TDAS;

public class FixedCapacityQueue<Item> { //ESTA OK

	//Item no es nada solo un nombre que se reemplaza cuando al instanciar la clase indican el tipo de dato que va a quedar     
	//se coloca parametros para que sea generico, el parametro indica a la estructura que tipo de datos se almacenan 

	    private Item[] array; //Arreglo 
	    private int count; //Contador 

	    //Constructor de capacidad fija ya que se trabaja con un arreglo 
	    //Si se quiere de capacidad no fija toca redimensionar el arreglo, con otro arreglo 
	    
	    public FixedCapacityQueue(int cap) {
	        
	    //Se debe hacer una conversion de tipo con un casting 
	        array = (Item[])new Object[cap]; // object es del estandar de java hereda todas las clases de java 
	        count = 0; //Es preferible inicializarlo 
	    }

	    //Enqueue - Encolar permite insertar en la estructura de datos. 
	    public void enqueue(Item item) { //se inserta una cosa 
	        array[count++] = item; //coloca el elemento en el arreglo en la posicion e incrementa el contador 
	    }

	    //Dequeue - Desencolar  los elementos, retorna el dato que este en la primera posicion
	    //
	    public Item dequeue() {
	        if (!isEmpty()) {
	        	
	        	Item aux = array[0]; //copia del primer elemento
	        	
	        	for (int i = 0; i < count-1; i++) { //mover los elementos hacia la izquierda, ya que se desencola el primero
					array[i] = array[i+1];
				}
	        	
	        	array[--count] = null; // primero se decrementa el contador y luego borra
	            return aux; //primero se usa y luego incrementa el valor de la posicion de salida
	        	
	        } else {
	            return null;
	        }
	    }

	    //metodo para mostrar el primer dato de la cola 
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

	    //Iterador para ir de poscicion en posicion 
	    public String toString() {
	        String salida = "";
	        for (int i = 0; i < count; i++)//Para cada entero en el arreglo 
	        {
	            salida += array[i] + "\n";
	        }

	        return salida;
	    }
}
