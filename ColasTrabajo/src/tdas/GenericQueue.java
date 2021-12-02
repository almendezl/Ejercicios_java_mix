/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.util.Iterator;

/**
 *
 * @author shirleycamargo
 * @param <Item>
 */
public class GenericQueue<Item> implements Iterable<Item> {

	private Item a[];
	private int num;

	public GenericQueue() {
		a = (Item[]) new Object[1];
		num = 0;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < num; i++)
			temp[i] = a[i];
		a = temp;
	}

	public void enqueue(Item item) {
		if (num == a.length)
			resize(2 * a.length);
		a[num++] = item;
	}

	public Item dequeue() {
		if (!isEmpty()) {
			Item item = a[0];
			for (int i = 0; i < num-1; i++) { // mover los elementos hacia la izquierda
				a[i] = a[i + 1];
			}
			a[--num] = null;
			if (num > 0 && num == a.length / 4)
				resize(a.length / 2);
			return item;
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return num == 0;
	}

	public int size() {
		return num;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < num;
		}

		@Override
		public Item next() {
			return a[i++];
		}

	}
}
