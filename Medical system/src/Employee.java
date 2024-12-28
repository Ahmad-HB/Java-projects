import java.util.Random;

public class Employee extends User {

<<<<<<< HEAD
	private String Role;
	private String status;

	public Employee(String name, int age) {
		super(name,age);
		setRole();
		this.status = Status.Free.toString();
	}

=======
	private String Name;
	private int ID;
	private static int lastID=0;
	private String Role;
	private String status;

	public Employee(String name, int id, String role) {

		this.Name = name;
		setID();
		this.Role = role;
		this.status = Status.Free.toString();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID() {
		this.ID = ++lastID;
	}
>>>>>>> 7ed6cd0a311dae63a4f7ab86893d88abe3df7125

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
