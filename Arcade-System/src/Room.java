
public class Room {
	private String name;
	private double pricePerHour;

	public Room(String name, double pricePerHour) {

		setName(name);
		setPricePerHour(pricePerHour);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

}