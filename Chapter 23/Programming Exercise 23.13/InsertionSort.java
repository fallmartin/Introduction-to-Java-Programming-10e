package benchmarksort;

/**
 *
 * @author martinfall
 */
public class InsertionSort {

    /**
     * Sorts a list using the bubble sort algorithm.
     *
     * @param list
     */
    public static void insertionSort(Integer[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int j;
            for (j = i - 1; j >= 0 && currentElement < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = currentElement;
        }
    }
}
