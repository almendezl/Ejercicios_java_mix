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
public class LLIQueue<Item> implements Iterable<Item> {
    //ya no se implementa arreglo, se usa un nodo 

    private Node first; //primer nodo 
    private Node last; //ultimo nodo
    private int count; // contador 

    //Constructor de LLIStack
    public LLIQueue() {
        first = null;
        count = 0;
    }

    // una clase anidada, privada para que nadie la use por fuera, una clase dentro de otra 
    private class Node {
        //un nodo tiene dos campos

        Item item; //tipo item llamado igual 
        Node next; //Acá se tiene un atributo9 que referencia aun objeto de su misma clase, llamandose next
    }

    public void enqueue(Item item) {
        Node oldLast = last; // se crea la referencia a un nodo llamado oldLast
        last = new Node(); // una vez creado el nodo se va a asignar a la referencia 
        last.item = item;//este va aser el nodo que nodo con el dato que nos pasan 
        last.next = null;//ME CONFUNDE 
        if (isEmpty()) {//si la cola esta vacia 
            first = last; //el primero tambien es el ultimo 
        } else {
            oldLast.next = last;//si no esta vacia el ultimo es el antiguo ultimo y el que llegue es el nuevo ultimo 
        }
        count++;
    }

    public Item dequeue() {//desencola de la ista 
        Item item = first.item;//Recupero el ultimp elemneto 
        first = first.next;//me muevo al siguiente nodo
        if (isEmpty()) { //pregunto si esta lleno 
            last = null; //si last es nulo entonces no hay nada ya 
        }
        count--;
        return item;
    }

    public boolean isEmpty() {
        return first == null; // o si el contador es igual a 0 
    }

    public int size() {//devuelve un entero para el tamaño o contador 
        return count;
    }

    //iterador
    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
