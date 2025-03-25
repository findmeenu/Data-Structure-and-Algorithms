import java.util.HashSet;

public class WordPuzzle {
    private char[][] puzzleGrid;
    private HashSet<String> wordSet;
    
    public WordPuzzle(char[][] grid, String[] words) {
        puzzleGrid = grid;
        wordSet = new HashSet<>(); //instiantiate a hash set
        // Insert words and their prefixes into the hash set.
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                wordSet.add(word.substring(0, i));  // Add all prefixes of each word
            }
        }
    }
    
    // Method to search for a word in all directions starting from a given position
    public boolean searchWord(int row, int col, String word) {
        int[] rowDir = {-1, -1, -1,  0, 1, 1, 1, 0}; // 8 possible directions.
        int[] colDir = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        // Check in all 8 directions (Eg, at position 0,0 & starting from letter 't')
        for (int dir = 0; dir < 8; dir++) {
            int r = row, c = col; // Eg parameters position 0,0
            //System.out.println("rc" + r +  c);
            boolean match = true;
            for (int i = 0; i < word.length(); i++) { // Eg word = 'this': word length = 4 
                if (r < 0 || c < 0 || r >= puzzleGrid.length || c >= puzzleGrid[0].length || puzzleGrid[r][c] != word.charAt(i)) {
                    match = false; // Used puzzleGrid[0].length to get no. of columns in row 0.
                    break;
                }
                r += rowDir[dir]; // if second letter matches i.e 'h' then keep moving in the current direction i.e 0,1 in dir =3.  
                c += colDir[dir];
            }
            if (match) {
                return true; // Word found in this direction
            }
        }
        return false;
    }
    
    // Method to find all words in the puzzle
    public void findWords(String[] words) {
        for (String word : words) {
            for (int row = 0; row < puzzleGrid.length; row++) {
                
                for (int col = 0; col < puzzleGrid[row].length; col++) {
                    //System.out.println(puzzleGrid[row].length);
                    if (wordSet.contains(word.substring(0, 1))) { // will return true or false. eg word = this,
                         // word.substring will include t on position 0 & excluding 1. 
                         // Till here method is checking every letter at all grids using last 2  for loops
                         //for row = 0, check all 5 columns if there is letter 't', then move to next row = 1 & check all columns
                         //& so on.  Only start if the first letter exists
                        if (searchWord(row, col, word)) { //searchWord(0,0, this) is called as in grid at position 0,0 found 't'. 
                            System.out.println("Word found: " + word + " at (" + row + "," + col + ")");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //puzzle grid (5x5)
        char[][] grid = {
            {'t', 'h', 'i', 's', 'w'},
            {'w', 'a', 't', 's', 'a'},
            {'o', 'a', 'h', 'g', 'f'},
            {'f', 'g', 'd', 't', 'o'},
            {'f', 'g', 'd', 't', 'y'}
        };

        // List of words to search in puzzle grid.
        String[] words = {"this", "two", "fat", "that"};
        long startTime = System.nanoTime(); 

        // Initialize word puzzle with the grid and words
        WordPuzzle wp = new WordPuzzle(grid, words);
        
        // Find and print all words in the puzzle
        wp.findWords(words);

        long endTime = System.nanoTime();
        System.out.println("Time taken to run in nano seconds: " + (endTime - startTime));
    }
}
