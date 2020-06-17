
import java.util.Scanner;

/**
 * Write a test program that prompts the user to enter a, b, c, d, e, and f and
 * displays the result. If ad - bc is 0, report that “The equation has no
 * solution.” See Programming Exercise 3.3 for sample runs.
 *
 * Output:
 * Enter a, b, c, d, e, and f: 9.0 4.0 3.0 -5.0 -6.0 -21.0
 * x is -2.0 and y is 3.0
 *
 * Enter a, b, c, d, e, and f: 1.0 2.0 2.0 4.0 4.0 5.0
 * The equation has no solution.
 *
 * @author martinfall
 */
public class TestLinearEquation {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a, b, c, d, e, f
        System.out.print("Enter a, b, c, d, e, and f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        // Create a new LinearEquation object
        LinearEquation le = new LinearEquation(a, b, c, d, e, f);

        // Display the result
        if (le.isSolvable()) {
            System.out.println("x is " + le.getX() + " and y is " + le.getY());
        } else {
            System.out.println("The equation has no solution.");
        }
    }
}
