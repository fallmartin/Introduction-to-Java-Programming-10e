
import java.util.Scanner;

/**
 * ﻿(Find the factors of an integer) Write a program that reads an integer and
 * displays all its smallest factors in increasing order. For example, if the
 * input integer is 120, the output should be as follows: 2, 2, 2, 3, 5.
 * 
 * Output:
 * 
 * Enter an integer: 120
 * The ﻿smallest factors of 120 in increasing order are 2, 2, 2, 3, 5
 */
/**
 *
 * @author martinfall
 */
public class FactorsOfAnInteger {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        System.out.print("The ﻿smallest factors of " + number + " in increasing order are ");

        for (int i = 2; number != 1;) { // Start at 2 at work your way up
            if (number % i == 0) { // if number is a factor
                System.out.print((number / i != 1) ? i + ", " : i); // display it to console
                number /= i; // divide the number by factor and assign to variable
            } else { // if number is not a factor
                i++; // increment number and try again
            }
        }
    }
}
