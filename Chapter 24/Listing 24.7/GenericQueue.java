package genericqueue;

import java.util.LinkedList;

/**
 * GenericQueue uses a linked list to provide a first-in, first-out data
 * structure.
 *
 * @author martinfall
 */
public class GenericQueue<E> {

    private LinkedList<E> list = new LinkedList<>();

    /**
     * Adds an element to this queue.
     *
     * @param e the specified element to add to this queue
     */
    public void enqueue(E e) {
        list.addLast(e); // add(e) would also work
    }

    /**
     * Removes an element from this queue.
     *
     * @return the element removed from this queue
     */
    public E dequeue() {
        return list.removeFirst();
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int getSize() {
        return list.size();
    }

    @Override // Override the toString method of the Object class
    public String toString() {
        return "Queue: " + list.toString();
    }
}
