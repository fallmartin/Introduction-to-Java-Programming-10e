
/**
 * (Algebra: solve quadratic equations) The two roots of a quadratic equation
 * ax^2 + bx + c = 0 can be obtained using the following formula:
 *
 * b^2 - 4ac is called the discriminant of the quadratic equation. If it is
 * positive, the equation has two real roots. If it is zero, the equation has one
 * root. If it is negative, the equation has no real roots. Write a program that
 * prompts the user to enter values for a, b, and c and displays the result based
 * on the discriminant. If the discriminant is positive, display two roots.
 * If the discriminant is 0, display one root. Otherwise, display “The equation
 * has no real roots”.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class SolveQuadraticEquation {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a, b, and c
        System.out.print("Enter a, b, c: ");

        // Collect input from user
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        // Calculate the discriminant b^2 - 4ac
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        // If the discriminant is positive, display two roots.
        if (discriminant > 0) {
            double r1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            double r2 = (-b - Math.sqrt(discriminant)) / 2 * a;

            // Display the results
            System.out.println("The equation has two roots "
                    + r1 + " and " + r2);
        } else if (discriminant == 0) { // If the discriminant is 0, display one root.
            double r = -b / 2 * a;
            
            // Display the results
            System.out.println("The equation has one root " + r);
        } else { // If the discriminant is negative, display "The equation has no real roots".
            System.out.println("The equation has no real roots");
        }
    }
}
