
import java.util.Scanner;

/**
 * (Find the index of the smallest element) Write a method that returns the
 * index of the smallest element in an array of integers. If the number of such
 * elements is greater than 1, return the smallest index. Use the following
 * header:
 *
 * public static int indexOfSmallestElement(double[] array)
 *
 * Write a test program that prompts the user to enter ten numbers, invokes this
 * method to return the index of the smallest element, and displays the index.
 *
 * @author martinfall
 */
public class IndexOfSmallestElement {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Declare, create, and initialize a new double array
        double[] array = new double[10];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");
        
        for (int i = 0; i < 10; i++) {
            array[i] = input.nextDouble();
        }

        // Display the results
        System.out.println("The index of the smallest element is "
                + indexOfSmallestElement(array));
    }

    /**
     * Return the index of the smallest element in an array of integers
     *
     * @param array
     * @return
     */
    public static int indexOfSmallestElement(double[] array) {
        int minIndex = 0;
        double min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
