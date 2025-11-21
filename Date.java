//First Name: Dante 
//Last Name: Chang Luciani
//Student #: 110127893


import java.util.Arrays;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) { 
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(Date other) { //copy constructor
		day = other.day;
		month = other.month;
		year = other.year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	
	//accessor methods^, no need for mutator as im not mutating these
	
	public boolean validation() {
		if (year >2024 || year < 1) {

			return false;
		}
		
		if(day < 1 || day > 31) {
			return false;
		}
		
		if(month< 1 || month > 12) {
			return false;
		}
		
		return true;
	} //helper function to check validity of the date
	
	public Date(String input) {
		
		char[] arr = input.trim().toCharArray();
		
		String tmpDay = "";
		
		String tmpMonth = "";
		String tmpYear = "";
		
		if (input.trim().contains(" ")) { // form Jan 01, 2023
			
			char[] tmpArrayMonth = Arrays.copyOfRange(arr, 0, 3); //gets month
			tmpMonth = String.valueOf(tmpArrayMonth);
			
			int i = 4;
			
			for(;i< arr.length;i++) {
				if (arr[i] == ',') {
					break;
				}
				
				tmpDay += arr[i]; //gets string version of day
			}
			
			i+=2;
			for(; i<arr.length;i++) { //gets string version of year
				tmpYear += arr[i];
			}
			
			System.out.println(tmpMonth);
			switch(tmpMonth.toLowerCase()){ //assigns month with its number
			
			case "jan":
				tmpMonth = "01";break;
			case "feb":
				tmpMonth = "02";break;
			case "mar":
				tmpMonth = "03";break;
			case "apr":
				tmpMonth = "04";break;
			case "may":
				tmpMonth = "05";break;
			case "jun":
				tmpMonth = "06";break;
			case "jul":
				tmpMonth = "07";break;
			case "aug":
				tmpMonth = "08";break;
			case "sep":
				tmpMonth = "09";break;
			case "oct":
				tmpMonth = "10";break;
			case "nov":
				tmpMonth = "11";break;
			case "dec":
				tmpMonth = "12";break;
			default:
				tmpMonth= "00"; break;
			
			}
		}
		
		else { //form 01/01/1983
			
			int i = 0;
			
			for(; i<arr.length; i++) {
				if(arr[i] == '/') {
					break;
				}
				tmpDay += arr[i]; //string form od day
				
			}
			
			i++;
			
			for(; i<arr.length; i++) {
				if (arr[i] == '/') {
					break;
				}
				
				tmpMonth += arr[i]; //string form of month
			}
			
			i++;
			for(; i<arr.length; i++) {
				tmpYear += arr[i]; //string form of year
				
			}
			

		}
		day = Integer.parseInt(tmpDay); 
		month = Integer.parseInt(tmpMonth);
		year = Integer.parseInt(tmpYear);
		//converts the strings to integers
		
	}
	
	
	
	public boolean equals(Date other) {
		return day == other.day && month == other.month && year == other.year;
	}

	public int compareMonth(Date d) { //method to see if a this month precedes date d's month
		if (this.month < d.getMonth()) {
			return -1;
		}
		
		else if(this.month == d.getMonth()) {
			return 0;
		}
		
		else {
			return 1;
		}
	}
	
	public int compareDay(Date d) { //method to see if this day precedes date d's day
		if (this.day < d.getDay()) {
			return -1;
		}
		
		else if(this.day == d.getDay()) {
			return 0;
		}
		
		else {
			return 1;
		}
	}
	
	public int compareYear(Date d) { //method to see if this year precedes date d's year
		if (this.year < d.getYear()) {
			return -1;
		}
		
		else if(this.year == d.getYear()) {
			return 0;
		}
		
		else {
			return 1;
		}
	}
	
}
