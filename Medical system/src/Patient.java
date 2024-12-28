
public class Patient {
	
	private String Name;
	private int ID ;
	private static int lastID=0;
	private int Age;
	private String status;
	private String Ailment;
	
	
	public Patient(String name, int age, String ailment) {
		this.Name = name;
		setID();
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

	public void setID() {
		this.ID = ++lastID;
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
