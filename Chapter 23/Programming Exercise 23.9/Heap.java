package genericheap;

import java.util.*;

/**
 * (Generic Heap using Comparator) Revise Heap in Listing 23.9, using a generic
 * parameter and a Comparator for comparing objects. Define a new constructor
 * with a Comparator as its argument as follows:
 *
 * Heap(Comparator<? super E> comparator)
 *
 * Output:
 * Sorted array: [53, 5, 4, 3, 3, 2, 1, 1, 0, -3, -4, -5, -44]
 *
 * @author martinfall
 */
public class Heap<E> {

    ArrayList<E> list = new ArrayList<>();
    Comparator<? super E> comparator;

    /**
     * Creates a default empty heap.
     */
    public Heap() {
    }

    /**
     * Creates an empty heap with a comparator.
     *
     * @param comparator
     */
    public Heap(Comparator<? super E> comparator) {
        this.comparator = comparator;
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

            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
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
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;

            if (leftChildIndex >= list.size()) {
                break;
            }

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
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

    /**
     * Main method with driver code to test the generic heap class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an array of Integer objects
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

        // Create a new comparator object to use as parameter for the heap constructor
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);

        // Construct a new heap object with the comparator
        Heap<Integer> heap = new Heap<>(comparator);

        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }

        // Remove elements from the heap and sort in descending order
        for (int i = 0; i < list.length; i++) {
            list[i] = heap.remove();
        }

        // Display the sorted array to the console
        System.out.println("Sorted array: " + Arrays.toString(list));
    }

}
