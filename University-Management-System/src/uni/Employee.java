package uni;

public class Employee extends Human implements Info {
	private String dateOfJoining;
	private Department department;

	public Employee(String ID, String dateOfBirth, String dateOfJoining, Department department) {
		super(ID, dateOfBirth);
		this.dateOfJoining = dateOfJoining;
		this.department = department;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public Department getDepartment() {
		return department;
	}

	@Override
	public void getInfo() {
		System.out.println(getDateOfJoining() + " work in: " + getDepartment().getDepartmentID() + " " + getDepartment().getDepartmentName());
	}
}
