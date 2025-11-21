
public class BST {
	
	private static class Node {
		Node left;
		Node right;
		Node parent;
		int key;
		
		private Node(int k, Node l, Node r, Node p) {
			left = l;
			right = r;
			key = k;
			parent = p;
		}
		private Node(int k) {
			key = k;
			
		}
	}
	
	public Node root;
	
	public BST(int k) {
		root = new Node(k,null,null, null);
	}
	
	public BST() {
		root = null;
	}
	
	public Node search(int k) { //since theres no point in returning the key lets return the node to help remove
		Node node = root;

		System.out.println(k);
		while(node != null) {
			System.out.println(node.key);
			if (k< node.key) {
				System.out.println("");
				node = node.left;
			}
			
			else if(k> node.key) {
				node = node.right;
			}
			
			else {
				return node;
			}
		}
		
		
		return null;
	}
	
	public void insert(int k) {
		Node newNode = new Node(k);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		insert(k,root);
	}
	
	private void insert(int k, Node v) {
		
			Node par = null;
			Node current = v;
			while(current != null) {
				par = current;
				
				if(k < current.key ) {
					current = current.left;
				}
				
				
				else {
					current = current.right;
				}
				
			}
			
			Node newNode = new Node(k);

			if(k < par.key) {
				par.left = newNode;
				
			}
			else {
				par.right = newNode;
			}
			
			newNode.parent = par;
			
			
		
	}
	
	public void  remove(int k) {
		try {
			
			Node search = search(k);
			
			if(search == null) {
				throw new IllegalStateException("unable to remove, its not in bst.");
			}
			
			
			Node p = search.parent;
			
			
			if (search.left == null && search.right == null) { //no children
				if(p == null) {
					root = null; //no items in bst since we remove root
				}
				else {
					if (p.left == search ) {
						p.left = null;
					}
					
					else {
						p.right = null;
					}
				}
			}
			
			
			else if(search.left ==null || search.right == null) { //right child no left
				Node child = (search.left !=null)? search.left : search.right; //finds which child is exsitsing
				
				if (p == null) { //root node
					root = child;
				}
				
				else {
					if(p.left == search) {
						p.left = child;
					}
					
					else {
						p.right = child;
					}

				}
				
				child.parent = p;
			}
		
			else { //two children
				Node tmp = search.right;
				
				
				while(tmp.left!=null) {
					
					tmp = tmp.left;
				}
			
				
				search.key = tmp.key;
				
				Node par = tmp.parent;
				
				if(par.left == tmp) {
					par.left = null;
				}
				else {
					par.right = null;
				}
				
			}
			
			
			
			
		}
		
		catch(IllegalStateException e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private void inOrderTraversal(Node v) {
		
		if (v.left != null) {
			inOrderTraversal(v.left);
		}
		
		System.out.print(v.key + " ");
		
		if(v.right != null) {
			inOrderTraversal(v.right);
		}
	
		
		
	}
	
	private void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) { //if last is true we are on the right side of tree
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(node.key);
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
	
	public static void main(String[] args) {
		BST tree = new BST();
		//Q4
		
		tree.insert(1);
		tree.insert(2);	
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		
		tree.inOrderTraversal();
		System.out.println();
		tree.printTree();
		
		//Q5
		long startTime, endTime, finalTime = 0;
		
		for(int i = 0; i<1;i++) {
			startTime = System.nanoTime();
			tree.search(1);
			endTime = System.nanoTime();
			
			finalTime += endTime - startTime;
		}
		
		finalTime /=1;
		
		System.out.println("\nTime it takes to search for 1: " + finalTime + " nanoseconds");
		
		finalTime = 0;
		
		for(int i = 0; i<1;i++) {
			startTime = System.nanoTime();
			tree.search(15);
			endTime = System.nanoTime();
			
			finalTime += endTime - startTime;
		}
		
		finalTime /=1;
		
		System.out.println("Time it takes to search for 15: " + finalTime + " nanoseconds");
		
		
		//Q6
		tree.remove(5);
		tree.inOrderTraversal();
		System.out.println();
		tree.remove(15);
		tree.inOrderTraversal();
		System.out.println();
		tree.remove(1);
		tree.inOrderTraversal();
		System.out.println();
		tree.insert(2);
		tree.inOrderTraversal();
		System.out.println();
		
		BST newTree = new BST();
		newTree.insert(8);
		newTree.insert(4);
		newTree.insert(12);
		newTree.insert(2);
		newTree.insert(6);
		newTree.insert(10);
		newTree.insert(14);
		newTree.insert(1);
		newTree.insert(3);
		newTree.insert(5);
		newTree.insert(7);
		newTree.insert(9);
		newTree.insert(11);
		newTree.insert(13);
		newTree.insert(15);
		
		
		newTree.inOrderTraversal();
		System.out.println();
	
		newTree.printTree();
		System.out.println();
		finalTime = 0;
		
		for(int i = 0; i<1;i++) {
			startTime = System.nanoTime();
			tree.search(1);
			endTime = System.nanoTime();
			
			finalTime += endTime - startTime;
		}
		
		finalTime /=1;
		
		System.out.println("Time it takes to search for 1: " + finalTime+ " nanoseconds");
		
		finalTime = 0;
		
		for(int i = 0; i<1;i++) {
			startTime = System.nanoTime();
			tree.search(1);
			endTime = System.nanoTime();
			
			finalTime += endTime - startTime;
		}
		
		finalTime /=1;
		
		System.out.println("Time it takes to search for 15: " + finalTime+ " nanoseconds");
		
		newTree.remove(8);
		newTree.printTree();
		newTree.inOrderTraversal();
		
		
	}
}
