/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;

/**
 * LISTING 23.7 Quick Sort Algorithm
 *
 * Before Sorting
 * List contents: 2 3 2 5 6 1 -2 3 14 12
 *
 * After Sorting
 * List contents: -2 1 2 2 3 3 5 6 12 14
 *
 * @author martinfall
 */
public class QuickSort {
    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Before Sorting");
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        printList(list);

        System.out.println("\nAfter Sorting");
        quickSort(list);
        printList(list);
    }

    /**
     * Print the contents of the list to the console.
     *
     * @param list
     */
    public static void printList(int[] list) {
        System.out.print("List contents: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    /**
     * LISTING 23.7 Quick Sort Algorithm implementation.
     *
     * @param list
     * @param low
     * @param high
     */
    public static void quickSort(int[] list, int first, int last) {

        // Set the pivot index to the first element in the array
        int pivotIndex = first;

        // If we're considering valid indices
        if (last > first) {
            // Initialize the pivot, low, and high variables
            int pivot = list[first];
            int low = first + 1;
            int high = last;

            // While low is greater than or equal to high
            while (low <= high) {
                // While high is greater than low
                while (high > low) {
                    // Stop low when a value greater than pivot is found
                    while (low <= high && list[low] <= pivot) {
                        low++;
                    }

                    // Stop high when a value less than or equal to pivot is found
                    while (low <= high && list[high] > pivot) {
                        high--;
                    }

                    // If high > low, swap values at high and low
                    if (high > low) {
                        swap(list, low, high);
                    }
                }

                // while element at high index is greater than or equal to pivot
                // ??? Is this to account for repeated values?
                while (high > first && list[high] >= pivot) {
                    high--; // Decrement the high index
                }

                // Place the pivot at the correct index and update pivotIndex
                if (pivot > list[high]) {
                    swap(list, first, high);
                    pivotIndex = high;
                }
            }

            // Recursively call quickSort on the first and second halves of list
            // Not including the pivot element which is now sorted
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Swap two values in an int array.
     *
     * @param list
     * @param i
     * @param j
     */
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
