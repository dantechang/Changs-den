import java.util.Scanner;

public class MergeSort {
	public static void sort(QueueSinglyList s) {
		
		if (s.size() <2) {
			return;
		}
		
		QueueSinglyList a = new QueueSinglyList();
		QueueSinglyList b = new QueueSinglyList();
		
		int len = s.size();
		
		int count = 0;
		
		while(count != len /2) {
			a.enqueue(s.dequeue());
			count ++;
		}
		
		while(count != len) {
			b.enqueue(s.dequeue());
			count++;
		}
		
		sort(a);
		sort(b);
		
		MergeLists.Merge(a,b, s);
		
		
	}
	
	public static void main(String[] args) {
		
		QueueSinglyList q = new QueueSinglyList();
		Scanner keyboard = new Scanner(System.in);
		
		
		for(int i = 0; i<10; i++) {
			System.out.print("Enter number: ");
			int a = keyboard.nextInt();
			q.enqueue(a);
			
		}
		MergeSort.sort(q);
		
		System.out.println("Sorted array with MergeSort: ");
		q.display();
	}
	
	
	
}
