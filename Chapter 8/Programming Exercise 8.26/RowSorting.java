
import java.util.Scanner;

/**
 * (Row sorting) Implement the following method to sort the rows in a
 * two-dimensional array. A new array is returned and the original array is
 * intact.
 *
 * public static double[][] sortRows(double[][] m)
 *
 * Write a test program that prompts the user to enter a 3 * 3 matrix of double
 * values and displays a new row-sorted matrix. Here is a sample run:
 *
 * Enter a 3-by-3 matrix row by row:
 * 0.15 0.875 0.375
 * 0.55 0.005 0.225
 * 0.30 0.12 0.4
 *
 * The row-sorted array is
 * 0.15 0.375 0.875
 * 0.005 0.225 0.55
 * 0.12 0.30 0.4
 *
 * @author martinfall
 */
public class RowSorting {

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

        double[][] sortedMatrix = sortRows(matrix);
        
        printMatrix(sortedMatrix);
    }

    /**
     * Sort each row in the matrix
     *
     * @param m
     * @return
     */
    public static double[][] sortRows(double[][] m) {
        // Create a new array
        double[][] sortedM = copyArray(m);
        
        for (int row = 0; row < sortedM.length; row++) {
            // Selection sort implementation
            for (int i = 0; i < sortedM[row].length; i++) {
                // Declare minIndex
                int minIndex = i;

                // Loop through the row
                for (int j = i + 1; j < sortedM[row].length; j++) {
                    if (sortedM[row][j] < sortedM[row][minIndex]) {
                        minIndex = j;
                    }
                }
                // If a smaller value is found, swap it
                if (minIndex != i) {
                    double temp = sortedM[row][i];
                    sortedM[row][i] = sortedM[row][minIndex];
                    sortedM[row][minIndex] = temp;
                }
            }
        }
        return sortedM;
    }

    /**
     * Fill the matrix with user input and return the array
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

    /**
     * Print the matrix
     *
     * @param matrix
     */
    public static void printMatrix(double[][] matrix) {
        System.out.println("\nThe row-sorted array is");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static double[][] copyArray(double[][] m) {
        // Create a new array
        double[][] copy = new double[m.length][m[0].length];
        
        // Copy each element to the right row/column
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                copy[row][column] = m[row][column];
            }
        }
        return copy;
    }
}
