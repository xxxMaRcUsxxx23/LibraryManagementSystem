package LibraryManagementSystem;

public class Book extends LibraryItem{

    public Book(String title, String author, int itemId) {
        super(title, author, itemId);
    }


    @Override
    public void displayInfo() {
        System.out.println("Book: "+ title + " by "+ author +" (ID: "+ itemId
            + ")" +(isBorrowed? " -> Unavailable, Available by: "
                +returnDate : " -> Available"));

    }

}