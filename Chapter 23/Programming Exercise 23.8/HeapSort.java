package heapsort;

import java.util.*;

/**
 * (Sort using a heap) Implement the following sort method using a heap.
 * public static <E extends Comparable<E>> void sort(E[] list)
 *
 * Output:
 * -44 -5 -4 -3 0 1 1 2 3 3 4 5 53
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
    public static <E extends Comparable<E>> void sort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<>();

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
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

        sort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}

/**
 * An array list implementation of a generic heap class.
 *
 * @author martinfall
 * @param <E>
 */
class Heap<E extends Comparable<E>> {

    ArrayList<E> list = new ArrayList<>();

    /**
     * Create a default heap.
     */
    public Heap() {
    }

    /**
     * Create a heap from an array of objects.
     *
     * @param objects
     */
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    /**
     * Add a new object into the heap.
     *
     * @param newObject
     */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            // Swap if the current object is greater than its parent
            if (list.get(parentIndex).compareTo(list.get(currentIndex)) < 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break; // The tree is a heap now
            }
            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root of the heap.
     *
     * @return
     */
    public E remove() {
        // Handle the empty list scenario
        if (list.isEmpty()) {
            return null;
        }

        // Remember the root object, set the root to the last node, 
        // and remove the last node
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;

        // Find the maximum between two children
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) {
                break; // The tree is a heap
            }

            // Find the index of the maximum child
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break; // The tree is a heap
            }
        }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree.
     *
     * @return
     */
    public int getSize() {
        return list.size();
    }
}
