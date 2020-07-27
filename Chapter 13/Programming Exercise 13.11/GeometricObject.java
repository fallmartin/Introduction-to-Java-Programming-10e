
import java.util.Date;

/**
 * (The Octagon class) Write a class named Octagon that extends GeometricObject
 * and implements the Comparable and Cloneable interfaces. Assume that all eight
 * sides of the octagon are of equal length. The area can be computed using the
 * following formula:
 *
 * area = (2 + (4 / Math.sqrt(2))) * side * side
 *
 * Draw the UML diagram that involves Octagon, GeometricObject, Comparable, and
 * Cloneable. Write a test program that creates an Octagon object with side
 * value
 * 5 and displays its area and perimeter. Create a new object using the clone
 * method and compare the two objects using the compareTo method.
 *
 * @author martinfall
 */
public abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /**
     * Construct a default geometric object.
     */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with color and filled value.
     *
     * @param color
     * @param filled
     */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color.
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color.
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled.Since filled is boolean, the get method is named isFilled.
     *
     * @return
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled.
     *
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated.
     *
     * @return
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color
                + " and filled: " + filled;
    }

    /**
     * Abstract method getArea.
     *
     * @return
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter.
     *
     * @return
     */
    public abstract double getPerimeter();
}
