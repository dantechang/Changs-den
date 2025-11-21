//First Name: Dante 
//Last Name: Chang Luciani
//Student #: 110127893

public class Player extends Person{
	private String game;
	private String team;
	
	public Player(String name, Date bday, int diff , String game, String team) {
		super(name,bday,diff);
		this.game = game;
		this.team = team;
	}
	
	public Player(Player other) {
		super(other);
		game = other.getGame();
		team = other.getTeam();
	}
	
	public String getGame() {
		return game;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String toString() {
		return super.toString() + " "+ this.getName() + " is a Player of Team " + team;
	}
	
	public String personType() {
		return "player";
	}
	
	public Person clone() {
		Player tmp = new Player(this.getName(), this.getBirthday(), this.getDifficulty(), game, team);
		
		return tmp;
	}

}
