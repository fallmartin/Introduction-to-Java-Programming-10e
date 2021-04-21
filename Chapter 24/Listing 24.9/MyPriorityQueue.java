package mypriorityqueue;

/**
 * MyPriorityQueue uses a heap to provide a largest-in, first-out data
 * structure.
 *
 * @author martinfall
 * @param <E>
 */
public class MyPriorityQueue<E extends Comparable<E>> {

    // A heap to store elements
    Heap<E> heap = new Heap<>();

    /**
     * Adds an element to this queue.
     *
     * @param newObject the element to add to this queue
     */
    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    /**
     * Removes an element from this queue.
     *
     * @return the highest priority element from this queue
     */
    public E dequeue() {
        return heap.remove();
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of element in this queue
     */
    public int getSize() {
        return heap.getSize();
    }
}
