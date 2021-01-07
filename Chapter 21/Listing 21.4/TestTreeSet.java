
import java.util.*;

/**
 * Output:
 * Sorted tree set: [Beijing, London, New York, Paris, San Francisco]
 * first(): Beijing
 * last(): San Francisco
 * headSet("New York"): [Beijing, London]
 * tailSet("New York"): [New York, Paris, San Francisco]
 * lower("P"): New York
 * higher("P"): Paris
 * floor("P"): New York
 * ceiling("P"): Paris
 * pollFirst(): Beijing
 * pollLast(): San Francisco
 * New tree set: [London, New York, Paris]
 *
 * @author martinfall
 */
public class TestTreeSet {

    public static void main(String[] args) {
        // Create a hash set
        Set<String> set = new HashSet<>();

        // Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        TreeSet<String> treeSet = new TreeSet<>(set);
        System.out.println("Sorted tree set: " + treeSet);

        // Used the methods in SortedSet interface
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("headSet(\"New York\"): "
                + treeSet.headSet("New York"));
        System.out.println("tailSet(\"New York\"): "
                + treeSet.tailSet("New York"));

        // Use the methods in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet.lower("P"));
        System.out.println("higher(\"P\"): " + treeSet.higher("P"));
        System.out.println("floor(\"P\"): " + treeSet.floor("P"));
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));
        System.out.println("pollFirst(): " + treeSet.pollFirst());
        System.out.println("pollLast(): " + treeSet.pollLast());
        System.out.println("New tree set: " + treeSet);
    }
}
