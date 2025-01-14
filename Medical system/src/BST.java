public class BST {
	private Node root;

	public BST() {
		this.root = null;
	}

	public void insert(Employee employee) {
		root = insertRec(root, employee);
	}

	private Node insertRec(Node current, Employee employee) {
		if (current == null) {
			return new Node(employee);
		}

		Employee currentEmployee = (Employee) current.obj;

		if (employee.getEmployeeId() < currentEmployee.getEmployeeId()) {
			current.left = insertRec(current.left, employee);
		} else if (employee.getEmployeeId() > currentEmployee.getEmployeeId()) {
			current.right = insertRec(current.right, employee);
		} else {

			System.out.println("Employee with ID " + employee.getEmployeeId() + " already exists.");
		}

		return current;
	}

	public void searchById(int id) {
		Object tempobj = searchByIdRec(root, id);

		if (tempobj != null) {
			((Employee) tempobj).toStringUser();
		} else {
			System.out.println("Employee with ID " + "'"+id+"'" + " not found.");
		}

	}

	private Employee searchByIdRec(Node current, int id) {
		if (current == null) {
			return null;
		}

		Employee currentEmployee = (Employee) current.obj;

		if (id == currentEmployee.getEmployeeId()) {
			return currentEmployee;
		} else if (id < currentEmployee.getEmployeeId()) {
			return searchByIdRec(current.left, id);
		} else {
			return searchByIdRec(current.right, id);
		}
	}

	public void searchByName(String name) {
		System.out.println("Employees with name \"" + name + "\":");
		searchByNameRec(root, name.toLowerCase());
	}

	private void searchByNameRec(Node current, String name) {
		if (current == null) {
			return;
		}

		Employee currentEmployee = (Employee) current.obj;

		if (currentEmployee.getName().toLowerCase().equals(name)) {
			currentEmployee.toStringUser();
		}

		searchByNameRec(current.left, name);
		searchByNameRec(current.right, name);

	}

	public void inOrderTraversal() {
		System.out.println("In-Order Traversal of Employees:");
		inOrderTraversalRec(root);
	}

	private void inOrderTraversalRec(Node current) {
		if (current == null) {
			return;
		}

		inOrderTraversalRec(current.left);
		((Employee) current.obj).toStringUser();
		inOrderTraversalRec(current.right);
	}
}
