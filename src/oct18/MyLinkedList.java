package oct18;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;
	public MyLinkedList(){};
	public MyLinkedList(E[] objects){
		super(objects);
	}
	
	public E getFirst() {
		if (size == 0) return null;
		else return head.element;
	}
	
	public E getLast() {
		if (size == 0) return null;
		else return tail.element;
	}
	
	public void addFirst(E e){
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void addLast(E e){
		if(tail == null){
			head = tail = new Node<>(e);
		}
		else {
			tail.next = new Node<>(e);
			tail = tail.next;
		}
		size++;
	}
	
	public void add(int index, E e){
		if(index == 0) addFirst(e);
		else if(index >= size) addLast(e);
		else{
			Node<E> current = head;
			for(int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}
	
	public E removeFirst(){
		if(size == 0)return null;
		else{
			Node<E> temp = head;
			size--;
		if(head == null) tail = null;
		return temp.element;
		}
	}
	
	public E removeLast() {
		if (size == 0)return null;
		else if(size == 1){
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;
			for(int i = 0; i < size; i++){
				current = current.next;
			}
				Node<E> temp = tail;
				tail = current;
				tail.next = null;
				size--;
				return temp.element;
			}
		
		}
	
	
	public E remove (int index){
		if (index < 0 || index >= size)return null;
		else if(index == 0) return removeFirst();
		else if (index == size-1) return removeLast();
		else {
			Node<E> previous = head;
			for(int i = 1; i < index; i++){
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
	
	public void clear() {
		size = 0;
		head = tail = null;
	}
	
	public boolean contains (E e){
		for(E tmp: this)
			if(tmp.equals(e)) return true;
		return false;
	}
	
	public E get(int index) {
		if(index < 0 || index > size()){
		return null;
		}
		Node<E> tmp = head;
		for (int i = 0; i < index; i++){
			tmp = tmp.next;
		}
		if (tmp == null) return null;
		return tmp.element;
	}
	
	public int indexOf(E e){
		int i = 0;
		Node<E> current = head;
		while (current!=null) {
			if (current.element.equals(e)) return i;
			i++;
			current = current.next;
		}
		return -1;
	}
	
	public int lastIndexOf(E e){
		int index = -1;
		int i = 0;
		Node<E> current = head;
		while (current!=null) {
			if (current.element.equals(e)) index=i;
			i++;
			current = current.next;
		}
		return index;
	}
	
	public E set(int index, E e){
		Node<E> current = goTo(index);
		current.element = e;
		return e;
	}
	
	private Node<E> goTo(int index) {
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element){
			this.element = element;
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		for (int i = 0; i < size; i++){
			result.append(current.element);
			current = current.next;
			if(current != null){
				result.append(", ");
			}
			else {
				result.append("[");
			}
		}
		return result.toString();
	}
	
	public Iterator<E> iterator() {
		return new MyLinkedListIterator();
	}
	
	private class MyLinkedListIterator implements java.util.Iterator<E>{
		private Node<E> current;
		public boolean hasNext() {
			return current != null;
		}
		
		public E next() {
			E result = current.element;
			current = current.next;
			return result;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
}
