
/**
 * (The Triangle class) Design a class named Triangle that extends
 * GeometricObject. The class contains:
 *
 * ■ Three double data fields named side1, side2, and side3 with default
 * values 1.0 to denote three sides of the triangle.
 * ■ A no-arg constructor that creates a default triangle.
 * ■ A constructor that creates a triangle with the specified side1, side2, and
 * side3.
 * ■ The accessor methods for all three data fields.
 * ■ A method named getArea() that returns the area of this triangle.
 * ■ A method named getPerimeter() that returns the perimeter of this triangle.
 * ■ A method named toString() that returns a string description for the triangle.
 *
 * For the formula to compute the area of a triangle, see Programming Exercise 2.19.
 * The toString() method is implemented as follows:
 *
 * return "Triangle: side1 = " + side1 + " side2 = " + side2 +
 * " side3 = " + side3;
 *
 * Draw the UML diagrams for the classes Triangle and GeometricObject and
 * implement the classes. Write a test program that prompts the user to enter
 * three sides of the triangle, a color, and a Boolean value to indicate whether
 * the triangle is filled. The program should create a Triangle object with these
 * sides and set the color and filled properties using the input. The program
 * should display the area, perimeter, color, and true or false to indicate
 * whether it is filled or not.
 *
 * @author martinfall
 */
public class Triangle extends GeometricObject {

    // Three double data fields named side1, side2, and side3 with default
    // values 1.0 to denote three sides of the triangle.
    private double side1, side2, side3;

    /**
     * A no-arg constructor that creates a default triangle.
     */
    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    /**
     * A constructor that creates a triangle with the specified side1, side2,
     * and side3.
     *
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * The accessor methods for private data field side1.
     *
     * @return
     */
    public double getSide1() {
        return side1;
    }

    /**
     * The accessor methods for private data field side2.
     *
     * @return
     */
    public double getSide2() {
        return side2;
    }

    /**
     * The accessor methods for private data field side3.
     *
     * @return
     */
    public double getSide3() {
        return side3;
    }

    /**
     * A method named getArea() that returns the area of this triangle.
     *
     * @return
     */
    public double getArea() {
        // Calculate s
        double s = (side1 + side2 + side3) / 2;

        // Calculate the area of the triangle
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * A method named getPerimeter() that returns the perimeter of this
     * triangle.
     *
     * @return
     */
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1
                + ", side2 = " + side2
                + ", side3 = " + side3;
    }

}
