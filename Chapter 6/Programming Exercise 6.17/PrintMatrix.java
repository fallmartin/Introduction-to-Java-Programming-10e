
import java.util.Scanner;


/**
 * ﻿(Display matrix of 0s and 1s) Write a method that displays an n-by-n matrix
 * using the following header:
 *
 * public static void printMatrix(int n)
 *
 * Each element is 0 or 1, which is generated randomly. Write a test program that
 * prompts the user to enter n and displays an n-by-n matrix. Here is a sample run:
 *
 * ﻿Enter n: 3
 * 0 1 0
 * 0 0 0
 * 1 1 1
 *
 * @author martinfall
 */
public class PrintMatrix {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter n
        System.out.print("Enter n: ");
        int n = input.nextInt();
        
        // Display the n-by-n matrix
        printMatrix(n);
    }

    /**
     * Display an n-by-n matrix
     * @param n
     */
    public static void printMatrix(int n) {
        // Outer loop
        for (int i = 0; i < n; i++) {
            // Inner loop
            for (int j = 0; j < n; j++) {
                // Generate a random int between 0 and 1
                System.out.print((int) (Math.random() * 2) + " ");
                
                // Print a new line at the end of each row
                if (j == n - 1) {
                    System.out.println();
                }
            }
        }
    }
}
