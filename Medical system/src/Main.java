
public class Main {

	public static void main(String[] args) {
		
		HospitalManagementSystem HMS = new HospitalManagementSystem();
		Patient p1 = new Patient("nega1", 1, 66, "too-much-smoking");
		Patient p2 = new Patient("nega2", 2, 99, "old-enough-to-live");
		LinkedList l1 = new LinkedList();
		l1.addFirst(p1);
		l1.addLast(p2);
		l1.printAll();
		
		Queue q1 = new Queue();
		q1.enqueue(p1);
		q1.printQueue();
		l1.printAll();
		q1.enqueue(p2);
		q1.printQueue();
		q1.dequeue();
		q1.dequeue();
		l1.printAll();
		q1.printQueue();
		
		
		
		
	}

}
