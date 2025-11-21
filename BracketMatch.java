package Dante; import Dante.StackImplement; import java.util.Scanner;

public class BracketMatch {

	public static boolean bracket(String input){
		Dante.StackImplement s = new Dante.StackImplement();
		
		char[] array = input.trim().toCharArray();
		int n = array.length;
		
		for (int i = 0; i<n;i++) 
		{
			if (array[i] == '(' || array[i] == '[' || array[i]== '{') 
			{
				s.push(array[i]);
			}
			
			else if (array[i]== ')' || array[i] == ']' || array[i]== '}') 
			{
				if(s.isEmpty()) {
					return false;
				}
				else {
					int tmp = s.pop();
					if ((tmp == '('&& array[i]!= ')')|| (tmp == '[' && array[i] != ']')||(tmp == '{' && array[i] != '}')) 
					{
						return false;
					}
				}
				
				
			}
			
			else if(array[i]== '+' || array[i] == '-'|| array[i]== '*' || array[i] == '/' || (array[i]>= '0' && array[i]<='9')) {
			}
			else {//invalid string
				throw new IllegalStateException("String does not contain valid characters");
			}
		}
		
		if (!s.isEmpty()) {
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		System.out.print("The input string may contain a combination of the following characters:{,},[,],(,),0,1,2,3,4,5,6,7,8,9,+,-,*,/\n Enter: ");
		Scanner keyboard = new Scanner(System.in);
		
		String testCase = keyboard.next();
		
		boolean answer = BracketMatch.bracket(testCase);
		
		if(answer)
			System.out.println("The input string is a valid expression.");
		else
			System.out.println("The input string is not a valid expression.");
		
		
	}

}
