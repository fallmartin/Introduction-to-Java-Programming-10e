package benchmarksort;

import java.util.ArrayList;

/**
 *
 * @author martinfall
 */
class Heap {

    // Array implementation of a heap
    ArrayList<Integer> list = new ArrayList<>();

    /**
     * Constructs a default heap.
     */
    public Heap() {
    }

    /**
     * Constructs a heap from an array of integers.
     *
     * @param elements
     */
    public Heap(Integer[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    /**
     * Add an integer to the heap.
     *
     * @param newElement
     */
    public void add(Integer newElement) {
        // Append the new element to the heap
        list.add(newElement);
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            // System.out.println("currentIndex=" + currentIndex);
            // System.out.println("parentIndex=" + parentIndex);

            /*
             * This handles the null pointer exception thrown by add when the
             * element at parentIndex is null
             */
            if (list.get(parentIndex) == null) {
                break;
            }

            if (list.get(currentIndex) > list.get(parentIndex)) {
                Integer temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break;
            }

            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap.
     *
     * @return
     */
    public Integer remove() {
        // Return null if the list is empty
        if (list.isEmpty()) {
            return null;
        }

        // Store the value of the root in a reference variable to return later
        Integer removedElement = list.get(0);

        // Remove the root and replace it with the last element in the heap
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // Current index variable to access heap elements
        int currentIndex = 0;

        while (currentIndex < list.size()) {
            // Find the left and right child indices
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Check if the left child index is valid
            if (leftChildIndex >= list.size()) {
                break;
            }

            // Find the maximum child of the current index
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex) < list.get(rightChildIndex)) {
                    maxIndex = rightChildIndex;
                }
            }

            if (list.get(currentIndex) < list.get(maxIndex)) {
                Integer temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }
        return removedElement;
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
