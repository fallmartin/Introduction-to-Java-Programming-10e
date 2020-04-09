/*
 * Output:

Enter the integer, the input ends if it is 0: 1 2 -1 3 0
The number of positives is 3
The number of negatives is 1
The total is 5.0
The average is 1.25

Enter the integer, the input ends if it is 0: 0
No numbers are entered except 0
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class AverageOfNumbers {

    public static void main(String[] args) {
        // Declare variables
        float sum = 0; // Sum initialized at 0
        int countPositiveNumbers = 0; // Count positive numbers
        int countNegativeNumbers = 0; // Count negative numbers
        int number; // Variable to hold integer for user input

        // Create a new Scanner input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter the integer, the input ends if it is 0: ");

        // Use a do-while loop to execute at least once, allowing us to test for
        // 0 sentinel value
        do {
            number = input.nextInt(); // Collect input
            sum += number; // Add input to sum, if 0 then nothing changes
            // This allows us to test if the first integer input is 0 later

            if (number < 0) { // if input is negative
                countNegativeNumbers++; // increment negatives counter
            } else if (number > 0) { // if input is positive
                countPositiveNumbers++; // increment positives counter
            } else { // if input is 0
                break; // break out of the loop structure
            }
        } while (number != 0); // loop continuation condition

        // Display the results
        if (sum == 0) {
            System.out.println("No numbers are entered except 0");
        } else {
            System.out.println("The number of positives is " + countPositiveNumbers);
            System.out.println("The number of negatives is " + countNegativeNumbers);
            System.out.println("The total is " + sum);
            System.out.println("The average is " + sum / (countNegativeNumbers + countPositiveNumbers));
        }
    }
}
