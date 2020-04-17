
import java.util.Scanner;

/**
 * (Statistics: compute mean and standard deviation) In business applications,
 * you are often asked to compute the mean and standard deviation of data. The
 * mean is simply the average of the numbers. The standard deviation is a
 * statistic that tells you how tightly all the various data are clustered
 * around the mean in a set of data. For example, what is the average age of the
 * students in a class? How close are the ages? If all the students are the same
 * age, the deviation is 0. Write a program that prompts the user to enter ten
 * numbers, and displays the mean and standard deviations of these numbers using
 * the following formula: see textbook
 * 
 * Output:
 * 
 * Enter ten numbers: 1 2 3 4.5 5.6 6 7 8 9 10
 * The mean is 5.61
 * The standard deviation is 2.99794
 */
/**
 *
 * @author martinfall
 */
public class MeanAndStandardDeviation {

    public static void main(String[] args) {
        // Create and initialize the variables to hold sum and sum^2
        double sum = 0, sumOfSquares = 0;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter ten number
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < 10; i++) {
            double number = input.nextDouble();

            sum += number;
            sumOfSquares += Math.pow(number, 2);
        }

        // Calculate the mean and deviation values and store in double variables
        double mean = sum / 10;
        double deviation = Math.sqrt(((sumOfSquares - (Math.pow(sum, 2) / 10)) / 9));

        System.out.println("The mean is " + mean);
        System.out.printf("The standard deviation is %.5f", deviation);
    }
}
