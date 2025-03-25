import java.util.List;

public class Traversal {
    private List<Integer> heap;


    public Traversal(List <Integer> heap){
        this.heap = heap;
    }

    public void preOrder(int index) {
        if (index >= heap.size()) 
            return;
        System.out.print(heap.get(index) + " ");
        preOrder(2 * index + 1);
        preOrder(2 * index + 2);
    }
    public void inOrder(int index) {
        if (index >= heap.size()) 
            return;
        inOrder(2 * index + 1);
        System.out.print(heap.get(index) + " ");
        inOrder(2 * index + 2);
    }

    public void postOrder(int index) {
        if (index >= heap.size()) return;
        postOrder(2 * index + 1);
        postOrder(2 * index + 2);
        System.out.print(heap.get(index) + " ");
    }

    public void levelOrder(int index) {
        for (int value : heap) {
            System.out.print(value + " ");
        }
    }

    static void printTraversal(List <Integer> minHeap){
        Traversal traversal = new Traversal(minHeap);
        
        System.out.println("---------------------------------\nTRAVERSAL\n__________________________________\n");
        System.out.println("Pre Order : "); traversal.preOrder(0);
        System.out.println("\n");
        System.out.println("In Order : "); traversal.inOrder(0);
        System.out.println("\n");
        System.out.println("Post Order : "); traversal.postOrder(0);
        System.out.println("\n");
        System.out.println("Level Order : "); traversal.levelOrder(0);
        System.out.println("\n\n--------------------End of Traversal----------------------\n");
        
    }
}
