package DantePrac;
import java.sql.Date;

public class Reservation {
	private Date start;
	private Date end;
	private float priceNight;
	private Person guest;
	private static int reserveNum = 100000;
	
	public Reservation(Date startDate, Date endDate, float price, Person guest) {
		start = startDate;
		end = endDate;
		priceNight = price;
		this.guest = guest;
		reserveNum += 1;
	}
	
	public Date getStartDate() {
		return start;
	}
	
	public Date getEndDate() {
		return end;
	}
	
	public int getReservationNumber() {
		return reserveNum;
	}
	
	public boolean isAvailable(Date startDate, Date endDate) {  //start date inclusive endDate exclusive [startDate, endDate)
		
		int tmp1 = startDate.compareTo(end);
		int tmp2 = endDate.compareTo(start);
		
		if (tmp2 <= 0 || tmp1 > 0) { // if endDate is before the start date of our reservation or the start date is after the end of our reservation
			return true;
		}
		
		return false;
		
	}
	
	public String ToString() {
		 return  "Reservation Number: " + reserveNum + "\nFrom: " + start + " To: " + end + "\nGuest: " + guest.toString() + "\n$" + priceNight + " per night";
		
		
	}
	
}


