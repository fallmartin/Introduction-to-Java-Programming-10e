
import java.util.Scanner;

/**
 * ﻿(Occurrence of max numbers) Write a program that reads integers, finds the
 * largest of them, and counts its occurrences. Assume that the input ends with
 * number 0. Suppose that you entered 3 5 2 5 5 5 0; the program finds that the
 * largest is 5 and the occurrence count for 5 is 4. (Hint: Maintain two
 * variables, max and count. max stores the current max number, and count stores
 * its occurrences. Initially, assign the first number to max and 1 to count.
 * Compare each subsequent number with max. If the number is greater than max,
 * assign it to max and reset count to 1. If the number is equal to max,
 * increment count by 1.)
 * 
 * Output:
 * Enter a number: 3
Enter a number: 5
Enter a number: 2
Enter a number: 5
Enter a number: 5
Enter a number: 5
Enter a number: 0
The largest integer is 5 and it occurs 4 times.
 */
/**
 *
 * @author martinfall
 */
public class OccurrenceOfMaxNumbers {

    public static void main(String[] args) {
        // Create two variables max and count
        int max, count;

        // Create a variable to hold a number temporarily while evaluated
        int number;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        number = input.nextInt();

        // Assign the first number to max and 1 to count
        max = number;
        count = 1;

        // Compare each subsequent number with max
        while (number != 0) {
            System.out.print("Enter a number: ");
            number = input.nextInt();

            // If the number is greater than max, assign it to max and reset count to 1. 
            if (number > max) {
                max = number;
                count = 1;
            } // If the number is equal to max, increment count by 1.)
            else if (number == max) {
                count++;
            }
        }
        System.out.printf("The largest integer is %d and it occurs %d times.", max, count);
    }
}
