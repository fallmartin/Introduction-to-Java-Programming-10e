package mypriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * (Generic PriorityQueue using Comparator) Revise MyPriorityQueue in Listing
 * 24.9, using a generic parameter for comparing objects.Define a new
 * constructor with a Comparator as its argument as follows:
 *
 * PriorityQueue(Comparator<? super E> comparator)
 *
 * Output:
 * original array: [210, 683, 138, 589, 829, 646, 965, 283, 377, 573]
 * priority queue: {965, 829, 683, 646, 589, 573, 377, 283, 210, 138}
 *
 * @author martinfall
 * @param <E>
 */
public class MyPriorityQueue<E extends Comparable<E>> {

    // Create a heap to store the objects
    private Heap<E> heap;

    /**
     * Constructs a defaults MyPriorityQueue object.
     */
    public MyPriorityQueue() {
        this.heap = new Heap<E>();
    }

    /**
     * Constructs a MyPriorityQueue with an instance of Comparator.
     *
     * @param comparator
     */
    public MyPriorityQueue(Comparator<? super E> comparator) {
        heap = new Heap<E>(comparator);
    }

    /**
     * Adds the specified element to the priority queue.
     *
     * @param newObject
     */
    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    /**
     * Removes and returns the element with the highest priority from this
     * priority queue.
     *
     * @return
     */
    public E dequeue() {
        return heap.remove();
    }

    /**
     * Returns the number of elements in this priority queue.
     *
     * @return
     */
    public int getSize() {
        return heap.getSize();
    }

    @Override // Override the toString method of the Object class
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("priority queue: ").append('{');
        while (getSize() > 0) {
            sb.append(dequeue());
            if (getSize() > 0) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /**
     * Private class Heap implements a complete binary tree data structure.
     *
     * @param <E>
     */
    private class Heap<E extends Comparable<E>> implements Cloneable {

        private ArrayList<E> list;
        private Comparator<? super E> comparator;

        /**
         * Creates a default empty heap.
         */
        public Heap() {
            this.list = new ArrayList<>();
        }

        /**
         * Creates a heap with the specified comparator.
         *
         * @param comparator
         */
        public Heap(Comparator<? super E> comparator) {
            this.list = new ArrayList<>();
            this.comparator = comparator;
        }

        /**
         * Creates a heap with the specified objects.
         *
         * @param objects
         */
        public Heap(E[] objects) {
            this.list = new ArrayList<>();
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
            list.add(newObject); // Append to the heap
            int currentIndex = list.size() - 1; // The index of the last node

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;

                // Swap if the current object is greater than its parent
                if (comparator == null
                        && list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                    swap(currentIndex, parentIndex);
                } else if (comparator != null
                        && comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
                    swap(currentIndex, parentIndex);
                } else {
                    break;  // The tree is a heap now
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

                // Find the maximum between two children
                if (leftChildIndex >= list.size()) {
                    break; // The tree is a heap
                }

                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (comparator == null
                            && list.get(maxIndex).compareTo(
                                    list.get(rightChildIndex)) < 0) {
                        maxIndex = rightChildIndex;
                    } else if (comparator != null
                            && comparator.compare(list.get(maxIndex),
                                    list.get(rightChildIndex)) < 0) {
                        maxIndex = rightChildIndex;
                    }
                }

                // Swap if the current node is less than the maximum
                if (comparator == null
                        && list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                    swap(currentIndex, maxIndex);
                    currentIndex = maxIndex;
                } else if (comparator != null
                        && comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                    swap(currentIndex, maxIndex);
                    currentIndex = maxIndex;
                } else {
                    break; // The tree is a heap
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
         * Swap the elements at index first with the element at index second.
         *
         * @param firstIndex
         * @param secondIndex
         */
        private void swap(int firstIndex, int secondIndex) {
            E temp = list.get(firstIndex);
            list.set(firstIndex, list.get(secondIndex));
            list.set(secondIndex, temp);
        }
    }
}
