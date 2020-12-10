
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author martinfall
 */
public class GeometricObjectComparator
        implements Comparator<GeometricObject>, Serializable {

    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2) {
            return -1;
        } else if (area1 == area2) {
            return 0;
        } else {
            return -1;
        }
    }

}

abstract class GeometricObject {

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
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean, the get method name is named
     * isFilled
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
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated
                + "\ncolor: " + color + " and filled: " + filled;
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
