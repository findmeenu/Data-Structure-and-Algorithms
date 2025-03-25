import java.util.*;

public class QueueUsingTwoStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor
    public QueueUsingTwoStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Add an element to queue
    public void enqueue(int item){
        stack1.push(item);
        System.out.println("Added to queue: " + item );
    }

    // Remove an element from queue based on FIFO
    public int dequeue(){
        if(stack2.isEmpty()){
            if (stack1.isEmpty()){
                throw new IllegalStateException("Dequeue Underflow: Queue is Empty");
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();   
    }

    // Provide the element by peeking and without removing
    public int peek(){
        if (stack1.isEmpty()){
            if (stack2.isEmpty()){
                throw new IllegalStateException("Peek Underflow: Queue is Empty");
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            } 
        }
        return stack2.peek();
        //System.out.println("First element in queue:" + peek);
    }

    
    // Print Stack1 - testing purpose
    public void printStack1(){
        System.out.println(stack1);
    }

    // Print queue - testing purpose
    public void printStack2(){
        System.out.println(stack2);
    }
}

