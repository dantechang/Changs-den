package Dante;import Dante.QueueSinglyList; 

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import java.util.stream.IntStream;

public class MergeLists {

	public static Dante.QueueSinglyList Merge(int[] listA, int[] listB){
		Dante.QueueSinglyList s = new Dante.QueueSinglyList();
		Dante.QueueSinglyList a = new Dante.QueueSinglyList();
		Dante.QueueSinglyList b = new Dante.QueueSinglyList();
		
		int sizeA= listA.length;
		int sizeB = listB.length;
		
		
		for(int i = 0;i<sizeA;i++) {
			a.enqueue(listA[i]);
		}
		
		for (int j =0;j<sizeB;j++) {
			b.enqueue(listB[j]);
		}

		while (!a.isEmpty() && !b.isEmpty()) {  //loop runs n-1 times in worst case, n = sizeA+sizeB
			if (a.front() < b.front()) { //smallest numbers at front
				s.enqueue(a.dequeue());
			}
			else {
				s.enqueue(b.dequeue());

				
			}
		}
		
		if (a.isEmpty()) { //nothing left in a
			while(!b.isEmpty()) { //loop runs n/2 times worst case scenario 
				s.enqueue(b.dequeue()); //everything left in B is added to s
			}
		}
		
		else { //nothing left in b
			while(!a.isEmpty()) { //loop runs n/2 times worst case
				s.enqueue(a.dequeue());
			}
		}
		
		
		return s;
		
	}
	
	public static void bonus() {
		Random gen = new Random();
		int n = 100;
		
		while(n< 51201) {
			long averageTime = 0;
			int[] a;
			int[] b;
			Dante.QueueSinglyList s = new Dante.QueueSinglyList();
			
			
			for(int i = 0; i<1000;i++) {
				a = gen.ints(n, 0, n).toArray(); //creates an int array of n numbers range from 0 to n
				Arrays.sort(a); //sorts arrau
				b = gen.ints(n,0,n).toArray();
				Arrays.sort(b);
				
				long startTime = System.nanoTime();
				s = MergeLists.Merge(a,b);
				long endTime = System.nanoTime();
				averageTime += (endTime-startTime);
				
			}
			
			averageTime/= 1000;
			
			
			System.out.println("\nSuccess, heres average time nanoseconds for 1000s of length "+ n+": "+ averageTime);
			
			
			n*=2;
		}
	}
	public static void main(String[] args) {
		

		System.out.print("A = ");
		
		Scanner keyboard = new Scanner(System.in);
		String tmpA = keyboard.next();		
		String[] inputA = tmpA.split(",");
		
		
		System.out.print("B = ");
		String tmpB = keyboard.next();
		String[] inputB = tmpB.split(",");
		
		int[] a= new int[inputA.length];
		int[] b = new int[inputB.length];
		
		for(int i =0;i<inputA.length;i++) {
			a[i] = Integer.valueOf(inputA[i]);
		}
		
		for(int j = 0; j<inputB.length;j++) {
			b[j] = Integer.valueOf(inputB[j]);
		}
		
		
		//(i) A = 1,3,5,7,9 B = 2,3,6,8,10 (ii) A = 1,2,3,4,5 B = 6,7,8,9,10
		//(iii) A = 2,4,8,16,32 B = 1,3,5,7,9 (iv) A = 10,11,12,13 B = 1,2,3,4
		
		 Dante.QueueSinglyList s = MergeLists.Merge(a, b);
		 
		 s.display();
		
		
		//comment out above when running bonus
		//MergeLists.bonus();
		
	}

}
