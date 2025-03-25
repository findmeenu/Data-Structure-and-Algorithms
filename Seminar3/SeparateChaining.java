import java.util.*;

public class SeparateChaining {
    private List<List<Integer>> hashTable;
    //private List<integer> hashTable;

    public SeparateChaining(int size) {
        hashTable = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            hashTable.add(new LinkedList<>());
        }
    }
    // Hash function is x mod 10 and insert the value.
    public void hashFunction(int key) {
        int index = key % 10;
        hashTable.get(index).add(key);
    }
    // Display the hash table.
    public void display() 
    {
        System.out.println("Separate Chaining: \n");
        for (int i = 0; i < hashTable.size(); i++) 
        {
            System.out.println("Index " + i + ": " + hashTable.get(i));
        }
        System.out.println();
    }
}
