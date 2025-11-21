

public class QueueSinglyList {
	
    private SinglyLinkList lst = new SinglyLinkList();
	
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
