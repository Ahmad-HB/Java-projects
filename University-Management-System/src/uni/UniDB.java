package uni;
import java.util.ArrayList;

public class UniDB {
	private static UniDB instance;
	private ArrayList<Department> departments;
	private ArrayList<Employee> Employees;
	private ArrayList<studentCounceling> studentsCounceling;
	private ArrayList<studentPerformance> studentsPerformance;
	
	private UniDB() {
		this.departments = new ArrayList<>();
		this.Employees = new ArrayList<>();
		this.studentsCounceling = new ArrayList<>();
		this.studentsPerformance = new ArrayList<>();
		
		this.departments = new ArrayList<>();
		this.Employees = new ArrayList<>();
		this.studentsCounceling = new ArrayList<>();
		this.studentsPerformance = new ArrayList<>();
		
	}
	
	
	public static UniDB getInstance() {
        if (instance == null) {
            instance = new UniDB();
        }
        return instance;
    }
	
	public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Employee> getEmployees() {
        return Employees;
    }

    public ArrayList<studentCounceling> getStudentsCounceling() {
        return studentsCounceling;
    }

    public ArrayList<studentPerformance> getStudentsPerformance() {
        return studentsPerformance;
    }
    

}
