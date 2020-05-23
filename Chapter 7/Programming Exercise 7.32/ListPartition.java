
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Partition of a list) Write the following method that partitions the list
 * using the first element, called a pivot.
 *
 * public static int partition(int[] list)
 *
 * After the partition, the elements in the list are rearranged so that all the
 * elements before the pivot are less than or equal to the pivot and the
 * elements after the pivot are greater than the pivot. The method returns the
 * index where the pivot is located in the new list. For example, suppose the
 * list is {5, 2, 9, 3, 6, 8}. After the partition, the list becomes {3, 2, 5,
 * 9, 6, 8}. Implement the method in a way that takes at most list.length
 * comparisons. Write a test program that prompts the user to enter a list and
 * displays the list after the partition. Here is a sample run. Note that the
 * first number in the input indicates the number of the elements in the list.
 * This number is not part of the list.
 *
 * @author martinfall
 */
public class ListPartition {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the list
        System.out.print("Enter list: ");
        int length = input.nextInt();

        // Populate the array
        int[] list = new int[length];
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        // System.out.println(Arrays.toString(list));
        System.out.println("The pivot is now at index " + partition(list));
        System.out.println("After the partition, the list is " + Arrays.toString(list));
    }

    public static int partition(int[] list) {
        // 8 10 1 5 16 61 9 11 1
        int pivot = 0;
        int low = 1;
        int high = list.length - 1;
        
        while (low < high) {
            while (list[low] <= list[pivot]) {
                low++;
            }
            while (list[high] >= list[pivot]) {
                high--;
            }
            if (low < high) {
                int temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
        }
        
        // Swap the pivot with the element at index high
        int temp = list[pivot];
        list[pivot] = list[high];
        list[high] = temp;
        
        // Update pivot
        pivot = high;
        return pivot;
    }
}
