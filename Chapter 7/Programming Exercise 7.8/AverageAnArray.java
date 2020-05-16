
import java.util.Scanner;

/**
 * (Average an array) Write two overloaded methods that return the average of
 * an array with the following headers:
 *
 * public static int average(int[] array) 
 * public static double average(double[] array)
 *
 * Write a test program that prompts the user to enter ten double values,
 * invokes this method, and displays the average value.
 * 
 * Enter ten double values: 1 2 3 4 5 6 7 8 9 0
 * The average value is 4.5
 *
 * @author martinfall
 */
public class AverageAnArray {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Declare, create, and initialize a new array
        double[] array = new double[10];

        // Prompt the user to enter ten double values
        System.out.print("Enter ten double values: ");

        for (int i = 0; i < 10; i++) {
            array[i] = input.nextDouble();
        }
        
        // Display the average
        System.out.println("The average value is " + average(array));
    }

    /**
     * Calculate the average of an array
     *
     * @param array
     * @return
     */
    public static int average(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    /**
     * Calculate the average of an array
     *
     * @param array
     * @return
     */
    public static double average(double[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }
}
