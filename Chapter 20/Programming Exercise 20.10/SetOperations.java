
import java.util.*;

/**
 * (Perform set operations on priority queues) Create two priority queues,
 * {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and
 * {"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their union,
 * difference, and intersection.
 *
 * Output:
 * Set A: [Blake, George, John, Jim, Kevin, Michael]
 * Set B: [George, Katie, Kevin, Michelle, Ryan]
 *
 * A U B = B U A:
 * [Blake, George, George, Jim, Kevin, Michael, John, Katie, Kevin, Michelle,
 * Ryan]
 *
 * A - B:
 * [Blake, John, Jim, Michael]
 * B - A:
 * [Katie, Michelle, Ryan]
 * A n B:
 * [George, Kevin]
 * A n B:
 * [George, Kevin]
 *
 * @author martinfall
 */
public class SetOperations {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create two string arrays
        String[] a
                = new String[]{"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String[] b
                = new String[]{"George", "Katie", "Kevin", "Michelle", "Ryan"};

        // Create two priority queues from the string arrays
        PriorityQueue<String> A = new PriorityQueue<>(Arrays.asList(a));
        PriorityQueue<String> B = new PriorityQueue<>(Arrays.asList(b));

        // Display both queues to the console
        System.out.println("Set A: " + A);
        System.out.println("Set B: " + B);
        System.out.println();

        // Display their union, difference, and intersection.
        // Union
        A.addAll(B);
        System.out.println("A U B = B U A:");
        System.out.println(A);
        System.out.println();

        // Housekeeping
        A = new PriorityQueue<>(Arrays.asList(a)); // Reset A

        // Difference
        A.removeAll(B);
        System.out.println("A - B:");
        System.out.println(A);
        A = new PriorityQueue<>(Arrays.asList(a)); // Reset A
        B.removeAll(A);
        System.out.println("B - A:");
        System.out.println(B);
        B = new PriorityQueue<>(Arrays.asList(b)); // Reset B

        // Intersection
        A.retainAll(B);
        System.out.println("A n B:");
        System.out.println(A);
        A = new PriorityQueue<>(Arrays.asList(a)); // Reset A
        B.retainAll(A);
        System.out.println("A n B:");
        System.out.println(B);
        // No need to reset B because we are done
    }
}
