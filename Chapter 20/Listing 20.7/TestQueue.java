
import java.util.*;

/**
 *
 * @author martinfall
 */
public class TestQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");

        while (queue.size() > 0) {
            System.out.println(queue.remove() + " ");
        }
    }
}
