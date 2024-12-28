import java.util.Random;

public class Patient extends User{
	
<<<<<<< HEAD
=======
	private String Name;
	private int ID ;
	private static int lastID=0;
	private int Age;
>>>>>>> 7ed6cd0a311dae63a4f7ab86893d88abe3df7125
	private String status;
	private String Ailment;
	
	
<<<<<<< HEAD
	public Patient(String name, int age) {
		super(name,age);
		setAilment();
=======
	public Patient(String name, int age, String ailment) {
		this.Name = name;
		setID();
		this.Age = age;
		this.Ailment = ailment;
>>>>>>> 7ed6cd0a311dae63a4f7ab86893d88abe3df7125
		this.status = Status.Waitting.toString();
	}


<<<<<<< HEAD
=======
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


>>>>>>> 7ed6cd0a311dae63a4f7ab86893d88abe3df7125
	public String getAilment() {
		return Ailment;
	}


	public void setAilment() {
		Ailments[] ailment = Ailments.values();
		Random random = new Random();
        int randomIndex = random.nextInt(ailment.length);
        this.Ailment = ailment[randomIndex].toString();
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public void toStringUser() {
		super.toStringUser();
        System.out.println("status :"+status+"Ailment :"+Ailment);
    }
	
		
}
