package uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class universityManager {

	public universityManager() {
	}

	public void getNumberOfPapers(String ID) {
		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				System.out.println(stdp.getPapers().size());
			}
		}
		System.out.println("Student Performance not found");

	}

	public void getNumberOfSemesters(String ID) {
		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				System.out.println(stdp.getSemesterName().length);
			}
		}
		System.out.println("Student Performance not found");
	}

	public void getAverageMarks(String ID) {
		double total = 0;
		int count = 0;

		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				for (double mark : stdp.getMarks()) {
					total += mark;
					count++;
				}
				System.out.println(total / count);
			}
		}
		System.out.println("Student Performance not found");
	}

	public void getMaxMarks(String ID) {
		double maxMarks = Double.MIN_VALUE;

		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				for (double mark : stdp.getMarks()) {
					if (mark > maxMarks) {
						maxMarks = mark;
					}
				}
				break;
			}
		}
		System.out.println("Student Performance not found");
	}

	public void getTotalMarks(String ID) {
		double total = 0;
		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				for (double mark : stdp.getMarks()) {
					total += mark;
				}
			}
		}
		System.out.println(total);
	}

	public void printStudentMarks(String ID) {
		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				for (double mark : stdp.getMarks()) {
					System.out.println(mark);
				}
				return;
			}
		}
		System.out.println("Student performance not found for ID: " + ID);
	}

	public void getMinMarks(String ID) {
		double min = Double.MAX_VALUE;
		boolean found = false;

		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				found = true;
				for (double mark : stdp.getMarks()) {
					if (mark < min) {
						min = mark;
					}
				}
				break;
			}
		}

		if (found) {
			System.out.println("Minimum marks for student " + ID + ": " + min);
		} else {
			System.out.println("Student performance not found for ID: " + ID);
		}
	}

	public void getNumberOfEmployees(String ID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(ID)) {
				System.out.println(dept.getEmployees().size());
			}
		}
	}

	public void getNumberOfStudents(String ID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(ID)) {
				System.out.println(dept.getStudents().size());
			}
		}
	}

	public void getDepartment(String ID) {
		boolean found = false;
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(ID)) {
				dept.getInfo();
//				System.out.println(
//						dept.getDepartmentID() + " " + dept.getDepartmentName() + " " + dept.getEstablishmentDate());

			}
		}
//		if (found == false) {
//			System.out.println("Department not found");
//		} else {
//			return;
//		}

	}
	
	
	public void getStudentByDate(String date) {
        for (studentCounceling student : UniDB.getInstance().getStudentsCounceling()) {
            if (student.getDateOfBirth().equals(date)) {
                System.out.println("Student ID: " + student.getID() + ", Date of Birth: " + student.getDateOfBirth());
            }
        }
    }


	public void getDOBByDepartment(String ID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(ID)) {
				for (studentCounceling stc : dept.getStudents()) {
					System.out.println(stc.getDateOfBirth());
				}
			}
		}
	}

	public void getDOAByDepartment(String ID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(ID)) {
				for (studentCounceling stc : dept.getStudents()) {
					System.out.println(stc.getDateOfAdmission());
				}
			}
		}
	}

	public void getEmployeeInDepartment(String DEPTID, String EID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(DEPTID)) {
				for (Employee emp : UniDB.getInstance().getEmployees()) {
					if (emp.getID().equals(EID)) {
						emp.getInfo();
					}
				}
			}
		}
	}

	public void getStudentInDepartment(String DEPTID, String STDCID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(DEPTID)) {
				for (studentCounceling stdc : UniDB.getInstance().getStudentsCounceling()) {
					if (stdc.getID().equals(STDCID)) {
						stdc.getInfo();
					}
				}
			}
		}
	}

	public void getStudentPerformance(String ID) {
		boolean found = false;
		for (studentPerformance stdp : UniDB.getInstance().getStudentsPerformance()) {
			if (stdp.getID().equals(ID)) {
				stdp.getInfo();
//				System.out.println(stdp.getID() + " " + stdp.getDateOfBirth() + " " + stdp.getSemesterName() + " "
//						+ stdp.getMarks() + " " + stdp.getPapers());

			}
//			if (found == false) {
//				System.out.println("Student Performance not found");
//			} else {
//				return;
//			}
		}

	}

	public void getStudentCounceling(String ID) {
		boolean found = false;
		for (studentCounceling stdc : UniDB.getInstance().getStudentsCounceling()) {
			if (stdc.getID().equals(ID)) {
				stdc.getInfo();
//				System.out.println(stdc.getID() + " " + stdc.getDateOfBirth() + " " + stdc.getDateOfAdmission() + " "
//						+ stdc.getDepartmentAdmitted().getDepartmentID() + " " + stdc.getDepartmentChoice().getDepartmentID());
			}

		}
//		if (found == false) {
//			System.out.println("Student Counceling not found");
//		} else {
//			return;
//		}

	}

	public void getEmployees(String ID) {
		boolean found = false;
		for (Employee emp : UniDB.getInstance().getEmployees()) {
			if (emp.getID().equals(ID)) {
				found = true;
				emp.getInfo();

//				System.out.println(emp.getID() + " " + emp.getDateOfBirth() + " " + emp.getDateOfJoining()
//						+ " work in: " + emp.getDepartment().getDepartmentID() + " "
//						+ emp.getDepartment().getDepartmentName());
			}
		}
//		if (found == false) {
//			System.out.println("Employee not found");
//		} else {
//			return;
//		}
	}

}