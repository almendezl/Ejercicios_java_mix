/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Angie Mendez
 * @param <Item>
 */
public class FixedCapacityStack<Item> {// a los genericos le digo que tipo de dato quiero utilizar en la estructura de datos, donde dice item, se va a reemplazar por el tipo que yo le diga
    //arreglo de la pila y tamañp de la pila

    private Item stack[];
    private int N;

    public FixedCapacityStack() {
/**
 * para que pueda ser generico, ya que los arreglos no puedden ser asi, entonces todos son herencia de object y se debe castear
 */
        stack = (Item[]) new Object[1]; 
        N = 0;
    }

    public void push(Item item) {
        if(N == stack.length)
            resize(2*stack.length);
        stack[N++] = item; //primero lo usa y lugo incrementa 
    }

    public Item pop() {
        Item item = stack[--N]; //porque necesita devolver el item antes de redimensionar
        stack[N] = null; //para que saque ese dato que esta guardado en la variable auxiliar item, ya que no lo saca solo lo copia, y eso es basura 
        if(N >0 && N == stack.length/4)
            resize(stack.length/2);
        
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;//es la cantidad de elementos  que estan en la pila y no el tamaño del arreglo
    }
    private void resize(int max){
        /**
         * crear una copia del arreglo en otro de tamaño mas grande, y luego al arreglo original se le asigna el nuevo arreglo mas grande
         */
        Item[] temp = (Item[]) new  Object[max];
        for (int i = 0; i < N; i++) { //porque son solo los datos que se van a copiar , no toda la pila, ya que puede estar vacia en algunas posiciones
            temp[i] = stack[i];
        }
        stack = temp; //paso por refeerencia
    }
}
