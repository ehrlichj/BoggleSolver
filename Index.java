import java.io.*;
import java.util.*;
public class Index{

    public static void main(String[] args){

        //Array represantion of the global dictionary.
        //String[] dictionary = new String[]{"HELLOWORLD", "RABID", "GEEKS","FOR","QUIZ","GO","GUESS","GEEK","BOY","A","AND","REAR","RARE","BOAR","ROBIN"};
        
        //Create Trie for dictionary.
        Trie_Node root = new Trie_Node('*');
        Trie myTrie = new Trie(root);

        try{
            File words = new File("words.txt");
            Scanner myReader =new Scanner(words);

        while(myReader.hasNextLine()){
            String data = myReader.nextLine();
            if(data.length()>=3){
                Index.addWord(myTrie, data);
            }
        }

        myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }


        //add words to the Trie dictionary
       // for(int i=0;i<dictionary.length; i++){
         //   myTrie.add(dictionary[i]);
        //}


        //Create board object.
        Board myBoard = new Board(5,5, myTrie);

        //find all words that are in the dictionary and can be made on the boggle board.
        myBoard.solve();
        System.out.println(myBoard.getFoundWords());
    
    }

    //return the index for children list based on the letters ASCII value.
    public static int getLetter_Index(char letter){
        int ascii =  letter;
        int letter_index = ascii-65;
        return letter_index;
    }

    public static void addWord(Trie trie, String word){
        trie.add(word);
    }
}