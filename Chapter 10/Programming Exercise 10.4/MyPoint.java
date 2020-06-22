
/**
 * (The MyPoint class) Design a class named MyPoint to represent a point with
 * x- and y-coordinates. The class contains:
 *
 * ■ The data fields x and y that represent the coordinates with getter
 * methods.
 * ■ A no-arg constructor that creates a point (0, 0).
 * ■ A constructor that constructs a point with specified coordinates.
 * ■ A method named distance that returns the distance from this point to a
 * specified point of the MyPoint type.
 * ■ A method named distance that returns the distance from this point to
 * another point with specified x- and y-coordinates.
 *
 * Draw the UML diagram for the class and then implement the class. Write a
 * test program that creates the two points (0, 0) and (10, 30.5) and displays the
 * distance between them.
 *
 * @author martinfall
 */
public class MyPoint {

    // The data fields x and y that represent the coordinates with getter methods.
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // A no-arg constructor that creates a point (0, 0).
    public MyPoint() {
        this(0, 0);
    }

    // A constructor that constructs a point with specified coordinates.
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // A method named distance that returns the distance from this point to a
    // specified point of the MyPoint type.
    public double distance(MyPoint point) {
        return distance(point.getX(), point.getY());
    }
    
    // A method named distance that returns the distance from this point to 
    // another point with specified x- and y-coordinates.
    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(getX() - x, 2) + Math.pow(getY() - y, 2));
    }
}
