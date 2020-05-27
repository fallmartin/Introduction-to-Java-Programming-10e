
import java.util.Scanner;

/**
 * (Sum elements column by column) Write a method that returns the sum of all
 * the elements in a specified column in a matrix using the following header:
 *
 * public static double sumColumn(double[][] m, int columnIndex)
 *
 * Write a test program that reads a 3-by-4 matrix and displays the sum of each
 * column.
 *
 * Output:
 *
 * Enter a 3-by-4 matrix row by row:
 * 1.5 2 3 4
 * 5.5 6 7 8
 * 9.5 1 3 1
 * Sum of the elements at column 0 is 16.5
 * Sum of the elements at column 0 is 9.0
 * Sum of the elements at column 0 is 13.0
 * Sum of the elements at column 0 is 13.0
 *
 * @author martinfall
 */
public class SumElementsColumnByColumn {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new 3-by-4 matrix
        double[][] m = new double[3][4];

        // Prompt the user to enter a 3-by-4 matrix row by row
        System.out.println("Enter a 3-by-4 matrix row by row:");
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                m[row][column] = input.nextDouble();
            }
        }

        // Display results
        System.out.println("Sum of the elements at column 0 is " + sumColumn(m, 0));
        System.out.println("Sum of the elements at column 0 is " + sumColumn(m, 1));
        System.out.println("Sum of the elements at column 0 is " + sumColumn(m, 2));
        System.out.println("Sum of the elements at column 0 is " + sumColumn(m, 3));
    }

    public static double sumColumn(double[][] m, int columnIndex) {
        double columnTotal = 0;
        for (int row = 0; row < m.length; row++) {
            columnTotal += m[row][columnIndex];
        }
        return columnTotal;
    }
}
