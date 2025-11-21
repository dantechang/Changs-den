
public class DVD extends LibraryItem implements Loanable{
	private int duration;
	private boolean availability;
	
	public DVD(String title, int year, int dur) {
		super(title,year);
		duration = dur;
		availability = true;
	}
	
	public void checkout() {
		if(availability == false ) {
			System.out.println("DVD '" + this.getTitle() +"'" + " has already been checked out.");
			return;
		}
		
		availability = false;
		System.out.println("DVD '" + this.getTitle() +"'" + " checked out.");
		
	}

	public void returnItem() {
		if(availability == true ) {
			System.out.println("DVD '" + this.getTitle() +"'" + " has never been checked out.");
			return;
		}
		
		availability = true;
		System.out.println("DVD '" + this.getTitle() +"'" + " returned.");
		
	}
	public void getItemDetails() {
		
		System.out.println("DVD: "+ this.getTitle() + ", Year: " + this.getYear() + ", Duration: " + duration + " mins"+ ", Available: " + availability);	
	}

}
