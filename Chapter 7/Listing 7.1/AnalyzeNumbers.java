
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class AnalyzeNumbers {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of items
        System.out.print("Enter the number of items: ");
        int n = input.nextInt();

        // Declare the array reference variable, create the array, and assign its 
        // reference to the array reference variable
        double[] numbers = new double[n];
        double sum = 0; // Declare and initialize sum to 0

        // Populate the array
        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextDouble(); // Collect an element
            sum += numbers[i]; // Add it to sum
        }

        // Determine the average
        double average = sum / n;

        int count = 0; // Counter variable for the number of elements above average

        // Check each array element for above average requirement
        for (int i = 0; i < n; i++) {
            if (numbers[i] > average) {
                count++;
            }
        }

        // Display the results
        System.out.println("Average is " + average);
        System.out.println("Number of elements above the average is "
                + count);
    }
}
