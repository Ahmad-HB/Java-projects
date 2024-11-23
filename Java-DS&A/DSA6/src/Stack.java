
public class Stack implements IStack {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];

	public boolean isEmpty() {
		return (top < 0);
	}

	Stack() {
		top = -1;
	}

	public boolean push(int x) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	public int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}

	public int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}

	public void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	@Override
	public int search(int value) {
		for (int i = top; i >= 0; i--) {
	        if (a[i] == value) {
	            return top - i + 1;
	        }
	    }
	    return -1;
	}
}
