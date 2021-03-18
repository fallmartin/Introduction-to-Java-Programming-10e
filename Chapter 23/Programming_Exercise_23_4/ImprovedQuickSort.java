package improvedquicksort;

import java.util.*;

/**
 * (Improve quick sort) The quick sort algorithm presented in the book selects
 * the first element in the list as the pivot. Revise it by selecting the median
 * among the first, middle, and last elements in the list.
 *
 * Output:
 * The unsorted array: [31, 50, 8, 87, 20, 13, 92, 72, 75, 55]
 * The sorted array: [8, 13, 20, 31, 50, 55, 72, 75, 87, 92]
 *
 * The unsorted array: [49, 6, 25, 37, 10, 27, 47, 68, 24, 1]
 * The sorted array: [1, 6, 10, 24, 25, 27, 37, 47, 49, 68]
 *
 * @author martinfall
 */
public class ImprovedQuickSort {

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

        quickSort(list);
        // quickSort(list, comparator);

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
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Returns the median among the first, middle, and last elements in the
     * list.
     *
     * @param <E>
     * @param list
     * @param first
     * @param last
     */
    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        // Find the index of the middle element in the list
        int middle = first + (last - first) / 2;

        // Construct a list of the first, middle, and last elements in the list
        ArrayList<E> pivots = new ArrayList<>();
        pivots.add(list[first]);
        pivots.add(list[middle]);
        pivots.add(list[last]);

        // Remove the first occurences of the min and max elements in the list
        pivots.remove(Collections.min(pivots));
        pivots.remove(Collections.max(pivots));

        // The remaining element is the pivot
        E pivot = pivots.get(0);

        // Find the element's index in the original list
        int pivotIndex = first; // Set the pivot index to the first position
        // If the pivot is not found at first position
        if (!pivot.equals(list[first])) {
            // If the pivot is equal to the element in the middle position
            if (pivot.equals(list[middle])) {
                // Update the pivot index to that of the middle index
                pivotIndex = middle;
            } // If the pivot is equal to the element in the last position
            else if (pivot.equals(list[last])) {
                // Update the pivot index to that of the last index
                pivotIndex = last;
            }
        }

        // Swap the pivot with the first element if necessary
        if (pivot.compareTo(list[first]) != 0) {
            list[pivotIndex] = list[first];
            list[first] = pivot;
            pivotIndex = first; // Update the pivot index to reflect the swap
        }

        // Two variables low and high to help partition the list
        int low = first;
        int high = last;

        // While low is less than high (no crossing)
        while (low < high) {
            // Increment low while the element is left of the pivot
            while (low <= high && list[low].compareTo(pivot) <= 0) {
                low++;
            }

            // Decrement high while the element is on the right of the pivot
            while (low <= high && list[high].compareTo(pivot) > 0) {
                high--;
            }

            // Swap if the current values of low and high permit
            if (low < high) {
                E temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
        }

        // Move high pointer to nearest element smaller than pivot
        while (high > first && list[high].compareTo(pivot) >= 0) {
            high--;
        }

        // If the pivot is larger than the element at high
        if (list[high].compareTo(pivot) < 0) {
            // Swap pivot with element at high
            list[first] = list[high];
            list[high] = pivot;

            // Change the value of pivotIndex to high
            pivotIndex = high;
        }

        // Return the index of the pivot
        return pivotIndex;
    }
}
