
/**
 * (Triangle class) Design a new Triangle class that extends the abstract
 * GeometricObject class. Draw the UML diagram for the classes Triangle and
 * GeometricObject and then implement the Triangle class. Write a test program
 * that prompts the user to enter three sides of the triangle, a color, and a
 * Boolean value to indicate whether the triangle is filled. The program should
 * create a Triangle object with these sides and set the color and filled
 * properties using the input. The program should display the area, perimeter,
 * color, and true or false to indicate whether it is filled or not.
 *
 * @author martinfall
 */
public class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;

    /**
     * Constructs a default object with sides equal to 1.
     */
    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    /**
     * Constructs a triangle object with side1, side2, and side3 values.
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
     * Returns side1.
     *
     * @return
     */
    public double getSide1() {
        return side1;
    }

    /**
     * Return side2.
     *
     * @return
     */
    public double getSide2() {
        return side2;
    }

    /**
     * Returns side3.
     *
     * @return
     */
    public double getSide3() {
        return side3;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    @Override
    public String toString() {
        return "Triangle{" + "side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + '}'
                + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }

}
