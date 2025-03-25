import java.io.File;
import java.util.*;



public class Task1{

    public static void main(String []args){
        List <Integer> fileData = readInputFile();
        //task1ABC();
        //taskD(fileData);
        taskE(fileData);
        

    }







    public static void task1ABC(){
        int [] input = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
        HeapAlg1 heapAlg1 = new HeapAlg1(input);        
        HeapAlg2 heapAlg2 = new HeapAlg2(input);    
        
        // Print Min Heap and Traversal from Alg. 1 & ALg. 2
        System.out.println("MIN HEAP FROM ALGORITHM 1.\n");
        heapAlg1.printMinHeap();
        Traversal.printTraversal(heapAlg1.getHeap());
        System.out.println("MIN HEAP FROM ALGORITHM 2.\n");
        heapAlg2.printMinHeap();
        Traversal.printTraversal(heapAlg2.getHeap());
    }

    public static void taskD(List <Integer> fileData){
        // populate the file data in an array.
        
        int[] array = {10, 100, 1000, 10000, 100000, 1000000};
        
        for (int size : array){
            int [] input = new int[size];
            for (int i = 0; i < size && i < fileData.size(); i++){
                input[i] = fileData.get(i);
        }
            long startTime1 = System.nanoTime();
        
            @SuppressWarnings("unused")
            HeapAlg1 algorithm1 = new HeapAlg1(input);
            long endTime1 = System.nanoTime();
        
            // Calculate the time difference in milliseconds
            long durationInMillis1 = (endTime1 - startTime1)/1000;
            //algorithm1.printMinHeap();

            long startTime2 = System.nanoTime();
            @SuppressWarnings("unused")
            HeapAlg2 alogirthm2 = new HeapAlg2(input);
            long endTime2 = System.nanoTime();
            // Calculate the time difference in milliseconds
            long durationInMillis2 = (endTime2 - startTime2)/1000;
            //alogirthm2.printMinHeap();
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.printf("Input : %-7d        Time taken Alg 1 (in microseconds): %d\n", size, durationInMillis1);
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.printf("Input : %-7d        Time taken Alg 2 (in microseconds): %d\n", size, durationInMillis2);

    }        
    }

    
    public static List<Integer> readInputFile(){
       String filename = "C:\\Users\\MEGU0007\\Desktop\\New folder\\Seminar 3\\Seminar 1 - File with random numbers.txt";
       ArrayList<Integer> input = new ArrayList<>();
       try{
            File file = new File(filename); // To open the file.
            Scanner scanner = new Scanner(file);
            //Read nos. 
            while (scanner.hasNextInt()){
                input.add(scanner.nextInt());
            }
            scanner.close();
        } catch (Exception e){
            System.out.println("File not found: " + e.getMessage());
       }
           return input;
    }

    public static void taskE(List <Integer> fileData) {
        int[] array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : array){
            int [] input = new int[size];
            for (int i = 0; i < size && i < fileData.size(); i++){
                input[i] = fileData.get(i);
        }
        
        // Run tests for HeapAlg1
            HeapAlg1 heapAlg1 = new HeapAlg1(input);
            //heapAlg1.printMinHeap();
            long startTime1Insert = System.nanoTime();
            heapAlg1.addElement(5);  // Insert a new element
            //heapAlg1.printMinHeap();
            long endTime1Insert = System.nanoTime();
            long durationInsert1 = (endTime1Insert - startTime1Insert) / 1000;
            
            //heapAlg1.printMinHeap();
            long startTime1Delete = System.nanoTime();
            heapAlg1.deleteMin();  // Delete the minimum element
            long endTime1Delete = System.nanoTime();
            //System.out.println("after del");heapAlg1.printMinHeap();
            long durationDelete1 = (endTime1Delete - startTime1Delete) / 1000;


            
           /*heapAlg1.addElement(21);  // Insert a new element
            
            heapAlg1.printMinHeap();
            long startTimeHeapifyDelete = System.nanoTime();
            heapAlg1.deleteMinHeapify();  // Delete the minimum element
            long endTimeHeapifyDelete = System.nanoTime();
            System.out.println("after del");heapAlg1.printMinHeap();
            long durationDeleteHeapify = (endTimeHeapifyDelete - startTimeHeapifyDelete) / 1000;*/

            // Run tests for HeapAlg2
            
            HeapAlg2 heapAlg2 = new HeapAlg2(input);
            //heapAlg2.printMinHeap();
            long startTime2Insert = System.nanoTime();
            heapAlg2.addElement(5);  // Insert a new element
            long endTime2Insert = System.nanoTime();
            //heapAlg2.printMinHeap();
            long durationInsert2 = (endTime2Insert - startTime2Insert) / 1000;
            
            //heapAlg2.printMinHeap();
            long startTime2Delete = System.nanoTime();
            heapAlg2.deleteMin();  // Delete the minimum element
            long endTime2Delete = System.nanoTime();
            //heapAlg2.printMinHeap();
            long durationDelete2 = (endTime2Delete - startTime2Delete) / 1000;

            // Output results
            System.out.printf("Input Size: %-7d, Algorithm 1: Insert Time = %-3d µs,   Delete Min Time = %-3d µs\n", size, durationInsert1, durationDelete1);
            //System.out.printf("Input Size: %-7d, Algorithm 1: Insert Time = %-3d µs,   Delete Min Time = %-3d µs\n", size, durationInsert1, durationDeleteHeapify);
            System.out.printf("Input Size: %-7d, Algorithm 2: Insert Time = %-3d µs,   Delete Min Time = %-3d µs\n", size, durationInsert2, durationDelete2);
    }
}}



