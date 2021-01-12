
import java.util.*;

/**
 * (Perform set operations on hash sets) Create two linked hash sets {"George",
 * "Jim", "John", "Blake", "Kevin", "Michael"} and {"George", "Katie", "Kevin",
 * "Michelle", "Ryan"} and find their union, difference, and intersection. (You
 * can clone the sets to preserve the original sets from being changed by these
 * set methods.)
 *
 * Output:
 * set1: [George, Jim, John, Blake, Kevin, Michael]
 * set2: [George, Katie, Kevin, Michelle, Ryan]
 *
 * Union
 * set1: [George, Jim, John, Blake, Kevin, Michael, Katie, Michelle, Ryan]
 * set2: [George, Katie, Kevin, Michelle, Ryan]
 *
 * Difference
 * set1: [Jim, John, Blake, Michael]
 * set2: [George, Katie, Kevin, Michelle, Ryan]
 *
 * Intersection
 * set1: [George, Kevin]
 * set2: [George, Katie, Kevin, Michelle, Ryan]
 *
 * @author martinfall
 */
public class SetOperationsOnHashSets {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create set1 and set2 with 
        LinkedHashSet<String> set1 = new LinkedHashSet<>(Arrays.asList(
                "George", "Jim", "John", "Blake", "Kevin", "Michael"));
        System.out.println("set1: " + set1);

        LinkedHashSet<String> set2 = new LinkedHashSet<>(Arrays.asList(
                "George", "Katie", "Kevin", "Michelle", "Ryan"));
        System.out.println("set2: " + set2);

        // Find their union
        System.out.println("\nUnion");
        LinkedHashSet<String> set1Clone = (LinkedHashSet<String>) set1.clone();
        set1Clone.addAll(set2);
        System.out.println("set1: " + set1Clone);
        System.out.println("set2: " + set2);

        // Find their difference
        System.out.println("\nDifference");
        set1Clone = (LinkedHashSet<String>) set1.clone();
        set1Clone.removeAll(set2);
        System.out.println("set1: " + set1Clone);
        System.out.println("set2: " + set2);

        // Find their intersection
        System.out.println("\nIntersection");
        set1Clone = (LinkedHashSet<String>) set1.clone();
        set1Clone.retainAll(set2);
        System.out.println("set1: " + set1Clone);
        System.out.println("set2: " + set2);
    }
}
