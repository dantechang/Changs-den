import java.util.Scanner;

public class InPlaceQuickSort {
	
	public static void quickSort(int[] s, int a, int b) {
		if (b<= a)
			return; 
		
		int pivot = s[b-1];
		int smallerThan = a; //index of smallest elements
		int greaterThan = b-2; //index of greatest elements
		
		
		while (smallerThan<= greaterThan) {
			
			
			while(smallerThan <= greaterThan && s[smallerThan] <= pivot) { // we have a number smaller than pivot increment smallerThan index
				smallerThan++;
			}
			
			//this loop ends when we reach a number greater than pivot or we traversed entire list
			
			
			while(smallerThan <= greaterThan && s[greaterThan] > pivot) { 
				greaterThan--;
			}
			// this loop ends when we reach a number lesser than pivot or traversed entire list
			
			
			if(smallerThan< greaterThan) {
				//only swap when they are on correct side
				
				int tmp = s[smallerThan];
				s[smallerThan] = s[greaterThan];
				s[greaterThan] = tmp;
				
			}
			
		}
		
		int tmp2 = s[smallerThan];
		s[smallerThan] = s[b-1]; //sets the pivot to its position
		s[b-1] = tmp2;
		
		
		quickSort(s,a,smallerThan);
		quickSort(s,smallerThan+1, b);
	}

	public static void main(String[] args) {
		
		int[] a = new int[10];
		Scanner keyboard = new Scanner(System.in);
		
		
		for(int i = 0; i<10; i++) {
			System.out.print("Enter number: ");
			a[i] = keyboard.nextInt();
			
		}
		InPlaceQuickSort.quickSort(a, 0, 10);;
		
		System.out.println("Sorted array with Quicksort: ");
		for(int i = 0; i<10; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
