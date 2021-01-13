import java.io.*;
import java.util.*;
public class Index{

    public static void main(String[] args){
        
        //Create Trie for dictionary.
        Dice.initializeDiceConfigsNew();
        Trie_Node root = new Trie_Node('*');
        Trie myTrie = new Trie(root);

        //add words from word list to dictionary
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



        //Create board object.
        Board myBoard = new Board(5,5, myTrie);

        System.out.println("Boggle Board:\n" + myBoard);

        System.out.println("Solution: ");
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