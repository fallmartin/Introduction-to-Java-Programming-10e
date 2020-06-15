
/**
 * (The Rectangle class) Following the example of the Circle class in Section 9.2,
 * design a class named Rectangle to represent a rectangle. The class contains:
 *
 * ■ Two double data fields named width and height that specify the width and
 * height of the rectangle. The default values are 1 for both width and height.
 * ■ A no-arg constructor that creates a default rectangle.
 * ■ A constructor that creates a rectangle with the specified width and height.
 * ■ A method named getArea() that returns the area of this rectangle.
 * ■ A method named getPerimeter() that returns the perimeter.
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that creates two Rectangle objects—one with width 4 and height 40
 * and the other with width 3.5 and height 35.9. Display the width, height, area,
 * and perimeter of each rectangle in this order.
 *
 * Output:
 * Rectangle 1
 * width: 4.0
 * height: 40.0
 * area: 160.0
 * perimeter: 88.0
 *
 * Rectangle 2
 * width: 3.5
 * height: 35.9
 * area: 125.64999999999999
 * perimeter: 78.8
 *
 * @author martinfall
 */
public class Rectangle {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        // Display the width, height, area, and perimeter of each rectangle
        System.out.println("Rectangle 1");
        System.out.println(rectangle1.toString());
        System.out.println();
        System.out.println("Rectangle 2");
        System.out.println(rectangle2.toString());
    }

    // Private data fields for height and width of a rectangle object
    // The default values are 1 for both width and height.
    private double width;
    private double height;

    // A no-arg constructor that creates a default rectangle.
    public Rectangle() {
        this(1.0, 1.0);
    }

    // A constructor that creates a rectangle with the specified width and height.
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // A method named getArea() that returns the area of this rectangle.
    public double getArea() {
        return this.width * this.height;
    }

    // A method named getPerimeter() that returns the perimeter.
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    // Getters & setters
    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "width: " + width
                + "\nheight: " + height
                + "\narea: " + getArea()
                + "\nperimeter: " + getPerimeter();
    }

}
