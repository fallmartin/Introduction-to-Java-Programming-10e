
import java.util.Scanner;

/**
 * (Find the number of uppercase letters in an array) Write a recursive method
 * to return the number of uppercase letters in an array of characters. You need
 * to define the following two methods. The second one is a recursive helper
 * method.
 *
 * public static int count(char[] chars)
 * public static int count(char[] chars, int high)
 *
 * Write a test program that prompts the user to enter a list of characters in
 * one line and displays the number of uppercase letters in the list.
 *
 * Output:
 * Enter a list of characters: ThE qUiCk BrOwN fOx JuMpS oVeR tHe LaZy DoG.
 * 18 uppercase letters found.
 *
 * @author martinfall
 */
public class FindUppercaseLetters {

    /**
     * Return the number of uppercase letters in an array of characters.
     *
     * @param chars
     * @return
     */
    public static int count(char[] chars) {
        return count(chars, chars.length - 1); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameters.
     *
     * @param chars
     * @param high
     * @return
     */
    public static int count(char[] chars, int high) {
        if (high < 0) { // Base case
            return 0;
        } else if (Character.isUpperCase(chars[high])) {
            return 1 + count(chars, high - 1); // Recursive call
        } else {
            return count(chars, high - 1); // Recursive call
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
        System.out.print("Enter a list of characters: ");
        String str = input.nextLine();
        char[] list = str.toCharArray();

        System.out.println(count(list) + " uppercase letters found.");
    }
}
