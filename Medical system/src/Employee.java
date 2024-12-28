
public class Employee {

	private String Name;
	private int ID;
	private String Role;
	private String status;

	public Employee(String name, int id, String role) {

		this.Name = name;
		this.ID = id;
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

	public void setID(int iD) {
		ID = iD;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
