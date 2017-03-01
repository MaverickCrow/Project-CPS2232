package nov03;

public class MyLinkedQueue<E> {
	QueueNode<E> first;
	QueueNode<E> last;
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;
		QueueNode<E> previous;
		
		public QueueNode(E element){
			this.element = element;
		}
	}
	
	
	MyLinkedQueue(){}
	MyLinkedQueue(E[] objects){
		 
	}

	public E peek (){
		return first.element;
	}
	public E poll () {
		QueueNode<E> current = last;
		if(isEmptyQueue()) last = null;
		return null; //enqueue
	}
	public E offer (){
		if(isEmptyQueue()) last = null;
		return null;
	}
	public boolean isEmptyQueue () {
		return false;
	}
}
