
import java.util.Scanner;

/**
 * (Sum the major diagonal in a matrix) Write a method that sums all the numbers
 * in the major diagonal in an n * n matrix of double values using the following
 * header:
 *
 * public static double sumMajorDiagonal(double[][] m)
 *
 * Write a test program that reads a 4-by-4 matrix and displays the sum of all
 * its
 * elements on the major diagonal.
 *
 * Output:
 *
 * Enter a 4-by-4 matrix row by row:
 * 1 2 3 4.0
 * 5 6.5 7 8
 * 9 10 11 12
 * 13 14 15 16
 * Sum of the elements in the major diagonal is 34.5
 *
 * @author martinfall
 */
public class SumTheMajorDiagonal {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array
        double[][] m = new double[4][4];

        // Prompt the user to enter a 4-by-4 matrix row by row
        System.out.println("Enter a 4-by-4 matrix row by row:");

        // Populate the array
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                m[row][column] = input.nextDouble();
            }
        }

        // Display the result
        System.out.println("Sum of the elements in the major diagonal is "
                + sumMajorDiagonal(m));
    }

    /**
     * Calculate the sum of all the elements on the major diagonal of the array
     *
     * @param m
     * @return
     */
    public static double sumMajorDiagonal(double[][] m) {
        double total = 0;
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                if (row == column) {
                    total += m[row][column];
                }
            }
        }
        return total;
    }
}
