
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Bubble sort) Write a sort method that uses the bubble-sort algorithm. The
 * bubblesort algorithm makes several passes through the array. On each pass,
 * successive neighboring pairs are compared. If a pair is not in order, its
 * values are swapped; otherwise, the values remain unchanged. The technique is
 * called a bubble sort or sinking sort because the smaller values gradually
 * “bubble” their way to the top and the larger values “sink” to the bottom.
 * Write a test program that reads in ten double numbers, invokes the method,
 * and displays the sorted numbers.
 *
 * @author martinfall
 */
public class BubbleSort {

    public static void main(String[] args) {
        final int NUMBER_OF_DOUBLE_NUMBERS = 10;
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter ten double numbers
        System.out.print("Enter ten double numbers: ");
        
        double[] list = new double[NUMBER_OF_DOUBLE_NUMBERS];
        
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextDouble();
        }
        
        // Sort the array
        double[] sortedList = bubbleSort(list);
        
        // Display the array
        System.out.println(Arrays.toString(sortedList));
    }

    /**
     * Bubble sort
     *
     * @param list
     * @return
     */
    public static double[] bubbleSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    double temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }
}
