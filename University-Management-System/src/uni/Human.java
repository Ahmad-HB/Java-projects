package uni;

public class Human implements Info{
    protected String ID;
    protected String dateOfBirth;

    public Human(String ID, String dateOfBirth) {
        this.ID = ID;
        this.dateOfBirth = dateOfBirth;
    }

    public String getID() {
        return ID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
	@Override
	public void getInfo() {
		System.out.println(ID);
        System.out.println(dateOfBirth);
		
	}
}
