package dantelab4;

public class AutomationTester extends Tester{
	String autoHelper;
	
	public AutomationTester(String empName, int empId, double empSalary, String empTitle, String helper) {
		
		super(empName, empId, empSalary, empTitle);
		autoHelper = helper;
		
	}
	
	public void writeAutomationScript() {
		System.out.println(this.name + " is writing an automation script for regression testing.");
		
		}
	
	public void performDuties() {
		System.out.println(this.name + " is writing scripts to automate test cases.");
	}
}
