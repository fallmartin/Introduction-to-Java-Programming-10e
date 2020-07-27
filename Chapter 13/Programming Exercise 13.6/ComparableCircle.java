
/**
 * (The ComparableCircle class) Define a class named ComparableCircle that
 * extends Circle and implements Comparable. Draw the UML diagram and implement
 * the compareTo method to compare the circles on the basis of area. Write a test
 * class to find the larger of two instances of ComparableCircle objects.
 *
 * @author martinfall
 */
public class ComparableCircle extends Circle implements Comparable<GeometricObject> {

    /**
     * Constructs a default ComparableCircle object with default value.
     */
    public ComparableCircle() {
    }

    /**
     * Constructs a ComparableCircle object with value radius.
     * @param radius
     */
    public ComparableCircle(double radius) {
        super(radius);
    }
    
    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(GeometricObject o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
