package File_io;

import java.io.*;
import java.util.Scanner;

public class FileIODemo {

    public static void main(String[] args) {
        
    
    PrintWriter CreateWritingFile ;
    try {
        CreateWritingFile = new PrintWriter(new FileOutputStream("stuff.txt"));
        CreateWritingFile.println("How you doing??");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

   

    PrintWriter AppendingorCreatingFile;
    try{
    AppendingorCreatingFile = new PrintWriter (new FileOutputStream("Appended.txt", true));

    AppendingorCreatingFile.println("Isnt this good");
    }
    catch (FileNotFoundException e){
        System.err.println(e.getMessage());
    }



    try{
        Scanner ReadingFile = new Scanner(new FileInputStream("File_io/Read.txt"));

        while (ReadingFile.hasNextLine()){
            Integer count = 0;
            String line = ReadingFile.nextLine();
            count ++ ;
            System.err.println(count+". "+line);

        }
 
        
    }

    catch(FileNotFoundException e){
        System.err.println(e.getMessage());
    }

   
    

}
    
}

