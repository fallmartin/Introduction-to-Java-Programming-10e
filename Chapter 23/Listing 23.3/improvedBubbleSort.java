package listing_23_3;

/**
 * Output:
 * -2 1 2 2 3 3 5 6 12 14
 *
 * @author martinfall
 */
public class BubbleSort {

    public static void improvedBubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;

            // Perform the kth pass
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true; // Next pass still needed
                }
            }
        }

    }

    public static void bubbleSort(int[] list) {
        for (int k = 1; k < list.length; k++) {
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        improvedBubbleSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
