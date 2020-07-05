
import java.util.Scanner;

/**
 * Draw the UML diagrams for the classes Triangle and GeometricObject and
 * implement the classes. Write a test program that prompts the user to enter
 * three sides of the triangle, a color, and a Boolean value to indicate whether
 * the triangle is filled. The program should create a Triangle object with
 * these sides and set the color and filled properties using the input. The
 * program should display the area, perimeter, color, and true or false to
 * indicate whether it is filled or not.
 *
 * Output:
 * Enter three sides of the triangle: 1 2 3
 * Enter a color: purple
 * Is the triangle filled? false
 * Triangle: side1 = 1.0, side2 = 2.0, side3 = 3.0
 * The triangle's area is 0.0
 * The triangle's perimeter is 6.0
 * The triangle's color is purple
 * The triangle is filled? false
 *
 * @author martinfall
 */
public class TestTriangle {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three sides of the triangle
        System.out.print("Enter three sides of the triangle: ");
        Triangle t = new Triangle(input.nextDouble(), input.nextDouble(), input.nextDouble());

        // Prompt the user to enter a color
        System.out.print("Enter a color: ");
        input.nextLine();
        t.setColor(input.nextLine());

        // Prompt the user to enter a Boolean value to indicate whether 
        // the triangle is filled
        System.out.print("Is the triangle filled? ");
        t.setFilled(input.nextBoolean());

        // Display the area, perimeter, color, and true or false to indicate
        // whether it is filled or not
        System.out.println(t.toString());
        System.out.println("The triangle's area is " + t.getArea());
        System.out.println("The triangle's perimeter is " + t.getPerimeter());
        System.out.println("The triangle's color is " + t.getColor());
        System.out.println("The triangle is filled? " + t.isFilled());
    }
}
