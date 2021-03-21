package heapsort;

import java.util.*;

/**
 * (Generic heap sort) Write the following two generic methods using heap sort.
 * The first method sorts the elements using the Comparable interface and the
 * second uses the Comparator interface.
 *
 * public static <E extends Comparable<E>> void heapSort(E[] list)
 * public static <E> void heapSort(E[] list, Comparator<? super E> comparator)
 *
 * Output using the Comparable interface:
 * The unsorted array: [1, 90, 42, 75, 87, 65, 58, 91, 71, 53]
 * The sorted array: [1, 42, 53, 58, 65, 71, 75, 87, 90, 91]
 *
 * Output using the Comparator interface:
 * The unsorted array: [98, 50, 30, 82, 44, 67, 100, 97, 72, 19]
 * The sorted array: [19, 30, 44, 50, 67, 72, 82, 97, 98, 100]
 *
 * @author martinfall
 */
public class HeapSort {

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

        // Uncomment the line below to test class with list2
        // Integer[] list2 = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        // Display the unsorted array in the console
        System.out.print("The unsorted array: ");
        System.out.println(Arrays.toString(list));

        heapSort(list);
        // heapSort(list, comparator);

        // Display the sorted array in the console
        System.out.print("The sorted array: ");
        System.out.println(Arrays.toString(list));
    }

    /**
     * Sorts the elements in the list using the Comparable interface.
     *
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a heap
        ComparableHeap<E> heap = new ComparableHeap<>(list);

        // Rebuild the list using the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }

    /**
     * Sorts the elements in the list using the Comparator interface.
     *
     * @param <E>
     * @param list
     * @param comparator
     */
    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        // Create a heap
        ComparatorHeap<E> heap = new ComparatorHeap<>(list, comparator);

        // Rebuild the list using the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
