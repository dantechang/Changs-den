
public class HeapSort {
		
	public static void sort(int[] a) {
		Heap h = new Heap(a.length);
			for (int i = 0; i< a.length; i++) {
				h.insert(a[i]);
				
			}
			
			for(int j = 0; j<a.length; j++) {
				int n = h.removeMin();
				a[j] = n;
				
			}
		
		
		
	}
	
	public static void main(String[] args) {
		int[] arr= {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
		
		HeapSort.sort(arr);
		
		System.out.println("Final Sort: ");
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	

}
