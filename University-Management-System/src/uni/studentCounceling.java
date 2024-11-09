package uni;

public class studentCounceling extends Human implements Info {
	private Department departmentAdmitted;
	private String dateOfAdmission;
	private Department departmentChoice;

	public studentCounceling(String ID, String dateOfBirth, String dateOfAdmission, Department departmentChoice,
			Department departmentAdmitted) {
		super(ID, dateOfBirth);
		this.dateOfAdmission = dateOfAdmission;
		this.departmentChoice = departmentChoice;
		this.departmentAdmitted = departmentAdmitted;
	}

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public Department getDepartmentChoice() {
		return departmentChoice;
	}

	public Department getDepartmentAdmitted() {
		return departmentAdmitted;
	}

	@Override
	public void getInfo() {
		System.out.println(getDateOfBirth() +" "+getDateOfAdmission() + " " + getDepartmentAdmitted().getDepartmentID() + " " + getDepartmentChoice().getDepartmentID());
	}

}
