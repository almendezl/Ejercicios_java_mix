/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.util.Iterator;

/**
 *
 * @author Daniela
 */
//Va a ser una implementación generica e iterable 
public class LLIStack<Item> implements Iterable<Item> { //implementación con listas enlasadas

    //ya no se implementa arreglo, se usa un nodo 
    private Node first; //primer nodo 
    private int count; // contador 

    //Constructor de LLIStack
    public LLIStack() {
        first = null;
        count = 0;
    }

    // una clase anidada, privada para que nadie la use por fuera, una clase dentro de otra 
    private class Node {
        //un nodo tiene dos campos

        Item item; //tipo item llamado igual 
        Node next; //Acá se tiene un atributo9 que referencia aun objeto de su misma clase, llamandose next
    }

    //MÉTODOS DE UN PILA 
    public void push(Item item) {//me pasan un item  
        // se crea una referencia a un nodo llamado oldfirst
        Node oldFirst = first;
        first = new Node();//crear el nuevo nodo y asignarlo a la referencia 
        first.item = item; //Donde first.item va a ser igual al item que nos pasan 
        first.next = oldFirst; //El nodo qeu va a ingresar apunta al siguiente en nest que apunta al nodo oldfirst
        count++; //incremento el contador en 1 
    }

    public Item pop() { //Permite retirar datos, tipo item 
        Item item = first.item; //creo una variable de tipo item y se le asigna lo que esta en firs.item 
        first = first.next;//se elimina la posicion y al correr el nodo anterior queda como first 
        count--;//se resta uno al contador 
        return item;//es el que sale 
    }

    public Item peek() {//conocer el elemento que esta en la primera posicion 
        return first.item;

    }

    public boolean isEmpty() {
        return first == null; //si la refereincia first es nulla esta vacia. Tambien se puede colocar return count == 0; y funciona igual 
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<Item> iterator() { //permite recorrer la estructura de datos
        return new LLIterator(); //lista enlazada 
    }

    //se implementa la clase de lista enlazada que implementa un iterador con datos de tipo item 
    private class LLIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
        return current != null; //si es diferente a nulo es por que hay un dato que procesar 
        }

        @Override
        public Item next() {
        Item item = current.item;
        current = current.next;
        return item; 
        }

    }
}
