import java.util.Random;

public class Employee extends User {

	private String Role;
	private String status;
	private int employeeId;
	private static int lastEmployeeId = 0;

	public Employee(String name, int age) {
		super(name,age);
		setRole();
		setEmployeeId();
		this.status = Status.Free.toString();
	}


	public String getRole() {
		return Role;
	}

	public void setRole() {
		Roles[] roles = Roles.values();
		Random random = new Random();
        int randomIndex = random.nextInt(roles.length);
        this.Role = roles[randomIndex].toString();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId() {
		this.employeeId = ++lastEmployeeId;
	}


	public void toStringUser() {
		super.toStringUser();
        System.out.println(", Employee ID: "+getEmployeeId()+", Role: " + getRole());
    }
	
}
