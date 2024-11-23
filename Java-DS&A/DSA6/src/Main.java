
public class Main {

	public static void main(String[] args) {
		
		Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(60);
        s.push(30);
        s.push(80);
        s.push(70);
        s.push(90);
        s.print();
        System.out.println("=============");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("=============");
        s.print();
        System.out.println("=============");
        System.out.println("Top element is :" + s.peek());
        System.out.println("=============");
        s.print();
        System.out.println("=============");
        System.out.println(s.search(80));
        System.out.println("=============");
        s.print();
	}

}
