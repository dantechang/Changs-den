//First Name: Dante 
//Last Name: Chang Luciani
//Student #: 110127893

public abstract class Person {
	private String name;
	private Date birthday;
	private String country;
	private int difficulty;
	
	public Person(String name, Date date, int diff,  String country) {
		this.name = name;
		this.birthday = date;
		this.difficulty = diff;
		this.country = country;
	}
	
	public Person(String name, Date date, int diff) { //in the test code they use a constructor which doesnt include the country: 
		//new Politician(“Justin Trudeau”, new Date(25, 12, 1971), 1,“Liberal”);  has no country so we set country to no country yet.
		this.name = name;
		this.birthday = date;
		this.difficulty = diff;
		this.country = "No country yet";
	}
	
	public Person(Person other) {
		name = other.name;
		birthday = other.birthday;
		country = other.country;
		difficulty = other.difficulty;
	}
	
	public Person(int num) {
		difficulty = num;
	}
	
	
	public String getName() {
		return name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public String getCountry() {
		return country;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(Date d) {
		this.birthday = d;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setDifficulty(int diff) {
		difficulty = diff;
	}
	
	//Accessor methods^ and mutator methods, they are both needed since we cannot make instances of person since its abstract
	public String toString() {
		return name + ", born on " + birthday.getDay() + "/" + birthday.getMonth() + "/" + birthday.getYear() + " in " + country + ".";
	}
	
	public abstract String personType();
	
	public abstract Person clone();
	
	public String welcomeMessage() {
		return "Welcome! Guess the birthday of " + personType() + " named " + name + ".";
	}
	
	public String successMessage() {
		return "Wow! You are able to successfully guess the birthday of " + toString();
	}
	
}
