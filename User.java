package LibraryManagementSystem;

import java.util.*;

public class User implements LibraryOperations{

    protected String name;
    protected int userId;


    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    @Override
    public void borrowItem(int itemId) throws Exception {
        if(itemId<=0){
            throw new InvalidItemException("Invalid Item ID!");
        }
//        System.out.println(name + " borrowed item having ID: "+ itemId);
    }

    @Override
    public void returnItem(int itemId) throws Exception {
        if(itemId<=0 ){
            throw new InvalidItemException("Invalid or unborrowed Item ID!");
        }

//        System.out.println(name + " returned item having ID: "+ itemId);
    }


}