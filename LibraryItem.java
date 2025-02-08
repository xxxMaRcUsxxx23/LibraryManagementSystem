package LibraryManagementSystem;

import java.time.*;
import java.util.*;

abstract class LibraryItem {

    protected String title;

    protected String author;
    protected int itemId;
    protected boolean isBorrowed = false;
    protected LocalDate returnDate;

    public LibraryItem(String title, String author, int itemId) {
        this.title = title;

        this.author = author;
        this.itemId = itemId;
    }

    public abstract void displayInfo();

    public boolean isAvailable(){
        return !isBorrowed;
    }

    public void borrowItem(){
        this.isBorrowed = true;
        this.returnDate = LocalDate.now().plusDays(14);
    }

    public void returnItem(){
        this.isBorrowed = false;
        this.returnDate = null;


    }



}