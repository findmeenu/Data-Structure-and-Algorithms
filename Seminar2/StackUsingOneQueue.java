import java.util.*;

public class StackUsingOneQueue {
    private Queue<Integer> queue ;
    
    public StackUsingOneQueue(){
        queue = new LinkedList<>();
    }    
    public void push(int data) {
        queue.add(data);
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.remove());
        }
        System.out.println("Added to stack: " + data);
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Underflow: Stack is Empty");
        }
        return queue.remove();
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Underflow: Stack is Empty");
        }
        return queue.peek();
    }
}