
import java.util.*;

/**
 * Output:
 * Member test time for hash set is 18 milliseconds
 * Remove element time for hash set is 14 milliseconds
 * Member test time for linked hash set is 12 milliseconds
 * Remove element time for linked hash set is 24 milliseconds
 * Member test time for tree set is 86 milliseconds
 * Remove element time for tree set is 38 milliseconds
 * Member test time for array list is 2252 milliseconds
 * Remove element time for array list is 1068 milliseconds
 * Member test time for linked list is 6053 milliseconds
 * Remove element time for linked list is 2821 milliseconds
 *
 * @author martinfall
 */
public class SetListPerformanceTest {

    static final int N = 50_000;

    public static void main(String[] args) {
        // Add numbers 0, 1, 2, ... , N - 1 to the array list
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        Collections.shuffle(list); // Shuffle the array lists

        // Create a hash set and test its performance
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("Member test time for hash set is "
                + getTestTime(set1) + " milliseconds");
        System.out.println("Remove element time for hash set is "
                + getRemoveTime(set1) + " milliseconds");

        // Create a linked hash set, and test its performance
        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("Member test time for linked hash set is "
                + getTestTime(set2) + " milliseconds");
        System.out.println("Remove element time for linked hash set is "
                + getRemoveTime(set2) + " milliseconds");

        // Create a tree set, and test its performance
        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("Member test time for tree set is "
                + getTestTime(set3) + " milliseconds");
        System.out.println("Remove element time for tree set is "
                + getRemoveTime(set3) + " milliseconds");

        // Create an array list, and test its performance
        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("Member test time for array list is "
                + getTestTime(list1) + " milliseconds");
        System.out.println("Remove element time for array list is "
                + getRemoveTime(list1) + " milliseconds");

        // Create a linked list, and test its performance
        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("Member test time for linked list is "
                + getTestTime(list2) + " milliseconds");
        System.out.println("Remove element time for linked list is "
                + getRemoveTime(list2) + " milliseconds");
    }

    public static long getTestTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        // Test if a number is in the collection
        for (int i = 0; i < N; i++) {
            c.contains((int) (Math.random() * 2 * N));
        }

        return System.currentTimeMillis() - startTime;
    }

    public static long getRemoveTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.remove(i);
        }

        return System.currentTimeMillis() - startTime;
    }
}
