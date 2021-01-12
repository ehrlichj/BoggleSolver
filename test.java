import java.io.*;
import java.util.*;

public class test{
    public static void main(String[] args){


        try{
            File words = new File("words.txt");
            Scanner myReader =new Scanner(words);
    
        while(myReader.hasNext()){
            String data = myReader.nextLine();
            System.out.println(data);
        }
    
        myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
