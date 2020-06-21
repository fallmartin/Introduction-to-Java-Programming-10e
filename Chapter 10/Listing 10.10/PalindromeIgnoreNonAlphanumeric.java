
import java.util.Scanner;

/**
 * Output:
 * Enter a string: ab<c>cb?a
 * Ignoring nonalphanumerical characters,
 * is ab<c>cb?a a palindrome? true
 *
 * Enter a string: abcc><?cab
 * Ignoring nonalphanumerical characters,
 * is abcc><?cab a palindrome? false
 *
 * @author martinfall
 */
public class PalindromeIgnoreNonAlphanumeric {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a String
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        // Display result
        System.out.println("Ignoring nonalphanumerical characters, \nis "
                + s + " a palindrome? " + isPalindrome(s));
    }

    /**
     * Return true if a string is a palindrome
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // Create a new string by eliminating nonalphanumeric characters
        String s1 = filter(s);

        // Create a new String that is the reversal of s1
        String s2 = reverse(s1);

        // Check if the reversal is the same as the original string
        return s2.equals(s1);
    }

    /**
     * Create a new string by eliminating nonalphanumeric chars
     *
     * @param s
     * @return
     */
    public static String filter(String s) {
        // Create a string builder
        StringBuilder stringBuilder = new StringBuilder();

        // Examine each char in the string to skip alphanumeric char
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }

        // Return a new filtered string
        return stringBuilder.toString();
    }

    /**
     * Create a new string by reversing a specified string
     *
     * @param s
     * @return
     */
    public static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
