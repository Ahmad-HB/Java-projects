import java.util.*;

public class HospitalManagementSystem {
     static final int ROOMS = 9;
     static final int EXITS = 4;

	private LinkedList patientList;
    private Queue emergencyQueue;
    private Stack dischargeStack;
    private Graph hospitalGraph;
    private BST employeeTree;
	
	public HospitalManagementSystem() {
		this.patientList = new LinkedList();
		this.emergencyQueue = new Queue();
		this.dischargeStack = new Stack();
		this.hospitalGraph = new Graph(ROOMS + EXITS);
		this.employeeTree = new BST();

        initializeGraph(hospitalGraph);

        Patient p1 = new Patient("nega1", 66);
        Patient p2 = new Patient("nega2", 9);
        Patient p3 = new Patient("nega3", 34);
        Patient p4 = new Patient("nega4", 77);
        patientList.addFirst(p1);
        patientList.addLast(p2);
        patientList.addLast(p3);
        patientList.addLast(p4);

        Patient p5 = new Patient("nega5", 66);
        Patient p6 = new Patient("nega6", 9);
        Patient p7 = new Patient("nega7", 34);
        Patient p8 = new Patient("nega8", 77);
        emergencyQueue.enqueue(p5);
        emergencyQueue.enqueue(p6);
        emergencyQueue.enqueue(p7);
        emergencyQueue.enqueue(p8);

        Employee e1 = new Employee("GoldenNega1", 6);
        Employee e2 = new Employee("GoldenNega2", 9);
        Employee e3 = new Employee("GoldenNega3", 6);
        Employee e4 = new Employee("GoldenNega4", 9);
        employeeTree.insert(e1);
        employeeTree.insert(e2);
        employeeTree.insert(e3);
        employeeTree.insert(e4);
		
	}
	
	public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient to registration");
            System.out.println("2. Remove Patient from registration");
            System.out.println("3. Sort Patients By Age");
            System.out.println("4. Sort Patients By ID");
            System.out.println("5 List All Patients in registration");
            System.out.println("6. Add Patient to Emergency");
            System.out.println("7. Remove Patient from Emergency");
            System.out.println("8. View Emergency");
            System.out.println("9. Add Patient to Consultation");
            System.out.println("10. View Consultation");
            System.out.println("11. Remove Patient from Consultation");
            System.out.println("12. Add Employee");
            System.out.println("13. Search Employee by ID");
            System.out.println("14. Search Employee by Name");
            System.out.println("15. List All Employees");
            System.out.println("16. Print Graph");
            System.out.println("17. Find Nearest Exit (Dijkstra)");
            System.out.println("18. Find Nearest Exit (Bellman-Ford)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPatient(scanner);
                case 2 -> removePatientfromregistration(scanner);
                case 3 -> sortByAge();
                case 4 -> sortById();
                case 5 -> listAllPatients();
                case 6 -> addEmergency(scanner);
                case 7 -> removePatientfromQueue(scanner);
                case 8 -> viewemergencyQueue();
                case 9 -> dischargePatient(scanner);
                case 10 -> viewConsultation();
                case 11 -> removePatientfromConsultation();
                case 12 -> addEmployee(scanner);
                case 13 -> searchEmployeeById(scanner);
                case 14 -> searchEmployeeByName(scanner);
                case 15 -> listAllEmployees();
                case 16 -> hospitalGraph.printGraph();
                case 17 -> findNearestExitdijkstra();
                case 18 -> findNearestExitBellmanFord();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        if(patientList.isEmpty()) {
            patientList.addFirst(new Patient(name, age));
            System.out.println("Patient added successfully.");
            return;
        }

        patientList.addLast(new Patient(name, age));
        System.out.println("Patient added successfully.");
    }

    private void addexistingpatient (Patient patient) {
        if(patientList.isEmpty()) {
            patientList.addFirst(patient);
            System.out.println("Patient added successfully.");
            return;
        }

        patientList.addLast(patient);
        System.out.println("Patient added successfully.");

        patientDequeueDone();

    }

    private void listAllPatients() {
        System.out.println("All Patients:");
        patientList.printAll();
    }

