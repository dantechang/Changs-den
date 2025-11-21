package dantelab4;

public class Main {

	public static void main(String[] args) {
		// Create objects
		
		BackendDeveloper backendDev = new BackendDeveloper("Alice", 1001, 6000.0, "Backend Developper", "Java");
		AutomationTester tester = new AutomationTester("Bob", 1002, 5500.0, "Automation Tester", "Selenium");
		ProjectManager manager = new ProjectManager("Carol", 1003, 8000.0, "Project Manager", 5);
		BackendDeveloper backendDev2 = new BackendDeveloper("Mike", 1004, 6500.0, "Backend Developer", "Java");
		
		// Polymorphism: Treating each as an Employee
		Employee emp1 = backendDev;
		Employee emp2 = tester;
		Employee emp3 = manager;
		Employee emp4 = backendDev2;
		
		// Calling performDuties() using polymorphism
		emp1.performDuties();
		emp2.performDuties();
		emp3.performDuties();
		emp4.performDuties();
		
		// Calling specific methods of each class
		backendDev.optimizeDatabase(); // Specific method for backendDeveloper
		tester.writeAutomationScript(); // Specific method for AutomationTester
		manager.scheduleMeeting(); // Specific method for ProjectManager
		
		
	}

}
