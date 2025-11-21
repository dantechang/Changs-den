package Dante;
import Dante.StackImplement;
import java.util.Scanner;

public class isValidLanguage 
{

	public static void langCheck(String toCheck) {
		Dante.StackImplement s = new Dante.StackImplement(); //gets user created stack
		boolean valid = true; //Yes or no
		
		char[] array = (toCheck.trim()).toCharArray();   //converts string to char array O(n)
		
		int n = array.length; 
		
		for (int i = 0; i<n;i++)  
		{
			if (array[i] == '0') { //0 goes on stack
				s.push('0');
			}
			
			else if(array[i] == '1')
			{
				
				if (i != n-1)  //not the last element
				{
					if (array[i+1] == '0')  //if 0 follows any of the 1's, invalid
					{
						valid = false; 
						break;			
					}
				}
				
				if (s.isEmpty()) { //there is no 0 in the stack to match 1
					valid = false;
					break;
				}
				
				else { //removes top 0 from stack
					s.pop();
				}
				
				
			}
		}
		
		if (!s.isEmpty()) { //no 1 leftover in array to match the 0 in stack
			valid = false;
		}
		
		
		/*if(valid) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}*/ 
		
	}
	
	
	public static void main(String[] args) 
	{	
		/*System.out.print("Enter a string in the language: ");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next();
		isValidLanguage.langCheck(input);*/
		
		//Used for computing runtime in nanoseconds for strings of length 2^n {0<n<21}
		int len = 2; int power = 1;
		String zero = "0";
		String one = "1";
		final int MAX= (int)Math.pow(len, 20) + 1;
		
		while(len < MAX) { //2^20 + 1
			long averageTime = 0; //average time per 1000 loops for each power of 2
			
			String tmp = zero.repeat(len/2) + one.repeat(len/2); //gets string of form 01 0011 with increasing powers of 2 for the length
			
			for (int i = 1;i<1001;i++) {
				long startTime = System.nanoTime();
				
				isValidLanguage.langCheck(tmp);
				
				long endTime = System.nanoTime();
				
				averageTime += endTime-startTime;
				
					
			}
			
			averageTime /=1000;
			System.out.println("Average Running time for 100000 runs of 2^"+power + " is "+ averageTime + " nanoseconds!");
			len = len*2;
			power++;
			
		}
		
	}

}
