package genericqueue;

import java.util.LinkedList;
import java.util.Random;

/**
 * (Implement GenericQueue using inheritance) In Section 24.5, Stacks and
 * Queues, GenericQueue is implemented using composition. Define a new queue
 * class that extends java.util.LinkedList.
 *
 * Output samples of toString:
 * queue: {25, 72, 83, 28, 76, 35, 87, 15, 22, 17}
 * queue: {75, 67, 20, 73, 28, 32, 63, 14, 24, 63}
 * queue: {54, 99, 62, 84, 87, 37, 23, 19, 17, 67}
 *
 * @author martinfall
 */
public class GenericQueue<E> extends LinkedList<E> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a new random object
        Random random = new Random();

        /*
         * Declare and initialize a generic queue with random int values in the
         * 0 (inclusive) and 100 (exclusive) range.
         */
        GenericQueue<Integer> queue = new GenericQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.endqueue(random.nextInt(100));
        }

        System.out.println(queue); // print the queue to console
    }

    /**
     * Appends the specified element to the end of this queue.
     *
     * @param e
     */
    public void endqueue(E e) {
        addLast(e);
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return
     */
    public E dequeue() {
        return removeFirst();
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return
     */
    public int getSize() {
        return size();
    }

    @Override // Override the toString method of the AbstractCollection class
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        sb.append("queue: ").append('{');
        for (E e : this) {
            sb.append(e);
            if (counter++ < getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');

        return sb.toString();
    }

}
