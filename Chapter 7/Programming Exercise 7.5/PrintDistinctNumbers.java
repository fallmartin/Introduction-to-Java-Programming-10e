
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Print distinct numbers) Write a program that reads in ten numbers and
 * displays the number of distinct numbers and the distinct numbers separated by
 * exactly one space (i.e., if a number appears multiple times, it is displayed
 * only once). (Hint: Read a number and store it to an array if it is new. If
 * the number is already in the array, ignore it.) After the input, the array
 * contains the distinct numbers. Here is the sample run of the program:
 *
 * Assumptions: Integers are greater than 0
 *
 * @author martinfall
 */
public class PrintDistinctNumbers {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");

        // Populate array
        int[] array = populateArray();

        // Count and display distinct number
        count(array);

        // Display the results
        displayResults(array);
    }

    /**
     * Populate the array
     *
     * @return
     */
    public static int[] populateArray() {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array
        int[] array = new int[10];

        // 
        int number;

        // Loop through the array and populate it
        for (int i = 0; i < array.length; i++) {
            number = input.nextInt();

            if (isDistinct(array, number)) {
                array[i] = number;
            }
        }

        return array;
    }

    /**
     * Check if the number is distinct and return true if it is
     *
     * @param array
     * @param number
     * @return
     */
    public static boolean isDistinct(int[] array, int number) {
        boolean flag = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                flag = false;
            }
        }

        return flag;
    }

    /**
     * Count and display the number of distinct numbers in the array
     *
     * @param array
     */
    public static void count(int[] array) {
        String format = "The number of distinct number is %d%n";
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                counter++;
            }
        }
        // Display the results
        System.out.printf(format, counter);
    }

    /**
     * Display the results in the format specified by the textbook
     *
     * @param array
     */
    public static void displayResults(int[] array) {
        System.out.print("The distinct numbers are: ");

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
