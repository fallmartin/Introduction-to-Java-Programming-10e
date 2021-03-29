package benchmarksort;

import java.util.*;

/**
 *
 * @author martinfall
 */
public class MergeSort {

    /**
     * Sorts a list using the merge sort algorithm.
     *
     * @param list
     */
    public static void mergeSort(Integer[] list) {
        if (list.length > 1) {
            // Copy the first and second halves of list into new arrays
            Integer[] firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            Integer[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);

            // Merge sort recursively on each half of the list
            mergeSort(firstHalf);
            mergeSort(secondHalf);

            // Merge the first and second halves into the list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * Merge the first and second halves into the list.
     *
     *
     * @param firstHalf
     * @param secondHalf
     * @param list
     */
    private static void merge(Integer[] firstHalf, Integer[] secondHalf, Integer[] list) {
        int index = 0; // List index
        int indexFirst = 0; // First half index
        int indexSecond = 0; // Second half index

        while (indexFirst < firstHalf.length && indexSecond < secondHalf.length) {
            if (firstHalf[indexFirst] < secondHalf[indexSecond]) {
                list[index++] = firstHalf[indexFirst++];
            } else {
                list[index++] = secondHalf[indexSecond++];
            }
        }

        while (indexFirst < firstHalf.length) {
            list[index++] = firstHalf[indexFirst++];
        }

        while (indexSecond < secondHalf.length) {
            list[index++] = secondHalf[indexSecond++];
        }
    }
}
