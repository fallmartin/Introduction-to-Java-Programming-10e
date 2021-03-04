package listing_23_5;

/**
 * Output:
 * Before Sorting
 * List contents: 2 3 2 5 6 1 -2 3 14 12
 *
 * After Sorting
 * List contents: -2 1 2 2 3 3 5 6 12 14
 *
 * @author martinfall
 */
public class MergeSort {

    /**
     * The method for sorting the numbers.
     *
     * @param list
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Before Sorting");
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        printList(list);

        System.out.println("\nAfter Sorting");
        mergeSort(list);
        printList(list);
    }

    /**
     * Print the contents of the list to the console.
     *
     * @param list
     */
    public static void printList(int[] list) {
        System.out.print("List contents: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
