
import java.util.Date;

/**
 *
 * @author martinfall
 */
public class GeometricObject {

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled) {
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
     * Return filled. Since filled is boolean, its getter method is named
     * isFilled
     *
     * @return
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     *
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     *
     * @return
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     *
     * @return
     */
    @Override
    public String toString() {
        return "created on " + dateCreated
                + "\ncolor: " + color + " and filled: " + filled;
    }
}
