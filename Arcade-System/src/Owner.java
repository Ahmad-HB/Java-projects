import java.util.ArrayList;

public class Owner {
	private ArrayList<Bulding> buldings;
	private String username;
	private String password;
	private String name;
	private int age;
	private String phoneNumber;

	public Owner() {
		buldings = new ArrayList<>();
		this.name = "Ahmad";
		this.age = 27;
		this.phoneNumber = "+962777941222";
		this.username = "Ahmad";
		this.password = "1qaz2wsx";
	}

	public void printOinfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println();

		if (buldings.isEmpty()) {
			System.out.println("No buildings owned.");
		} else {
			System.out.println("Buildings owned:" + buldings.size());

			for (Bulding building : buldings) {
				System.out.println("Building Owner: " + building.getOwner().getName());
				System.out.println("Rooms in Building:");
				System.out.println();

			}
		}
	}

	public int numofbuldings() {
		return buldings.size();
	}

	public void addBulding(Bulding bulding) {
		buldings.add(bulding);

		bulding.setOwner(this);
	}

	public ArrayList<Bulding> getBuldings() {
		return buldings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}