import java.util.*;
public class Board{
    private char[][] board;
    private int height;
    private int width;
    private Trie dictionary;

    public HashSet<String> foundWords;

    //Board Constructor
    public Board(int height, int width, Trie dictionary){
        this.height = height;
        this.width = width;
        this.board = this.makeBoard(this.height, this.width);
        this.dictionary = dictionary;
        this.foundWords = new HashSet<String>();
    }


    //creates the board. The board is currently hard coded but currently working on a dynamic implemenation.
    private char[][] makeBoard(int height, int widht){
        char[][] ret = new char[height][width];
        /* ret[0] = new char[]{'R','T','A','A','C'};
        ret[1] = new char[]{'L','Y','I','U','C'};
        ret[2] = new char[]{'E','O','N','D','U'};
        ret[3] = new char[]{'R','A','B','I','O'};
        ret[4] = new char[]{'A','H','R','O','I'}; */

        int dieNum = 0;
        for(int r=0; r<height; r++){
            for(int c=0; c<width; c++){
                Dice die = new Dice(dieNum);
                die.rollDie();

                ret[r][c] = die.getShowing();
                dieNum++;
            }
        }
        

        return ret;

    }

    //recursive utility function to create word paths
    public void solve_(boolean[][] visited, int i, int j, String s){
        //mark the node as having been visited
        visited[i][j] = true;

        //intialize some variables for readability.
        char[][] board = this.board;
        Trie dictionary = this.dictionary;

        //variable to determine whether or not the current string has a suffix in the dictionary.
        boolean hasChildren;

        //update the string path
        s = s + board[i][j];
        //System.out.println(s);

        //check if string path in dictionary
        if(dictionary.contains(s)){
            this.foundWord(s);
        }

        //check if string path has suffix in dictionary
        boolean isPrefix = dictionary.hasChildren(s);

        //checks if current string path is not longer than the longest word in dictionary
        boolean isWordTooLong = s.length()<=dictionary.getLongestWord();

        //extend path for neighbors
        for(int r=i-1; r<=i+1 && r<this.height; r++){
            for(int c=j-1;c<=j+1 && c<this.width;c++){
                
                /*recurse if all are true:
                     - we have a valid neighbor
                     - we have a neighbor we havent visited
                     - our current string path is not longer than the longest word in dictionary.
                     - the string path has a suffix in the dictionary.
                */
                if(r >=0 && c >=0 && !visited[r][c] && isWordTooLong && isPrefix){
                    solve_(visited, r,c,s);
                }
            }
        }

        //reset the string path
        s = "";
        visited[i][j] = false;



    }

    //find all the words in the boggle board
    public void solve(){

        //Mark all nodes as not visited
        boolean[][] visited = new boolean[this.height][this.width];

        //Initialize current string
        String s = "";

        //Consider every character and look for all words
        //starting with this character

        for(int i=0;i<this.height;i++){
            for(int j=0; j<this.width; j++){
                solve_(visited,i,j,s);
            }
        }

    }

    //add a valid word to the found words set.
    public void foundWord(String word){
        this.foundWords.add(word);
    }

    //getter method for foundWords
    public HashSet<String> getFoundWords(){
        return this.foundWords;
    }


//toString method to show the board
    public String toString(){
        String ret = "";
        for(int r=0; r<this.height;r++){
            for(int c=0;c<this.width;c++){
                ret = ret + " " + this.board[r][c];
            }
            ret = ret + "\n";
        }
        return ret;
    }

}