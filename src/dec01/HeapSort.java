package dec01;

import java.util.Scanner;

public class HeapSort {
	private static int N;
	Heap<Integer> myheap = new Heap<>(N);
	/*Sort Function*/
	HeapSort(){}
	HeapSort(int [] arr){
		N = arr.length;
		Integer[] newarr = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) newarr[i] = arr[i];
		this.myheap = new Heap<Integer>(newarr);
	}
	/* Sort Function */
	
	public void sort (){
		for(int i = N-1; i > N/2; i--){
			//poll to the top and reset the heap
			this.myheap.swap(this.myheap.getArray(), 0, i);
			N = N-1;
			this.myheap.maxheap(this.myheap.getArray(), 0);
		}
	
		
	}
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Heap sort Test \n");
		int i, n;
		/*Accept number of elements*/
		System.out.println("Enter number of integer elements");
		n = scan.nextInt();
		/*Make array of n elements */
		int arr [] = new int[n];
		/*Accept elements*/
		System.out.println("\nEnter "  + n +  " integer elements");
		for(i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		/* call sort method */
		HeapSort hs = new HeapSort(arr);
		hs.sort();
		Integer [] arr2 = (Integer[]) hs.myheap.getArray();
		/* Print sorted Array */
		System.out.println("\nElements after sorting ");
		for(i = 0; i < n; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();
	}
}
