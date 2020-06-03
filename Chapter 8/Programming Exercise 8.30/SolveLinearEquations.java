
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Algebra: solve linear equations) Write a method that solves the following
 * 2 x 2 system of linear equations:
 *
 * a00x + a01y = b0
 * a10x + a11y = b1
 *
 * x = (b0a11 - b1a01) / (a00a11 - a01a10)
 * y = (b1a00 - b0a10) / (a00a11 - a01a10)
 *
 * The method header is
 *
 * public static double[] linearEquation(double[][] a, double[] b)
 *
 * The method returns null if a00a11 - a01a10 is 0. Write a test program that
 * prompts the user to enter a00, a01, a10, a11, b0, and b1, and displays the
 * result. If a00a11 - a01a10 is 0, report that “The equation has no solution.”
 * A sample run is similar to Programming Exercise 3.3.
 *
 * Output:
 * Enter a00, a01, a10, a11, b0, and b1:
 * 9.0 4.0 3.0 -5.0 -6.0 -21.0
 * x is -2.00 and y is 3.00
 *
 * @author martinfall
 */
public class SolveLinearEquations {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a00, a01, a10, a11, b0, and b1
        System.out.print("Enter a00, a01, a10, a11, b0, and b1: ");
        double[][] a = new double[2][2];
        double[] b = new double[2];

        a[0][0] = input.nextDouble();
        a[0][1] = input.nextDouble();
        a[1][0] = input.nextDouble();
        a[1][1] = input.nextDouble();

        b[0] = input.nextDouble();
        b[1] = input.nextDouble();

        // System.out.println(Arrays.toString(linearEquation(a, b)));
        double[] results = linearEquation(a, b);
        System.out.printf("x is %.2f and y is %.2f%n", results[0], results[1]);
    }

    /**
     * Solves the following 2 x 2 system of linear equations
     *
     * @param a
     * @param b
     * @return
     */
    public static double[] linearEquation(double[][] a, double[] b) {
        double a00 = a[0][0];
        double a01 = a[0][1];
        double a10 = a[1][0];
        double a11 = a[1][1];

        double b0 = b[0];
        double b1 = b[1];

        double[] solution = new double[2];

        if (a00 * a11 - a01 * a10 == 0) {
            System.out.println("The equation has no solution.");
            System.exit(0);
        } else {
            // x
            solution[0] = (b0 * a11 - b1 * a01) / (a00 * a11 - a01 * a10);

            // y
            solution[1] = (b1 * a00 - b0 * a10) / (a00 * a11 - a01 * a10);
        }
        return solution;
    }
}
