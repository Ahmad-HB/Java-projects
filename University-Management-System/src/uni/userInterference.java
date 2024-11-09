package uni;

import java.lang.runtime.SwitchBootstraps;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class userInterference {
	private universityManager manager;
	private datahandler handler;
	private static Scanner scanner = new Scanner(System.in);

	public userInterference() {
		this.manager = new universityManager();
		this.handler = new datahandler();
	}

	public void start() {

		handler.readTXTfileDepartment("src/Department_Information.txt");
		handler.readTXTfileEmployee("src/Employee_Information.txt");
		handler.readTXTfileStudentPerformance("src/Student_Performance_Data.txt");
		handler.readTXTfileStudentCounseling("src/Student_Counceling_Information.txt");
		handler.InitialiseDepartment();

		System.out.println("1. Retrieve information by ID");
		System.out.println("2. Retrieve all students' dates of birth in a given department");
		System.out.println("3. Retrieve all students' dates of admission in a given department");
		System.out.println("4. Perform operation on student");
		System.out.println("5. Perform operation on department");
		System.out.println("6. Retrieve student info and employee in specific department");
		System.out.println("7. Exit");
		
//		System.out.println(UniDB.getInstance().getDepartments().size());
//		System.out.println(UniDB.getInstance().getEmployees().size());
//		System.out.println(UniDB.getInstance().getStudentsCounceling().size());
//		System.out.println(UniDB.getInstance().getStudentsPerformance().size());

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			retrieveByID();
			break;
		case 2:
                retrieveDOBByDepartment();
			break;
		case 3:
                retrieveDOAByDepartment();
			break;
		case 4:
			studentOperation();
			break;
		case 5:
			departmentOperation();
			break;
		case 6:
			retrieveInSpecificDepartment();
			break;
		case 7:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
			start();
			break;
		}
	}

	public void retrieveByID() {
		System.out.println("1. Retrieve department");
		System.out.println("2. Retrieve student Counceling");
		System.out.println("3. Retrieve student Performance");
		System.out.println("4. Retrieve employee");
		System.out.println("5. Back");
		System.out.println("6. Exit");

		String studentID;
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Please enter department ID:");
			String deptID = scanner.nextLine();
			manager.getDepartment(deptID);

			break;
		case 2:
			System.out.println("Please enter student Counceling ID:");
			studentID = scanner.nextLine();
			manager.getStudentCounceling(studentID);
			break;
		case 3:
			System.out.println("Please enter student Performance ID:");
			studentID = scanner.nextLine();
			manager.getStudentPerformance(studentID);
			break;
		case 4:
			System.out.println("Please enter employee ID:");
			String employeeID = scanner.nextLine();
			manager.getEmployees(employeeID);
			break;
		case 5:
			start();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
			retrieveByID();
			break;
		}
	}

    public void retrieveDOBByDepartment() {
//        System.out.println("Please enter department ID:");
//        String deptID = scanner.nextLine();
//        manager.getDOBByDepartment(deptID);
    	
    	System.out.println("Please enter student date:");
    	String deptID = scanner.nextLine();
    	manager.getStudentByDate(deptID);
      
    }

    public void retrieveDOAByDepartment() {
        System.out.println("Please enter department ID:");
        String deptID = scanner.nextLine();
        manager.getDOAByDepartment(deptID);
    }

	public void studentOperation() {
		System.out.println("1. Number of papers");
		System.out.println("2. Number of semesters");
		System.out.println("3. Average, sum, max, and min marks");
		System.out.println("4. Back");
		System.out.println("5. Exit");
		
		String studentID;
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Please enter student Performance ID:");
			studentID = scanner.nextLine();
			manager.getNumberOfPapers(studentID);
			break;
		case 2:
			System.out.println("Please enter student Performance ID:");
			studentID = scanner.nextLine();
			manager.getNumberOfSemesters(studentID);
			break;
		case 3:
			System.out.println("Please enter student Performance ID:");
			studentID = scanner.nextLine();
			manager.getAverageMarks(studentID);
			manager.getTotalMarks(studentID);
			manager.getMaxMarks(studentID);
			manager.getMinMarks(studentID);
			break;
		case 4:
			start();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
			studentOperation();
			break;
		}
	}

	public void departmentOperation() {
		System.out.println("1. Number of employees");
		System.out.println("2. Number of students");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		
		String deptID;
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Please enter department ID:");
	        deptID = scanner.nextLine();
	        manager.getNumberOfEmployees(deptID);
			break;
		case 2:
			System.out.println("Please enter department ID:");
	        deptID = scanner.nextLine();
	        manager.getNumberOfStudents(deptID);
			break;
		case 3:
			start();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
			departmentOperation();
			break;
		}
	}

	public void retrieveInSpecificDepartment() {
		System.out.println("1. Retrieve specific Employee in department");
		System.out.println("2. Retrieve specific student in department");
		System.out.println("3. Back");
		System.out.println("4. Exit");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Enter department ID:");
			String deptID = scanner.nextLine();
			System.out.println("Enter employee ID:");
			String employeeID = scanner.nextLine();
			manager.getEmployeeInDepartment(deptID, employeeID);
			break;
		case 2:
			System.out.println("Enter department ID:");
			String departmentID = scanner.nextLine();
			System.out.println("Enter student ID:");
			String studentID = scanner.nextLine();
			manager.getStudentInDepartment(departmentID, studentID);
			break;
		case 3:
			start();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
			retrieveInSpecificDepartment();
			break;
		}
	}

	public universityManager getManager() {
		return manager;
	}

	public datahandler getHandler() {
		return handler;
	}
	
}


//public void start() {
//System.out.println("Select which file do you want to read from?");
//System.out.println("1. TXT files");
//System.out.println("2. Exit");
//
//int choice = scanner.nextInt();
//scanner.nextLine();
//
//switch (choice) {
//case 1:
//	handler.readCSVfileDepartment("/Final/src/Department_Information.csv");
//	handler.readCSVfileEmployee("/Final/src/Employee_Information.csv");
//	handler.readCSVfileStudentCounseling("/Final/src/Student_Counceling_Information.csv");
//	handler.readCSVfileStudentPerformance("/Final/src/Student_Performance_Data.csv");
//	functions();
//	break;
//case 1:
//	handler.readTXTfileDepartment(
//			"/Users/ahmad/eclipse-workspace Advanec/Final/src/Department_Information.txt");
//	handler.readTXTfileEmployee("Users/ahmad/eclipse-workspace Advanec/Final/src/Employee_Information.txt");
//	handler.readTXTfileStudentCounseling(
//			"Users/ahmad/eclipse-workspace Advanec/Final/src/Student_Counceling_Information.txt");
//	handler.readTXTfileStudentPerformance(
//			"/Users/ahmad/eclipse-workspace Advanec/Final/src/Student_Performance_Data.txt");
//	functions();
//	break;
//case 2:
//	System.exit(0);
//	break;
//default:
//	System.out.println("Invalid option. Please try again.");
//	start();
//	break;
//}
//}

