import java.util.Arrays;

public class Heap {
	private int[] heap;
	private int current = 1; //current position for inserting
	
	
	public Heap(int n) {
		heap = new int[n+1]; //n+1 for size n sicnce we dont use heap[0]
	}
	
	
	
	
	public void insert(int num) {
		
		if (heap.length == current) { //O(1) amortized time
			int[] tmp = new int[heap.length*2];
			System.arraycopy(heap, 0, tmp, 0, heap.length);
			heap = tmp;
		}
		//this part above runs in O(1)
		heap[current] = num;
		upHeap(); //upHeap runs in O(logn) where n is thesize of the heap
		current ++;
	}
	
	private void upHeap() {
		int i = current;
		
		while(i > 0) {  //since i is halfed each time this loop runs logn times with O(1) therfore upHeap is O(1)
			int parent = i/2; 
			if (heap[parent] <= heap[i]) {
				break;
			}
			
			int tmp = heap[i];
			heap[i] = heap[i/2];
			heap[i/2] = tmp;
			
			i = parent;
		}
		
	}
	
	public int removeMin() {
		
		if(size() <= 1) {
			throw new IllegalStateException("Heap has no elements");
		}
		
		
		int min = heap[1];
		
		if(current == 1) { //there was only 1 element in the heap it is the root so set it to 0
			heap[1] = 0;
		}
		
		else {
			heap[1] = heap[current-1];
			heap[current-1] = 0;  //sets it to 0 and decrements the length 
			current --; 
			//everything above is O(1)
			downHeap(); //downHeap is O(logn)
		}
		
		
		return min;
	}
	
	private void downHeap() {
		
		int i = 1; //root rank
		
		while(2*i < size()) { //there exist a child of i
			int left_index = 2*i;
			int right_index = 2*i+1;
			
			int small = left_index;
			
			if(right_index < size() && heap[right_index] < heap[small]) {
				//right child exist
				small = right_index;
			}
			
			if(heap[i] <= heap[small]) {
				break;
			}
			
			else {
				int num = heap[small];
				heap[small] = heap[i];
				heap[i] = num;
				i = small; // here once i is swapped it is doubled for each iteration therefore the loop runs O(logn) times with O(1) work
			}
	
			
		}
	}
	
	public int min() {
		return heap[1];
	}
	
	public boolean isEmpty() {
		if (heap.length == 1)
			return true;
		
		
		return false;
	}
	
	public int size() {
		return current; //since we dont use 0th position, when current is 5 we have 4 elements in the heap waiting for 5th
	}
	
	public void printHeap() {
		for(int i = 1; i< current;i++) {
			System.out.print(heap[i]+ " ");
		}
	}
}
