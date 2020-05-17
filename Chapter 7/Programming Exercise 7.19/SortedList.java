
import java.util.Scanner;


/**
 * (Sorted?) Write the following method that returns true if the list is already sorted
 * in increasing order.
 *
 * public static boolean isSorted(int[] list)
 *
 * Write a test program that prompts the user to enter a list and displays whether
 * the list is sorted or not. Here is a sample run. Note that the first number in the
 * input indicates the number of the elements in the list. This number is not part
 * of the list.
 *
 * Enter list: 8 10 1 5 16 61 9 11 1
 * The list is not sorted
 *
 * Enter list: 10 1 1 3 4 4 5 7 9 11 21
 * The list is already sorted
 *
 * @author martinfall
 */
public class SortedList {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the list
        System.out.print("Enter list: ");
        
        int n = input.nextInt(); // Array length
        
        int[] list = new int[n]; // New array
        
        // Populate the array
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }
        
        System.out.println("The list is " + (isSorted(list) ? "already" : "not") + " sorted.");
    }

    /**
     * Check if the list is already sorted in increasing order
     *
     * @param list
     * @return
     */
    public static boolean isSorted(int... list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
