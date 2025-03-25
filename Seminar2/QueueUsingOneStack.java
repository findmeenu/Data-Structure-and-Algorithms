import java.util.*;

public class QueueUsingOneStack {
    private Stack<Integer> stack;
    

    // Constructor
    public QueueUsingOneStack(){
        stack = new Stack<>();
       
    }
    
    // Add an element to queue
    public void enqueue(int item){
        stack.push(item);
        System.out.println("Added to queue: " + item );
    }
    
    // Remove an element from queue based on FIFO
    public int dequeue(){
        if (stack.isEmpty()){
            throw new IllegalStateException("Dequeue Underflow: Queue is Empty");
        }
        if (stack.size() == 1){
            return stack.pop();
            
        }
        int data = stack.pop();
        int result = dequeue();
        stack.push(data);
        return result;
    }

    // Provide the element by peeking and without removing
    public int peek(){
        if (stack.isEmpty()){
                throw new IllegalStateException("Peek Underflow: Queue is Empty");
        }
        if (stack.size() == 1){
            return stack.peek();
        }
        int data = stack.pop();
        int result = peek();
        stack.push(data);
        return result;
    }


    // Print Stack1 - testing purpose
    public void printStack(){
        System.out.println(stack);
    }

}

