//package Testing;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import uni.*;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DataHandlerTests {
//
//    static datahandler handler;
//    static userInterference UI;
//
//    @BeforeAll
//    static void setUpBeforeClass() {
//        handler = new datahandler();
//        UI = new userInterference();
//    }
//
//    @Test
//    void testReadTXTfileDepartment() {
//        // Test reading a valid department file with correct format
//        handler.readTXTfileDepartment("test_files/ValidDepartment.txt");
//        ArrayList<Department> departments = UniDB.getInstance().getDepartments();
//        assertEquals(1, departments.size());
//
//        // Test reading an invalid department file with incorrect format
//        handler.readTXTfileDepartment("test_files/InvalidDepartment.txt");
//        assertEquals(1, departments.size()); // Should not add invalid data
//
//        // Test reading an empty department file
//        handler.readTXTfileDepartment("test_files/EmptyDepartment.txt");
//        assertEquals(1, departments.size()); // Should not add empty data
//    }
//
//    @Test
//    void testReadTXTfileEmployee() {
//        // Test reading a valid employee file with correct format
//        handler.readTXTfileEmployee("test_files/ValidEmployee.txt");
//        ArrayList<Employee> employees = UniDB.getInstance().getEmployees();
//        assertEquals(1, employees.size());
//
//        // Test reading an invalid employee file with incorrect format
//        handler.readTXTfileEmployee("test_files/InvalidEmployee.txt");
//        assertEquals(1, employees.size()); // Should not add invalid data
//
//        // Test reading an empty employee file
//        handler.readTXTfileEmployee("test_files/EmptyEmployee.txt");
//        assertEquals(1, employees.size()); // Should not add empty data
//    }
//
//    @Test
//    void testReadTXTfileStudentCounseling() {
//        
//        handler.readTXTfileStudentCounseling("test_files/ValidStudentCounseling.txt");
//        ArrayList<studentCounceling> studentsCounseling = UniDB.getInstance().getStudentsCounceling();
//        assertEquals(1, studentsCounseling.size());
//
//        handler.readTXTfileStudentCounseling("test_files/InvalidStudentCounseling.txt");
//        assertEquals(1, studentsCounseling.size());
//
//        
//        handler.readTXTfileStudentCounseling("test_files/EmptyStudentCounseling.txt");
//        assertEquals(1, studentsCounseling.size());
//    }
//
//    @Test
//    void testReadTXTfileStudentPerformance() {
//        
//        handler.readTXTfileStudentPerformance("test_files/ValidStudentPerformance.txt");
//        ArrayList<studentPerformance> studentsPerformance = UniDB.getInstance().getStudentsPerformance();
//        assertEquals(1, studentsPerformance.size());
//
//        
//        handler.readTXTfileStudentPerformance("test_files/InvalidStudentPerformance.txt");
//        assertEquals(1, studentsPerformance.size());
//
//        
//        handler.readTXTfileStudentPerformance("test_files/EmptyStudentPerformance.txt");
//        assertEquals(1, studentsPerformance.size());
//    }
//
//    @Test
//    void testAddEmployee() {
//        Department department = new Department("001", "Engineering", "2020-01-01");
//        Employee employee = new Employee("E001", "1990-01-01", "2022-01-01", department);
//
//        
//        department.addEmployee(employee);
//        assertEquals(1, department.getEmployees().size());
//
//        
//        department.addEmployee(null);
//        assertEquals(1, department.getEmployees().size());
//        
//        Employee anotherEmployee = new Employee("E002", "1995-01-01", "2023-01-01", null);
//        assertNull(anotherEmployee.getDepartment());
//    }
//
//    @Test
//    void testGetDepartmentInfo() {
//        Department department = new Department("001", "Engineering", "2020-01-01");
//
//        String info = department.getInfo();
//        assertNotNull(info);
//
//        assertEquals("Department ID: 001\nDepartment Name: Engineering\nEstablishment Date: 2020-01-01\nEmployees: \nStudents: \n", info);
//
//        Department nullDepartment = null;
//        assertThrows(NullPointerException.class, () -> {
//            nullDepartment.getInfo();
//        });
//    }
//
//    @Test
//    void testGetEmployeeInfo() {
//        Department department = new Department("001", "Engineering", "2020-01-01");
//        Employee employee = new Employee("E001", "1990-01-01", "2022-01-01", department);
//
//        String info = employee.getInfo();
//        assertNotNull(info);
//
//        Employee anotherEmployee = new Employee("E002", "1995-01-01", "2023-01-01", null);
//        assertEquals("Employee ID: E002\nDate of Birth: 1995-01-01\nJoining Date: 2023-01-01\nDepartment: \n", anotherEmployee.getInfo());
//
//        Employee nullEmployee = null;
//        assertThrows(NullPointerException.class, () -> {
//            nullEmployee.getInfo();
//        });
//    }
//    @Test
//    void testInitializeDepartment() {
//    	UI.getHandler().InitialiseDepartment();
//        ArrayList<Department> departments = UniDB.getInstance().getDepartments();
//        assertEquals(1, departments.size());
//    }
//
//    @Test
//    void testUniversityManagerOperations() {
//    	
//
//        // Test retrieving department information through the university manager
//        String departmentInfo = UI.getManager().getDepartment(null);
//        assertNotNull(departmentInfo);
//
//        // Test retrieving employee information through the university manager
//        String employeeInfo = UI.getManager().getEmployees(null);
//        assertNotNull(employeeInfo);
//
//        // Test retrieving student counseling information through the university manager
//        String studentCounselingInfo = UI.getManager().getStudentCounceling(null);
//        assertNotNull(studentCounselingInfo);
//
//        // Test retrieving student performance information through the university manager
//        String studentPerformanceInfo = UI.getManager().getStudentPerformance(null);
//        assertNotNull(studentPerformanceInfo);
//
//}
