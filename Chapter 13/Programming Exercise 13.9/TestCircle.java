
/**
 * (Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
 * GeometricObject and implement the Comparable interface. Override the
 * equals method in the Object class. Two Circle objects are equal if their radii
 * are the same. Draw the UML diagram that involves Circle, GeometricObject,
 * and Comparable.
 *
 * Output:
 * c1.equals(c2)? false
 * c1.equals(c3)? true
 *
 * @author martinfall
 */
public class TestCircle {

    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Circle c2 = new Circle(20);
        Circle c3 = new Circle(10);

        System.out.println("c1.equals(c2)? " + c1.equals(c2));
        System.out.println("c1.equals(c3)? " + c1.equals(c3));
    }
}
