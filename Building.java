package DantePrac;
import java.time.Year;

public class Building {
	Year createdYear;
	int floors;
	
	public Building() {
		createdYear = Year.now();
		floors = 1;
	}
	
	public Building(Year year, int floor) {
		createdYear = year;
		floors = floor;
	}
}


