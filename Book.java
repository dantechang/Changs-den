
public class Book extends LibraryItem implements Loanable{
	private String author;
	private boolean availability;
	
	public Book(String title, int year, String authorName) {
		super(title,year);
		author = authorName;
		availability = true;
	}
	

	public void checkout() {
		if(availability == false ) {
			System.out.println("Book '" + this.getTitle() +"'" + " has already been checked out.");
			return;
		}
		
		availability = false;
		System.out.println("Book '" + this.getTitle() +"'" + " checked out.");
		
	}

	public void returnItem() {
		if(availability == true ) {
			System.out.println("Book '" + this.getTitle() +"'" + " has never been checked out.");
			return;
		}
		
		availability = true;
		System.out.println("Book '" + this.getTitle() +"'" + " returned.");
		
	}


	public void getItemDetails() {
		System.out.println("Book: "+ this.getTitle() + " by " + author + ", Year: " + this.getYear() + ", Available: " + availability);	
	}

}
