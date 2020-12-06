
import java.util.Random;

/**
 * (Maximum element in an array) Implement the following method that returns the
 * maximum element in an array.
 *
 * public static <E extends Comparable<E>> E max(E[] list)
 *
 * Output:
 *
 * 550	104	87	116	162
 * 745	111	935	714	505
 * 406	815	745	889	495
 * 46	951	76	408	441
 * 162	693	667	931	165
 * 612	458	554	94	260
 * 703	974	600	812	105
 * 601	249	896	899	872
 * 374	515	927	493	43
 * 179	600	957	687	641
 * 77	877	203	436	137
 * 324	571	665	487	884
 * 181	801	850	675	583
 * 623	331	457	477	316
 * 924	421	704	409	449
 * 552	914	424	206	573
 * 853	776	363	836	379
 * 659	581	618	56	245
 * 726	839	84	235	844
 * 427	765	110	855	405
 *
 * The maximum element is 974
 *
 * @author martinfall
 */
public class MaximumElement {

    /**
     * Returns the maximum element in an array.
     *
     * @param <E>
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> E max(E[] list) {
        E o = list[0]; // Start with the first element in list

        // Loop through the list one element at a time
        for (int i = 1; i < list.length; i++) {
            // If the element at index i is larger than o
            if (list[i].compareTo(o) >= 1) {
                o = list[i]; // Update o
            }
        }
        return o; // Return o
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an array of 100 integers
        Integer[] array = new Integer[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // Print the array to the console
        for (int i = 1; i <= array.length; i++) {
            System.out.print(array[i - 1] + "\t");
            if (i % 5 == 0 && i != 0) {
                System.out.println();
            }
        }

        System.out.println(); // Formatting line
        System.out.println("The maximum element is " + max(array));
    }
}
