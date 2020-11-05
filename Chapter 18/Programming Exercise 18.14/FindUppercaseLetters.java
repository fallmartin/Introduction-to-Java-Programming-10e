
import java.util.Scanner;

/**
 * (Find the number of uppercase letters in a string) Write a recursive method
 * to return the number of uppercase letters in a string. Write a test program
 * that prompts the user to enter a string and displays the number of uppercase
 * letters in the string.
 *
 * Output:
 * Enter a string: ThE qUiCk BrOwN fOx JuMpS oVeR tHe LaZy DoG.
 * 18 uppercase letters found.
 *
 * @author martinfall
 */
public class FindUppercaseLetters {

    /**
     * Returns the number of uppercase letters in a string.
     *
     * @param str
     * @return
     */
    public static int countUppercase(String str) {
        return countUppercase(str, 0, 0); // Call auxiliary method.
    }

    /**
     * Recursive helper method with auxiliary parameter counter.
     *
     * @param str
     * @param counter
     * @return
     */
    public static int countUppercase(String str, int index, int counter) {
        if (index == str.length()) {
            return counter;
        } else {
            if (Character.isUpperCase(str.charAt(index))) {
                counter++;
            }
            return countUppercase(str, index + 1, counter);
        }
    }

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        input.close(); // Close the scanner to prevent resource leak

        // Display the results for ThE qUiCk BrOwN fOx JuMpS oVeR tHe LaZy DoG.
        System.out.println(countUppercase(str) + " uppercase letters found.");
    }
}
