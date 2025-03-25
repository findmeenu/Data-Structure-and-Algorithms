    import java.util.Arrays;

public class Probing {
    private Integer [] hashTable;

    public Probing(int size) {
        hashTable = new Integer [size];
    }
    // Generates hash value and insert data into hash table.
    public void linearProbing(int key) {
        int index = key % 10;
        while (hashTable[index] != null) {
            index = (index + 1) % hashTable.length; // Linear probing
        }
        hashTable[index] = key;
    }

    public void quadraticProbing(int key){
        int hashValue = key % 10;
        int index = key % 10;
        int i = 1;
        while (hashTable[index] != null){
            index = (hashValue + i*i) % hashTable.length;
            i++;
        }
        hashTable[index] = key;
    }
    // Print the hash table.
    public void display() 
    {    
        System.out.println(Arrays.toString(hashTable));
    }

    public Integer [] getTable(){
        return hashTable;
    }
}
