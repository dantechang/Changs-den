package Dante;

public class StackImplement {
	private static final int  MAXLEN = (int)Math.pow(2,19);
	public int currentLength;
	public int[] array;
	
	public StackImplement() {
		currentLength = 0;
		array = new int[MAXLEN]; //max stack size is 2^19
	}
	
	public int pop() {
		if (currentLength == 0) {
			throw new IllegalStateException("Cannot pop, len is 0");
		}
		
		else {
			currentLength --; 
			return array[currentLength]; //say length was 5 that means 4 indexs but we subtracted one so to return top we just go at length which is 4
		}
		
	}
	
	
	public void push(int value) {
		if (currentLength == MAXLEN) {
			throw new IllegalStateException("Cannot push, max len is reached");
		}
		else {
			array[currentLength] =value;
			currentLength ++;
		}
	}
	
	public int top() {
		return array[currentLength-1]; //say length is 1 that means our index is 0 for top
	}
	
	public int size() {
		return currentLength;
	}
	
	public boolean  isEmpty() {
		return (currentLength == 0);
	}
	
	public static void main(String[] args) {
		StackImplement s = new StackImplement();
		s.push('a');
		
		int len = s.currentLength;
		
		for (int i= 0;i<len;i++) {
			System.out.print(s.array[i] + " ");
		}
		
	}
}
