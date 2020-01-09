
/**
 * Write a program that prompts the user to enter the length from the center of a
 * pentagon to a vertex and computes the area of the pentagon, as shown in the
 * following figure.
 *
 * The formula for computing the area of a pentagon is
 * Area = 5 * s^2 / 4 * tan(pi / 5), where s is the length of a side. The side can
 * be computed using the formula s = 2r sin (pi / 5), where r is the length from
 * the center of a pentagon to a vertex. Round up two digits after the decimal
 * point. Here is a sample run:
 *
 * Enter the length from the center to a vertex: 5.5
 * The area of the pentagon is 71.92
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class GeometryAreaOfAPentagon {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the length from the center to a vertex
        System.out.print("Enter the length from the center to a vertex: ");
        // Collect input from the user and store in variable r
        double r = input.nextDouble();
        
        // Calculate side
        double side = 2 * r * Math.sin(Math.PI / 5);
        
        // Calculate area
        double area = (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));
        
        // Display the results
        System.out.printf("The area of the pentagon is %5.2f", area);
    }
}
