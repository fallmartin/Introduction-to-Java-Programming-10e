package heapsort;

import java.util.*;

/**
 * Generic implementation of a binary heap.
 *
 * @author martinfall
 * @param <E>
 */
public class ComparatorHeap<E> {

    ArrayList<E> list = new ArrayList<>();
    Comparator<? super E> comparator;

    /**
     * Creates a heap with the specified objects.
     *
     * @param objects
     * @param comparator
     */
    public ComparatorHeap(E[] objects, Comparator<? super E> comparator) {
        // Assign the comparator to the data field
        this.comparator = comparator;

        // Add the elements of objects to the heap
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    /**
     * Adds a new object to the heap using the Comparable interface.
     *
     * @param newObject
     */
    public void add(E newObject) {
        // Append the new object to the heap
        list.add(newObject);

        // Find the index of the new object
        int currentIndex = list.size() - 1;

        // 
        while (currentIndex > 0) { // ??? Would >= work?
            int parentIndex = (currentIndex - 1) / 2;

            // Swap if the object at current index is greater than parent
            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
                E tempObject = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, tempObject);
            } else {
                break; // The tree is a heap now
            }

            currentIndex = parentIndex;
        }
    }

    /**
     * Removes the root from the heap and returns it using the Comparable
     * interface.
     *
     * @return
     */
    public E remove() {
        // Return null if the heap is empty
        if (list.isEmpty()) {
            return null;
        }

        E removedObject = list.get(0); // Remember the last node
        // Set the last node as the first element and remove it for the last position
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // Rebalance the heap
        int currentIndex = 0;

        // While the currentIndex is in the valid range
        while (currentIndex < list.size()) {

            // Find the left and right children of the node
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Break out of the loop if node doesn't have a left child
            if (leftChildIndex >= list.size()) {
                break; // The tree is a heap
            }

            // Find the index of the max child
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) { // If the right index is valid
                // and the right child > left child
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                // Swap the two values
                E tempObject = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, tempObject);

                // Update the current index
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
}
