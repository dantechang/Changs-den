//First Name: Dante 
//Last Name: Chang Luciani
//Student #: 110127893

public class Politician extends Person{

	private String party;
	
	public Politician(String name, Date bday, int diff , String party) {
		super(name,bday,diff);
		this.party = party;
	}
	
	public Politician(Politician other) {
		super(other);
		party = other.getParty();
	}
	
	public String getParty() {
		return party;
	}
	
	public void setParty(String p) {
		party = p;
	}
	
	public String toString() {
		return super.toString()+ " "+ this.getName() + " is a member of Party " + party;
	}
	
	
	
	public String personType() {
		return "politician";
	}
	
	public Person clone() {
		Politician tmp = new Politician(this.getName(), this.getBirthday(), this.getDifficulty(), party);
		return tmp;
	}
}
