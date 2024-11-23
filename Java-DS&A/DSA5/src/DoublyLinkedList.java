public class DoublyLinkedList implements IDoublyLinkedList{
	Node head;
	int length;

	public DoublyLinkedList() {
		this.head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			addFirst(data);
		} else {
			Node loopingNode = head;
			while (loopingNode.next != null) {
				loopingNode = loopingNode.next;
			}
			loopingNode.next = newNode;
			newNode.prev = loopingNode;
			length++;
		}
	}

	public void deleteFirst() {
		if (!isEmpty()) {
			head = head.next;
			head.prev = null;
			length--;
		} else {
			System.out.println("List is empty");
		}
	}

	public void deleteLast() {
		if (isEmpty()) {
			System.out.println("List is already empty");
		} else if (head.next == null) {
			head.prev = null;
			head = null;
			length--;
		} else {
			Node loopingNode = head;
			while (loopingNode.next != null) {
				loopingNode = loopingNode.next;
			}
			loopingNode.prev.next = null;
			loopingNode.prev = null;
			length--;
		}
	}

	public void printForward() {
		if (!isEmpty()) {
			Node loopingNode = head;
			while (loopingNode != null) {
				System.out.println(loopingNode.data);
				loopingNode = loopingNode.next;
			}
		}
	}

	public void printBackward() {
		Node loopingNode = head;
		while (loopingNode.next != null) {
			loopingNode = loopingNode.next;
		}
		while (loopingNode != null) {
			System.out.println(loopingNode.data);
			loopingNode = loopingNode.prev;
		}
	}

}
