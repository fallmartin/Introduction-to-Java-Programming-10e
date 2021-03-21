package bubblesort;

import java.util.*;

/**
 * (Generic bubble sort) Write the following two generic methods using bubble
 * sort. The first method sorts the elements using the Comparable interface and
 * the second uses the Comparator interface.
 *
 * public static <E extends Comparable<E>> void bubbleSort(E[] list)
 * public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator)
 *
 * Output:
 * The unsorted array: [8, 43, 19, 91, 32, 27, 89, 10, 74, 16]
 * The sorted array: [8, 10, 16, 19, 27, 32, 43, 74, 89, 91]
 *
 * @author martinfall
 */
public class BubbleSort {

    /**
     * Sorts the elements in the list using the Comparable interface.
     *
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean nextPassNeeded = true;
        for (int i = 0; i < list.length - 1 && nextPassNeeded; i++) {
            nextPassNeeded = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    nextPassNeeded = true;
                }
            }
        }
    }

    /**
     * Sorts the elements in the list using the Comparator interface.
     *
     * @param <E>
     * @param list
     * @param comparator
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean nextPassNeeded = true;
        for (int i = 0; i < list.length - 1 && nextPassNeeded; i++) {
            nextPassNeeded = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    nextPassNeeded = true;
                }
            }
        }
    }

    /**
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create int array of 10 randomly generated value in the 0-100 range
        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 101);
        }

        // Display the unsorted array in the console
        System.out.print("The unsorted array: ");
        System.out.println(Arrays.toString(list));

        // Create a comparator to use with the overloaded bubbleSort method
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);

        // Uncomment one of the method calls below to sort the list
        // bubbleSort(list);
        bubbleSort(list, comparator);

        // Display the sorted array in the console
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(list));
    }

}
