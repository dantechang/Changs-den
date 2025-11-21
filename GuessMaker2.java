//First Name: Dante 
//Last Name: Chang Luciani
//Student #: 110127893

import java.util.Scanner; import java.util.ArrayList;

public class GuessMaker2 {
	private ArrayList<Person> people = new ArrayList<Person>();
	private int currentPerson = -1;
	
	public void addPerson(Person p) {
		people.add(p);
	}
	
	public static boolean checkGuess(String guess) { //helper function to check guess inputs
		
		if(guess.equalsIgnoreCase("Quit")) {
			return true;
		}
		
		if (guess.matches("\\d{2}/\\d{2}/\\d{4}") || guess.matches("\\d{1}/\\d{2}/\\d{4}") || guess.matches("\\d{2}/\\d{1}/\\d{4}") || guess.matches("\\d{1}/\\d{1}/\\d{4}")) {
			//checks if it has form DD/MM/YYYY or D/MM/YYYY or DD/M/YYYY or D/M/YYYY	
			Date tmp = new Date(guess);
			return tmp.validation(); //once it has correct form check if the date is valid
		}
		
		return false;
		
		
		
	}
	
	
	
	public void startGame() {
		System.out.println("Hello player, please choose one of the following players to guess their birthday:\n");
		
		for(int i = 0; i< people.size() && people.get(i) != null;i++) {
			System.out.println((i+1) + ") " + people.get(i).getName() + " born in " + people.get(i).getCountry()); //prints out people
		}
		
		Scanner keyboard = new Scanner(System.in); 
		
		while(currentPerson < 0 || currentPerson > people.size()-1) {
			currentPerson = keyboard.nextInt() - 1;
			
			if (currentPerson < 0 || currentPerson > people.size()-1) {
				System.out.println("Invalid choice, try again: ");
			}
		}
		//selection menu^ from 1 to number of people
		
		
		boolean flag = true;
		int guessNum = 1;
		String tmp = "";
		
		while(flag) {
			
			if(guessNum == 1) {
				System.out.println(people.get(currentPerson).welcomeMessage());
			}
			
	
			boolean inputRes = false;
			
			while(!inputRes) {
				System.out.println("Guess #" + guessNum + ": ");
				tmp = keyboard.next().trim();
				inputRes = GuessMaker2.checkGuess(tmp);
				
				
				if(inputRes == false) {
					System.out.println("The input is the either in the wrong format or consists of an invalid date, please try again in the form DD/MM/YYYY\n");
				}
			}
			//uses helper function to check for invalid guess^ and if there is get input again
			
			guessNum +=1;
			
			if(tmp.equalsIgnoreCase("quit")) { //ends the game
				break;
			}
			
			Date guess = new Date(tmp);
			
			boolean res = guess.equals(people.get(currentPerson).getBirthday());
			
			if(res) { //equal guess
				System.out.println(people.get(currentPerson).successMessage());
				System.out.println("\nHello player, please choose again:");
				
				for(int i = 0; i< people.size() && people.get(i) != null;i++) {
					System.out.println((i+1) + ") " + people.get(i).getName() + " born in " + people.get(i).getCountry());
				}
				currentPerson = -1;
				
				while(currentPerson < 0 || currentPerson > people.size()-1) {
					currentPerson = keyboard.nextInt() - 1;
					
					if (currentPerson < 0 || currentPerson > people.size()-1) {
						System.out.println("Invalid choice, try again: ");
					}
				}
				//shows menu again^^
				
				guessNum =1;
				continue; //return to top of while
				
			}
			
			else { //unequal quess
				System.out.println("Oops!Incorrect guess.");
				
				int diff = people.get(currentPerson).getDifficulty();
				
				int yearCompare = people.get(currentPerson).getBirthday().compareYear(guess);
				int monthCompare = people.get(currentPerson).getBirthday().compareMonth(guess);
				int dayCompare = people.get(currentPerson).getBirthday().compareDay(guess);
				
				
				if( yearCompare < 0) {
					System.out.println("Select an earlier year.");
				}
				else if (yearCompare > 0) {
					System.out.println("Select a later year.");
				}
				
				else {
					System.out.println("The year is correct");  //the assignment does not specify what we say when the value is correct, so I put this
				}
				
				if(diff == 2 || diff == 3) { //show month
					if( monthCompare < 0) {
						System.out.println("Select an earlier month.");
					}
					else if (monthCompare > 0) {
						System.out.println("Select a later month.");
					}
					
					else {
						System.out.println("The month is correct");
					}
					
					if(diff == 3) {
						if( dayCompare < 0) {
							System.out.println("Select an earlier day.");
						}
						else if (dayCompare > 0) {
							System.out.println("Select a Later day.");
						}
						else {
							System.out.println("The day is correct.");
						}
					}
					
				}
				
				
				
			}
			
			
			
		}
		
		System.out.println("Thank you for playing the game.");
		keyboard.close();
		System.exit(0);
		
	}
	

	public static void main(String[] args) {
		Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), 1,"Liberal");
		Player ronaldo = new Player("Cristiano Ronaldo", new Date(5, 2, 1985), 2,"Soccer" , "Al Nassr");
		Politician pierre = new Politician("Pierre Poilievre", new Date(3, 6, 1979), 3,"Conservative");
		GuessMaker2 gm = new GuessMaker2();
		
		
		trudeau.setCountry("Canada"); //i added the countries as they were not included in sample input and will 
		//initialize to "no country yet" if we do not include them in our constructor or update them with set method
		ronaldo.setCountry("Portugal");
		pierre.setCountry("Canada");
		
		gm.addPerson(trudeau);
		gm.addPerson(ronaldo);
		gm.addPerson(pierre);
		gm.startGame();
	//Tests for the game
	}
	
	
}


