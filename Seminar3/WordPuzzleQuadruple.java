import java.util.HashSet;

public class WordPuzzleQuadruple {
    private char[][] puzzleGrid;
    private HashSet<String> wordSet;

    public WordPuzzleQuadruple(char[][] grid, String[] words) {
        puzzleGrid = grid;
        wordSet = new HashSet<>();
        // Insert words and their prefixes into the hash set.
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                wordSet.add(word.substring(0, i));  // Add all prefixes of each word
            }
        }
    }

    // Method to search for a word in all directions starting from a given position
    public boolean searchWord(int row, int col, String word, int remainingChars) {
        int[] rowDir = {-1, -1, -1,  0, 1, 1, 1, 0}; // 8 possible directions.
        int[] colDir = {-1, 0, 1, 1, 1, 0, -1, -1};

        // Check in all 8 directions
        for (int dir = 0; dir < 8; dir++) {
            int r = row, c = col;
            boolean match = true;

            // Check if the word fits within the puzzle's bounds and matches in the direction
            for (int i = 0; i < remainingChars; i++) {
                if (r < 0 || c < 0 || r >= puzzleGrid.length || c >= puzzleGrid[0].length || puzzleGrid[r][c] != word.charAt(i)) {
                    match = false;
                    break;
                }
                r += rowDir[dir];
                c += colDir[dir];
            }

            if (match) {
                return true; // Word found in this direction with the remaining characters
            }
        }
        return false;
    }

    // Method to find all words in the puzzle
    public void findWords(String[] words) {
        for (String word : words) {
            for (int row = 0; row < puzzleGrid.length; row++) {
                for (int col = 0; col < puzzleGrid[row].length; col++) {
                    if (wordSet.contains(word.substring(0, 1))) { // Only start if first letter matches
                        int remainingChars = word.length(); // Different from triple approach. 
                        // Check all orientations and number of characters
                        //System.out.println("remaining" + remainingChars);
                        if (searchWord(row, col, word, remainingChars)) {
                            System.out.println("Word found: " + word + " at (" + row + "," + col + ")");
                            System.out.println("remaining" + remainingChars); System.out.flush();
                        }
                    }
                }
            }
        }
    }

    

    public static void main(String[] args) {
        // Puzzle grid (5x5)
        char[][] grid = {
            {'t', 'h', 'i', 's', 'w'},
            {'w', 'a', 't', 's', 'a'},
            {'o', 'a', 'h', 'g', 'f'},
            {'f', 'g', 'd', 't', 'o'},
            {'f', 'g', 'd', 't', 'y'}
        };

        // List of words to search in puzzle grid
        String[] words = {"this", "two", "fat", "that"};
        long startTime = System.nanoTime(); 
        // Initialize word puzzle with the grid and words
        WordPuzzleQuadruple wp = new WordPuzzleQuadruple(grid, words);

        // Find and print all words in the puzzle
        wp.findWords(words);
        long endTime = System.nanoTime(); 
        System.out.println("Time taken to run in nano seconds: " + (endTime - startTime));
    }
}
