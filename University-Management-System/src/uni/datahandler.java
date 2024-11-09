package uni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class datahandler {
	private Reader reader = new Reader();

	public datahandler() {
		
	}
	
	public void readTXTfileDepartment(String filepath) {
        List<String> lines = reader.read(filepath);
        for (String line : lines) {
            String[] values = line.split("\\|");
            if (values.length == 3) {
                CreateDepartment(values);
            } else {
                System.out.println("Invalid department entry: " + line);
            }
        }
    }

    public void readTXTfileEmployee(String filepath) {
        List<String> lines = reader.read(filepath);
        for (String line : lines) {
            String[] values = line.split("\\|");
            if (values.length == 4) {
                Department departmentworkin = findDepartment(values[3]);
                CreateEmployee(values, departmentworkin);
            } else {
                System.out.println("Invalid employee entry: " + line);
            }
        }
    }

    public void readTXTfileStudentCounseling(String filepath) {
        List<String> lines = reader.read(filepath);
        for (String line : lines) {
            String[] values = line.split("\\|");
            if (values.length == 5) {
                Department deptChoice = findDepartment(values[3]);
                Department deptAdmitted = findDepartment(values[4]);
                CreateStudentCounseling(values, deptChoice, deptAdmitted);
            } else {
                System.out.println("Invalid student counseling entry: " + line);
            }
        }
    }

    public void readTXTfileStudentPerformance(String filepath) {
        List<String> lines = reader.read(filepath);
        for (String line : lines) {
            String[] values = line.split("\\|");
            if (values.length >= 5) {
                String[] semesterNames = values[1].split(",");
                double[] marks = Arrays.stream(values[4].split(",")).mapToDouble(Double::parseDouble).toArray();
                List<Paper> papers = new ArrayList<>();
                for (int i = 2; i < values.length - 2; i += 2) {
                    papers.add(new Paper(values[i], values[i + 1]));
                }
                CreateStudentPerformance(values[0], values[3], semesterNames, marks, papers);
            } else {
                System.out.println("Invalid student performance entry: " + line);
            }
        }
    }

	

	private Department findDepartment(String deptID) {
		for (Department dept : UniDB.getInstance().getDepartments()) {
			if (dept.getDepartmentID().equals(deptID)) {
				return dept;
			}
		}
		return null;
	}

	private void CreateDepartment(String[] values) {
	    UniDB.getInstance().getDepartments().add(new Department(values[0], values[1], values[2]));
	    
	}

	private void CreateEmployee(String[] values, Department departmentWorking) {
	    UniDB.getInstance().getEmployees().add(new Employee(values[0], values[1], values[2], departmentWorking));
	}

	private void CreateStudentCounseling(String[] values, Department deptChoice, Department deptAdmitted) {
	    UniDB.getInstance().getStudentsCounceling().add(new studentCounceling(values[0], values[1], values[2], deptChoice, deptAdmitted));
	}


	private void CreateStudentPerformance(String value1, String value2, String[] semesterNames, double[] marks, List<Paper> papers) {
	    UniDB.getInstance().getStudentsPerformance().add(new studentPerformance(value1, value2, semesterNames, marks, papers));
	}
	
	
	public void InitialiseDepartment() {
		for (Employee emp : UniDB.getInstance().getEmployees()) {
	        for (Department dept : UniDB.getInstance().getDepartments()) {
	            if (emp.getDepartment().getDepartmentID().equals(dept.getDepartmentID())) {
	                dept.addEmployee(emp);
	            }
	        }
	    }

		
	    for (studentCounceling sc : UniDB.getInstance().getStudentsCounceling()) {
	        for (Department dept : UniDB.getInstance().getDepartments()) {
	            if (sc.getDepartmentAdmitted().getDepartmentID().equals(dept.getDepartmentID())) {
	                dept.addStudentCounceling(sc);
	            }
	        }
	    }
	}


}

//
//
//public void readTXTfileDepartment(String filepath) {		
//	try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//		String line;
//		boolean isFirstLine = true;
//		while ((line = br.readLine()) != null) {
//			if (isFirstLine) {
//				isFirstLine = false;
//				continue;
//			}
//			String[] values = line.split("\\|");
//			if (values.length == 3) {
//				CreateDepartment(values);
////				UniDB.getInstance().getDepartments().add(new Department(values[0], values[1], values[2]));
//			} else {
//				System.out.println("Invalid department entry: " + line);
//			}
//		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
//
//public void readTXTfileEmployee(String filepath) {
//	try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//		String line;
//		boolean isFirstLine = true;
//		while ((line = br.readLine()) != null) {
//			if (isFirstLine) {
//				isFirstLine = false;
//				continue;
//			}
//			String[] values = line.split("\\|");
//			Department departmentworkin = findDepartment(values[3]);
//			if (values.length == 4) {
//				CreateEmployee(values, departmentworkin);
////				UniDB.getInstance().getEmployees()
////						.add(new Employee(values[0], values[1], values[2], departmentworkin));
//			} else {
//				System.out.println("Invalid employee entry: " + line);
//			}
//		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
//
//public void readTXTfileStudentCounseling(String filepath) {
//	try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//		String line;
//		boolean isFirstLine = true;
//		while ((line = br.readLine()) != null) {
//			if (isFirstLine) {
//				isFirstLine = false;
//				continue;
//			}
//			String[] values = line.split("\\|");
//			if (values.length == 5) {
//				Department deptChoice = findDepartment(values[3]);
//				Department deptAdmitted = findDepartment(values[4]);
//				CreateStudentCounseling(values, deptChoice, deptAdmitted);
////				UniDB.getInstance().getStudentsCounceling()
////						.add(new studentCounceling(values[0], values[1], values[2], deptChoice, deptAdmitted));
//			} else {
//				System.out.println("Invalid student counseling entry: " + line);
//			}
//		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
//
//public void readTXTfileStudentPerformance(String filepath) {
//	try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//		String line;
//		boolean isFirstLine = true;
//		while ((line = br.readLine()) != null) {
//			if (isFirstLine) {
//				isFirstLine = false;
//				continue;
//			}
//			String[] values = line.split("\\|");
//			if (values.length >= 5) {
//				String[] semesterNames = values[1].split(",");
//				double[] marks = Arrays.stream(values[4].split(",")).mapToDouble(Double::parseDouble).toArray();
//				List<Paper> papers = new ArrayList<>();
//
//				for (int i = 2; i < values.length - 2; i += 2) {
//					papers.add(new Paper(values[i], values[i + 1]));
//				}
//				CreateStudentPerformance(values[0], values[3], semesterNames, marks, papers);
////				UniDB.getInstance().getStudentsPerformance()
////						.add(new studentPerformance(values[0], values[3], semesterNames, marks, papers));
//			} else {
//				System.out.println("Invalid student performance entry: " + line);
//			}
//		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
