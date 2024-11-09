package uni;

import java.util.ArrayList;
import java.util.List;

public class Department implements Info {
	private String departmentID;
	private String departmentName;
	private String establishmentDate;
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<studentCounceling> students = new ArrayList<>();

	public Department(String departmentID, String departmentName, String establishmentDate) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.establishmentDate = establishmentDate;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getEstablishmentDate() {
		return establishmentDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public List<studentCounceling> getStudents() {
		return students;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void addStudentCounceling(studentCounceling student) {
		students.add(student);
	}

	@Override
	public void getInfo() {
		System.out.println(getDepartmentID() + " " + getDepartmentName() + " " + getEstablishmentDate());

	}
}
