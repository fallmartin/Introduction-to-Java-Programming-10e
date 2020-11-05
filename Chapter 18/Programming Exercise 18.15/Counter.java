
import java.util.*;

/**
 * (Occurrences of a specified character in a string) Rewrite Programming
 * Exercise 18.10 using a helper method to pass the substring high index to the
 * method. The helper method header is:
 *
 * public static int count(String str, char a, int high)
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
        return count(str, a, str.length() - 1); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameter high.
     *
     * @param str
     * @param a
     * @param high
     * @return
     */
    public static int count(String str, char a, int high) {
        if (high < 0) { // Base case
            return 0;
        } else if (str.charAt(high) == a) {
            return 1 + count(str, a, high - 1);
        } else {
            return count(str, a, high - 1);
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
