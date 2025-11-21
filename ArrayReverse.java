import java.util.Scanner;
public class ArrayReverse {
	
	public static void reverse(int [] s, int a, int b) {
		b--;
		
		if ( a>= b) {
			return;
		}
	
		int tmp = s[a];
		s[a] = s[b];
		s[b] = tmp;

		reverse(s,a+1,b);

		
	}
	public static void main(String[] args) {
		int[] a = new int[10];
		QueueSinglyList q = new QueueSinglyList();
		Scanner keyboard = new Scanner(System.in);
		
		
		for(int j = 0; j<3; j++) {
			System.out.println();
			for(int i = 0; i< 10;i++) {
				System.out.println("Enter number: ");
				a[i] = keyboard.nextInt();
				q.enqueue(a[i]);
				
			}
			
			if (j == 0) {
				InPlaceInsertion.sort(a);
				System.out.println("Heres the reversed array with Insertion: ");
			}
			
			else if(j == 1) {
				InPlaceQuickSort.quickSort(a, 0, 10);
				System.out.println("Heres the reversed array with QuickSort: ");
			}
			
			
			else {		
				MergeSort.sort(q);
				System.out.println("Heres the reversed array with MergeSort: ");
				
				for(int i = 0;i<10;i++) {
					a[i] = q.dequeue();
				}
				
				
			}
			for(int k = 0;k<10;k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
			
			ArrayReverse.reverse(a, 0, 10);
			for(int k = 0;k<10;k++) {
				System.out.print(a[k] + " ");
			}
			
			
			
			
			
		}
		
		
	}
}
