
public class PayrollSystem {
	public static void displayEmployeeInfo(Employee emp) {
		System.out.println("\nEmployee name: " + emp.getEmployeeName() + "\nEmployee ID: " + emp.getEmployeeID() + "\nSalary: " + emp.getSalary() + "\nBonus Percentage: " + emp.getBonusPercentage() 
		+ "\nAddress: "+ emp.getAddress() + "\nJob Title: "+ emp.getJobTitle() + "\n");
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("Dante", "110289", 200000, 95, "915 Westminster", "Developer"); //valid attributes
		PayrollSystem.displayEmployeeInfo(emp1);
		
		Employee emp2 = new Employee("Rob", "112893", 400000, 50, "2596 Lloyd George", "Tester"); //invalid salary
		PayrollSystem.displayEmployeeInfo(emp2);	
		
		emp2.setSalary(80000);
		
		PayrollSystem.displayEmployeeInfo(emp2);
		
		
		
		Employee emp3 = new Employee("", "0124 ", 40000, -2, "945Mckay", "Manage"); //invalid everything
		PayrollSystem.displayEmployeeInfo(emp3);
		emp3.setEmployeeName("Bianca");
		emp3.setEmployeeID("110218");
		emp3.setBonusPercentage(10);
		emp3.setAddress("945 Mckay");
		emp3.setJobTitle("Manager");
		
		PayrollSystem.displayEmployeeInfo(emp3);
		
		
	}
}
