package dantelab3;

public class Student {
	String name;
	int id;
	float[] marks;
	
	public Student(String studentName, int studentId, float mark1, float mark2, float mark3) {
		name = studentName;
		id = studentId;
		marks = new float[3];
		
		marks[0] = mark1;
		marks[1] = mark2;
		marks[2] = mark3;
		
	}
	
	
	
	public float getAverageMarks() {
		float avg = 0;
		
		for(int i =0;i<marks.length;i++) {
			avg+= marks[i];
			
		}
		
		avg/=marks.length;
		
		
		return avg;
		
		
	}
	
	public void printStudentDetails() {
		System.out.println("Student Name: "+ name +"\nStudent ID: "+ id + "\nAverage Mark: " + getAverageMarks());
	
	}
	
	public boolean isPassing() {
		
		for(int i = 0;i<marks.length;i++) {
			if (marks[i] < 50) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void findTopScorer(Student[] students) {
		int highestIndex = 0;
		float highMarks = students[highestIndex].getAverageMarks();
		
		
		for(int i = 1; i<students.length;i++) {
			float tmp = students[i].getAverageMarks();
			
			if(highMarks< tmp) {
				highestIndex = i;
				highMarks = tmp;
				
			}
		}
		
		students[highestIndex].printStudentDetails();
	}
	
	
	
}
