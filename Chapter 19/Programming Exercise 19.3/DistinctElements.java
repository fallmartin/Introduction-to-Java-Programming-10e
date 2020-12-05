
import java.util.ArrayList;

/**
 * (Distinct elements in ArrayList) Write the following method that returns a
 * new ArrayList. The new list contains the non-duplicate elements from the
 * original list.
 *
 * public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 *
 * Output:
 * List with duplicates:
 * [1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5]
 * List without duplicates:
 * [1, 2, 3, 4, 5]
 *
 * @author martinfall
 */
public class DistinctElements {

    /**
     * Returns a new list that contains the non-duplicate elements from the
     * original list.
     *
     * @param <E>
     * @param list
     * @return
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Create a new array list
        ArrayList<E> updatedList = new ArrayList<>();

        // For each element in list
        for (E element : list) {
            // If the updated list does not contain the current element
            if (!updatedList.contains(element)) {
                updatedList.add(element); // Add it to the updated list
            }
        }
        // Return the updated list
        return updatedList;
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new array list with duplicates
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5};
        for (int number : array) {
            list.add(number);
        }

        // Display the list to console
        System.out.println("List with duplicates: ");
        System.out.println(list);

        // Remove the duplicates
        list = removeDuplicates(list);

        // Display the list to console
        System.out.println("List without duplicates: ");
        System.out.println(list);
    }
}
