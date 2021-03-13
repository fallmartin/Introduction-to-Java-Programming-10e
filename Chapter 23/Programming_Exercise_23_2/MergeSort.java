package mergesort;

import java.util.*;

/**
 * (Generic merge sort) Write the following two generic methods using merge
 * sort. The first method sorts the elements using the Comparable interface and
 * the second uses the Comparator interface.
 *
 * public static <E extends Comparable<E>> void mergeSort(E[] list)
 * public static <E> void mergeSort(E[] list, Comparator<? super E> comparator)
 *
 * Output for mergeSort using the Comparable interface:
 * The unsorted array: [1, 61, 73, 61, 22, 3, 48, 75, 96, 21]
 * The sorted array: [1, 3, 21, 22, 48, 61, 61, 73, 75, 96]
 *
 * Output for mergeSort using the Comparator interface:
 * The unsorted array: [25, 25, 81, 87, 62, 97, 41, 5, 99, 15]
 * The sorted array: [5, 15, 25, 25, 41, 62, 81, 87, 97, 99]
 *
 * @author martinfall
 */
public class MergeSort {

    /**
     * Sorts the elements using the Comparable interface.
     *
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            // System.out.println(Arrays.toString(firstHalf));
            mergeSort(firstHalf);

            // Merge sort the second half
            E[] secondHalf = Arrays.copyOfRange(
                    list, list.length / 2, list.length);
            // System.out.println(Arrays.toString(secondHalf));
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * Merges the first and second halves of a list in a temp array.
     *
     * @param <E>
     * @param firstHalf
     * @param secondHalf
     * @param temp
     */
    public static <E extends Comparable<E>> void merge(
            E[] firstHalf, E[] secondHalf, E[] temp) {
        int index = 0;
        int indexFirstHalf = 0;
        int indexSecondHalf = 0;

        while (indexFirstHalf < firstHalf.length && indexSecondHalf < secondHalf.length) {
            if (firstHalf[indexFirstHalf].compareTo(secondHalf[indexSecondHalf]) < 0) {
                temp[index++] = firstHalf[indexFirstHalf++];
            } else {
                temp[index++] = secondHalf[indexSecondHalf++];
            }
        }

        while (indexFirstHalf < firstHalf.length) {
            temp[index++] = firstHalf[indexFirstHalf++];
        }

        while (indexSecondHalf < secondHalf.length) {
            temp[index++] = secondHalf[indexSecondHalf++];
        }

        // System.out.println(Arrays.toString(temp));
    }

    /**
     * Sorts the elements using the Comparator interface.
     *
     * @param <E>
     * @param list
     * @param comparator
     */
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            // System.out.println(Arrays.toString(firstHalf));
            mergeSort(firstHalf, comparator);

            // Merge sort the second half
            E[] secondHalf = Arrays.copyOfRange(
                    list, list.length / 2, list.length);
            // System.out.println(Arrays.toString(secondHalf));
            mergeSort(secondHalf, comparator);

            // Merge firstHalf with secondHalf into list
            int index = 0;
            int indexFirstHalf = 0;
            int indexSecondHalf = 0;

            while (indexFirstHalf < firstHalf.length && indexSecondHalf < secondHalf.length) {
                if (comparator.compare(
                        firstHalf[indexFirstHalf], secondHalf[indexSecondHalf]) < 0) {
                    list[index++] = firstHalf[indexFirstHalf++];
                } else {
                    list[index++] = secondHalf[indexSecondHalf++];
                }
            }

            while (indexFirstHalf < firstHalf.length) {
                list[index++] = firstHalf[indexFirstHalf++];
            }

            while (indexSecondHalf < secondHalf.length) {
                list[index++] = secondHalf[indexSecondHalf++];
            }

            // System.out.println(Arrays.toString(list));
        }
    }

    /**
     * @param args the command line arguments
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

        mergeSort(list, comparator);

        // Display the sorted array in the console
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(list));
    }

}
