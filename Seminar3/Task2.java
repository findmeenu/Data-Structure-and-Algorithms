import java.util.Arrays;

public class Task2 {
    public static void main(String []args)
    {
        SeparateChaining separateChaining = new SeparateChaining(10);
        Probing linearProbing = new Probing(10);
        Probing qudraticProbing = new Probing(10);
        int [] input = {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        for (int value : input)
        {
            separateChaining.hashFunction(value);
        }
        separateChaining.display();

        // Linear Probing
        for (int value : input)
        {
            linearProbing.linearProbing(value);
        }
        System.out.println("LINEAR PROBING TABLE:\n");
        linearProbing.display();
        System.out.println();

        
        // Quadratic probing
        
        for (int value : input)
        {
            qudraticProbing.quadraticProbing(value);
        }
        System.out.println("Quadratic Probing Table:\n");
        qudraticProbing.display();
        System.out.println();
    
    // Testing Rehashing
        Integer [] oldHashTable1 = linearProbing.getTable();
        double loadFactor1 = loadFactor(oldHashTable1);
        Integer [] newTable = rehash(loadFactor1, oldHashTable1);
        System.out.println(Arrays.toString(newTable));

        }
   
    // to rehash the table based on linear Probing if load factor >= 0.7
    public static Integer [] rehash(double loadFactor, Integer [] oldHashTable)
    {
        if (loadFactor >= 0.7){
            Integer []  newTable = new Integer[oldHashTable.length *2];
            for(Integer key : oldHashTable)
            {
                if (key != null) 
                { 
                int hashValue = key % newTable.length;
                while (newTable[hashValue] != null)
                {
                    hashValue = (hashValue + 1)% newTable.length;
                }
                newTable[hashValue] = key;
                }
            }
        return newTable;
        }
        System.out.println("No need to rehash as load factor < 0.7%.");
        return oldHashTable;
}
    // To calculate the loadFactor    
    public static double loadFactor(Integer [] oldHashTable)
    {    
        double count = 0;
        for (Integer key : oldHashTable)
        {
            if (key != null)
            {
                count++;
            }
        }
        double loadFactor = count/oldHashTable.length;
        return loadFactor;
    }
     //End function
        
}
/*When to Use:
int[]: When performance and memory usage are critical, and you don't need null values (as it can't).
Integer[]: When you need nullability (as it can hold null value), want to use collections, or need compatibility with APIs that work with objects.
*/
