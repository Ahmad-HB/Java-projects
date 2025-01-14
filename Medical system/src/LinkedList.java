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

		if (head.obj instanceof Patient && ((Patient) head.obj).getPatientId() == id) {
			head = head.next;
			System.out.println("Patient with ID " + id + " has been deleted.");
			System.out.println();
			return;
		}

		Node current = head;
		Node previous = null;

		while (current != null) {
			if (current.obj instanceof Patient && ((Patient) current.obj).getPatientId() == id) {
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
		head = selectionSort(head);
	}

	private Node selectionSort(Node head) {
		if (head == null || head.next == null) return head;

		Node sortedHead = null; // The new head for the sorted list
		Node sortedTail = null; // Tail of the sorted list

		while (head != null) {
			// Find the node with the smallest patient ID
			Node[] smallestAndPrev = findSmallestNode(head);
			Node smallestNode = smallestAndPrev[0];
			Node prevToSmallest = smallestAndPrev[1];

			// Remove the smallest node from the original list
			if (prevToSmallest != null) {
				prevToSmallest.next = smallestNode.next;
			} else {
				head = smallestNode.next; // Update head if smallest node is the first node
			}

			smallestNode.next = null;

			// Append the smallest node to the sorted list
			if (sortedHead == null) {
				sortedHead = smallestNode;
				sortedTail = smallestNode;
			} else {
				sortedTail.next = smallestNode;
				sortedTail = smallestNode;
			}
		}

		return sortedHead;
	}

	private Node[] findSmallestNode(Node head) {
		Node smallest = head;
		Node prevToSmallest = null;
		Node current = head;
		Node prev = null;

		while (current != null) {
			if (getPatientId(current) < getPatientId(smallest)) {
				smallest = current;
				prevToSmallest = prev;
			}
			prev = current;
			current = current.next;
		}

		return new Node[]{smallest, prevToSmallest};
	}

	private int getPatientId(Node node) {
		return ((Patient) node.obj).getPatientId();
	}


}