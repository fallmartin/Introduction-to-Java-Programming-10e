
import java.util.Scanner;

/**
 * (Column sorting) Implement the following method to sort the columns in a
 * two-dimensional array. A new array is returned and the original array is
 * intact.
 *
 * public static double[][] sortColumns(double[][] m)
 *
 * Write a test program that prompts the user to enter a 3 * 3 matrix of double
 * values and displays a new column-sorted matrix. Here is a sample run:
 *
 * Enter a 3-by-3 matrix row by row:
 * 0.15 0.875 0.375
 * 0.55 0.005 0.225
 * 0.30 0.12 0.4
 *
 * The column-sorted array is
 * 0.15 0.0050 0.225
 * 0.3 0.12 0.375
 * 0.55 0.875 0.4
 *
 * @author martinfall
 */
public class ColumnSorting {

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

        double[][] sortedMatrix = sortColumns(matrix);

        printMatrix(sortedMatrix);
    }

    /**
     * Create an array and fill it with user input
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
     * Sort the columns of the array
     *
     * @param m
     * @return
     */
    public static double[][] sortColumns(double[][] m) {
        // Create a new array
        double[][] sortedM = copyArray(m);

        for (int column = 0; column < sortedM.length; column++) {
            // Selection sort implementation
            for (int i = 0; i < sortedM[column].length; i++) {
                // Declare minIndex
                int minIndex = i;

                // Loop through the column
                for (int j = i + 1; j < sortedM[column].length; j++) {
                    if (sortedM[j][column] < sortedM[minIndex][column]) {
                        minIndex = j;
                    }
                }
                // If a smaller value is found, swap it
                if (minIndex != i) {
                    double temp = sortedM[i][column];
                    sortedM[i][column] = sortedM[minIndex][column];
                    sortedM[minIndex][column] = temp;
                }
            }
        }
        return sortedM;
    }

    /**
     * Print the matrix to the console
     *
     * @param matrix
     */
    public static void printMatrix(double[][] matrix) {
        System.out.println("\nThe column-sorted array is");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Copy array m to preserve it as required by the program specifications
     *
     * @param m
     * @return
     */
    public static double[][] copyArray(double[][] m) {
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
