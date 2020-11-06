
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Occurrences of a specified character in an array) Write a recursive method
 * that finds the number of occurrences of a specified character in an array.
 * You need to define the following two methods. The second one is a recursive
 * helper method.
 *
 * public static int count(char[] chars, char ch)
 * public static int count(char[] chars, char ch, int high)
 *
 * Write a test program that prompts the user to enter a list of characters in
 * one line, and a character, and displays the number of occurrences of the
 * character in the list.
 *
 * Output:
 * Enter a list of characters in one line: Welcome
 * Enter a character: e
 * The character e appears 2 times in [W, e, l, c, o, m, e]
 *
 * @author martinfall
 */
public class Counter {

    /**
     * Returns the number of occurrences of a specified character in an array.
     *
     * @param chars
     * @param ch
     * @return
     */
    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameter high.
     *
     * @param chars
     * @param ch
     * @param high
     * @return
     */
    public static int count(char[] chars, char ch, int high) {
        if (high < 0) { // Base case
            return 0;
        } else if (chars[high] == ch) {
            return 1 + count(chars, ch, high - 1); // Recursive call
        } else {
            return count(chars, ch, high - 1); // Recursive call
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a list of characters in one line: ");
        char[] chars = input.nextLine().toCharArray();
        System.out.print("Enter a character: ");
        char ch = input.nextLine().charAt(0);

        // 
        int times = count(chars, ch);

        // Display the results
        System.out.println("The character " + ch + " appears " + times
                + " times in " + Arrays.toString(chars));
    }
}
