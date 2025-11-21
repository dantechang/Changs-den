import java.util.Random;
public class SortCompare{
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		int len = 32;
		
		for (int i = 6; i<21;i++) { //loop for length 
			
			len*=2; //length doubled each time
			long avgTime = 0;
			
			for(int j = 0; j<1000; j++) {
				
				
				int[] array = new int[len];

							
				for(int p = 0;p <len;p++) {
					array[p] = rand.nextInt(len);
				}
			
					
					
				long startTime = System.nanoTime();
				HeapSort.sort(array);
				long endTime = System.nanoTime();
				avgTime += endTime - startTime;
			
			}
			
			
			System.out.println("Heres the 1000 times average of Heap Sort on length "+ len + ": " +avgTime/1000);
			
								
		}
		System.out.println();					
				
	}
			

}


