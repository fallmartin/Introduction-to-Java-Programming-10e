package benchmarksort;

/**
 *
 * @author martinfall
 */
public class BubbleSort {

    /**
     * Sorts a list using the bubble sort algorithm.
     *
     * @param list
     */
    public static void bubbleSort(Integer[] list) {
        boolean needNextPass = true;
        for (int i = 0; i < list.length - 1 && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    Integer temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}