    private void addEmergency(Scanner scanner) {

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Patient ptemp = new Patient(name, age);

        if (ptemp != null) {
            emergencyQueue.enqueue(ptemp);
            System.out.println("Patient with ID: "+ptemp.getPatientId()+" And with the name: "+ptemp.getName()+" added to Emergency ");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void viewemergencyQueue() {
        System.out.println("Appointment Queue:");
        emergencyQueue.printQueue();
    }

    private void dischargePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to Add to Consultation : ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = (Patient) patientList.searchById(patientId);
        if (patient != null) {
            dischargeStack.push(patient);
            System.out.println("Patient ID " + patientId + " Added to Consultation.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(name, age);
        employeeTree.insert(employee);
        System.out.println("Employee added successfully.");
    }

    private void searchEmployeeById(Scanner scanner) {
        System.out.print("Enter Employee ID to Search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        employeeTree.searchById(id);
    }

    private void searchEmployeeByName(Scanner scanner) {
        System.out.print("Enter Employee Name to Search: ");
        String name = scanner.nextLine();

        employeeTree.searchByName(name);
    }

    private void listAllEmployees() {
        System.out.println("All Employees (Sorted by ID):");
        employeeTree.inOrderTraversal();
    }

    private void removePatient(){
        System.out.print("Enter Patient ID to remove: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();

        patientList.deleteById(id);
    }

    private void removePatientfromregistration (Scanner scanner) {

        System.out.println("1. Remove the patient");
        System.out.println("2. Send the patient to Consultation");

        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1 -> removePatient();
            case 2 -> sendToConsultation();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void removePatientfromQueue(Scanner scanner) {

        System.out.println("1. Remove the patient");
        System.out.println("2. Send the patient to Registration");

        int input = scanner.nextInt();
        scanner.nextLine();
        Patient ptemp = (Patient) emergencyQueue.peek();

        switch (input) {
            case 1 -> patientDequeueDone();
            case 2 -> addexistingpatient(ptemp);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void patientDequeueDone () {
        Patient ptemp = (Patient) emergencyQueue.peek();
        emergencyQueue.dequeueDone();

        System.out.println("Patient ID " + ptemp.getPatientId() + " removed from Emergency.");
    }

    private void sendToConsultation() {
        System.out.print("Enter Patient ID to Send to Consultation: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient ptemp = patientList.searchById(id);

        if (ptemp != null) {
            dischargeStack.push(ptemp);
            System.out.println("Patient ID " + ptemp.getPatientId() + " sent to consultation.");
            patientList.deleteById(id);
        } else {
            System.out.println("No patients to send to consultation.");

        }
    }

    private void sortByAge() {
    	patientList.sortByAge();
    }

    private void sortById() {
    	patientList.sortById();
    }

    private void viewConsultation (){
        	dischargeStack.printStack();
    }

    private void removePatientfromConsultation() {
        Patient patient = (Patient) dischargeStack.pop();
        if (patient != null) {
            System.out.println("Patient ID " + patient.getPatientId() + " removed from Consultation.");
        }
    }

    private void initializeGraph(Graph graph) {
        int[][] adjacencyMatrix = {
                // Rooms (R0 to R8) and Exits (E0 to E3)
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0},
                {2, 0, 3, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0},
                {0, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 0, 5, 0, 7, 0, 0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 7, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 6, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0, 1, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 1, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 5, 0, 0, 0, 0, 0, 0}
        };

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    graph.addEdge(i, j, adjacencyMatrix[i][j]);
                }
            }
        }
    }

//    private void findnearestExit(){
//        System.out.print("Enter source room (0 to " + (ROOMS - 1) + "): ");
//        Scanner scanner = new Scanner(System.in);
//        int source = scanner.nextInt();
//
//        if (source < 0 || source >= ROOMS) {
//            System.out.println("Invalid room number.");
//            return;
//        }
//
//        Dijkstra dijkstra = new Dijkstra(hospitalGraph.getAdjacencyMatrix());
//        int[] distances = dijkstra.shortestPath(source);
//
//        int nearestExit = -1;
//        int minDistance = Integer.MAX_VALUE;
//
//        for (int i = ROOMS; i < ROOMS + EXITS; i++) {
//            if (distances[i] < minDistance) {
//                minDistance = distances[i];
//                nearestExit = i;
//            }
//        }
//
//        if (nearestExit != -1) {
//            System.out.println("Nearest exit: Exit " + (nearestExit - ROOMS) + " at distance " + minDistance);
//        } else {
//            System.out.println("No exit reachable.");
//        }
//    }

    private void findNearestExitdijkstra() {
    System.out.print("Enter source room (0 to " + (ROOMS - 1) + "): ");
    Scanner scanner = new Scanner(System.in);
    int source = scanner.nextInt();

    if (source < 0 || source >= ROOMS) {
        System.out.println("Invalid room number.");
        return;
    }

    Dijkstra dijkstra = new Dijkstra(hospitalGraph.getAdjacencyMatrix());
    Dijkstra.Result result = dijkstra.shortestPath(source);

    int[] distances = result.distances;
    int[] parents = result.parents;

    int nearestExit = -1;
    int minDistance = Integer.MAX_VALUE;

    for (int i = ROOMS; i < ROOMS + EXITS; i++) {
        if (distances[i] < minDistance) {
            minDistance = distances[i];
            nearestExit = i;
        }
    }

    if (nearestExit != -1) {
        System.out.println("Nearest exit: Exit " + (nearestExit - ROOMS) + " at distance " + minDistance);
        System.out.print("Path: ");
        printPath(parents, source, nearestExit);
    } else {
        System.out.println("No exit reachable.");
    }
}

    private void findNearestExitBellmanFord() {
        System.out.print("Enter source room (0 to " + (ROOMS - 1) + "): ");
        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();

        if (source < 0 || source >= ROOMS) {
            System.out.println("Invalid room number.");
            return;
        }

        BellmanFord bellmanFord = new BellmanFord(hospitalGraph.getAdjacencyMatrix());
        BellmanFord.Result result = bellmanFord.shortestPath(source);

        int[] distances = result.distances;
        int[] parents = result.parents;

        int nearestExit = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = ROOMS; i < ROOMS + EXITS; i++) {
            if (distances[i] < minDistance) {
                minDistance = distances[i];
                nearestExit = i;
            }
        }

        if (nearestExit != -1) {
            System.out.println("Nearest exit: Exit " + (nearestExit - ROOMS) + " at distance " + minDistance);
            System.out.print("Path: ");
            printPath(parents, source, nearestExit);
        } else {
            System.out.println("No exit reachable.");
        }
    }

    private void printPath(int[] parents, int source, int target) {
        List<Integer> path = new ArrayList<>();
        int current = target;

        while (current != -1) {
            path.add(current);
            current = parents[current];
        }

        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) < ROOMS) {
                System.out.print("R" + path.get(i));
            } else {
                System.out.print("E" + (path.get(i) - ROOMS));
            }
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

}