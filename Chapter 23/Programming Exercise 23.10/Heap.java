/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapvisualizer;

/**
 *
 * @author martinfall
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    /**
     * Creates a default heap.
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
     * Returns the element at index i.
     *
     * @param i
     * @return
     */
    public E get(int i) {
        return list.get(i);
    }

    /**
     * Get the number of nodes in the tree.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Return true if heap is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Heap{" + "list=" + list + '}';
    }
}
