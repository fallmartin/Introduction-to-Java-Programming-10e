
import java.util.*;

/**
 * Output:
 * [San Francisco, Beijing, New York, London, Paris]
 * SAN FRANCISCO BEIJING NEW YORK LONDON PARIS
 *
 * @author martinfall
 */
public class TestHashSet {

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

        System.out.println(set);

        // Display the elements in the hash set
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }
    }
}
