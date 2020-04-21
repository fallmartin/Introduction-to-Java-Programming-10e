
import java.util.Scanner;


/**
 * ﻿(Display an integer reversed) Write a method with the following header to
 * display an integer in reverse order:
 *
 * public static void reverse(int number)
 *
 * For example, reverse(3456) displays 6543. Write a test program that prompts
 * the user to enter an integer and displays its reversal.
 * 
 * Output:
 * Enter an integer: 12345
 * 12345 in reverse order is 54321
 */
/**
 *
 * @author martinfall
 */
public class ReverseInteger {

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        System.out.print(number + " in reverse order is ");
        reverse(number);
    }
    
    /**
     * Display an integer in reverse order
     *
     * @param number
     */
    public static void reverse(int number) {
        String reverse = "";
        
        while(number > 0) {
            reverse = reverse + number % 10;
            number /= 10;
        }
        
        System.out.println(reverse);
    }
}
