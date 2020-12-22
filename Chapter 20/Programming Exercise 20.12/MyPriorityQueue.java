
import java.util.*;

/**
 * (Clone PriorityQueue) Define MyPriorityQueue class that extends PriorityQueue
 * to implement the Cloneable interface and implement the clone() method to
 * clone a priority queue.
 *
 * Output:
 * queue: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * queueClone: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *
 * Remove even numbers from queue...
 * Done!
 *
 * Remove odd numbers from queue...
 * Done!
 *
 * queue: [1, 3, 5, 7, 9]
 * queueClone: [0, 4, 2, 8, 10, 6]
 *
 * @author martinfall
 */
public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {

    MyPriorityQueue<E> queue;

    @Override // Does not call super.clone() because we need deep copy of E in super
    protected Object clone() throws CloneNotSupportedException {
        // Initialize the data field queue
        queue = new MyPriorityQueue<>();

        // Deep copy of all elements in the super type
        Iterator<E> it = super.iterator();
        while (it.hasNext()) {
            queue.offer(it.next());
        }

        return queue;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        for (int i = 0; i <= 10; i++) {
            queue.offer(i);
        }

        MyPriorityQueue<Integer> queueClone
                = (MyPriorityQueue<Integer>) queue.clone();

        System.out.println("queue: " + queue);
        System.out.println("queueClone: " + queueClone);
        System.out.println();

        // Remove even numbers from queue
        System.out.println("Remove even numbers from queue...");
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            int c = it.next();
            if (c % 2 == 0) {
                it.remove();
            }
        }
        System.out.println("Done!\n");

        // Remove odd numbers from queueClone
        System.out.println("Remove odd numbers from queue...");
        Iterator<Integer> itClone = queueClone.iterator();
        while (itClone.hasNext()) {
            int c = itClone.next();
            if (c % 2 != 0) {
                itClone.remove();
            }
        }
        System.out.println("Done!\n");

        System.out.println("queue: " + queue);
        System.out.println("queueClone: " + queueClone);
    }

}
