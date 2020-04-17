
import java.util.Scanner;

/**
 * ﻿(Process string) Write a program that prompts the user to enter a string and
 * displays the characters at odd positions. Here is a sample run:
 *
 * ﻿Enter a string: Beijing Chicago 
 * BiigCiao
 * 
 * Output:
 * Enter a string: Beijing Chicago
 * BiigCiao
 */
/**
 *
 * @author martinfall
 */
public class ProcessString {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        // Display the characters at odd positions using a conditional statement
        for (int i = 0; i < str.length(); i++) {
            System.out.print(i % 2 == 0 ? str.charAt(i) : "");
        }
    }
}
