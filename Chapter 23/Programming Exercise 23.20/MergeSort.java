package mergesort;

import java.util.Arrays;

/**
 * (Modify merge sort) Rewrite the mergeSort method to recursively sort the
 * first half of the array and the second half of the array without creating new
 * temporary arrays, and then merge the two into a temporary array and copy its
 * contents to the original array, as shown in Figure 23.6b.
 *
 * Output: -2 1 2 2 3 3 5 6 12 14
 *
 * @author martinfall
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        // mergeSort(list);
        recursiveMergeSort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
            if (i == list.length - 1) {
                System.out.println();
            }
        }
    }

    /**
     * The method for sorting the numbers recursively.
     *
     * @param list
     */
    public static void recursiveMergeSort(int[] list) {
        helper(list, 0, list.length - 1);
    }

    public static void helper(int[] list, int low, int high) {
        if (high - low > 0) {
            int mid = low + (high - low) / 2;

            helper(list, low, mid);
            helper(list, mid + 1, high);

            recursiveMerge(list, low, mid, high);
        }
    }

    /**
     * Merge two sorted lists without temporary arrays.
     *
     * @param list
     * @param low
     * @param mid
     * @param high
     */
    public static void recursiveMerge(int[] list, int low, int mid, int high) {
        int current1 = low; // Current index of list1
        int current2 = mid + 1; // Current index of list2
        int current3 = 0; // Current index of temp

        // Creat a new integer array of length high - low + 1
        int[] temp = new int[high - low + 1];

        while (current1 <= mid && current2 <= high) {
            if (list[current1] < list[current2]) {
                temp[current3++] = list[current1++];
            } else {
                temp[current3++] = list[current2++];
            }
        }

        while (current1 <= mid) {
            temp[current3++] = list[current1++];
        }

        while (current2 <= high) {
            temp[current3++] = list[current2++];
        }

        // Cope the contents of temp to the original array
        for (int i = low, j = 0; i <= high; i++, j++) {
            list[i] = temp[j];
        }
    }

    /**
     * The method for sorting the numbers.
     *
     * @param list
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * Merge two sorted lists.
     *
     * @param list1
     * @param list2
     * @param temp
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index of list1
        int current2 = 0; // Current index of list2
        int current3 = 0; // Current index of temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }
}
