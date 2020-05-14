
import java.util.Scanner;

/**
 * ﻿(Reverse the numbers entered) Write a program that reads ten integers and
 * displays them in the reverse of the order in which they were read.
 *
 * @author martinfall
 */
public class Reverse {

    public static void main(String[] args) {
        // Declare the constant variable for the number of integers
        final int NUMBER_OF_INTEGERS = 10;
        
        // Declare, create, and initialize an integer array 
        int[] list = new int[NUMBER_OF_INTEGERS];
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter 10 integers
        System.out.print("Enter 10 integers: ");
        
        // Populate the array
        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            list[i] = input.nextInt();
        }
        
        // Display the array elemnts in the reverse order they were entered
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i] + " ");
        }
    }
}
