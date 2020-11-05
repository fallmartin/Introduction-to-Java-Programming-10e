
import java.util.Scanner;

/**
 * (Print the characters in a string reversely) Rewrite Programming Exercise
 * 18.9 using a helper method to pass the substring high index to the method.
 * The helper method header is:
 *
 * public static void reverseDisplay(String value, int high)
 *
 * Output:
 * Enter a string: "Hello, World!"
 * Reverse string: "!dlroW ,olleH"
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
        reverseDisplay(value, value.length() - 1); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameter high.
     *
     * @param value
     * @param high
     */
    public static void reverseDisplay(String value, int high) {
        if (high >= 0) { // Base case i == 0
            System.out.print(value.charAt(high));
            reverseDisplay(value, high - 1); // Recursive call
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

        System.out.print("Reverse string: ");
        reverseDisplay(str);
        System.out.println(); // Formatting line
    }
}
