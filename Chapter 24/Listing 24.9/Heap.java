package mypriorityqueue;

import java.util.ArrayList;

/**
 * Heap uses an array list to implement a generic class.
 *
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {

    private ArrayList<E> list = new ArrayList<>();

    /**
     * Creates a default heap.
     */
    public Heap() {
    }

    /**
     * Creates a heap from an array of objects.
     *
     * @param objects an array of objects to construct a heap from
     */
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    /**
     * Adds a new object into the heap.
     *
     * @param newObject new object to insert into the heap
     */
    public final void add(E newObject) {

        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (list.get(currentIndex).compareTo(
                    list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break; // the tree is a heap now
            }
            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap.
     *
     * @return the root element of the heap
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

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) {
                break; // The tree is a heap
            }
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (list.get(currentIndex).compareTo(
                    list.get(maxIndex)) < 0) {
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
     * @return the number of nodes in the tree
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns true if the heap is empty.
     *
     * @return true if the heap is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
