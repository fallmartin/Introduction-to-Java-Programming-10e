
/**
 *
 * @author martinfall
 */
public class RecursiveBinarySearch {

    /**
     * Recursive binary search method.
     *
     * @param list
     * @param key
     * @return
     */
    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    }

    /**
     * Recursive helper method.
     *
     * @param list
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursiveBinarySearch(
            int[] list, int key, int low, int high) {
        if (low > high) { // The list has been exhausted without a match
            return -low - 1;
        }

        int mid = (low + high) / 2;
        if (key < list[mid]) {
            return recursiveBinarySearch(list, key, low, mid - 1);
        } else if (key == list[mid]) {
            return mid;
        } else {
            return recursiveBinarySearch(list, key, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] list = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        System.out.println(recursiveBinarySearch(list, 18));
    }
}
