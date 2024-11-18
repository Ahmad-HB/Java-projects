
public class Main {

	public static void main(String[] args) {
		
		LinkedList l1 = new LinkedList();
		
		
		l1.addFirst(2);
		l1.addFirst(7);
		l1.addFirst(3);
		l1.addLast(6);
		l1.addLast(5);
		l1.addLast(9);
		l1.printLinkedList();
		System.out.println("============");
		System.out.println(l1.search(5));
		System.out.println("============");
		l1.deleteSpecificElement(7);
		l1.printLinkedList();
		System.out.println("============");
		l1.addAtPosition(17, 3);
		l1.printLinkedList();
		System.out.println("============");
		l1.addZeroNode();
		l1.printLinkedList();

	}

}
