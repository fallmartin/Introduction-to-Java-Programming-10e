
/**
 * (Print the characters in a string reversely) Write a recursive method that
 * displays a string reversely on the console using the following header:
 *
 * public static void reverseDisplay(String value)
 *
 * For example, reverseDisplay("abcd") displays dcba. Write a test program that
 * prompts the user to enter a string and displays its reversal.
 *
 * @author martinfall
 */
public class ReverseDisplay {

    /**
     * Displays a string reversely on the console.
     *
     * @param value
     */
    public static void reverseDisplay(String value) {
        reverseDisplay(value, value.length() - 1);
    }

    /**
     * Recursive helper method with auxiliary parameter i.
     *
     * @param value
     * @param i
     */
    public static void reverseDisplay(String value, int i) {
        if (i >= 0) { // Base case i == 0
            System.out.print(value.charAt(i));
            reverseDisplay(value, i - 1); // Recursive call
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        reverseDisplay("abcd");
    }
}
