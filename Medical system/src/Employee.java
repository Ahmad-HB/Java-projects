import java.util.Random;

public class Employee extends User {

	private String Role;
	private String status;

	public Employee(String name, int age) {
		super(name,age);
		setRole();
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
	
	public void toStringUser() {
		super.toStringUser();
        System.out.println(", Role: " + Role);
    }
	
}
