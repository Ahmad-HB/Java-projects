
public class List implements IList {

	private int[] arr;
	private int size;

	public List(int capcity) {
		arr = new int[capcity];
		size = 0;
	}

	@Override
	public void add(int value) {
		if (size == arr.length) {
			resize();
		}

		arr[size] = value;
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {

		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);

		}

	}

	@Override
	public int removeLastIndex() {
		int removed = arr[size-1];
		arr[size-1] = 0;
		return removed;
	}

	@Override
	public void resize() {
		int[] newArray = new int[arr.length * 2];

		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}

		arr = newArray;

	}

	@Override
	public int get(int value) {
		
		return arr[value];
	}

	@Override
	public int removeAtIndex(int value) {
		int removed = arr[value];
		if(value <0 || value >= size) {
			System.out.println("Error");
			return -1;
		}
		arr[value]=0;
		for(int i= value; i<arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		return removed;
	}

}
