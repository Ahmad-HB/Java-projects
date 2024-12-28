
public class Queue {

	private Node front;
	private Node rear;
	private int size; 

	public Queue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return front == null;
	}


	public int getSize() {
		return size;
	}


	public void enqueue(Object obj) {
		if (!(obj instanceof Patient)) {
			System.out.println("Only Patients can be added to the queue.");
			return;
		}

		
		if (obj instanceof Patient) {
			((Patient) obj).setStatus(Status.BeingProcessed.toString());
		}

		Node newNode = new Node(obj);

		if (isEmpty()) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}

		size++;
		System.out.println("Enqueued: " + ((Patient) obj).getName());
		System.out.println();
	}


	public Object dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to dequeue.");
			
			return null;
		}

		Object obj = front.obj;

		
		if (obj instanceof Patient) {
			((Patient) obj).setStatus(Status.Done.toString());
		} 

		front = front.next;

		if (front == null) {
			rear = null;
		}

		size--;
		System.out.println("Dequeued: " + ((Patient) obj).getName());
		System.out.println();
		return obj;
	}


	public Object peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to peek.");
			return null;
		}
		return front.obj;
	}


	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			System.out.println();
			return;
		}

		Node current = front;
		while (current != null) {
			if (current.obj instanceof Patient) {
				Patient patient = (Patient) current.obj;
				System.out.println("=====================================================");
				System.out.println("Queue elements:");
				System.out.println("Patient - Name: " + patient.getName() + ", ID: " + patient.getID() + ", Status: "
						+ patient.getStatus());
				System.out.println("=====================================================");
				System.out.println();
			} 
			current = current.next;
		}
	}
}
