
/**
 * (Geometry: two rectangles) Write a program that prompts the user to enter the
 * center x-, y-coordinates, width, and height of two rectangles and determines
 * whether the second rectangle is inside the first or overlaps with the first,
 * as shown in Figure 3.9. Test your program to cover all cases.
 *
 * Here are the sample runs:
 *
 * Enter r1's center x-, y-coordinates, width, and height: 2.5 4 2.5 43
 * Enter r2's center x-, y-coordinates, width, and height: 1.5 5 0.5 3
 * r2 is inside r1
 *
 * Enter r1's center x-, y-coordinates, width, and height: 1 2 3 5.5
 * Enter r2's center x-, y-coordinates, width, and height: 3 4 4.5 5
 * r2 overlaps r1
 *
 * Enter r1's center x-, y-coordinates, width, and height: 1 2 3 3
 * Enter r2's center x-, y-coordinates, width, and height: 40 45 3 2
 * r2 does not overlap r1
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class GeometryTwoRectangles {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter r1's center x-, y-coordinates, width, and height
        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");

        // Collect input from the user
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();

        // Prompt the user to enter r1's center x-, y-coordinates, width, and height
        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");

        // Collect input from the user
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();

        input.close(); // Close this Scanner

        // Use the distance between x- and y-coordinates in relation to the 
        // width and height to determine if one rectange is inside another, if
        // the overlap, or if they do not overlap
        double xDistance = Math.abs(x1 - x2); // distance between both x
        double yDistance = Math.abs(y1 - y2); // distance between both y

        // is inside?
        if (xDistance <= Math.abs(w1 - w2) / 2
                && yDistance <= Math.abs(h1 - h2) / 2) {
            if (w1 > w2) {
                System.out.println("r2 is inside r1");
            } else if (w2 > w1) {
                System.out.println("r1 is inside r2");
            } else {
                System.out.println("r1 and r2 are identical");
            }

            // overlap?
        } else if (xDistance <= Math.abs(w1 + w2) / 2
                && yDistance <= Math.abs(h1 + h2) / 2) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 does not overlap r1");
        }
    }
}
