
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * (Shuffle ArrayList) Write the following method that shuffles an ArrayList:
 *
 * public static <E> void shuffle(ArrayList<E> list)
 *
 * Output:
 * Unsorted list
 * [80, 4, 52, 35, 32, 6, 9, 49, 7, 21]
 *
 * Sorted list
 * [4, 6, 7, 9, 21, 32, 35, 49, 52, 80]
 *
 * Shuffled list
 * [7, 4, 6, 52, 9, 80, 32, 49, 35, 21]
 *
 * @author martinfall
 */
public class Shuffle {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an array list and populate it with random Integer values
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }

        // Display the unsored list to the console
        System.out.println("Unsorted list");
        System.out.println(list);
        System.out.println();

        // Display the sorted list to the console
        System.out.println("Sorted list");
        Collections.sort(list);
        System.out.println(list);
        System.out.println();

        // Display the shuffled list to the console
        System.out.println("Shuffled list");
        shuffle(list);
        System.out.println(list);
    }

    /**
     * Shuffles an ArrayList.
     *
     * @param <E>
     * @param list
     */
    public static <E> void shuffle(ArrayList<E> list) {
        Random random = new Random();

        for (int i = 0; i < list.size(); i++) {
            // Generate a random index within the correct bounds
            int randomIndex = random.nextInt(list.size() - 1);

            // Swap the value at i with the value at randomIndex
            // Collections.swap(list, i, randomIndex);
            E o = list.get(i);
            E v = list.get(randomIndex);

            list.set(i, v);
            list.set(randomIndex, o);
        }
    }
}
