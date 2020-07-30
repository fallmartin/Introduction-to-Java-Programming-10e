
/**
 * (Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to obtain
 * imaginary roots if the determinant is less than 0 using the Complex class in
 * Programming Exercise 13.17. Here are some sample runs.
 *
 * Enter a, b, c: 1 3 1
 * The roots are -0.381966 and -2.61803
 *
 * Enter a, b, c: 1 2 1
 * The root is -1
 *
 * Enter a, b, c: 1 2 3
 * The roots are -1.0 + 1.4142i and -1.0 + -1.4142i
 *
 * @author martinfall
 */
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
        } else { // If the discriminant is negative, obtain imaginary roots
            Complex c1 = new Complex((-b / 2 * a), (Math.sqrt(Math.abs(discriminant)) / 2 * a));
            Complex c2 = new Complex((-b / 2 * a), -(Math.sqrt(Math.abs(discriminant)) / 2 * a));

            // Display the results
            System.out.println("The equation has two complex roots "
                    + c1 + " and " + c2);
        }
    }
}
