
/**
 * Write a test program that adds 20 numbers from 1 to 20 into the queue and
 * removes these numbers and displays them.
 *
 * Output:
 * 14 13 1 4 14 16 5 20 20 3 3 11 15 12 20 20 5 17 10 11
 *
 * @author martinfall
 */
public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue();
        int size = 20;

        for (int i = 0; i < size; i++) {
            queue.enqueue((int) (Math.random() * 20) + 1);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
