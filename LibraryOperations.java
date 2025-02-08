package LibraryManagementSystem;

import java.util.*;

public interface LibraryOperations {

    void borrowItem(int itemId) throws Exception;
    void returnItem(int itemId) throws Exception;



    default void showAvailableItems(List<LibraryItem> items){
        items.forEach(item -> item.displayInfo());
    }



    static void welcomeMessage(){
        System.out.println("Welcome to Library Management System");
    }

}