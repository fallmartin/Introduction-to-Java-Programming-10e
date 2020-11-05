
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Find the largest number in an array) Write a recursive method that returns
 * the largest integer in an array. Write a test program that prompts the user
 * to enter a list of eight integers and displays the largest element.
 *
 * Output:
 * Enter a list of eight integers: 2 3 1 6 4 8 9 1
 * The largest element is 9
 *
 * @author martinfall
 */
public class LargestNumberIntArray {

    /**
     * Returns the largest integer in an array.
     *
     * @param list
     * @return
     */
    public static int findLargest(int[] list) {
        return findLargest(list, list[0], 0); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameter i.
     *
     * @param list
     * @param largest
     * @param index
     * @return
     */
    public static int findLargest(int[] list, int largest, int index) {
        if (index == list.length) { // Base case
            return largest;
        } else {
            // Compare the element at index to largest
            if (list[index] > largest) {
                largest = list[index];
            }
            // Recursive call
            return findLargest(list, largest, index + 1);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an array of integers with eight elements
        int[] list = new int[8];

        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a list of eight integers: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        // Close the scanner
        input.close();

        // Display the results
        System.out.println("The largest element is " + findLargest(list));
    }
}
