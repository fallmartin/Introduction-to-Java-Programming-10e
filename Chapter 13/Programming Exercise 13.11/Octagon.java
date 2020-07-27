
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
 * @author martinfall
 */
public class Octagon extends GeometricObject
        implements Comparable<Octagon>, Cloneable {

    private double side;

    /**
     * Constructs an Octagon object with default value.
     */
    public Octagon() {
    }

    /**
     * Constructs an Octagon object with value side.
     *
     * @param side
     */
    public Octagon(double side) {
        this.side = side;
    }

    @Override // Implement the abstract getArea method of GeometricObject
    public double getArea() {
        return (2 + (4 / Math.sqrt(2))) * side * side;
    }

    @Override // Implement the abstract getPerimeter method of GeometricObject
    public double getPerimeter() {
        return 8 * side;
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(Octagon o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override // Implement the equals method of the Object class
    public boolean equals(Object obj) {
        if (!(obj instanceof Octagon)) {
            return false;
        }
        return compareTo((Octagon) obj) == 0;
    }

    @Override // Implement the clone method define in Cloneable
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
