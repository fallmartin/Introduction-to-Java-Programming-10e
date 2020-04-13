
/**
 * ﻿(Display four patterns using loops) Use nested loops that display the
 * following patterns in four separate programs:
 * 
 * Output:
 * 
 * Pattern A
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
1 2 3 4 5 6 

Pattern B
1 2 3 4 5 6 
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 

Pattern C
          1 
        1 2 
      1 2 3 
    1 2 3 4 
  1 2 3 4 5 
1 2 3 4 5 6 

Pattern D
1 2 3 4 5 6 
  1 2 3 4 5 
    1 2 3 4 
      1 2 3 
        1 2 
          1 
 */
/**
 *
 * @author martinfall
 */
public class Patterns {

    public static void main(String[] args) {
        // Pattern A
        System.out.println("Pattern A");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println(); // New line

        // Pattern B
        System.out.println("Pattern B");
        for (int i = 6; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println(); // New line

        // Pattern C
        System.out.println("Pattern C");
        int blanks = 5;
        for (int i = 1; i <= 6; i++) {
            // Print whitespaces
            for (int n = blanks; n > 0; n--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            blanks--;
        }

        System.out.println(); // New line

        // Pattern D
        System.out.println("Pattern D");
        blanks = 0;
        for (int i = 6; i >= 1; i--) {
            // Print whitespaces 
            for (int n = 0; n < blanks; n++) {
                System.out.print("  ");
            }
            
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            blanks++;
        }
    }
}
