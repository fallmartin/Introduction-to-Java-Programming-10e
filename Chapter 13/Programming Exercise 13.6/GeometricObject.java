
/**
 * (Enable GeometricObject comparable) Modify the GeometricObject class to
 * implement the Comparable interface, and define a static max method in the
 * GeometricObject class for finding the larger of two GeometricObject objects.
 * Draw the UML diagram and implement the new GeometricObject class. Write a test
 * program that uses the max method to find the larger of two circles and the
 * larger of two rectangles.
 *
 * @author martinfall
 */
public abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with color and filled value
     */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean,
     * the get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color
                + " and filled: " + filled;
    }

    /**
     * Abstract method getArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}
