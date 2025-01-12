import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	public void printAll() {
		int i = 0;
		if (!isEmpty()) {
			Node loopingNode = head;
			while (loopingNode != null) {
				if (loopingNode.obj instanceof Patient) {
					Patient patient = (Patient) loopingNode.obj;
					System.out.println("=========================");
					System.out.println("Patient :" + (++i));
					System.out.println("Name :" + patient.getName());
					System.out.println("User ID :" + patient.getID());
					System.out.println("Patient ID: "+ patient.getPatientId());
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

	public Patient searchById(int givenId) {
		List<Patient> patientList = new ArrayList<>();
		Node current = head;

		while (current != null) {
			if (current.obj instanceof Patient) {
				patientList.add((Patient) current.obj);
			}
			current = current.next;
		}

		Collections.sort(patientList, Comparator.comparingInt(Patient::getPatientId));

		int left = 0, right = patientList.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			Patient midPatient = patientList.get(mid);

			if (midPatient.getPatientId() == givenId) {
				return midPatient;
			} else if (midPatient.getPatientId() < givenId) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return null;
	}

	public void sortByAge() {
	    if (head == null || head.next == null) return;

	    boolean swapped;
	    do {
	        swapped = false;
	        Node current = head;

	        while (current != null && current.next != null) {
	            Patient currentPatient = (Patient) current.obj;
	            Patient nextPatient = (Patient) current.next.obj;

	            if (currentPatient.getAge() > nextPatient.getAge()) {
	                current.obj = nextPatient;
	                current.next.obj = currentPatient;
	                swapped = true;
	            }

	            current = current.next;
	        }
	    } while (swapped);
	}
	
	public void sortById() {
	    head = mergeSort(head);
	}

	private Node mergeSort(Node head) {
	    if (head == null || head.next == null) return head;

	    Node[] halves = split(head);
	    Node left = mergeSort(halves[0]);
	    Node right = mergeSort(halves[1]);

	    return merge(left, right);
	}

	private Node[] split(Node head) {
	    if (head == null || head.next == null) return new Node[] {head, null};

	    Node slow = head, fast = head.next;
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    Node secondHalf = slow.next;
	    slow.next = null;
	    return new Node[] {head, secondHalf};
	}

	private Node merge(Node left, Node right) {
	    if (left == null) return right;
	    if (right == null) return left;

	    if (getPatientId(left) <= getPatientId(right)) {
	        left.next = merge(left.next, right);
	        return left;
	    } else {
	        right.next = merge(left, right.next);
	        return right;
	    }
	}

	private int getPatientId(Node node) {
	    return ((Patient) node.obj).getPatientId();
	}

}