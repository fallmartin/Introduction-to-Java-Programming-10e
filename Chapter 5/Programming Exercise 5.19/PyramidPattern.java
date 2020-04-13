
/**
 * ﻿(Display numbers in a pyramid pattern) Write a nested for loop that prints the
 * following output: see book for figure
 * 
 * Output:
 * 
 *                                1
                           1   2   1
                       1   2   4   2   1
                   1   2   4   8   4   2   1
               1   2   4   8  16   8   4   2   1
           1   2   4   8  16  32  16   8   4   2   1
       1   2   4   8  16  32  64  32  16   8   4   2   1
   1   2   4   8  16  32  64 128  64  32  16   8   4   2   1
 */
/**
 *
 * @author martinfall
 */
public class PyramidPattern {

    public static void main(String[] args) {
        int blanks = 6; // Determine the number of empty slots before each line
        // Each slot consists of 4 spaces
        // This is an arbitrary decision
        for (int i = 0; i < 8; i++) { // For each row 
            for (int n = 0; n <= blanks; n++) { // Print empty slots
                System.out.print("    ");
            }
            for (int j = 0; j <= i; j++) { // Print the powers of 2 from 0 to i
                System.out.printf("%4d", (int) Math.pow(2, j));
            }
            for (int k = i - 1; k >= 0; k--) { // Print the powers of 2 from i - 1 to 0
                System.out.printf("%4d", (int) Math.pow(2, k));
            }
            System.out.println(); // Print a new line
            blanks--; // Decrease the number of empty slots for the new row
        }
    }
}
