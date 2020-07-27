
/**
 * (The ComparableCircle class) Define a class named ComparableCircle that
 * extends Circle and implements Comparable. Draw the UML diagram and implement
 * the compareTo method to compare the circles on the basis of area. Write a test
 * class to find the larger of two instances of ComparableCircle objects.
 *
 * Output:
 * The largest circle has a radius of 25.0
 *
 * @author martinfall
 */
public class TestComparableCircle {

    public static void main(String[] args) {
        // Create two Circle objects
        ComparableCircle c1 = new ComparableCircle(20);
        ComparableCircle c2 = new ComparableCircle(25);

        // Find the larger of two instances of ComparableCircle objects
        Circle largestCircle = (c1.compareTo(c2) == 1) ? c1 : c2;
        System.out.println("The largest circle has a radius of "
                + largestCircle.getRadius());
    }
}
