
import java.util.Scanner;

/**
 * (Merge two sorted lists) Write the following method that merges two sorted
 * lists into a new sorted list.
 *
 * public static int[] merge(int[] list1, int[] list2)
 *
 * Implement the method in a way that takes at most list1.length + list2.length
 * comparisons. Write a test program that prompts the user to enter two sorted
 * lists and displays the merged list. Here is a sample run. Note that the first
 * number in the input indicates the number of the elements in the list. This
 * number is not part of the list.
 *
 * Enter list1: 5 1 5 16 61 111 
 * Enter list2: 4 2 4 5 6 
 * The merged list is 1 2 4 5 5 6 16 61 111
 *
 * @author martinfall
 */
public class MergeTwoSortedLists {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter list1
        System.out.print("Enter list1: ");
        int length1 = input.nextInt();

        // Populate list1 array
        int[] list1 = new int[length1];
        for (int i = 0; i < length1; i++) {
            list1[i] = input.nextInt();
        }

        // Prompt the user to enter list2
        System.out.print("Enter list2: ");
        int length2 = input.nextInt();

        // Populate list1 array
        int[] list2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            list2[i] = input.nextInt();
        }

        // Display results
        displayResults(merge(list1, list2));
    }

    /**
     * Merge list1 and list2 before sorting them using the System.arraycopy
     * method
     *
     *
     * @param list1
     * @param list2
     * @return
     */
    public static int[] merge(int[] list1, int[] list2) {
        int[] list = new int[list1.length + list2.length];

        // Copy list1 and list2 into list
        System.arraycopy(list1, 0, list, 0, list1.length);
        System.arraycopy(list2, 0, list, list1.length, list2.length);

        return selectionSort(list);
    }

    /**
     * Selection sort for the merged array
     *
     * @param list
     * @return
     */
    public static int[] selectionSort(int[] list) {
        // Implement a selection sort that takes at most
        // list1.length + list2.length comparisons
        for (int i = 0; i < list.length - 1; i++) {
            // int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[currentMinIndex] > list[j]) {
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                int temp = list[currentMinIndex];
                list[currentMinIndex] = list[i];
                list[i] = temp;
            }
        }
        return list;
    }

    public static void displayResults(int[] list) {
        System.out.print("The merged list is ");
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println(); // For format
    }
}
