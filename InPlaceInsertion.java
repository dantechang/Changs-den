import java.util.Scanner;
public class InPlaceInsertion {
	
	public static void sort(int[] s) {
		for (int i = 1;i<s.length;i++) {
			
			for(int j=i;j>0;j--) {
				if (s[j]< s[j-1]) {
					int tmp = s[j];
					s[j] = s[j-1];
					s[j-1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = new int[10];
		Scanner keyboard = new Scanner(System.in);
		
		
		for(int i = 0; i<10; i++) {
			System.out.print("Enter number: ");
			a[i] = keyboard.nextInt();
			
		}
		InPlaceInsertion.sort(a);
		
		System.out.println("Sorted array with insertion: ");
		for(int i = 0; i<10; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
