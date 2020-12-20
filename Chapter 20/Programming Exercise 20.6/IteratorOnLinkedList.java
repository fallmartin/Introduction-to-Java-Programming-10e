
import java.util.*;

/**
 * (Use iterators on linked lists) Write a test program that stores 5 million
 * integers in a linked list and test the time to traverse the list using an
 * iterator vs. using the get(index) method.
 *
 * Output with 5,000 integers:
 * Storing 5,000 integers in a linked list...
 * Done!
 *
 * Traversing the list using an iterator takes 2ms
 * Traversing the list using the get(index) method takes 1608459313328ms
 *
 * @author martinfall
 */
public class IteratorOnLinkedList {

    private static final int LIMIT = 5_000_000;
    private static final Random RANDOM = new Random();

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new linked list
        List<Integer> list = new LinkedList<>();

        System.out.println("Storing " + String.format("%,d", LIMIT) + " integers in a linked list...");
        // Populate the list with 5000000 randomly generated integer values
        for (int i = 0; i < LIMIT; i++) {
            list.add(RANDOM.nextInt());
        }
        System.out.println("Done!\n");

        /**
         * Test the time to traverse the list using an iterator.
         */
        // Create a list iterator for our list.
        Iterator<Integer> iterator = list.iterator();
        long startTime = System.currentTimeMillis(); // Start time
        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.print("Traversing the list using an iterator takes ");
        printDuration(startTime);

        /**
         * Test the time to traverse the list using the get(index) method.
         */
        // Reset the timer
        startTime = 0;
        for (int i = 0; i < LIMIT; i++) {
            list.get(i);
        }
        System.out.print("Traversing the list using the get(index) method takes ");
        printDuration(startTime);
    }

    public static void printDuration(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
    }
}
