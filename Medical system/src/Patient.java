import java.util.Random;

public class Patient extends User{
	
	private String status;
	private String Ailment;
	
	
	public Patient(String name, int age) {
		super(name,age);
		setAilment();
		this.status = Status.Waitting.toString();
	}


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
