
import java.io.Serializable;
import java.util.Comparator;

/**
 * Output:
 * The area of the larger object is 78.53981633974483
 *
 * @author martinfall
 */
public class TestComparator {

    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5, 5);
        GeometricObject g2 = new Circle(5);

        GeometricObject g = max(g1, g2, new GeometricObjectComparator());
        System.out.println("The area of the larger object is " + g.getArea());
    }

    public static GeometricObject max(
            GeometricObject g1, GeometricObject g2,
            Comparator<GeometricObject> c) {
        if (c.compare(g1, g2) > 0) {
            return g1;
        } else {
            return g2;
        }
    }
}

class GeometricObjectComparator
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

class Rectangle extends GeometricObject {

    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Return width
     *
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set a new width
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return height
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set a new height
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
}

class Circle extends GeometricObject {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Return radius
     *
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set a new radius
     *
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    /**
     * Return area
     */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Return diameter
     *
     * @return
     */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    /**
     * Return perimeter
     */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /* Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated()
                + " and the radius is " + radius);
    }
}
