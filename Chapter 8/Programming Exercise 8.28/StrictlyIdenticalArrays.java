
import java.util.Scanner;

/**
 * (Strictly identical arrays) The two-dimensional arrays m1 and m2 are strictly
 * identical if their corresponding elements are equal. Write a method that
 * returns true if m1 and m2 are strictly identical, using the following header:
 *
 * public static boolean equals(int[][] m1, int[][] m2)
 *
 * Write a test program that prompts the user to enter two 3 * 3 arrays of
 * integers and displays whether the two are strictly identical. Here are the
 * sample runs.
 *
 * Enter list1: 51 22 25 6 1 4 24 54 6
 * Enter list2: 51 22 25 6 1 4 24 54 6
 * The two arrays are strictly identical
 *
 * Enter list1: 51 25 22 6 1 4 24 54 6
 * Enter list2: 51 22 25 6 1 4 24 54 6
 * The two arrays are not strictly identical
 *
 * @author martinfall
 */
public class StrictlyIdenticalArrays {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter list1 and list2
        System.out.print("Enter list1: ");
        int[][] list1 = getInput(input);

        System.out.print("Enter list2: ");
        int[][] list2 = getInput(input);

        // Display the results
        System.out.println("The two arrays are "
                + (equals(list1, list2) ? "" : "not ") + "strictly identical");
    }

    /**
     * Check if m1 and m2 are strictly identical
     *
     * @param m1
     * @param m2
     * @return
     */
    public static boolean equals(int[][] m1, int[][] m2) {
        // Not checking for array length 
        // Easily implemented by comparing the lengths of both arrays

        for (int row = 0; row < m1.length; row++) {
            for (int column = 0; column < m1[row].length; column++) {
                if (m1[row][column] != m2[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Collect user input and populate the array
     *
     * @param input
     * @return
     */
    public static int[][] getInput(Scanner input) {
        // Create a new array
        int[][] array = new int[3][3];

        // Populate array with user input
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = input.nextInt();
            }
        }
        // Return the array to the caller method
        return array;
    }
}
