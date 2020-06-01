
/**
 * (Even number of 1s) Write a program that generates a 6-by-6 two-dimensional
 * matrix filled with 0s and 1s, displays the matrix, and checks if every row
 * and every column have an even number of 1s.
 *
 * Output:
 * 1 1 0 0 0 1
 * 1 0 0 0 0 1
 * 1 1 0 0 0 1
 * 0 1 1 1 0 0
 * 1 0 1 1 1 1
 * 0 1 1 1 0 0
 * Rows with even number of 1s: 1
 * Columns with even number of 1s: 0 1 5
 *
 * 0 1 1 1 1 0
 * 0 1 0 1 0 0
 * 1 0 0 1 1 1
 * 0 0 1 1 0 0
 * 0 0 1 0 0 0
 * 1 1 1 1 0 0
 * Rows with even number of 1s: 0 1 2 3 5
 * Columns with even number of 1s: 0 2 4
 *
 * @author martinfall
 */
public class EvenNumberOfOnes {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a constant variable for the size of the square matrix
        final int SIZE = 6;

        // Create and populate the array holding the matrix
        int[][] matrix = createMatrix(SIZE);

        // Display the matrix to console
        printMatrix(matrix);

        // Check if every row and every column have an even number of 1s
        checkForEvenNumberOfOnes(matrix);
    }

    /**
     * Generate a 6-by-6 two-dimensional matrix filled with 0s and 1s
     *
     * @param SIZE
     * @return
     */
    public static int[][] createMatrix(int SIZE) {
        int[][] matrix = new int[SIZE][SIZE];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * 2);
            }
        }
        return matrix;
    }

    /**
     * Print the matrix to console
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Check if every row and every column have an even number of 1s
     *
     * @param matrix
     */
    public static void checkForEvenNumberOfOnes(int[][] matrix) {
        // Check rows
        System.out.print("Rows with even number of 1s: ");
        checkRows(matrix);
        System.out.println();

        // Check columns
        System.out.print("Columns with even number of 1s: ");
        checkColumns(matrix);
        System.out.println();
    }

    /**
     * Check what rows have an even number of 1s
     *
     * @param matrix
     */
    public static void checkRows(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int counter = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    counter++;
                }
            }
            if (counter != 0 && counter % 2 == 0) {
                System.out.print(row + " ");
            }
        }
    }

    /**
     * Check what columns have an even number of 1s
     *
     * @param matrix
     */
    public static void checkColumns(int[][] matrix) {
        for (int column = 0; column < matrix[0].length; column++) {
            int counter = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] == 1) {
                    counter++;
                }
            }
            if (counter != 0 && counter % 2 == 0) {
                System.out.print(column + " ");
            }
        }
    }

}
