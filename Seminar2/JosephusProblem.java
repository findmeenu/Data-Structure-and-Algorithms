import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class JosephusProblem {

    // Method 1: Using ArrayList
    public static int josephusWithArrayList(int n, int m) {
        ArrayList<Integer> josephus = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            josephus.add(i);
        }

        int start = 0;
        while (josephus.size() > 1) {
            start = (start + m-1) % josephus.size();
            josephus.remove(start);
        }
        return josephus.get(0);
    }


    // Method 1: Using ArrayList
/*    public static int solveJosephusWithArrayList(int n, int m) {
        ArrayList<Integer> circle = new ArrayList<>();
        int start = 0;
        for (int i = 2; i <= n; i++) {
            start = (start + m)%i;
            
        }
        return start +1;

    }*/

    // Method 2: Using ArrayList with Iterator
    public static int josephusWithArrayListIterator(int n, int m) {
        ArrayList<Integer> josephus = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            josephus.add(i);
        }

        Iterator<Integer> iterator = josephus.iterator();
        while (josephus.size() > 1) {
            for (int i = 0; i < m; i++) {
                if (!iterator.hasNext()) {
                    iterator = josephus.iterator();
                }
                iterator.next();
            }
            iterator.remove();
        }
        return josephus.get(0);
    }

    // Method 3: Using Custom LinkedList
    public static class Node {
        int personNumber;
        Node nextPerson;

        Node(int personNumber) {
            this.personNumber = personNumber;
        }
    }

    public static int josephusWithOwnLinkedList(int n, int m) {
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            temp.nextPerson = node;
            temp = node;
        }
        temp.nextPerson = head; // Make it circular

        Node current = head;
        while (current.nextPerson != current) {
            for (int i = 1; i < m; i++) {
                current = current.nextPerson;
            }
            current.personNumber = current.nextPerson.personNumber;
            current.nextPerson = current.nextPerson.nextPerson; // Remove the m-th person
        }
        return current.personNumber;
    }

    // Method 4: Using LinkedList with Iterator
    public static int josephusLinkedListIterator(int n, int m) {
        LinkedList<Integer> josephus = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            josephus.add(i);
        }

        Iterator<Integer> iterator = josephus.iterator();
        while (josephus.size() > 1) {
            for (int i = 0; i < m; i++) {
                if (!iterator.hasNext()) {
                    iterator = josephus.iterator();
                }
                iterator.next();
            }
            iterator.remove();
        }
        return josephus.get(0);
    }

    // Method to compare execution times
    public static void performanceComparison(int n, int m) {
        System.out.println("Performance comparision for N = " + n + ", M = " + m);
        System.out.println("**************************************************");

        // Execution time : ArrayList
        long start = System.nanoTime();
        josephusWithArrayList(n, m);
        long end = System.nanoTime();
        long nano = end - start;
        
        System.out.println("Execution time with ArrayList df.format(in nanoseconds): " + (nano));
        System.out.println(" ");

        // Execution time :  ArrayList with Iterator
        start = System.nanoTime();
        josephusWithArrayListIterator(n, m);
        end = System.nanoTime();
        nano = end - start;
        
        System.out.println("Execution time ArrayList with Iterator df.format(in nanoseconds): " + (nano));
        System.out.println(" ");

        // Execution time :  Own LinkedList
        start = System.nanoTime();
        josephusWithOwnLinkedList(n, m);
        end = System.nanoTime();
        nano = end - start;
        
        System.out.println("Execution time own LinkedList df.format(in nanoseconds): " + (nano));
        System.out.println(" ");

        // Execution time : LinkedList with Iterator
        start = System.nanoTime();
        josephusLinkedListIterator(n, m);
        end = System.nanoTime();
        nano = end - start;
        
        System.out.println("Execution time LinkedList with Iterator df.format(in nanoseconds): " + (nano));
        System.out.println(" ");
    }

    // Main Method
    public static void main(String[] args) {

        int n = 7; // Number of people
        int m = 3; // Number of passes

        System.out.println("Josephus Problem Results:");
        System.out.println("Using ArrayList: " + josephusWithArrayList(n, m));
        System.out.println("Using ArrayList with Iterator: " + josephusWithArrayListIterator(n, m));
        System.out.println("Using Custom LinkedList: " + josephusWithOwnLinkedList(n, m));
        System.out.println("Using LinkedList with Iterator: " + josephusLinkedListIterator(n, m));

        // Compare performance with larger inputs
        /*performanceComparison(10, 10);
        performanceComparison(100, 10);
        performanceComparison(1000, 10);
        performanceComparison(10000, 10);
        performanceComparison(100000,10);
        performanceComparison(100000, 10);*/

        performanceComparison(10, 1000);
        performanceComparison(100, 1000);
        performanceComparison(1000, 1000);
        performanceComparison(10000, 1000);
        performanceComparison(100000,1000);
        performanceComparison(1000000, 1000);

        /*performanceComparison(10, 3);
        performanceComparison(100, 3);
        performanceComparison(1000, 3);
        performanceComparison(10000, 3);
        performanceComparison(100000,3);
        performanceComparison(100000, 3);*/
    }
}
