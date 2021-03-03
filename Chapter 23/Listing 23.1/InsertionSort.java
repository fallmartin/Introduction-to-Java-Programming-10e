package listing_23_1;

/**
 * Output:
 * 2 3 2 5 6 1 -2 3 14 12
 * -2 1 2 2 3 3 5 6 12 14
 *
 * @author martinfall
 */
public class InsertionSort {

    /**
     * The method for sorting the numbers.
     *
     * @param list
     */
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            /**
             * insert list[i] into a sorted sublist list[0..i-1] so that
             * list[0..i] is sorted.
             */
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k+1]
            list[k + 1] = currentElement;

            // Print to console at each iteration
            // System.out.print("i = " + i + ": ");
            // printList(list);
        }
    }

    /**
     * Prints the contents of the array to the console.
     *
     * @param list
     */
    public static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an int array and print to console
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        printList(list);

        // Sort the int array using insertion sort
        insertionSort(list);

        // Print the sorted array to console
        printList(list);
    }
}
