
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
public abstract class GeometricObject implements Comparable<GeometricObject> {

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

    /**
     * Finds and returns the largest of two GeometricObject objects.
     *
     * @param o1
     * @param o2
     * @return
     */
    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        return (o1.compareTo(o2) > 1) ? o1 : o2;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated
                + "\ncolor: " + color + " and filled: " + filled;
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
