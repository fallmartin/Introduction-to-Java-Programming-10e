package listing_23_10;

/**
 * Output: -44 -5 -4 -3 0 1 1 2 3 3 4 5 53
 *
 * @author martinfall
 */
public class HeapSort {

    /**
     * Heap sort method.
     *
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a heap of integers
        Heap<E> heap = new Heap();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }

    /**
     * Print the contents of the list to the console.
     *
     * @param list
     */
    public static <E> void printList(E[] list) {
        System.out.print("List contents: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
