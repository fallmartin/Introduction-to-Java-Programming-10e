
import java.util.Arrays;

/**
 * Output:
 *
 * Unsorted List: [2.0, 1.0, 4.0, 0.0]
 * Sorted List: [0.0, 1.0, 2.0, 4.0]
 *
 * @author martinfall
 */
public class RecursiveSelectionSort {

    /**
     * Recursive selection sort.
     *
     * @param list
     */
    public static void sort(double[] list) {
        sort(list, 0, list.length - 1);
    }

    /**
     * Recursive helper method.
     *
     * @param list
     * @param low
     * @param high
     */
    public static void sort(double[] list, int low, int high) {
        if (low < high) { // Base case
            // Find the smallest number and its index in list[low ... high]
            int indexOfMin = low;
            double min = list[indexOfMin];

            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            // Swap the smallest in list[low .. high] with list[low]
            list[indexOfMin] = list[low];
            list[low] = min;

            // Sort the remaining list[low+1 .. high]
            sort(list, low + 1, high);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        double[] list = {2, 1, 4, 0};
        System.out.println("Unsorted List: " + Arrays.toString(list));

        sort(list);
        System.out.println("Sorted List: " + Arrays.toString(list));
    }

}
