public class Stack {

	private Node top;
	private int size;


	public Stack() {
		this.top = null;
		this.size = 0;
	}

	public void push(Patient patient) {
		Node newNode = new Node(patient);
		newNode.next = top;
		top = newNode;
		size++;
		System.out.println("Patient ID " +((Patient) newNode.obj).getID() + "added to Consultation.");
		System.out.println();
	}
	
	public Patient pop() {
        if (isEmpty()) {
            System.out.println("No patients to re-admit.");
            System.out.println();
            return null;
        }
        Patient patient = (Patient) top.obj;
        top = top.next;                
        size--;
        System.out.println("Patient ID :" + patient.getID() + " removed from Consultation.");
        System.out.println();
        return patient;
    }

	public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No patients to view.");
            System.out.println();
        }
        System.out.println("Patient ID :" + ((Patient) top.obj).getID()+ ", Patient Name :" + ((Patient) top.obj).getName());
        System.out.println();
    }

	public boolean isEmpty() {
		return top == null;
	}

	public int getSize() {
		return size;
	}

	public void printStack() {
        if (isEmpty()) {
            System.out.println("No discharged patients.");
            System.out.println();
        } else {
        	System.out.println("======================================");
            System.out.println("Waitting Patients in Consultation (Top to Bottom):");
            Node current = top;
            while (current != null) {
                Patient patient = (Patient) current.obj;
                System.out.println("Patient ID: " + patient.getID() + ", Name: " + patient.getName());
                System.out.println();
                current = current.next;
            }
            System.out.println("======================================");
            System.out.println();
        }
    }
}
