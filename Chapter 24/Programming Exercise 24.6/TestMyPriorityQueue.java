package mypriorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Output:
 * original array: [210, 683, 138, 589, 829, 646, 965, 283, 377, 573]
 * priority queue: {965, 829, 683, 646, 589, 573, 377, 283, 210, 138}
 *
 * @author martinfall
 */
public class TestMyPriorityQueue {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] array = getTestArray(10, 1000);
        System.out.print("original array: ");
        System.out.println(Arrays.toString(array));
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);

        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(comparator);

        for (int i = 0; i < array.length; i++) {
            queue.enqueue(array[i]);
        }

        System.out.println(queue);
    }

    private static Integer[] getTestArray(int n, int bound) {
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}
