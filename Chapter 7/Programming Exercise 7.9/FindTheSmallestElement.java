
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Find the smallest element) Write a method that finds the smallest element
 * in an array of double values using the following header:
 *
 * public static double min(double[] array)
 *
 * Write a test program that prompts the user to enter ten numbers, invokes this
 * method to return the minimum value, and displays the minimum value. Here is a
 * sample run of the program:
 *
 * ﻿Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2 
 * The minimum number is: 1.5
 *
 * @author martinfall
 */
public class FindTheSmallestElement {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Declare, create, and initialize a new double array
        double[] array = new double[10];

        // Prompt the user to enter ten numbers
        System.out.print("Enter ten numbers: ");

        // Populate the array
        for (int i = 0; i < 10; i++) {
            array[i] = input.nextDouble();
        }

        System.out.println("The minimum number is " + minArrays(array));
    }

    /**
     * Find the smallest element in an array of double values
     *
     * @param array
     * @return
     */
    public static double min(double[] array) {
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Find the smallest element in an array of double values using Arrays
     *
     * @param array
     * @return
     */
    public static double minArrays(double[] array) {
        Arrays.sort(array);
        return array[0];
    }
}
