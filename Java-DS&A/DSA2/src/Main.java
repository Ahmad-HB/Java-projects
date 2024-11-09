
public class Main {

	public static void main(String[] args) {

		List l1 = new List(2);

		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);

		l1.print();

		System.out.println("===========");
		System.out.println(l1.size());
		System.out.println("===========");
		System.out.println(l1.removeLastIndex());
		System.out.println("===========");
		System.out.println(l1.size());
		System.out.println("===========");
		l1.print();
		System.out.println("===========");
		System.out.println(l1.get(2));
		System.out.println("===========");
		System.out.println(l1.removeAtIndex(1));
		System.out.println("===========");
		l1.print();
	}

}