
public class LibrarySystem {

	public static void processLibraryItem(LibraryItem item) {
		System.out.println("Processing Item:");
		
		item.getItemDetails();
		if(item instanceof Loanable) {
			((Loanable) item).checkout();
			((Loanable) item).returnItem();
		}
		
		else {
			System.out.println("This item is not loanable.");
		}
	}
	
	public static void main(String[] args) {
		Book b1 = new Book("The Alchemist", 1993, "Paulo Coelho");
		
		Magazine m1 = new Magazine("National Geographic", 2022, "Science");
		
		DVD d1 = new DVD("Inception", 2010, 148);
		
		LibrarySystem.processLibraryItem(b1);
		System.out.println();
		LibrarySystem.processLibraryItem(m1);
		System.out.println();
		LibrarySystem.processLibraryItem(d1);
	}
}
