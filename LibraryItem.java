
public abstract class LibraryItem {

	private String title;
	private int year;
	
	public LibraryItem(String name, int year) {
		title = name;
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public abstract void getItemDetails();
	
}

