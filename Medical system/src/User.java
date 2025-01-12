
public class User {
	private String Name;
	private int Age;
	private int ID;
	private static int lastID = 0;

	public User(String name, int age) {
		this.Name = name;
		this.Age = age;
		setID();

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

	public void toStringUser() {
        System.out.print("User ID :"+getID()+", Name: " + getName() +", Age: " + getAge());
	}

}
