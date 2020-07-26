
import java.util.ArrayList;

/**
 * (Sort ArrayList) Write the following method that sorts an ArrayList of
 * numbers.
 *
 * public static void sort(ArrayList<Number> list)
 *
 * Output:
 * Unsorted list: [9, 5, 2, 7, 0, 6, 1, 3, 8, 4]
 * Sorted list: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 * @author martinfall
 */
public class SortArrayList {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new ArrayList
        ArrayList<Number> list = new ArrayList<>();

        // Populate the list with integers 0 - 9
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(0);
        list.add(6);
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(4);

        // Display the list
        System.out.println("Unsorted list: " + list);

        // Shuffle the list
        sort(list);

        // Display the shuffled list
        System.out.println("Sorted list: " + list);
    }

    /**
     * Sorts an ArrayList of number using selection sort.
     *
     * @param list
     */
    public static void sort(ArrayList<Number> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(minIndex).doubleValue() > list.get(j).doubleValue()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Number temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }
}
