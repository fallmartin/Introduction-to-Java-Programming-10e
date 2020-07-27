
/**
 * (The Octagon class) Write a class named Octagon that extends GeometricObject
 * and implements the Comparable and Cloneable interfaces. Assume that all eight
 * sides of the octagon are of equal length. The area can be computed using the
 * following formula:
 *
 * area = (2 + (4 / Math.sqrt(2))) * side * side
 *
 * Draw the UML diagram that involves Octagon, GeometricObject, Comparable, and
 * Cloneable. Write a test program that creates an Octagon object with side value
 * 5 and displays its area and perimeter. Create a new object using the clone
 * method and compare the two objects using the compareTo method.
 *
 * Output:
 * Area: 120.71067811865476
 * Perimeter: 40.0
 * o1.compareTo(o2): true
 *
 * @author martinfall
 */
public class TestOctagon {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Create a new Octagon object
        Octagon o1 = new Octagon(5);

        // Display its area and perimeter
        System.out.println("Area: " + o1.getArea());
        System.out.println("Perimeter: " + o1.getPerimeter());

        // Create a new object using the clone method
        Octagon o2 = (Octagon) o1.clone();

        // Compare the two objects using the compareTo method
        System.out.println("o1.compareTo(o2): " + (o1.compareTo(o2) == 0));
    }
}
