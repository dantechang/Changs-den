package Dante;

public class SinglyLinkList {
	
	private static class Node{ 
		int element;
		Node next;
		
		Node(int e){
			element = e;
			next = null;
		}
		
	}
	
	public Node head; 
	private Node tail;
	private int len;
	
	
	public SinglyLinkList() {
		head = null;
		tail = null;
		len = 0;
	}
	
	public void insertFirst(int val) {
		Node newNode = new Node(val);
		
		if (head == null) { //list length 0 still
			head = newNode;
			tail = newNode;
		}
		
		else {
			newNode.next = head; //newnode points to head
			head = newNode; //newnode is head now
		}
		
		len ++;
	}
	
	public int removeFirst() {
		
		if (head == null) {
			throw new IllegalStateException("List is empty");
		}
		else {
			
			int tmp = head.element;
			head = head.next;
			
			if (head == null) { //when moving head to next item, check if list is empty cuz tail will be null
				tail = null;
			}
			len--;
			return tmp;
		}
	}
	
	public void insertLast(int val) {
		Node newNode = new Node(val);
		
		if (tail == null) { //empty list
			tail = newNode;
			head = newNode;
		}
		
		else {
			tail.next = newNode; //old tail points new tail
			tail = newNode; //new tail assigned
		}
		
		len++;
	}
	
	public int removeLast() {
		int val;
		if (head == null) { 
			throw new IllegalStateException("List is empty");
		}
		
		if (head == tail) { //one element to remove
			val = head.element;
			head = null;
			tail = null;
			len--;
			return val;
		}
		
		else {// at least 2 nodes, distinct head and tail
			Node tmp = head;
			
			while(tmp.next != tail) {
				tmp = tmp.next; //traverses list o(n) until reaches second last node
			}
			
			val = tail.element;
			
			tmp.next = null; //removes tail, second last element is tail
			
			tail = tmp;// second last element is tail
			len--;
			return val;
		}	

	}
	
	public int getFirst() {
		return head.element;
	}
	public int getLast() {
		return tail.element;
	}
	
	public int size() {
		return len;
		
	}
	
	public void displayList(Node currNode) {
			if (currNode.next == null) {
				System.out.print(currNode.element);
			}
			
			else {
				
			System.out.print(currNode.element+ " --> ");
			displayList(currNode.next);
			
			}
			
			
			
		
	}
	
	
	
}
