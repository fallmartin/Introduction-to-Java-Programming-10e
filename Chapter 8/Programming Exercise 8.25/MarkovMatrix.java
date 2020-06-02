
import java.util.Scanner;

/**
 * (Markov matrix) An n * n matrix is called a positive Markov matrix if each
 * element is positive and the sum of the elements in each column is 1. Write
 * the following method to check whether a matrix is a Markov matrix.
 *
 * public static boolean isMarkovMatrix(double[][] m)
 *
 * Write a test program that prompts the user to enter a 3 * 3 matrix of double
 * values and tests whether it is a Markov matrix. Here are sample runs:
 *
 * Enter a 3-by-3 matrix row by row:
 * 0.15 0.875 0.375
 * 0.55 0.005 0.225
 * 0.30 0.12 0.4
 * It is a Markov matrix
 *
 * Enter a 3-by-3 matrix row by row:
 * 0.95 -0.875 0.375
 * 0.65 0.005 0.225
 * 0.30 0.22 -0.4
 * It is not a Markov matrix
 *
 * @author martinfall
 */
public class MarkovMatrix {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new constant variable
        final int SIZE = 3;

        // Create a new array
        double[][] matrix = getInput(input, SIZE);
        
        // Display the results
        System.out.println("It is " + (isMarkovMatrix(matrix) ? "" : "not ") + "a Markov matrix");

    }

    /**
     * Check whether a matrix is a Markov matrix
     *
     * @param m
     * @return
     */
    public static boolean isMarkovMatrix(double[][] m) {
        return isPositive(m) && sumColumnIsOne(m);
    }

    /**
     * Check if the elements are all positive
     *
     * @param m
     * @return
     */
    public static boolean isPositive(double[][] m) {
        // Check if each element is positive
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                if (m[row][column] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the sum of each column of the matrix is equal to 1
     *
     * @param m
     * @return
     */
    public static boolean sumColumnIsOne(double[][] m) {
        for (int column = 0; column < m[0].length; column++) {
            double sum = 0;
            for (int row = 0; row < m.length; row++) {
                sum += m[row][column];
            }
            if (sum != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Collect user input for the matrix
     *
     * @param input
     * @param SIZE
     * @return
     */
    public static double[][] getInput(Scanner input, int SIZE) {
        // Create a new array
        double[][] matrix = new double[SIZE][SIZE];

        System.out.printf("Enter a %d-by-%d matrix row by row:%n", SIZE, SIZE);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextDouble();
            }
        }

        return matrix;
    }
}
