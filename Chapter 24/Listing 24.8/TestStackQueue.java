package teststackqueue;

/**
 * Output:
 * (1) Stack: [Tom]
 * (2) Stack: [Tom, Susan]
 * (3) Stack: [Tom, Susan, Kim, Michael]
 * (4) Michael
 * (5) Kim
 * (6) Stack: [Tom, Susan]
 * (7) Queue: [Tom]
 * (8) Queue: [Tom, Susan]
 * (9) Queue: [Tom, Susan, Kim, Michael]
 * (10) Tom
 * (11) Susan
 * (12) Queue: [Kim, Michael]
 *
 * @author martinfall
 */
public class TestStackQueue {

    /**
     * Main method the driver code to test the stack and queue generic classes.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a stack
        GenericStack<String> stack = new GenericStack<>();

        // Add elements to the stack
        stack.push("Tom"); // Push it to the stack
        System.out.println("(1) " + stack);

        stack.push("Susan"); // Push it to the stack
        System.out.println("(2) " + stack);

        stack.push("Kim"); // Push it to the stack
        stack.push("Michael"); // Push it to the stack
        System.out.println("(3) " + stack);

        // Remove elements from the stack
        System.out.println("(4) " + stack.pop());
        System.out.println("(5) " + stack.pop());
        System.out.println("(6) " + stack);

        // Create a queue
        GenericQueue<String> queue = new GenericQueue<>();

        // Add elements to the queue
        queue.enqueue("Tom"); // Add it to the queue
        System.out.println("(7) " + queue);

        queue.enqueue("Susan"); // Add it to the queue
        System.out.println("(8) " + queue);

        queue.enqueue("Kim"); // Add it to the queue
        queue.enqueue("Michael"); // Add it to the queue
        System.out.println("(9) " + queue);

        // Remove elements from the queue
        System.out.println("(10) " + queue.dequeue());
        System.out.println("(11) " + queue.dequeue());
        System.out.println("(12) " + queue);
    }
}
