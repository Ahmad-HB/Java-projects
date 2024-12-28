
public class Main {

	public static void main(String[] args) {
		
		LinkedList l1 = new LinkedList();
		Queue q1 = new Queue();
		Stack s1 = new Stack();
		BST b1 = new BST();
		
		
		HospitalManagementSystem HMS = new HospitalManagementSystem();
		Patient p1 = new Patient("nega1", 66);
		Patient p2 = new Patient("nega2", 99);
		Patient p3 = new Patient("nega1", 66);
		Patient p4 = new Patient("nega2", 99);
		Employee e1 = new Employee("GoldenNega2", 6);
		Employee e2 = new Employee("GoldenNega2", 9);
		Employee e3 = new Employee("GoldenNega3", 6);
		Employee e4 = new Employee("GoldenNega4", 9);
		
		
		System.out.println("LinkedList");
		l1.addFirst(p1);
		l1.addLast(p2);
		l1.addLast(p3);
		l1.addLast(p4);
		l1.printAll();
		System.out.println("Queue");
		q1.enqueue(p1);
		q1.printQueue();
		l1.printAll();
		q1.enqueue(p2);
		q1.printQueue();
		q1.dequeue();
		q1.dequeue();
		l1.printAll();
		q1.printQueue();
		
		
		System.out.println("Stack");
		s1.push(p1);
		s1.push(p2);
		s1.peek();
		s1.printStack();
		s1.pop();
		s1.printStack();
		s1.peek();
		s1.printStack();
		
		System.out.println("BST");
		b1.insert(e1);
		b1.insert(e2);
		b1.insert(e3);
		b1.insert(e4);
		b1.inOrderTraversal();
		System.out.println();
		b1.searchById(7);
		b1.searchByName("GoldenNega2");
		
		
		
	}

}
