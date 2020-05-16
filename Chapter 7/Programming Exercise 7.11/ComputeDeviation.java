
import java.util.Scanner;

/**
 * (Statistics: compute deviation) Programming Exercise 5.45 computes the
 * standard deviation of numbers. This exercise uses a different but equivalent
 * formula to compute the standard deviation of n numbers.
 *
 * To compute the standard deviation with this formula, you have to store the
 * individual numbers using an array, so that they can be used after the mean is
 * obtained.
 *
 * Your program should contain the following methods:
 *
 * Compute the deviation of double values public static double
 * deviation(double[] x)
 *
 * Compute the mean of an array of double values public static double
 * mean(double[] x)
 *
 * Write a test program that prompts the user to enter ten numbers and displays
 * the mean and standard deviation, as shown in the following sample run:
 *
 * Enter ten numbers: 1.9 2.5 3.7 2 1 6 3 4 5 2 
 * The mean is 3.1100000000000003
 * The standard deviation is 1.5573838462127583
 *
 * @author martinfall
 */
public class ComputeDeviation {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Declare, create, and initialize a new double array
        double[] array = new double[10];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextDouble();
        }

        // Display the results
        System.out.println("The mean is " + mean(array));
        System.out.println("The standard deviation is " + deviation(array));
    }

    /**
     * Compute the deviation of double values
     *
     * @param x
     * @return
     */
    public static double deviation(double[] x) {
        double numerator = 0;
        double mean = mean(x);

        for (int i = 0; i < x.length; i++) {
            numerator += Math.pow((x[i] - mean), 2);
        }

        return Math.sqrt(numerator / (x.length - 1));
    }

    /**
     * Compute the mean of an array of double values
     *
     * @param x
     * @return
     */
    public static double mean(double[] x) {
        double sum = 0;

        for (double number : x) {
            sum += number;
        }

        return sum / x.length;
    }
}
