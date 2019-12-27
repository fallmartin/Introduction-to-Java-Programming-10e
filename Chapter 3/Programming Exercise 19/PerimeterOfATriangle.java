
/**
 * (Compute the perimeter of a triangle) Write a program that reads three edges
 * for a triangle and computes the perimeter if the input is valid. Otherwise,
 * display that the input is invalid. The input is valid if the sum of every pair
 * of two edges is greater than the remaining edge.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class PerimeterOfATriangle {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user three edges from a triangle
        System.out.print("Enter three edges for a triangle: ");

        // Collect three edges from the user
        double edge1 = input.nextDouble();
        double edge2 = input.nextDouble();
        double edge3 = input.nextDouble();

        if ((edge1 + edge2 > edge3)
                && (edge2 + edge3 > edge1)
                && (edge3 + edge1 > edge2)) {
            System.out.println("The input is valid.");
            System.out.println("The perimeter is " + (edge1 + edge2 + edge3));
        } else {
            System.out.println("The input is invalid");
        }
    }
}
