
import java.util.Scanner;

/**
 * (Display pyramid) Write a program that prompts the user to enter an integer
 * from 1 to 15 and displays a pyramid, as shown in the following sample run:
 * See textbook
 * 
 * Output:
 * 
 * Enter an integer from 1 to 15: 8
                1 
              1 2 1 
            1 2 3 2 1 
          1 2 3 4 3 2 1 
        1 2 3 4 5 4 3 2 1 
      1 2 3 4 5 6 5 4 3 2 1 
    1 2 3 4 5 6 7 6 5 4 3 2 1 
  1 2 3 4 5 6 7 8 7 6 5 4 3 2 1 
 */

/**
 *
 * @author martinfall
 */
public class DisplayPyramid {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt user to enter an integer from 1 to 15
        System.out.print("Enter an integer from 1 to 15: ");
        int number = input.nextInt();
        
        // Variable blanks controls the space before the first number of each line
        int blanks = number - 1;
        
        for (int i = 1; i <= number; i++) { // row control
            // Print white spaces before every row as needed
            for (int n = 0; n <= blanks; n++) {
                System.out.print("  ");
            }
            // Print numbers from 1 to i
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + " ");
            }
            // print numbers from i - 1 to 1
            for (int k = i - 1; k > 0; k--) {
                System.out.print(k + " ");
            }
            System.out.println();
            blanks--;
        }
    }
}
