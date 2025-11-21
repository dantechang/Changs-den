package Dante;import Dante.SinglyLinkList;

public class QueueSinglyList {
	
    private Dante.SinglyLinkList lst = new Dante.SinglyLinkList();
	
	public void enqueue(int e) {
		lst.insertLast(e); //FIFO add at back and remove from front
	}
	
	public int dequeue() {
		return lst.removeFirst(); //FIFO
	}
	
	public int front() {
		return lst.getFirst();
	}
	
	public int size() {
		return lst.size();
	}
	
	public boolean isEmpty() {
		return (lst.size()==0);
	}
	
	public void display() {
		lst.displayList(lst.head);
	}
}
