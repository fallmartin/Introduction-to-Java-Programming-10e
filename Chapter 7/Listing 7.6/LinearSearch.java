
/** Output:
 * 1
 * -1
 * 5
 */

/**
 *
 * @author martinfall
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] list = {1, 4, 4, 2, 5, -3, 6, 2};

        int i = linearSearch(list, 4);
        int j = linearSearch(list, -4);
        int k = linearSearch(list, -3);

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    /**
     * The method for finding a key in the list
     *
     * @param list
     * @param key
     * @return
     */
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) {
                return i;
            }
        }
        return -1;
    }
}
