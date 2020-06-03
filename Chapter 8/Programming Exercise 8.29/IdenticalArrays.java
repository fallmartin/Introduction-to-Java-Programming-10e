
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Identical arrays) The two-dimensional arrays m1 and m2 are identical if they
 * have the same contents. Write a method that returns true if m1 and m2 are
 * identical, using the following header:
 *
 * public static boolean equals(int[][] m1, int[][] m2)
 *
 * Write a test program that prompts the user to enter two 3 * 3 arrays of
 * integers and displays whether the two are identical. Here are the sample runs.
 *
 * Enter list1: 51 25 22 6 1 4 24 54 6
 * Enter list2: 51 22 25 6 1 4 24 54 6
 * The two arrays are identical
 *
 * Enter list1: 51 5 22 6 1 4 24 54 6
 * Enter list2: 51 22 25 6 1 4 24 54 6
 * The two arrays are not identical
 *
 * @author martinfall
 */
public class IdenticalArrays {

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
                + (equals(list1, list2) ? "" : "not ") + "identical");
        
        // Uncomment to test that both original arrays remain unchanged
        // System.out.println(Arrays.deepToString(list1));
        // System.out.println(Arrays.deepToString(list2));
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

        // Sort each one of the two-dimensional arrays
        int[][] m1Sorted = sort(m1);
        int[][] m2Sorted = sort(m2);

        // Compare the elements of each array to each other after sorting
        for (int row = 0; row < m1Sorted.length; row++) {
            for (int column = 0; column < m1Sorted[row].length; column++) {
                if (m1Sorted[row][column] != m2Sorted[row][column]) {
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

    /**
     * Sort a two-dimensional array
     *
     * @param m
     * @return
     */
    public static int[][] sort(int[][] m) {
        // Create a one-dimensional array
        int[] array = new int[m.length * m[0].length];
        // Incrementor
        int i = 0;

        // Copy two-dimensional array to the one-dimensional array
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                array[i] = m[row][column];
                i++;
            }
        }

        // System.out.println(Arrays.toString(array));
        // Bubble sort
        for (int j = 0; j < array.length - 1; j++) {
            for (int k = 0; k < array.length - 1 - j; k++) {
                if (array[k] > array[k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }

        // System.out.println(Arrays.toString(array));
        // Convert the one-dimensional array back to a sorted two-dimensional array
        int[][] sortedM = new int[m.length][m[0].length];
        i = 0;
        for (int row = 0; row < sortedM.length; row++) {
            for (int column = 0; column < sortedM[row].length; column++) {
                sortedM[row][column] = array[i];
                i++;
            }
        }

        // System.out.println(Arrays.deepToString(m));
        // Return the sorted two-dimensional array
        return sortedM;
    }
}
