
import java.util.ArrayList;
import java.util.Arrays;

/**
 * (Generic linear search) Implement the following generic method for linear
 * search.
 *
 * public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
 *
 * Output:
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
 * 6 is found at index 5
 * [red, green, blue, green]
 * green is found at index 1
 *
 * @author martinfall
 */
public class GenericLinearSearch {

    /**
     * Returns the index of the first key in the list if found, and -1 if
     * not found.
     *
     * @param <E>
     * @param list
     * @param key
     * @return
     */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new array of integers
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(intArray));
        int intKey = 6;
        System.out.println(intKey + " is found at index "
                + linearSearch(intArray, intKey));

        String[] stringArray = new String[]{"red", "green", "blue", "green"};
        System.out.println(Arrays.toString(stringArray));
        String stringKey = "green";
        System.out.println(stringKey + " is found at index "
                + linearSearch(stringArray, stringKey));
    }
}
