
import java.util.ArrayList;

/**
 * (Shuffle ArrayList) Write the following method that shuffles an ArrayList of
 * numbers:
 *
 * public static void shuffle(ArrayList<Number> list)
 *
 * Output:
 * Unshuffled list: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * Shuffled list: [9, 7, 3, 8, 6, 2, 1, 4, 0, 5]
 *
 * @author martinfall
 */
public class ShuffleArrayList {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new ArrayList
        ArrayList<Number> list = new ArrayList<>();

        // Populate the list with integers 0 - 9
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        // Display the list
        System.out.println("Unshuffled list: " + list);

        // Shuffle the list
        shuffle(list);

        // Display the shuffled list
        System.out.println("Shuffled list: " + list);
    }

    /**
     * Shuffles an ArrayList of numbers.
     *
     * @param list
     */
    public static void shuffle(ArrayList<Number> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            // Generate a random index between 0 and list.size()
            int randomIndex = (int) (Math.random() * size);
            // Swap the values at i and randomIndex
            Number temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }
    }
}
