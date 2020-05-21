
import java.util.Scanner;

/**
 * (Algebra: solve quadratic equations) Write a method for solving a quadratic
 * equation using the following header:
 *
 * public static int solveQuadratic(double[] eqn, double[] roots)
 *
 * The coefficients of a quadratic equation ax^2 + bx + c = 0 are passed to the
 * array eqn and the real roots are stored in roots. The method returns the
 * number of real roots. See Programming Exercise 3.1 on how to solve a
 * quadratic equation. Write a program that prompts the user to enter values for
 * a, b, and c and displays the number of real roots and all real roots.
 *
 * @author martinfall
 */
public class QuadraticEquations {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        double[] eqn = new double[3];
        double[] roots = new double[2];

        // Prompt the user to enter values for a, b, and c
        System.out.print("Enter values for a, b, and c: ");
        for (int i = 0; i < eqn.length; i++) {
            eqn[i] = input.nextDouble();
        }

        // Display the number of roots
        System.out.println(solveQuadratic(eqn, roots));

        // Display the roots
        System.out.print("The roots are: ");
        for (double root : roots) {
            if (root != 0) {
                System.out.print(root + " ");
            }
        }
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {
        double a = eqn[0];
        double b = eqn[1];
        double c = eqn[2];

        // Calculate the discriminant b^2 - 4ac
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) { // If the discriminant is positive, display two roots
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {// If the discriminant is 0, display one root
            roots[0] = -b / 2 * a;
        }

        return countRoots(roots);
    }

    public static int countRoots(double[] roots) {
        int count = 0;
        for (double root : roots) {
            if (root != 0) {
                count++;
            }
        }
        return count;
    }
}
