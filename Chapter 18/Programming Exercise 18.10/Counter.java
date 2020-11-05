
import java.util.*;

/**
 * (Occurrences of a specified character in a string) Write a recursive method
 * that finds the number of occurrences of a specified letter in a string using
 * the following method header:
 *
 * public static int count(String str, char a)
 *
 * For example, count("Welcome", 'e') returns 2. Write a test program that
 * prompts the user to enter a string and a character, and displays the number
 * of occurrences for the character in the string.
 *
 * Output:
 * Enter a string: Welcome
 * Enter a character: e
 *
 * The character e appears 2 times in "Welcome"
 *
 *
 * @author martinfall
 */
public class Counter {

    /**
     * Finds the number of occurrences of a specified letter in a string.
     *
     * @param str
     * @param a
     * @return
     */
    public static int count(String str, char a) {
        return count(str, a, 0, 0); // Auxiliary call
    }

    /**
     * Recursive helper method with auxiliary parameter i.
     *
     * @param str
     * @param a
     * @param i
     * @param result
     * @return
     */
    public static int count(String str, char a, int i, int result) {
        if (i == str.length()) { // Base case
            return result;
        } else {
            if (Character.toLowerCase(str.charAt(i))
                    == Character.toLowerCase(a)) {
                result++;
            }
            return count(str, a, i + 1, result);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter a character: ");
        char a = input.nextLine().charAt(0);

        int i = count(str, a);
        System.out.println("\nThe character " + a + " appears " + i
                + " times in \"" + str + "\"");
    }
}
