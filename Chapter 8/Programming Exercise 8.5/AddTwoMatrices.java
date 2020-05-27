
import java.util.Scanner;

/**
 * (Algebra: add two matrices) Write a method to add two matrices. The header of
 * the method is as follows:
 *
 * public static double[][] addMatrix(double[][] a, double[][] b)
 *
 * In order to be added, the two matrices must have the same dimensions and the
 * same or compatible types of elements. Let c be the resulting matrix. Each
 * element
 * cij is aij + bij. For example, for two 3 * 3 matrices a and b, c is (see
 * textbook)
 *
 * Write a test program that prompts the user to enter two 3 * 3 matrices and
 * displays their sum. Here is a sample run: (see textbook).
 *
 * @author martinfall
 */
public class AddTwoMatrices {

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
        double[][] sum = addMatrix(matrix1, matrix2);

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
    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] sum = new double[a.length][a[0].length];
        for (int row = 0; row < sum.length; row++) {
            for (int column = 0; column < sum[row].length; column++) {
                sum[row][column] = a[row][column] + b[row][column];
            }
        }
        return sum;
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
            str += row[i] + " ";
        }
        return str;
    }
}
