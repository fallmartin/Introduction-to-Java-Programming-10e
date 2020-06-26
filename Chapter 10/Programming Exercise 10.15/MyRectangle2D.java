
/**
 * (Geometry: the MyRectangle2D class) Define the MyRectangle2D class that
 * contains:
 *
 * ■ Two double data fields named x and y that specify the center of the rectangle
 * with getter and setter methods. (Assume that the rectangle sides are
 * parallel to x- or y- axes.)
 * ■ The data fields width and height with getter and setter methods.
 * ■ A no-arg constructor that creates a default rectangle with (0, 0) for (x, y)
 * and 1 for both width and height.
 * ■ A constructor that creates a rectangle with the specified x, y, width, and
 * height.
 * ■ A method getArea() that returns the area of the rectangle.
 * ■ A method getPerimeter() that returns the perimeter of the rectangle.
 * ■ A method contains(double x, double y) that returns true if the
 * specified point (x, y) is inside this rectangle (see Figure 10.24a).
 * ■ A method contains(MyRectangle2D r) that returns true if the specified
 * rectangle is inside this rectangle (see Figure 10.24b).
 * ■ A method overlaps(MyRectangle2D r) that returns true if the specified
 * rectangle overlaps with this rectangle (see Figure 10.24c).
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that creates a MyRectangle2D object r1 (new MyRectangle2D(2,
 * 2, 5.5, 4.9)), displays its area and perimeter, and displays the result of
 * r1.contains(3, 3), r1.contains(new MyRectangle2D(4, 5, 10.5,
 * 3.2)), and r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)).
 *
 * @author martinfall
 */
public class MyRectangle2D {

    private double x;
    private double y;
    private double width;
    private double height;

    /**
     * A no-arg constructor that creates a default rectangle with (0, 0) for (x,
     * y) and 1 for both width and height.
     */
    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    /**
     * A constructor that creates a rectangle with the specified x, y, width,
     * and height.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns x.
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Returns y.
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the width of the triangle.
     *
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the triangle.
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set x.
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set y.
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Set the width of the triangle.
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Set the height of the triangle.
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * A method getArea() that returns the area of the rectangle.
     *
     * @return
     */
    public double getArea() {
        return getWidth() * getHeight();
    }

    /**
     * A method getPerimeter() that returns the perimeter of the rectangle.
     *
     * @return
     */
    public double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    /**
     * A method contains(double x, double y) that returns true if the specified
     * point (x, y) is inside this rectangle (see Figure 10.24a).
     *
     * @param x
     * @param y
     * @return
     */
    public boolean contains(double x, double y) {
        return (x <= getX() + (getWidth() / 2)
                && x >= getX() - (getWidth() / 2)
                && y <= getY() + (getHeight() / 2))
                && y >= getY() - (getHeight() / 2);
    }

    /**
     * A method contains(MyRectangle2D r) that returns true if the specified
     * rectangle is inside this rectangle (see Figure 10.24b).
     *
     * @param r
     * @return
     */
    public boolean contains(MyRectangle2D r) {
        // Create a new array for the 4 vertices of the rectangle r
        double[][] vertices = new double[4][2];

        // Populate the vertices array
        vertices[0][0] = getX() - (getWidth() / 2);
        vertices[0][1] = getY() + (getHeight() / 2);
        vertices[1][0] = getX() + (getWidth() / 2);
        vertices[1][1] = getY() + (getHeight() / 2);
        vertices[2][0] = getX() + (getWidth() / 2);
        vertices[2][1] = getY() - (getHeight() / 2);
        vertices[3][0] = getX() - (getWidth() / 2);
        vertices[3][1] = getY() - (getHeight() / 2);

        // Check if each vertex is contained in the rectangle
        for (double[] vertex : vertices) {
            if (!contains(vertex[0], vertex[1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * A method overlaps(MyRectangle2D r) that returns true if the specified
     * rectangle overlaps with this rectangle (see Figure 10.24c).
     *
     * @param r
     * @return
     */
    public boolean overlaps(MyRectangle2D r) {
        // A rectangle A overlaps another rectangle B if up to 2 of B's vertices are 
        // contained within rectangle A

        // Create a new array for the 4 vertices of the rectangle r
        double[][] vertices = new double[4][2];

        // Populate the vertices array
        vertices[0][0] = getX() - (getWidth() / 2);
        vertices[0][1] = getY() + (getHeight() / 2);
        vertices[1][0] = getX() + (getWidth() / 2);
        vertices[1][1] = getY() + (getHeight() / 2);
        vertices[2][0] = getX() + (getWidth() / 2);
        vertices[2][1] = getY() - (getHeight() / 2);
        vertices[3][0] = getX() - (getWidth() / 2);
        vertices[3][1] = getY() - (getHeight() / 2);

        // Create a counter to tally the number of vertices contained
        int counter = 0;

        // Check if each vertex is contained in the rectangle
        for (double[] vertex : vertices) {
            if (contains(vertex[0], vertex[1])) {
                counter++;
            }
        }

        // Return true if counter <= 2
        return (counter <= 2);
    }

    @Override
    public String toString() {
        String format
                = String.format("The bounding rectangle's center (%.2f, %.2f), width %.1f, height %.1f",
                        getX(), getY(), getWidth(), getHeight());
        return format;
    }

}
