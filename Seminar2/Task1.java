public class Task1 {
    public static void main(String[] args) {
        // Testing Queue using Two Stacks
        System.out.println("Testing Queue using Two Stacks");
        
        tryCatch(()-> {
            QueueUsingTwoStack queueTwoStacks = new QueueUsingTwoStack();
            queueTwoStacks.enqueue(1);
            queueTwoStacks.enqueue(2);
            queueTwoStacks.enqueue(3);
            System.out.println("Dequeued: " + queueTwoStacks.dequeue());
            System.out.println("Peek: " + queueTwoStacks.peek());
            System.out.println("Dequeued: " + queueTwoStacks.dequeue());
            System.out.println("Peek: " + queueTwoStacks.peek());
            System.out.println("Dequeued: " + queueTwoStacks.dequeue());
            System.out.println("Dequeued: " + queueTwoStacks.dequeue());
            System.out.println("Peek: " + queueTwoStacks.peek());
        });
        // Testing Queue using One Stack
        System.out.println("\nTesting Queue using One Stack");
        tryCatch(() -> {
            QueueUsingOneStack queueOneStack = new QueueUsingOneStack();
            queueOneStack.enqueue(1);
            queueOneStack.enqueue(2);
            queueOneStack.enqueue(3);
            System.out.println("Dequeued: " + queueOneStack.dequeue());
            System.out.println("Peek: " + queueOneStack.peek());
});
        System.out.println("-------------------------------");
        System.out.println("\nTesting Stack using Two Queue");
        tryCatch(()->{
            StackUsingTwoQueues stackTwoQueue = new StackUsingTwoQueues();
            stackTwoQueue.push(1);
            stackTwoQueue.push(2);
            stackTwoQueue.push(3);
            
            System.out.println("Removed Element from Stack: " +stackTwoQueue.pop());
            System.out.println("Peeked Element from Stack: " +stackTwoQueue.peek());
            System.out.println("Removed Element from Stack: " +stackTwoQueue.pop());
            System.out.println("Removed Element from Stack: " +stackTwoQueue.pop());
            
            
        });

        System.out.println("\nTesting Stack using One Queue");
        tryCatch(()->{
            StackUsingOneQueue stackOneQueue = new StackUsingOneQueue();
            stackOneQueue.push(1);
            stackOneQueue.push(2);
            stackOneQueue.push(3);
            System.out.println("Removed Element from Stack: " +   stackOneQueue.pop());
            System.out.println("Peeked Element from Stack" + stackOneQueue.peek() );
            System.out.println("Removed Element from Stack: " +   stackOneQueue.pop());
            System.out.println("Removed Element from Stack: " +   stackOneQueue.pop());
            System.out.println("Removed Element from Stack: " +   stackOneQueue.pop());
            System.out.println("Removed Element from Stack: " +   stackOneQueue.peek());




        });

    }
    public static void tryCatch (Runnable test){
        try{
            test.run();
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

} 