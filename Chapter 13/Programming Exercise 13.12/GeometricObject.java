
import java.util.Date;

/**
 * (Sum the areas of geometric objects) Write a method that sums the areas of
 * all the geometric objects in an array. The method signature is:
 *
 * public static double sumArea(GeometricObject[] a)
 *
 * Write a test program that creates an array of four objects (two circles and
 * two rectangles) and computes their total area using the sumArea method.
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
