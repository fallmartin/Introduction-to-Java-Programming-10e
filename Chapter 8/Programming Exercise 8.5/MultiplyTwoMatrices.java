
import java.util.Scanner;

/**
 * (Algebra: multiply two matrices) Write a method to multiply two matrices. The
 * header of the method is:
 *
 * public static double[][] multiplyMatrix(double[][] a, double[][] b)
 *
 * To multiply matrix a by matrix b, the number of columns in a must be the same
 * as the number of rows in b, and the two matrices must have elements of the
 * same
 * or compatible types. Let c be the result of the multiplication. Assume the
 * column size of matrix a is n.
 *
 * @author martinfall
 */
public class MultiplyTwoMatrices {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Prompt the user to enter matrix 1
        System.out.print("Enter matrix1: ");
        double[][] matrix1 = populateArray();

        // Prompt the user to enter matrix 1
        System.out.print("Enter matrix2: ");
        double[][] matrix2 = populateArray();

        // Add two matrices
        double[][] sum = multiplyMatrix(matrix1, matrix2);

        // Display results
        displayResults(matrix1, matrix2, sum);
    }

    /**
     * Add two matrices
     *
     * @param a
     * @param b
     * @return
     */
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                // cij = ai1 * b1j + ai2 * b2j + ai3 * b3j.
                c[i][j]
                        = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;
    }

    /**
     * Collect input and populate the array
     *
     * @return
     */
    public static double[][] populateArray() {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array for matrix
        double[][] matrix = new double[3][3];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextDouble();
            }
        }

        return matrix;
    }

    /**
     * Display the two arrays being added and their sum
     *
     * @param a
     * @param b
     * @param sum
     */
    public static void displayResults(double[][] a, double[][] b, double[][] sum) {
        System.out.println("The matrices are added as follows");
        for (int row = 0; row < sum.length; row++) {
            System.out.print(printRow(a[row]) + "\t" + (row == 1 ? "+" : "") + "\t" + printRow(b[row]) + "\t" + (row == 1 ? "=" : "") + "\t" + printRow(sum[row]));
            System.out.println();
        }
    }

    /**
     * Print a row from a given matrix
     *
     * @param row
     * @return
     */
    public static String printRow(double[] row) {
        String str = "";
        for (int i = 0; i < row.length; i++) {
            str += (int) (row[i] * 10) / 10.0 + " ";
        }
        return str;
    }
}
