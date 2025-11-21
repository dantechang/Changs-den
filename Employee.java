package dantelab4;

public class Employee {
		String name;
		int id;
		double salary;
		String jobTitle;
		
		
	public Employee(String empName, int empId, double empSalary, String empTitle) {
		
		name = empName;
		id = empId;
		salary = empSalary;
		jobTitle = empTitle;
		
	}
	
	public void performDuties() {
		System.out.println("Average employee duties");
	}
}
