
/**
 * (Enable Rectangle comparable) Rewrite the Rectangle class in Listing 13.3 to
 * extend GeometricObject and implement the Comparable interface. Override
 * the equals method in the Object class. Two Rectangle objects are equal
 * if their areas are the same. Draw the UML diagram that involves Rectangle,
 * GeometricObject, and Comparable.
 *
 * Output;
 * r1.equals(r2)? false
 * r1.equals(r3)? true
 *
 * @author martinfall
 */
public class TestRectangle {

    public static void main(String[] args) {
        // Create three Rectangle objects
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(20, 30);
        Rectangle r3 = new Rectangle(20, 10);

        // Display two comparisons
        System.out.println("r1.equals(r2)? " + r1.equals(r2));
        System.out.println("r1.equals(r3)? " + r1.equals(r3));
    }
}
