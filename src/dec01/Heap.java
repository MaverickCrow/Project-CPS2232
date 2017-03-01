package dec01;

public class Heap<E extends Comparable> {
	static int capacity = 1000;
	E[] myarray;
	static int size = 0;
	
	Heap(int capacity){
		this.capacity = capacity;
		size = 0;
		this.myarray = (E[]) new Comparable[capacity];
	}
	
	E[] getArray() {
		return myarray;
	}
	
	Heap(E[] arr){
		int N = arr.length - 1;
		size = N;
		if (N > capacity){
			capacity = N;
			myarray = (E[]) new Comparable[capacity];
		} //makes sure you don't overflow the array
		if(N > 0){	
			for(int i = N/2; i >= 0; i--){
				maxheap(arr, i);
		myarray = arr;
		} // splits it in half, goes through each element, makes sure biggest element is at the top
	}
}
	
			
	protected void trickeUp(int newPosition){
		Object temp = myarray[newPosition];
		int parent = (newPosition - 1)/2;
		while (newPosition > 0 && myarray[parent].compareTo(temp)< 0){
			myarray[newPosition] = myarray[parent];
			newPosition = parent;
			parent = (newPosition -1)/2;
		} //swapping
		myarray[newPosition] = (E) temp;
			
	}
			
	protected void trickleDown(int itemPosition){
		int child; // Index of the larger child
		if(2*itemPosition+1 >= size){
			child = itemPosition; //Leaf node (no children)
		}
		else if (2*itemPosition+2 == size){
			child = 2*itemPosition+1; // One child (at the left)
		}
		else if(myarray[2*itemPosition+1].compareTo(myarray[2*itemPosition+2]) >= 0){
			child = 2*itemPosition+1; //Two children w/ larger on the left
		}
		else {
			child = 2*itemPosition+2; //two children w/ larger on the right
		}
		if(myarray[itemPosition].compareTo(myarray[child]) < 0){
			Object temp = myarray[itemPosition];
			myarray[itemPosition] = myarray[child];
			myarray[child] = (E)temp;
			trickleDown(child);
		}
	}
	
	protected void maxheap(E[] arr, int i){
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max = i;
		if(left <= size && (arr[left].compareTo(arr[i]) > 0)){
			max = left;
		}
		if (right <= size && (arr[right].compareTo(max) > 0)) {
			max = right;
		}
		if(max != i){
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}
	/*Function to swap two numbers in an array*/
	protected void swap(E[] arr, int i, int j){
		E temp = arr[i];
		arr[i] = arr[j];
		arr[j] =(E)temp;
	}
}
