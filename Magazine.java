
public class Magazine extends LibraryItem {
	private String genre; 
	
	public Magazine(String title, int year, String genre) {
		super(title,year);
		this.genre = genre;
	}

	public void getItemDetails() {
		System.out.println("Magazine: "+ this.getTitle() + ", Genre: " + genre +", Year: " + this.getYear() +"\nNote: This item is for reference only and cannot be loaned.");
	}

}
