package benchmarksort;

/**
 *
 * @author martinfall
 */
public class SelectionSort {

    /**
     * Sorts a list using the selection sort algorithm.
     *
     * @param list
     */
    public static void selectionSort(Integer[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[minIndex] > list[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Integer temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }
}
