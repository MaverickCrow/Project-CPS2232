package dec01;

public class PriorityQueue<E extends Comparable> {
	Heap<E> myheap;
	
	public PriorityQueue(int capacity){
		myheap = new Heap<E>(capacity);
	}
	
	public boolean isEmpty(){
		return (myheap.getArray().length == 0);
	}
	
	public void offer(E item){
		if((myheap.myarray == null) || (myheap.size == 0)) {
			E[] arr = (E[]) new Comparable[1];
			arr[0] = item;
			myheap = new Heap<E>(arr);
			myheap.size++;
		}
		
		else if(myheap.size < myheap.capacity){
			myheap.myarray[myheap.size] = item;
			myheap.trickeUp(myheap.size);
			myheap.size++;
		}
		
	}
	
	
	public E poll(){
		E temp = myheap.myarray[0];
		myheap.size--;
		if(myheap.size > 0){
			myheap.myarray[0] = myheap.myarray[myheap.size];
			myheap.trickleDown(0);
			
		}
		return temp;
	}
	
	public static void main (String...strings){
		PriorityQueue<String> pq = new PriorityQueue<String>(5);
		pq.offer("e");
		System.out.println(pq.myheap.size);
		
	}
	
	
}
