public class LinkedList {
	Node head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(Patient patient) {
		Node newNode = new Node(patient);

		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}

	}

	public void addLast(Patient patient) {
		Node newNode = new Node(patient);
		if (isEmpty()) {
			head = newNode;
		} else {
			Node LoopingNode = head;
			while (LoopingNode.next != null) {
				LoopingNode = LoopingNode.next;
			}
			LoopingNode.next = newNode;
		}

	}

	public void deleteFirst() {
		if (!isEmpty()) {
			head = head.next;

		} else {
			System.out.println("List is empty");
		}
	}

	public void deleteLast() {
		if (isEmpty()) {
			System.out.println("List is already empty");
		} else if (head.next == null) {
			head = null;
		} else {
			Node loopingNode = head;
			while (loopingNode.next.next != null) {
				loopingNode = loopingNode.next;
			}
			loopingNode.next = null;
		}
	}

	public void printAll() {
		int i = 0;
		if (!isEmpty()) {
			Node loopingNode = head;
			while (loopingNode != null) {
				if (loopingNode.obj instanceof Patient) {
					Patient patient = (Patient) loopingNode.obj;
					System.out.println("=========================");
					System.out.println("Patient :" + (++i));
					System.out.println("Name: " + patient.getName());
					System.out.println("ID :" + patient.getID());
					System.out.println("Age :" + patient.getAge());
					System.out.println("Ailment :" + patient.getAilment());
					System.out.println("Status :"+ patient.getStatus());
					System.out.println("=========================");
					System.out.println();
				} else {
					System.out.println("Unknown object in list: " + loopingNode.obj);
				}
				loopingNode = loopingNode.next;
			}
		} else {
			System.out.println("The list is empty.");
		}
	}

	public void deleteById(int id) {
		if (isEmpty()) {
			System.out.println("The list is empty. Nothing to delete.");
			System.out.println();
			return;
		}

		if (head.obj instanceof Patient && ((Patient) head.obj).getID() == id) {
			head = head.next;
			System.out.println("Patient with ID " + id + " has been deleted.");
			System.out.println();
			return;
		}

		Node current = head;
		Node previous = null;

		while (current != null) {
			if (current.obj instanceof Patient && ((Patient) current.obj).getID() == id) {
				previous.next = current.next;
				System.out.println("Patient with ID " + id + " has been deleted.");
				System.out.println();
				return;
			}
			previous = current;
			current = current.next;
		}

		System.out.println("Patient with ID " + id + " was not found.");
	}

}
