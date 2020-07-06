
import java.util.ArrayList;

/**
 * (Shuffle ArrayList) Write the following method that shuffles the elements in
 * an ArrayList of integers.
 *
 * public static void shuffle(ArrayList<Integer> list)
 *
 * Output:
 * Randomly generated list:
 * [67, 43, 5, 88, 26, 19, 64, 10, 67, 91]
 *
 * Shuffling...
 *
 * Shuffled list:
 * [19, 91, 26, 64, 67, 10, 5, 43, 67, 88]
 *
 * @author martinfall
 */
public class Shuffle {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println("Randomly generated list:");
        System.out.println(list);

        System.out.println();
        System.out.println("Shuffling...");
        shuffle(list);
        System.out.println();

        System.out.println("Shuffled list:");
        System.out.println(list);
    }

    public static void shuffle(ArrayList<Integer> list) {
        int size = list.size();

        // For each element in the list
        for (int i = 0; i < size; i++) {
            // System.out.println("LOOP " + i);
            // Generate a random number between i + 1 and size() - 1
            int index = (int) (Math.random() * list.size());

            // Swap the value at i with the value at index
            int temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);

        }
    }
}
