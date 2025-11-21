import java.util.Random;
public class SortingCompare {

	public static void main(String[] args) {
		Random rand = new Random();
		
		
			int len = 32;
			
			for (int i = 6; i<21;i++) { //loop for length 
				
				len*=2; //length doubled each time
				long avgTime = 0;
				
				for(int j = 0; j<1; j++) {
					
					
					int[] array = new int[len];
					QueueSinglyList q = new QueueSinglyList();
							
		
					for(int p = 0;p <len;p++) {
							array[p] = rand.nextInt(len);
					}
					
					for (int m = 0; m< len; m++) {
						q.enqueue(rand.nextInt(len));
						
					}
						
						
					long startTime = System.nanoTime();
					
					//InPlaceInsertion.sort(array);
	
					InPlaceQuickSort.quickSort(array, 0, len);
					
					//MergeSort.sort(q);
					
					long endTime = System.nanoTime();
					avgTime += endTime - startTime;
				
			}
				
				
				System.out.print("Heres the 1000 times average on length "+ len + ", ");
				
					//System.out.println("Insertion Time: "+ avgTime);
	
					System.out.println("Quick Sort Time: "+ avgTime);
	
					//System.out.println("Merge Sort Time: "+ avgTime);
				
									
			}
			System.out.println();					
					
		}
				
}



		
	

