package LibraryManagementSystem;
import java.time.LocalDate;
import java.util.*;
public class LibraryManagement {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter you Name: ");

            String name  = sc.nextLine();
            System.out.print("Hello, "+name+"! ");
            LibraryOperations.welcomeMessage();

            List<LibraryItem> items = new ArrayList<>();
            Map<Integer,User> userMp = new HashMap<>();

            // Reading books from books.txt
            List<String> bookData = FileHelper.readFromFile("src/LibraryManagementSystem/books.txt");
            if(bookData.isEmpty()){
                System.out.println("books.txt is empty");
                return;
            }

            for (String line:bookData){
                String [] parts = line.split(",");
                LibraryItem item = parts[0]
                        .equals("Book")? new Book(parts[1],parts[2],Integer.parseInt(parts[3]))
                        : new Journal(parts[1],parts[2],Integer.parseInt(parts[3]));

                if(parts.length > 4 && parts[4].equals("Borrowed")){
                    item.borrowItem();
                }

                items.add(item);
            }

            // read Users from users.txt
            List<String> userData = FileHelper.readFromFile("src/LibraryManagementSystem/users.txt");


            for(String it: userData){
                String [] parts = it.split(",");
                User user = parts[0].equals("Student")?
                        new Student(parts[1], Integer.parseInt(parts[2]))
                        :
                        new Faculty((parts[1]), Integer.parseInt((parts[2])));

                userMp.put(Integer.parseInt(parts[2]),user);
            }


//            User exampleUsr = userMp.get(1);
            Optional<User> example = Optional.ofNullable(userMp.get(2));
            if(example.isPresent()) {
                try {
                    User exampleUsr = example.get();
                    exampleUsr.borrowItem(101);
                    System.out.println(exampleUsr.name + " borrowed book with ID 101");

                    for (int i = 0; i < userData.size(); i++) {
                        if (userData.get(i).contains(exampleUsr.name)) {
                            userData.set(i, userData.get(i) + "-> Borrowed: 101");
                        }
                    }

                    for (int i = 0; i < bookData.size(); i++) {
                        if (bookData.get(i).contains("101")) {
                            bookData.set(i, bookData.get(i) + "-> Borrowed by User ID: " + exampleUsr.userId
                                    + ",Return Date: " + LocalDate.now().plusDays(14));
                        }
                    }

                    FileHelper.writeToFile("src/LibraryManagementSystem/users.txt", userData);
                    FileHelper.writeToFile("src/LibraryManagementSystem/books.txt", bookData);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            // Users FilePath -> src/LibraryManagementSystem/users.txt
            // Books FilePath -> src/LibraryManagemntSystem/books.txt
    }

}