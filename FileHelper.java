package LibraryManagementSystem;

import java.io.*;
import java.util.*;

public class FileHelper {

    public static List<String> readFromFile(String filename){
        List<String> lines = new ArrayList<>();

        File file = new File(filename);
        if(!file.exists()){
            System.out.println(filename + " is missing");
            return lines;
        }

        if(file.length() ==0){
            System.out.println(filename + " is empty");
            return lines;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while(line !=null){
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error in reading "+filename+"."+e.getMessage());
        }

        return lines;


   }

   public static void writeToFile(String filename, List<String> lines){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){

            for(String it: lines){
                bw.write(it);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing to "+filename+"."+e.getMessage());
        }
   }


}