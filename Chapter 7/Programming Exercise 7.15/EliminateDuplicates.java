
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Eliminate duplicates) Write a method that returns a new array by
 * eliminating the duplicate values in the array using the following method
 * header:
 *
 * public static int[] eliminateDuplicates(int[] list)
 *
 * Write a test program that reads in ten integers, invokes the method, and
 * displays the result. Here is the sample run of the program:
 *
 * Enter ten numbers: 1 2 3 2 1 6 3 4 5 2 
 * The distinct numbers are 1 2 3 6 4 5
 *
 * @author martinfall
 */
public class EliminateDuplicates {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Constant variable
        final int NUMBER_OF_INTEGERS = 10;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // New int array
        int[] list = new int[NUMBER_OF_INTEGERS];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        // Process the array
        int[] result = eliminateDuplicates(list);

        System.out.print("The distinct numbers are ");
        printArray(result);
    }

    /**
     * Eliminate the duplicate values in the array and return it
     *
     * @param list
     * @return
     */
    public static int[] eliminateDuplicates(int[] list) {
        boolean flag;

        // New int array
        int[] result = new int[list.length];

        // Remove duplicates
        for (int i = 0; i < list.length; i++) { // Pick a number from list
            flag = true; // Assume it is not is result
            for (int j = 0; j < result.length; j++) { // Compare to elements in result
                if (list[i] == result[j]) {
                    flag = false; // If found, set flag to false
                }
            }
            if (flag) { // If flag is still true after comparisons, update result
                result[i] = list[i];
            }
        }
        return result; // Return result
    }

    /**
     * Print array
     *
     * @param list
     */
    public static void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                System.out.print(list[i] + " ");
            }
        }
    }
}
