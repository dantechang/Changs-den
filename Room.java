package DantePrac; 
import java.sql.Date;

public class Room {
	
	enum RoomType{SINGLE, DOUBLE, STUDIO, SUITE};
	
	private RoomType typeRoom;
	private float pricePerNight;
	private int roomSize;
	private int floorNumber;
	private int roomNumber;
	private String description;
	private boolean vacancyStatus;
	private Reservation[] allReservations;
	
	public Room(RoomType room, float price, int size, int number, int floor, String descript ) {
		typeRoom = room;
		pricePerNight = price;
		roomSize = size;
		roomNumber = number;
		floorNumber = floor;
		description = descript;
		vacancyStatus = true;
		allReservations = new Reservation[10];
		
	}
	
	public boolean getVacancyStatus() {
		return vacancyStatus;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public float getPricePerNight() {
		return pricePerNight;
	}
	
	public Reservation[] getAllReservations() {
		return allReservations;
	}
	
	public void setPricePerNight(float price) {
		pricePerNight = price;
	}
	
	public int reserve(Date start, Date end, Person guest) {
		boolean flag = true;
		int last;
		
		for (int i = 0; i< allReservations.length; i++) {
			if (allReservations[i].isAvailable(start, end) == false) {
				flag = false;
			}
			
		}
		
		if(flag) {
			
		}
		
	}
	
	
	
}
