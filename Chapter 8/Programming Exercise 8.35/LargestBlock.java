
import java.util.Scanner;

/**
 * (Largest block) Given a square matrix with the elements 0 or 1, write a
 * program to find a maximum square submatrix whose elements are all 1s. Your
 * program should prompt the user to enter the number of rows in the matrix. The
 * program then displays the location of the first element in the maximum square
 * submatrix and the number of the rows in the submatrix. Here is a sample run:
 *
 * Enter the number of rows in the matrix: 5
 * Enter the matrix row by row:
 * 1 0 1 0 1
 * 1 1 1 0 1
 * 1 0 1 1 1
 * 1 0 1 1 1
 * 1 0 1 1 1
 * The maximum square submatrix is at (2, 2) with size 3
 *
 * Your program should implement and use the following method to find the
 * maximum square submatrix:
 *
 * public static int[] findLargestBlock(int[][] m)
 *
 * The return value is an array that consists of three values. The first two
 * values are the row and column indices for the first element in the submatrix,
 * and the third value is the number of the rows in the submatrix.
 *
 * @author martinfall
 */
public class LargestBlock {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array and populate it with user input
        int[][] matrix = getInput(input);

        // Display the results in the specified format
        int[] point = findLargestBlock(matrix);
        String format = "The maximum square submatrix is at (%d, %d) with size %d%n";
        System.out.printf(format, point[0], point[1], point[2]);
    }

    /**
     * Collect input from user and store it into a returned array
     *
     * @param input
     * @return
     */
    public static int[][] getInput(Scanner input) {
        // Prompt the user to enter the number of rows in the matrix
        System.out.print("Enter the number of rows in the matrix: ");
        int size = input.nextInt();

        // Create an array
        int[][] m = new int[size][size];

        // Prompt the user to enter the matrix row by row
        System.out.println("Enter the matrix row by row: ");
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                m[row][column] = input.nextInt();
            }
        }
        // Return the array
        return m;
    }

    /**
     * Find a maximum square submatrix whose elements are all 1s
     *
     * @param m
     * @return
     */
    public static int[] findLargestBlock(int[][] m) {
        // Local variable and return variable for findLargestBlock method
        int size = 0;
        int[] point = new int[3];

        // Create an array to hold number of times the value 1 repeats in a row
        int[][] arr = new int[m.length][m[0].length];

        // Process the matrix and populate the new array arr
        for (int row = 0; row < m.length; row++) {
            size = 0;
            for (int column = 0; column < m[row].length; column++) {
                if (m[row][column] == 1) {
                    size++;
                    if (size > 1) {
                        arr[row][column] = size;
                    }
                } else {
                    // Record current starting point and size on row
                    size = 0;
                }
                // System.out.print(size + " ");
            }
            // System.out.println();
        }

        // Print the new matrix to screen
        // displayArray(arr);

        // Check if the value n is repeated n times in the same column
        // n represents any value in the arr matrix that is greater than 1
        // If n = 2, and it is repeated 2 times, then we have a square of size 2
        // If n = 3, and it is repeated 3 times, then we have a square of size 2
        // Return the largest square
        // Loop through each element of the array
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                // If the element is greater than 1
                if (arr[row][column] > 1
                        && isSquareMatrix(row, column, arr)
                        && point[2] < arr[row][column]) {
                    point[0] = row;
                    point[1] = column - arr[row][column] + 1;
                    point[2] = arr[row][column];
                    // System.out.println("Got one: " + arr[row][column]);
                    // System.out.println(isSquareMatrix(row, column, arr));;
                }
            }
        }

        return point;
    }

    /**
     * Print the array to console
     *
     * @param m
     */
    public static void displayArray(int[][] m) {
        System.out.println();

        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                System.out.print(m[row][column] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Check if the value of arr at row/column is matched below n - 1 times
     *
     * @param row
     * @param column
     * @param arr
     * @return
     */
    public static boolean isSquareMatrix(int row, int column, int[][] arr) {
        if (row + arr[row][column] > arr.length) {
            // If there is no spacial possibility for the square matrix
            return false; // return false
        } else {
            // Otherwise, if the values don't match below, return false
            for (int i = row; i < row + arr[row][column]
                    && row + arr[row][column] <= arr.length; i++) {
                // System.out.println(arr[i][column]);
                if (arr[row][column] != arr[i][column]) {
                    return false;
                }
            }
        }
        // If all the value match n - 1 times, return true
        return true;
    }
}
