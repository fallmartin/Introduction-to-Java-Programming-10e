
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
public class Rectangle extends GeometricObject implements Comparable<Rectangle> {

    private double width;
    private double height;

    /**
     * Constructs a Rectangle object with default values.
     */
    public Rectangle() {
    }

    /**
     * Constructs a Rectangle object with values width and height.
     *
     * @param width
     * @param height
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Return width.
     *
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set a new width.
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return height.
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set a new height.
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    /**
     * Return area
     */
    public double getArea() {
        return width * height;
    }

    @Override
    /**
     * Return perimeter
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override // Implement the compareTo method defined in Comparable.
    public int compareTo(Rectangle o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override // Implement the equals defined in Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        // Two Rectangle objects are equal if their areas are the same.
        return compareTo((Rectangle) obj) == 0;
    }
}
