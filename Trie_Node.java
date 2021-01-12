public class Trie_Node{
    private char data;
    private Trie_Node[] children;
    private int numChildren;
    private boolean isEnd = false;

    //Trie_Node Constructor
    public Trie_Node(char data){
        this.data = data;
        this.children = new Trie_Node[26];
        this.numChildren = 0;
    }

    //the parameter is the child node to be added the children[] of this.Trie_Node
    public void setChild(Trie_Node node){
        char letter = node.getData();
        int ascii = letter;
        int index = ascii-65;
        this.children[index] = node;
        this.numChildren++;
    }

    //getter and setters
    public char getData(){
        return this.data;
    }

    public Trie_Node[] getChildren(){
        return this.children;
    }

    public String toString(){
        return String.valueOf(this.data);
    }

    public boolean isEnd(){
        return this.isEnd;
    }

    public int getNumChildren(){
        return this.numChildren;
    }

    public void setIsEnd(boolean b){
        this.isEnd = b;
    }

    public boolean getIsEnd(){
        return this.isEnd;
    }

    //checks to see if the current node has a child equivalent to the function parameter.
    public boolean hasChild(char data){
        //get ASCII value for the char
        int ascii = data;

        //slide the ascii value down to line up with the indexes of Trie_Node[] children
        int data_index = ascii-65;

        
        boolean ret;
        if(data_index >=0 && data_index <=25){
           if(this.children[data_index]==null){
               ret = false;
           }
           else{
               ret = true;
           }
        }
        else{
            return false;
        }
        return ret;

    }

}