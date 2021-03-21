package quicksort;

import java.util.*;

/**
 * (Generic quick sort) Write the following two generic methods using quick
 * sort. The first method sorts the elements using the Comparable interface and
 * the second uses the Comparator interface.
 *
 * public static <E extends Comparable<E>> void quickSort(E[] list)
 * public static <E> void quickSort(E[] list, Comparator<? super E> comparator)
 *
 * Output for quickSort using the Comparable interface:
 * The unsorted array: [86, 14, 78, 19, 46, 83, 12, 85, 40, 53]
 * The sorted array: [12, 14, 19, 40, 46, 53, 78, 83, 85, 86]
 *
 * Output for quickSort using the Comparator interface:
 * The unsorted array: [94, 47, 84, 38, 64, 55, 74, 49, 9, 66]
 * The sorted array: [9, 38, 47, 49, 55, 64, 66, 74, 84, 94]
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
        // Create int array of 10 randomly generated value in the 0-100 range
        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 101);
        }

        // Create a comparator to use with the overloaded mergeSort method
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);

        // Display the unsorted array in the console
        System.out.print("The unsorted array: ");
        System.out.println(Arrays.toString(list));

        // quickSort(list);
        quickSort(list, comparator);

        // Display the sorted array in the console
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(list));
    }

    /**
     * Sorts the elements using the Comparable interface.
     *
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    /**
     * Recursive helper method for the quickSort method that sorts the elements
     * using the Comparable interface.
     *
     * @param <E>
     * @param list
     * @param first
     * @param last
     */
    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (first < last) {
            E pivot = list[first];
            int low = first + 1;
            int high = last;

            while (low < high) {
                while (low <= high && list[low].compareTo(pivot) <= 0) {
                    low++;
                }

                while (low <= high && list[high].compareTo(pivot) > 0) {
                    high--;
                }

                if (low < high) {
                    E temp = list[low];
                    list[low] = list[high];
                    list[high] = temp;
                }
            }

            while (high > first && list[high].compareTo(pivot) >= 0) {
                high--;
            }

            int pivotIndex = first;

            if (pivot.compareTo(list[high]) > 0) {
                list[first] = list[high];
                list[high] = pivot;
                pivotIndex = high;
            }

            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Sorts the elements using the Comparator interface.
     *
     * @param <E>
     * @param list
     * @param comparator
     */
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    /**
     * Recursive helper method for the quickSort method that sorts the elements
     * using the Comparator interface.
     *
     * @param <E>
     * @param list
     * @param first
     * @param last
     * @param comparator
     */
    public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (first < last) {
            E pivot = list[first];
            int low = first + 1;
            int high = last;

            while (low < high) {
                if (low <= high && comparator.compare(list[low], pivot) <= 0) {
                    low++;
                }

                if (low <= high && comparator.compare(list[high], pivot) > 0) {
                    high--;
                }

                if (low < high) {
                    E temp = list[low];
                    list[low] = list[high];
                    list[high] = temp;
                }
            }

            while (high > first && comparator.compare(list[high], pivot) >= 0) {
                high--;
            }

            int pivotIndex = first;

            if (comparator.compare(pivot, list[high]) > 0) {
                list[first] = list[high];
                list[high] = pivot;
                pivotIndex = high;
            }

            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }
}
