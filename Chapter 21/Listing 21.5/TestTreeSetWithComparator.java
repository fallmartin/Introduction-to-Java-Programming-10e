
import java.util.*;

/**
 * Output:
 * A sorted set of geometric objects
 * area = 4.0
 * area = 20.0
 * area = 5026.548245743669
 *
 * @author martinfall
 */
public class TestTreeSetWithComparator {

    public static void main(String[] args) {
        // Create a tree set for geometric objects using a comparator
        Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());
        set.add(new Rectangle(4, 5));
        set.add(new Circle(40));
        set.add(new Circle(40));
        set.add(new Rectangle(4, 1));

        // Display geometric objects in the tree set
        System.out.println("A sorted set of geometric objects");
        set.forEach((t) -> {
            System.out.println("area = " + t.getArea());
        });
    }
}
