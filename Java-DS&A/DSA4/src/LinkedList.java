
public class LinkedList implements IlinkedList {
	Node head;

	public LinkedList() {
		head = null;
	}

	@Override
	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;

		}
	}

	@Override
	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	@Override
	public void printLinkedList() {
		if (head == null) {
			System.out.println("The List is Empty");
		} else {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println("");
		}
	}

	@Override
	public void removeFirst() {
		if (head == null) {
			System.out.println("The List is Empty");
		} else {
			Node current = head;
			head = head.next;
			System.out.println("The deleted iteam is: " + current.data);
		}
	}

	@Override
	public void removeLast() {
		if (head == null) {
			System.out.println("The List is Empty");
			return;
		}
		if (head.next == null) {
			System.out.println("The deleted iteam is: " + head.data);
			head = null;
			return;
		}
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		Node deletedNode = current.next;
		current.next = null;
		System.out.println("The deleted iteam is: " + deletedNode.data);

	}

	@Override
	public boolean search(int val) {

		Node current = head;
		while (current != null) {
			if (current.data == val) {
				return true;
			}
			current = current.next;
		}
		return false;

	}

	@Override
	public void deleteSpecificElement(int val) {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}

		if (head.data == val) {
			removeFirst();
			return;
		}

		Node current = head;
		Node previous = null;

		while (current != null && current.data != val) {
			previous = current;
			current = current.next;
			
		}
		previous.next = current.next;
	    System.out.println("Deleted element: " + current.data);
		
	}

	@Override
	public void addAtPosition(int val, int pos) {
		Node newNode = new Node(val);
		
		if (pos == 1) {
			addFirst(val);
	        return;
	    }
		
		Node current = head;
		Node previous = null;
	    int count = 0;
	    
	    while (current != null && count < pos) {
	    	previous = current;
	        current = current.next;
	        count++;
	    }
	    
	    newNode.next= current;
	    previous.next = newNode;
	    
	    
	    
	}

	@Override
	public void addZeroNode() {
		Node current = head;

	    while (current != null) {
	        if (current.data > 5) {
	            Node newNode = new Node(0);

	            newNode.next = current.next;
	            current.next = newNode;
	            
	        }
	        current = current.next;
	        
	    }
	}
}
