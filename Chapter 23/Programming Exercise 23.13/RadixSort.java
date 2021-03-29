package benchmarksort;

import java.util.*;

/**
 *
 * @author martinfall
 */
public class RadixSort {

    /**
     * Sorts a list using the heap sort algorithm.
     *
     * @param list
     */
    public static void radixSort(Integer[] list) {

        // Largest possible value for the radix at least significant position
        int maxWidth = Collections.max(Arrays.asList(list)).toString().length();
        int radixIndex = maxWidth - 1;

        while (radixIndex >= 0) {
            // Create a new array of arraylists for our buckets
            ArrayList<Integer>[] buckets = new ArrayList[10];

            // Distribute the elements for the list to the buckets
            for (int i = 0; i < list.length; i++) {
                int key = Integer.parseInt(padLeft(maxWidth, list[i]).charAt(radixIndex) + "");

                if (buckets[key] == null) {
                    buckets[key] = new ArrayList<>();
                }

                buckets[key].add(list[i]);
            }

            // Now move the elements from the buckets back to list
            int k = 0; // k is the list index
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    for (int j = 0; j < buckets[i].size(); j++) {
                        list[k] = buckets[i].get(j);
                        k++;
                    }
                }
            }

            // Decrement the radix index
            radixIndex--;
        }
    }

    /**
     * Returns a zero left-padded string of specified maximum length from the
     * number parameter.
     *
     * @param maxWidth
     * @param number
     * @return
     */
    public static String padLeft(int maxWidth, int number) {
        // Create a new string builder
        StringBuilder padded = new StringBuilder();

        /*
         * While the length of the string builder is less than the difference
         * between the maximum length and the length of the number argument
         */
        while (padded.length() < maxWidth - Integer.toString(number).length()) {
            padded.append("0"); // zero left-padding
        }
        padded.append(number); // Add the number to obtain the desired string

        // Return the padded string
        return padded.toString();
    }
}
