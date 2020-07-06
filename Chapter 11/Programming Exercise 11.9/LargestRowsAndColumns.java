
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * (Largest rows and columns) Write a program that randomly fills in 0s and 1s
 * into an n-by-n matrix, prints the matrix, and finds the rows and columns with
 * the most 1s. (Hint: Use two ArrayLists to store the row and column indices
 * with the most 1s.) Here is a sample run of the program:
 *
 * Enter the array size n: 4
 * The random array is
 * 0011
 * 0011
 * 1101
 * 1010
 * The largest row index: 2
 * The largest column index: 2, 3
 *
 * Output:
 * Enter the array size n: 5
 * The random array is
 * 0 0 1 1 0
 * 1 1 1 1 1
 * 1 0 0 0 1
 * 1 1 0 1 1
 * 0 1 1 0 0
 * The largest row index: 1
 * The largest column index: 0, 1, 2, 3, 4
 *
 * @author martinfall
 */
public class LargestRowsAndColumns {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the array size n
        System.out.print("Enter the array size n: ");

        // Create an n-by-n matrix and populate randomly with 0s and 1s.
        int n = input.nextInt();
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * 2);
            }
        }

        // Print the matrix to console.
        printMatrix(matrix);

        System.out.print("The largest row index: ");
        System.out.println(printArrayList(processList(findLargestRowIndex(matrix))));

        System.out.print("The largest column index: ");
        System.out.println(printArrayList(processList(findLargestColumnIndex(matrix))));
    }

    /**
     * Print the matrix to console.
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        System.out.println("The random array is");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Find the rows with the most 1s.
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> findLargestRowIndex(int[][] matrix) {
        // Create an ArrayList variable
        ArrayList<Integer> list = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int count = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    count++;
                }
            }
            list.add(count);
        }

        // Return ArrayList
        return list;
    }

    /**
     * Find the columns with the most 1s.
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> findLargestColumnIndex(int[][] matrix) {
        // Create an ArrayList variable
        ArrayList<Integer> list = new ArrayList<>();

        for (int column = 0; column < matrix[0].length; column++) {
            int count = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] == 1) {
                    count++;
                }
            }
            list.add(count);
        }

        // Return ArrayList
        return list;
    }

    /**
     * Build an ArrayList with indices of the max value of 1s per row/column.
     *
     * @param list
     * @return
     */
    public static ArrayList<Integer> processList(ArrayList<Integer> list) {
        // Create a new ArrayList variable
        ArrayList<Integer> indices = new ArrayList<>();
        Object[] arr = list.toArray();
        int max = Collections.max(list);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(max)) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static String printArrayList(ArrayList<Integer> list) {
        Object[] arr = list.toArray();
        String s = "";

        for (int i = 0; i < arr.length; i++) {
            s = s + ((i == arr.length - 1) ? arr[i] : arr[i] + ", ");
        }

        return s;
    }
}
