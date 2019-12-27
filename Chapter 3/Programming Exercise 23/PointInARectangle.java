
/**
 * Write a program that prompts the user to enter a point (x, y) and checks
 * whether the point is within the rectangle centered at (0, 0) with width 10 and
 * height 5. For example, (2, 2) is inside the rectangle and (6, 4) is outside the
 * rectangle, as shown in Figure 3.7b. (Hint: A point is in the rectangle if its
 * horizontal distance to (0, 0) is less than or equal to 10 / 2 and its vertical
 * distance to (0, 0) is less than or equal to 5.0 / 2. Test your program to cover
 * all cases.) Here are two sample runs.
 *
 * Enter a point with two coordinates: 2 2
 * Point (2.0, 2.0) is in the rectangle
 *
 * Enter a point with two coordinates: 6 4
 * Point (6.0, 4.0) is not in the rectangle
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class PointInARectangle {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a point with two coordinates
        System.out.print("Enter a point with two coordinates: ");

        // Collect input from the user
        double x = input.nextDouble();
        double y = input.nextDouble();

        // A point is in the rectangle if 
        // its horizontal distance to (0, 0) is less than or equal to 10 / 2, and 
        // its vertical distance to (0, 0) is less than or equal to 5.0 / 2.
        
        // Horizontal distance to (0, 0)
        double horizontalDistance
                = Math.sqrt(Math.pow(x, 2) + Math.pow(0, 2));

        // Vertical distance to (0, 0)
        double verticalDistance
                = Math.sqrt(Math.pow(0, 2) + Math.pow(y, 2));
        
        /* Simplified logically
        
        // Horizontal distance to (0, 0)
        double xDistance = Math.abs(x);

        // Vertical distance to (0, 0)
        double yDistance = Math.abs(y);
        */

        // Display the results
        System.out.println("Point (" + x + ", " + y + ") is"
                + ((horizontalDistance <= 10.0 / 2 && verticalDistance <= 5.0 / 2) ? " " : " not ") + "in the rectangle");
    }
}
