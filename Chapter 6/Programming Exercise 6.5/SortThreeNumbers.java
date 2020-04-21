
import java.util.Scanner;

/**
 * ﻿(Sort three numbers) Write a method with the following header to display
 * three numbers in increasing order:
 *
 * public static void displaySortedNumbers(double num1, double num2, double
 * num3)
 *
 * ﻿Write a test program that prompts the user to enter three numbers and
 * invokes the method to display them in increasing order.
 */
/**
 *
 * @author martinfall
 */
public class SortThreeNumbers {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three numbers
        System.out.print("Enter three numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        displaySortedNumbers(num1, num2, num3);
    }

    /**
     * Display three numbers in increasing order. This implementation doesn't
     * use any conditional statements.
     *
     * @param num1
     * @param num2
     * @param num3
     */
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        double min = Math.min(Math.min(num1, num2), num3);
        double max = Math.max(Math.max(num1, num2), num3);
        double middle = (num1 + num2 + num3) - max - min;
        System.out.println(min + " " + middle + " " + max);
    }
}
