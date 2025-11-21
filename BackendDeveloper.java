package dantelab4;

public class BackendDeveloper extends Developer{
	
	public BackendDeveloper(String empName, int empId, double empSalary, String empTitle, String lang) {
		
		super(empName,empId,empSalary, empTitle, lang);
		
	}
	
	public void optimizeDatabase() {
		System.out.println(this.name + " is optimizing database queries for better performance.");
	}
	
	public void performDuties() {
		System.out.println(this.name + " is building APIs and ensuring database integration.");
	}
}
