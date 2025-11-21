package dantelab4;

public class Developer extends Employee{
	String programLang;
	
	public Developer(String empName, int empId, double empSalary, String empTitle, String lang) {
		
		super(empName, empId, empSalary, empTitle);
		programLang = lang;
		
	}
	
	
}
