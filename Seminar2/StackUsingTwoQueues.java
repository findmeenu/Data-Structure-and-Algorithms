import java.util.*;

public class StackUsingTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();    
    }

    // To add data to Stack
    public void push(int number){
        queue1.offer(number);
        System.out.println("Added to Stack: " +  number);

    }

    // Remove element from stack
    public int pop(){
        //if both queue empty then Exception
        if (queue1.isEmpty()){
            throw new IllegalStateException("Underflow : Stack is Empty");
        }
        while (queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        int data = queue1.remove();
        Queue<Integer> emptyQueue = queue1;
        queue1 = queue2;
        queue2 = emptyQueue;
        return data;
    }


    public int peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Underflow: Stack is Empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int data = queue1.remove();
        queue2.add(data);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return data;
    }

    public void printQueue1(){
        System.out.println(queue1);
        System.out.println(queue2);
    }    
}
