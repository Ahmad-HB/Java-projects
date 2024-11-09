import java.util.Timer;

public class Players extends User {

	//private double playedhours;
	private int PlayerID;
	private static int lastPlayerID = 0;
	private Timer playedhours;
	private String inroom;

	public Players(String name, int age, String phonenumber,String inroom) {
		super(name, age, phonenumber);
		setPlayerID();
		setPlayedhours();
		setInroom(inroom);
	}

	public void printPinfo() {
		super.printUinfo();
		System.out.println("Player ID: " + PlayerID);
		System.out.println("Played Hours: " + playedhours);
	}
	
	public double calculatecost() {
		double cost=GUI.owner.getBuldings().get(7).getRooms().get(6).getPricePerHour();
		
		
		return cost;
	}

	public double getPlayedhours() {
		
		return 0;
	}

	public void setPlayedhours() {
		
	}

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID() {
		PlayerID = ++lastPlayerID;
	}
	
	public String getInroom() {
		return inroom;
	}

	public void setInroom(String inroom) {
		this.inroom = inroom;
	}

}