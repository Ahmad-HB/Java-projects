
public class Patient {
	
	private String Name;
	private int ID;
	private int Age;
	private String status;
	private String Ailment;
	
	
	public Patient(String name, int id, int age, String ailment) {
		this.Name = name;
		this.ID = id;
		this.Age = age;
		this.Ailment = ailment;
		this.status = Status.Waitting.toString();
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


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getAilment() {
		return Ailment;
	}


	public void setAilment(String ailment) {
		Ailment = ailment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
		
}
