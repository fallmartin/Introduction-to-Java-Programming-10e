package heap;

import java.util.*;

/**
 * (Heap clone and equals) Implement the clone and equals method in the Heap
 * class.
 *
 * Output:
 * Heap = [94, 65, 81, 60, 33, 49, 5, 17, 43, 16]
 * Clone = [94, 65, 81, 60, 33, 49, 5, 17, 43, 16]
 *
 * heap.equals(clone) returns true
 * clone.equals(heap) returns true
 * Heap = [94, 65, 81, 60, 33, 49, 5, 17, 43, 16]
 * Clone = [65, 60, 49, 43, 33, 16, 5, 17]
 *
 * heap.equals(clone) returns false
 * clone.equals(heap) returns false
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
        return list.toString();
    }

    @Override // Override the clone method of the Object class
    protected Object clone() throws CloneNotSupportedException {
        // Create a new heap object
        Heap<E> heapClone = new Heap<E>();

        // Iterate over the heap elements and deep copy into clone
        for (E element : list) {
            heapClone.add(element);
        }

        // Return heap clone
        return heapClone;
    }

    @Override // Override the equals method of the Object class
    public boolean equals(Object obj) {
        // If obj is not empty and is an instance of the generic Heap class
        if (obj != null && obj instanceof Heap) {
            // Assign obj to a ref var of type Heap<E>
            Heap<E> heap = (Heap<E>) obj;
            // Return true if both lists are equal
            return list.equals(heap.list);
        }
        return false; // Return false otherwise
    }

    /**
     * Main method with driver code.
     *
     * @param args
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create a new random number generator
        Random r = new Random();

        // Create and populate a default heap
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < 10; i++) {
            heap.add(r.nextInt(100));
        }

        // Clone the heap and display both the original and the clone to console
        Heap<Integer> clone = (Heap<Integer>) heap.clone();
        System.out.println("Heap = " + heap);
        System.out.println("Clone = " + clone + "\n");

        // Test if they are equal
        System.out.println("heap.equals(clone) returns " + heap.equals(clone));
        System.out.println("clone.equals(heap) returns " + clone.equals(heap));

        // Remove 2 elements from clone and compare them again
        clone.remove(); // Remove the root
        clone.remove(); // Remove the root

        // Display both the heap and the clone to console
        System.out.println("Heap = " + heap);
        System.out.println("Clone = " + clone + "\n");

        // Test if they are equal
        System.out.println("heap.equals(clone) returns " + heap.equals(clone));
        System.out.println("clone.equals(heap) returns " + clone.equals(heap));
    }
}
