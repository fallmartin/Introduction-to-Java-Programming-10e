
import java.util.Scanner;

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
 * Output:
 * Enter three sides of the triangle: 2 4 3
 * Enter a color: pink
 * Is the triangle filled? (true / false) true
 *
 * Area: 2.9047375096555625
 * Perimeter: 9.0
 * Color: pink
 * Is filled? true
 *
 * @author martinfall
 */
public class TestTriangle {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three sides of the triangle
        System.out.print("Enter three sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        // Prompt the user to enter a color
        System.out.print("Enter a color: ");
        input.nextLine();
        String color = input.nextLine();

        // Prompt the user to enter a a Boolean value to indicate whether the 
        // triangle is filled
        System.out.print("Is the triangle filled? (true / false) ");
        boolean filled = input.nextBoolean();

        // Create a Triangle object with these sides
        Triangle t = new Triangle(side1, side2, side3);

        // Set the color and filled properties using the input
        t.setColor(color);
        t.setFilled(filled);

        // Display the area, perimeter, color, and true or false to indicate 
        // whether it is filled or not
        System.out.println();
        System.out.println("Area: " + t.getArea());
        System.out.println("Perimeter: " + t.getPerimeter());
        System.out.println("Color: " + t.getColor());
        System.out.println("Is filled? " + t.isFilled());
    }
}
