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

        //get board parameters from user
        Scanner scanDim = new Scanner(System.in);
        System.out.println("Please enter a board height: ");
        int boardHeight = scanDim.nextInt();
        System.out.println("Please enter a board width: ");
        int boardWidth = scanDim.nextInt();
        scanDim.close();

        //Create board object.
        Board myBoard = new Board(boardHeight,boardWidth, myTrie);

        System.out.println("Boggle Board:\n" + myBoard);

        System.out.println("Solution: ");
        //find all words that are in the dictionary and can be made on the boggle board.
        myBoard.solve();
        System.out.println(myBoard.getFoundWords());
    
    }

    public static void addWord(Trie trie, String word){
        trie.add(word);
    }
}