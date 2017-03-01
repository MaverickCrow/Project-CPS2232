package nov03;

public class MyLinkedStack<E> {
	
	StackNode<E> stackTop = null;
	
	public MyLinkedStack(){
	stackTop = null;
	}
	
	public void push (E newElement) {
		stackTop = new StackNode<E>(newElement, stackTop);
		
		}
	
	public E pop() {
		if(stackTop == null) return null;
		StackNode<E> tmp = stackTop;
		stackTop = stackTop.next;
		return tmp.element;
	}
	
	public E peek () {
		if (stackTop == null) return null;
		return stackTop.element;
		
	}
	
	boolean isEmptyStack() {
		return (stackTop == null);
	}
	
	private class StackNode<E> {
		E element = null;
		StackNode<E> next = null;
		StackNode(){}
		StackNode(E e){ element = e;}
		StackNode(E e, StackNode<E> ptr){
			element = e;
			next = ptr;
		}
		public String toString() {
			return element.toString();
		}
		
	}
	
}
