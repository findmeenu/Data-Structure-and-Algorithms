import java.util.*;

    
public class HeapAlg2 {
    private ArrayList<Integer> minHeap;
    
    // instantiate an empty array list and add all elements into it.
    public HeapAlg2(int [] input) {
        minHeap = new ArrayList<>();
        for (int data : input){
            minHeap.add(data);
        } 
        makeHeap(); 
    }

    public void makeHeap(){
        int parentIndex = (minHeap.size()/2)-1; // get the index for first parent node with child.
        for (int i = parentIndex; i>=0; i--){
            percolateDown(i);
        }
    }

    public void addElement(int data){
        minHeap.add(data);
        percolateUp(minHeap.size()-1);                       // percolate-up the inserted data. 
    }

    public void deleteMin() {
        if (minHeap.size() == 0) {
            System.out.println("Heap is empty, nothing to delete.");
            return;
        }
        Collections.swap(minHeap, 0, minHeap.size() - 1); // Swap the root with last element
        minHeap.remove(minHeap.size() - 1); // Removes root element from last position
       
        percolateDown(0); // Use HeapAlg2's percolateDown method
    }

    public void percolateUp (int index){
        int parentIndex = (index-1)/2; // calculating the index of parent
        // if index is greater than 0 then compare the value at given index and compare it with it's parent.
        while (index > 0 && minHeap.get(index) < minHeap.get(parentIndex)){   
            Collections.swap(minHeap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;

        }
    }

    public void percolateDown(int parentIndex){
        // we are considering that parent node contains the minimum value.
        int min = parentIndex;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        
        if (leftChildIndex < minHeap.size() && minHeap.get(leftChildIndex) < minHeap.get(min)){
            min = leftChildIndex; // compare left child value with parent and store it's index in min.
        }
        if (rightChildIndex < minHeap.size() && minHeap.get(rightChildIndex) < minHeap.get(min)){
            min = rightChildIndex; // compare right child value with parent and store it's index in min.
        }
        if (min != parentIndex) {
            Collections.swap(minHeap, parentIndex, min); // swap the minimum value with child if parent value > child.
            percolateDown(min); //Use recursion
        }
    }

    public void printMinHeap() {
        System.out.println(minHeap);
    }

    public List<Integer> getHeap() {
        return minHeap;
    }
}


