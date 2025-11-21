package dantelab4;

public class ProjectManager extends Employee{
	
	int numProjects;
	public ProjectManager(String empName, int empId, double empSalary, String empTitle, int projects) {
		
		super(empName, empId, empSalary, empTitle);
		numProjects = projects;
		
	}
	
	public void scheduleMeeting() {
		System.out.println(this.name + " is scheduling a team meeting.");
	}
	
	public void performDuties() {
		System.out.println(this.name + " is managing teams and overseeing project deadlines.");
	}
}
