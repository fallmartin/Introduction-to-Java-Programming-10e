
import java.util.Scanner;

/**
 * (Computer architecture: bit-level operations) A short value is stored in 16
 * bits. Write a program that prompts the user to enter a short integer and
 * displays the 16 bits for the integer. Here are sample runs:
 *
 * ﻿Enter an integer: 5 The bits are 0000000000000101
 *
 * Enter an integer: -5 The bits are 1111111111111011 The bits are
 *
 * ﻿(Hint: You need to use the bitwise right shift operator (>>) and the bitwise
 * AND operator (&), which are covered in Appendix G, Bitwise Operations.)
 * 
 * Output:
 * Enter an integer: 5
 * 000000000000101
 * 
 * Enter an integer: -5
 * 1111111111111011
 */

/**
 * x & 1 produces a value that is either 1 or 0, depending on the least
 * significant bit of x: if the last bit is 1, the result of x & 1 is 1;
 * otherwise, it is 0. This is a bitwise AND operation.
 *
 * x >>= 1 means "set x to itself shifted by one bit to the right". The
 * expression evaluates to the new value of x after the shift.
 * 
 * https://stackoverflow.com/questions/38922606/what-is-x-1-and-x-1
 */
/**
 *
 * @author martinfall
 */
public class BitLevelOperations {

    public static void main(String[] args) {
        // Create a new Scanner object 
        Scanner input = new Scanner(System.in);

        // Prompt the user to a short integer
        System.out.print("Enter an integer: ");
        short value = input.nextShort();

        // Empty string to build
        String str = "";

        for (int i = 0; i < 16; i++) {
            // Add the least significat digit to the beginning of it
            str = (value & 1) + str;
            // Shift to the right by one to get the least significant binary digit in the next pass
            // Right shift with sign extension filling with the highest bit on the left (sign)
            // a 1 bit in the left denotes a negative number
            value >>= 1; 
        }

        System.out.println(str);
    }
}
