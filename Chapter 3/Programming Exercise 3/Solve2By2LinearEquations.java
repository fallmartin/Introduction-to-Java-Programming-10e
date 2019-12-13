
/**
 * (Algebra: solve 2 * 2 linear equations) A linear equation can be solved using
 * Cramer’s rule given in Programming Exercise 1.13. Write a program that prompts
 * the user to enter a, b, c, d, e, and f and displays the result.
 *
 * If a * d - b * c is 0, report that “The equation has no solution.”
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class Solve2By2LinearEquations {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a, b, c, d, e, and f
        System.out.print("Enter a, b, c, d, e, f: ");

        // Collect input from user
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        // Calculate denominator
        double denominator = a * d - b * c;

        // If a * d - b * c is 0, report that "The equation has no solution."
        if (denominator == 0) {
            System.out.println("The equation has no solution.");
        } else {
            double x = (e * d - b * f) / denominator;
            double y = (a * f - e * c) / denominator;
            System.out.println("x is " + x + " and y is " + y);
        }
    }
}
