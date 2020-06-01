
import java.util.Scanner;

/**
 * (Game: find the flipped cell) Suppose you are given a 6-by-6 matrix filled
 * with
 * 0s and 1s. All rows and all columns have an even number of 1s. Let the user
 * flip one cell (i.e., flip from 1 to 0 or from 0 to 1) and write a program to
 * find which cell was flipped. Your program should prompt the user to enter a
 * 6-by-6 array with 0s and 1s and find the first row r and first column c where
 * the even number of the 1s property is violated (i.e., the number of 1s is not
 * even). The flipped cell is at (r, c). Here is a sample run:
 *
 * Enter a 6-by-6 matrix row by row:
 * 1 1 1 0 1 1
 * 1 1 1 1 0 0
 * 0 1 0 1 1 1
 * 1 1 1 1 1 1
 * 0 1 1 1 1 0
 * 1 0 0 0 0 1
 * The flipped cell is at (0, 1)
 *
 * @author martinfall
 */
public class FindTheFlippedCellGame {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Constant variable for matrix size
        final int SIZE = 6;

        // Prompt the user to ener a 6-by-6 matrix row by row
        System.out.println("Enter a 6-by-6 matrix row by row: ");
        int[][] matrix = createMatrix(SIZE);

        // Print the matrix to console
        System.out.println();
        printMatrix(matrix);

        findFlippedCell(matrix);
    }

    /**
     * Find the flipped cell
     *
     * @param matrix
     */
    public static void findFlippedCell(int[][] matrix) {
        int foundRow = -1;
        int foundColumn = -1;

        for (int row = 0; row < matrix.length; row++) {
            int counter = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    counter++;
                }
            }
            if (counter != 0 && counter % 2 != 0) {
                foundRow = row;
            }
        }

        for (int column = 0; column < matrix[0].length; column++) {
            int counter = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] == 1) {
                    counter++;
                }
            }
            if (counter != 0 && counter % 2 != 0) {
                foundColumn = column;
            }
        }
        System.out.printf("The flipped cell is at (%d, %d)", foundRow, foundColumn);
    }

    /**
     * Create and populate a 6-by-6 array with 0s and 1s
     *
     * @param SIZE
     * @return
     */
    public static int[][] createMatrix(int SIZE) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new matrix
        int[][] matrix = new int[SIZE][SIZE];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextInt();
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

}
