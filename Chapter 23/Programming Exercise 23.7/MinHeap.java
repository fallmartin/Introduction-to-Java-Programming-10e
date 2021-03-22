package minheap;

import java.util.*;

/**
 * (Min-heap) The heap presented in the text is also known as a max-heap, in
 * which each node is greater than or equal to any of its children.A min-heap
 * is a heap in which each node is less than or equal to any of its children.
 * Min-heaps are often used to implement priority queues. Revise the Heap class
 * in Listing 23.9 to implement a min-heap.
 *
 * Output:
 * MinHeap: [-44, -5, -4, 0, 2, 1, -3, 3, 1, 3, 4, 5, 53]
 * Ordered list: 53 5 4 3 3 2 1 1 0 -3 -4 -5 -44
 *
 * @author martinfall
 * @param <E>
 */
public class MinHeap<E extends Comparable<E>> {

    ArrayList<E> list = new ArrayList<>();

    /**
     * Creates a default empty heap.
     */
    public MinHeap() {
    }

    /**
     * Creates a heap with the specified objects.
     *
     * @param objects
     */
    public void MinHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    /**
     * Adds a new object to the heap.
     *
     * @param newObject
     */
    public void add(E newObject) {
        list.add(newObject);

        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
                E tempObject = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, tempObject);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    /**
     * Removes the root from the heap and returns it.
     *
     * @return
     */
    public E remove() {
        if (list.isEmpty()) {
            return null;
        }

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;

        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) {
                break;
            }

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) > 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (list.get(currentIndex).compareTo(list.get(maxIndex)) > 0) {
                E tempObject = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, tempObject);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }
        return removedObject;
    }

    /**
     * Returns the size of the heap.
     *
     * @return
     */
    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a heap
        MinHeap<E> heap = new MinHeap<>();

        // Add elements from list to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }

        // Display the array-based internal represenation of the heap to console
        System.out.print("MinHeap: ");
        System.out.println(heap);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }

    /**
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a list of integers
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

        // Sort using a min heap internally
        heapSort(list);

        // Display the resulting array
        System.out.print("Ordered list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
