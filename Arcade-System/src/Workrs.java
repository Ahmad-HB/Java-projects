public class Workrs extends User {

	private String job;
	private int workhours;
	private int WorkrID;
	private double salary;
	private static int lastWorkrsID = 0;
	private boolean status;
	private String gender;

	public Workrs(String name, int age, String gender, String phonenumber, String job, int workhours, double salary) {

		super(name, age, phonenumber);
		setWorkrID();
		setGender(gender);
		setStatus(true);
		setJob(job);
		setWorkhours(workhours);
		setSalary(salary);
		
	}
	
	public void printWinof() {
		super.printUinfo();
		System.out.println("Workr ID: " + WorkrID);
		System.out.println("Job Description: " + job);
		System.out.println("Work Hours: " + workhours);
		System.out.println("salary: " + salary);
		if (status == true) {
			System.out.println("worker status: active");
		} else {
			System.out.println("worker status: inactive");
		}
	}

	public double calculatesalaryperyear() {
		return salary * 12;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getWorkhours() {
		return workhours;
	}

	public void setWorkhours(int workhours) {
		this.workhours = workhours;
	}

	public int getWorkrID() {
		return WorkrID;
	}

	public void setWorkrID() {
		WorkrID = ++lastWorkrsID;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}