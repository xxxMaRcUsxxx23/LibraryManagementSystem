package LibraryManagementSystem;

import java.util.List;

public class Faculty extends User{




    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Faculty(String name, int userId) {
        super(name, userId);


    }
}