package benchmarksort;

/**
 *
 * @author martinfall
 */
public class IterativeQuickSort {

    /**
     * Sorts a list using the iterative quick sort algorithm.
     *
     * @param list
     */
    public static void iterativeQuickSort(Integer[] list) {
        // Create a new integer array
        Integer[] temp = new Integer[list.length];

        /*
         * Traverse the list to find the correct position of each element and
         * position it in the temp array at the correct index.
         */
        for (int i = 0; i < list.length; i++) {
            int index = partition(list.clone(), i);
            temp[index] = list[i];
        }

        // Copy temp into list
        for (int i = 0; i < list.length; i++) {
            list[i] = temp[i];
        }
    }

    /**
     * Helper method for the iterative quick sort method. Partitions the array
     * and returns the correct index of the element at i.
     *
     * @param list
     * @param currentIndex
     */
    private static int partition(Integer[] list, int currentIndex) {

        // Place the pivot at the head of the list with a swap
        Integer temp = list[0];
        list[0] = list[currentIndex];
        list[currentIndex] = temp;

        // Remember the pivot value at the current index
        Integer pivot = list[0];

        // Declare the low and high variables
        int low = 1;
        int high = list.length - 1;

        while (low < high) {
            while (low <= high && list[low] <= pivot) {
                low++;
            }

            while (low <= high && list[high] > pivot) {
                high--;
            }

            if (low < high) {
                temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > 0 && list[high] >= pivot) {
            high--;
        }

        int correctIndex = 0;

        if (pivot > list[high]) {
            list[0] = list[high];
            list[high] = pivot;
            correctIndex = high;
        }

        return correctIndex;
    }
}
