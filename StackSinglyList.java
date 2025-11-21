package Dante;import Dante.SinglyLinkList;

public class StackSinglyList {
	
	private SinglyLinkList lst = new SinglyLinkList();
		
		
	public int pop() {
		return lst.removeFirst();
	}
		
		
	public void push(char value) {
		lst.insertFirst(value); //LIFO
	}
		
	public int top() {
			return lst.getFirst(); //LIFO
	}
		
	public int size() {
		return lst.size();
	}
		
	public boolean  isEmpty() {
			return (lst.size() == 0);
	}
	
}
