# boggleSolver

## Project Description<BR>
BoggleSolver is a project designed to find the solution to the game boggle. The objective of the game boggle is to find all of the words that can be built from a board of characters. The only rules are that the built words must be built by connecting adjacent letters and that we cannot repeat letters.
  
## Data Structures
This project mainly uses two data structures a character array and trie. The character array is used to represent the boggle board with each cell representing a different letter. We use a trie to maintain a dictionary of words in order to check if a path of characters is a valid word. By using a trie we have a more efficient search function for our string validation because we don't need to iterate through every string in the dictionary for every check.

## Algorithm Description
We iterate through the character array for each starting letter and then recursively build every possible string path. This solution on its own is very slow and as a result the algorithm has been optimized by limiting the depth of a search path. This is done by ensuring that for every string we will only add to its path if that string has a suffix in the trie. If it does not then we move off that search path and on to the next one. This signficantly decreased our run time since our Trie dictionary implementation allows for a very efficient check for prefixs and suffixs.

## 
To run the project download the repository and make the project folder your wokring directory. Then type into your command line:

```bash
java Index
```