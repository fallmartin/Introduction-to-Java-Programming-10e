
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Reverse an array) The reverse method in Section 7.7 reverses an array by
 * copying it to a new array. Rewrite the method that reverses the array passed
 * in the argument and returns this array. Write a test program that prompts the
 * user to enter ten numbers, invokes the method to reverse the numbers, and
 * displays the numbers.
 *
 * @author martinfall
 */
public class ReverseAnArray {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new empty array
        int[] list = new int[10];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");

        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }
        // Reverse the list
        int[] reverseList = reverse(list);

        // Display the results
        System.out.println(Arrays.toString(reverseList));
    }

    /**
     * Reverse the array passed in the argument and returns the new array
     *
     * @param list
     * @return
     */
    public static int[] reverse(int[] list) {
        // Create a target array with the same length as the source array
        int[] result = new int[list.length];

        // Copy from source 0 to target length - 1, and adjust indices, etc.
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result; // Return the result
    }
}
