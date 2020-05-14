
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Count occurrence of numbers) Write a program that reads the integers
 * between 1 and 100 and counts the occurrences of each. Assume the input ends
 * with 0. Here is a sample run of the program:
 *
 * Input: 2 5 6 5 4 3 23 43 2 0
 *
 * Output: 
 * 2 occurs 2 times 
 * 3 occurs 1 times 
 * 4 occurs 1 times 
 * 5 occurs 2 times 
 * 6 occurs 1 times 
 * 23 occurs 1 times 
 * 43 occurs 1 times
 *
 * @author martinfall
 */
public class Counter {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Populate the array by passing the Scanner object to a method
        int[] counter = populateCounter(input);

        // Print the counter
        printCounter(counter);
    }

    public static void printCounter(int[] counter) {
        for (int i = 0; i < 100; i++) {
            if (counter[i] > 0) {
                System.out.println((i + 1) + " occurs " + counter[i] + " times");
            }
        }
    }

    public static int[] populateCounter(Scanner input) {
        // Declare, create, and initialize a counter array
        int[] counter = new int[100];

        // Create a variable to hold each integer as it is processed
        int number;

        // Prompt the user to enter a list of integers between 1 and 100
        System.out.print("Enter the integers between 1 and 100: ");
        do {
            number = input.nextInt();
            if (number >= 1 && number <= 100) {
                counter[number - 1]++;
            }

        } while (number != 0);
        return counter;
    }
}
