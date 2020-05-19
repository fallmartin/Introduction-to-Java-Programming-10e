
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Revise selection sort) In Section 7.11, you used selection sort to sort an
 * array. The selection-sort method repeatedly finds the smallest number in the
 * current array and swaps it with the first. Rewrite this program by finding
 * the largest number and swapping it with the last. Write a test program that
 * reads in ten double numbers, invokes the method, and displays the sorted
 * numbers.
 *
 * Output: Enter ten numbers: 9 5 3 8 1 0 4 2 7 6 
 * [9, 5, 3, 8, 1, 0, 4, 2, 7, 6]
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 * @author martinfall
 */
public class RevisedSelectionSort {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array
        int[] list = new int[10];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        // Print the array of int collected from user
        System.out.println(Arrays.toString(list));

        // Sort the array
        revisedSelectionSort(list);

        // Display the sorted array
        System.out.println(Arrays.toString(list));

    }

    /**
     * Selection sort implemented to find the largest number and swap it with
     * the last
     *
     * @param list
     */
    public static void revisedSelectionSort(int[] list) {
        for (int i = list.length - 1; i >= 1; i--) {
            int maxIndex = i;

            for (int j = i - 1; j >= 0; j--) {
                if (list[j] > list[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = list[maxIndex];
                list[maxIndex] = list[i];
                list[i] = temp;
            }
        }
    }
}
