
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
public class Circle extends GeometricObject implements Comparable<Circle> {

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

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(Circle c) {
        if (getArea() > c.getArea()) {
            return 1;
        } else if (getArea() < c.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override // Implement the equals method defined in Object
    public boolean equals(Object obj) {
        // Check if the Object is of type Circle
        if (!(obj instanceof Circle)) {
            return false;
        }

        // If the radii are equal, return true. Else, return false.
        return getRadius() == ((Circle) obj).getRadius();
    }
}
