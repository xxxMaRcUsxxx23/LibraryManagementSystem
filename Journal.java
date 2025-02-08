package LibraryManagementSystem;

public class Journal extends LibraryItem{

    public Journal(String title, String author, int itemId) {
        super(title, author, itemId);
    }


    @Override
    public void displayInfo() {
        System.out.println("Journal: "+ title + " by "+ author +" (ID: "+ itemId
                + ")" +(isBorrowed? " -> Unavailable, Available by: "
                +returnDate : " -> Available"));

    }

}