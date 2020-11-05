
import java.util.Random;
import java.util.Scanner;

/**
 * (Print the digits in an integer reversely) Write a recursive method that
 * displays an int value reversely on the console using the following header:
 *
 * public static void reverseDisplay(int value)
 *
 * For example, reverseDisplay(12345) displays 54321. Write a test program that
 * prompts the user to enter an integer and displays its reversal.
 *
 * Output:
 * Number:	647892438
 * Reversed:	834298746
 *
 * Number:	1321193204
 * Reversed:	4023911231
 *
 * Number:	2040372578
 * Reversed:	8752730402
 *
 * Number:	500680498
 * Reversed:	894086005
 *
 * Number:	381105692
 * Reversed:	296501183
 *
 * Number:	242788731
 * Reversed:	137887242
 *
 * Number:	1442905877
 * Reversed:	7785092441
 *
 * Number:	1149374088
 * Reversed:	8804739411
 *
 * Number:	1250863147
 * Reversed:	7413680521
 *
 * Number:	1583673975
 * Reversed:	5793763851
 *
 * @author martinfall
 */
public class ReverseDisplay {

    /**
     * Displays an int value reversely on the console.
     *
     * @param value
     */
    public static void reverseDisplay(int value) {
        if (value / 10 == 0) {
            System.out.print(value);
        } else {
            System.out.print(value % 10);
            reverseDisplay(value / 10);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // Generate a random integer at each pass of the for loop
            Random r = new Random();
            int random = r.nextInt(Integer.MAX_VALUE);

            // Display the integer and its reversed value in the console
            System.out.println("Number:\t\t" + random);
            System.out.print("Reversed:\t");
            reverseDisplay(random);

            // Formatting line
            System.out.println();
            System.out.println();
        }
    }
}
