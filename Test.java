package dantelab3;import dantelab3.Student;import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Student[] course = new Student[5];
		Scanner keyboard = new Scanner(System.in);
		
		for(int i = 0; i<5;i++) {
			System.out.println("Student #" + (i+1));
			System.out.println("Name: ");
			String name = keyboard.next();
			
			System.out.println("Student id: ");
			
			int id = keyboard.nextInt();
			float mark1,mark2,mark3;
			
			
			while(true) {
				System.out.println("Mark 1: ");
				mark1 = keyboard.nextFloat();
				
				
				if(mark1>= 0 && mark1<=100) {
					break;
				}
			}
			
			
			
			
			while(true) {
				System.out.println("Mark 2: ");
				mark2 = keyboard.nextFloat();
				
				
				if(mark2>= 0 && mark2<=100) {
					break;
				}
			}
			


			while(true) {
				System.out.println("Mark 3: ");
				mark3 = keyboard.nextFloat();
				
				
				if(mark3>= 0 && mark3<=100) {
					break;
				}
			}
			
		
			
			
			
			course[i]= new Student(name,id,mark1,mark2,mark3);
			System.out.println();
		}
		
		System.out.println("\nfindTopScorer method check");
		Student.findTopScorer(course);
		
		System.out.println("\nHeres the array of Students sorted:\n");
		for(int i = 0;i <5;i++) {
			
			int biggestIndex = i;
			float currentBig = course[i].getAverageMarks();
			for(int j = i;j<5;j++) {
				
				float tmp = course[j].getAverageMarks();
				
				if (tmp> currentBig) {
					currentBig = tmp;
					biggestIndex = j;
				}
			}
			
			Student swap = course[i];
			
			course[i] = course[biggestIndex];
			
			course[biggestIndex] = swap;
			
		}
		
		
		for(int i = 0;i<5;i++) {
			course[i].printStudentDetails();
			System.out.println("Is Passing: "+ course[i].isPassing() + "\n");
		}
		
		
		
		System.out.println("\nEnter a student id to search: ");
		int search = keyboard.nextInt();
		
		for(int i = 0;i<5;i++) {
			if(course[i].id == search) {
				course[i].printStudentDetails();
				System.exit(0);
			}
		}
		
		System.out.println("\nStudent with following ID was not found");
		
	}

}
