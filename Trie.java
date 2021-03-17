public class Trie implements Vocabulary{

    private Trie_Node root;
    
    //variable to keep track of the lengthof htelongest word in the dictionary
    private int longestWordLength = 0;

    public Trie(Trie_Node root){
        this.root = root;
    }

    //adds a word to the dictionary
    public void add(String word){
        //Our dictionary stores uppercase words.
        String u_word = word.toUpperCase();

        //update this.longestWordLength if necessary
        int wordLength = u_word.length();
        if(u_word.length()>this.longestWordLength){
            this.longestWordLength = u_word.length();
        }

        //create pointer for traversing the trie
        Trie_Node node_pointer = root;

        //iterate through the letters in the word
        for(int i= 0; i<wordLength; i++){

            //find the index that the letter will be inserted into 
            char letter = u_word.charAt(i);
            int ascii = letter;
            int letter_index = ascii-65;

            //check to see if the current node already has the letter as a child.
            if(node_pointer.hasChild(letter)){

                //update pointer to that child
                Trie_Node[] children = node_pointer.getChildren();
                node_pointer = children[letter_index];
            }
            else{
                //insert letter and update pointer to thatchild
                Trie_Node nextChild = new Trie_Node(letter);
                node_pointer.setChild(nextChild);
                node_pointer = nextChild;
            }
        }
        //notify the trie that this node represents the end of a word.
        node_pointer.setIsEnd(true);
    }
    
    //getter method for this.longestWordLength
    public int getLongestWord(){
        return this.longestWordLength;
    }
    //helper method for contains. Checks to see if we've reached a full word. 
    public boolean isPrefix(Trie_Node node){
        boolean ret;
        if(node.getIsEnd()){
            ret = true;
        }
        else{
            ret = false;
        }
        return ret;
    }

    //checks to see if the word parameter is a subword of a longer word
    //process is very similar ot add/contains. Might be able to genaralize some of the code.
    public boolean hasChildren(String word){
        boolean ret;
        String u_word = word.toUpperCase();
        Trie_Node node_pointer = root;

        for(int i=0; i<word.length(); i++){
            char letter = u_word.charAt(i);
            int ascii = letter;
            int letter_index = ascii-65;

            if(node_pointer.hasChild(letter)){
                Trie_Node[] children = node_pointer.getChildren();
                node_pointer = children[letter_index];
                
            }
            else{
                ret = false;
                return ret;
            }
        }
        ret = true;
        return ret;

    }
    
    //checks to see if the word is in the dictionary.
    public boolean contains(String word){
        boolean ret;
        String u_word = word.toUpperCase();
        Trie_Node node_pointer = root;

        for(int i=0; i<word.length(); i++){
            char letter = u_word.charAt(i);
            int ascii = letter;
            int letter_index = ascii-65;

            if(node_pointer.hasChild(letter)){
                Trie_Node[] children = node_pointer.getChildren();
                node_pointer = children[letter_index];
                
            }
            else{
                ret = false;
                return ret;
            }
        }
        ret = this.isPrefix(node_pointer);
        return ret;
    }

    public String toString(){
        String node = "Node: " + this.root;
        String children = "";
        Trie_Node[] children_list = this.root.getChildren();
        for(int i =0; i<children_list.length; i++){
            if(children_list[i]!=null){
                children = String.valueOf(children_list[i].getData());
                Trie temp = new Trie(children_list[i]);
                children = children + " " + temp;
            }
        }
        String ret = node + "\nChildren of " + node +": " + children;
        return ret; 
    }
}