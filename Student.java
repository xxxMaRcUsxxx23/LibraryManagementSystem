package LibraryManagementSystem;

import java.util.List;

public class Student extends User{

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Student(String name, int userId) {
        super(name, userId);


    }
}