package nov15;

import java.util.Arrays;
public class SortingExercise {

	static void RecursiveSelectionSort(int [] a, int startIndex){
		recursiveSelSort(a, startIndex + 1);
	}
	
	static void recursiveInsertionSort(int [] a){
		for (int i = 1; i < a.length; i++){
			int currentelement = a[i];
			int k;
			for(k = i-1; k>= 0 && a[k] > currentelement; k--){
				a[k-1] = a[k];
			}
			a[k+1] = currentelement;
		}
		
	}
	
	private static void recursiveSelSort(int [] a, int startIndex){
		if (startIndex >= a.length - 1)
	        return;
	    int minIndex = startIndex;
	    for ( int index = startIndex + 1; index < a.length; index++ )
	    {
	        if (a[index] < a[minIndex] )
	            minIndex = index;
	    }
	    int temp = a[startIndex];
	    a[startIndex] = a[minIndex];
	    a[minIndex] = temp;
	    recursiveSelSort(a, startIndex + 1);

		
	}
	static void recursiveQuickSort(int [] a, int startIdx, int endIdx) {
		int idx = partition(a, startIdx, endIdx);
		if(startIdx < idx - 1){
			recursiveQuickSort(a, startIdx, idx - 1);
		}
		if(endIdx > idx){
			recursiveQuickSort(a, idx, endIdx);
		}
	}
	static void recursiveBubbleSort(int [] a) {
		boolean sorted = true;
		for(int i = 0; i < a.length; i++){
			if(a[i+1] < a[i]){
				int tmp = a[i];
				a[i] = a[i+1];
				a[i+1] = tmp;
				sorted = false;
				}
			if(!sorted) recursiveBubbleSort(a);
		}
	}
	static void recursiveMergeSort(int [] a, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) return;
		else {
			int mid = (lowerBound + upperBound)/2;
			recursiveMergeSort(a, lowerBound, mid);
			recursiveMergeSort(a, mid+1, upperBound);
			merge(a, lowerBound, mid+1, upperBound);
		}
	}
	
	static private void merge(int [] a, int lowPtr, int highPtr, int upperBound){
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound;
		
		while(lowPtr <= mid && highPtr <= upperBound){
			if(a[lowPtr] < a[highPtr]) a[j++] = a[lowPtr++];
			else a[j++] = a[highPtr++];
			
		while(lowPtr <= mid)
			a[j++] = a[lowPtr];
		
		while(highPtr <= upperBound)
			a[j++] = a[highPtr++];
		
		for(j=0; j<n; j++){
			a[lowerBound+j] = a[j];
		}
		}
	}
	
	private static int partition (int [] a, int left, int right){
		int pivot = a[left];
		while(left <= right){
			while(a[left] < pivot){
				left++;
			}
			while (a[right] > pivot){
				right--;
			}
			if (left <= right){
				int tmp = a[left];
				a[left] = a[right];
				a[right] = tmp;
				left++;
				right--;
			}
		}
		return left;
		
	}
	
	static void nonRecursiveSelectionSort (int [] a, int n){
		
	}
	
	static void nonRecursiveInsertionSort(int [] a, int n){
		for(int i = 1; i < n; i++){
			int j, temp = a[i];
			for(j = i-1; j >= 0 && a[j] > temp; j--){
				a[j+1] = a[j];
				a[j+1] = temp;
			}
		}
		
	}
	
	static void nonRecursiveQuickSort(int [] a) {
		
	}
	
	static void nonRecursiveBubbleSort(int [] a) {
		boolean sorted = false;
		while(!sorted){
			sorted = true;
			for(int i = 0; i < a.length; i++){
				if(a[i+1] < a[i]){
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					sorted = false;
				}
			}
		}
		
	}
	
	static void nonRecursiveMergeSort(int [] a, int lowerBound, int upperBound, int mid){
		for(int i = 1; i <= a.length/2 +1; i *= 2){
			for(int j = i; j < a.length; j += 2*i){
				merge(a, lowerBound, mid+1, upperBound);
			}
		}
	}
	
	static void testCaseSelection(int [] a){
		int [] b = Arrays.copyOf(a, a.length);
		long current = System.nanoTime();
		RecursiveSelectionSort(b, 0);
		current = System.nanoTime()- current;
		System.out.println("The recursive execution time is" + current);
		for(int i : b) System.out.print(i+ ":");
		System.out.println();
		int [] c = Arrays.copyOf(a,  a.length);
		current = System.nanoTime();
		nonRecursiveSelectionSort(c, 0);
		current = System.nanoTime() - current;
		System.out.println("The nonrecursive execution time is" + current);
		for(int i : c) System.out.print(i+":");
	}
	
	public static void main (String...strings){
		int [] a = {12, 3, 5, -4, 7, 20, 54, 6};
		testCaseSelection(a);
		int [] c = new int [5000];
		for (int i = 0; i < 5000; i++){
			c[i] = (int)(Math.random()*5000);
		}
		testCaseSelection(c);
	}
}
