
import java.math.BigInteger;
import java.util.Scanner;

/**
 * (Convert decimals to fractions) Write a program that prompts the user to
 * enter a decimal number and displays the number in a fraction. Hint: read the
 * decimal number as a string, extract the integer part and fractional part from
 * the string, and use the BigInteger implementation of the Rational class in
 * Programming Exercise 13.15 to obtain a rational number for the decimal
 * number. Here are some sample runs:
 *
 * Enter a decimal number: 3.25
 * The fraction number is 13/4
 *
 * Enter a decimal number: -0.45452
 * The fraction number is -11363/25000
 *
 * @author martinfall
 */
public class ConvertDecimalToFraction {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a decimal number
        System.out.print("Enter a decimal number: ");

        // Split string input in integer and decimal parts
        // The split method doesn't work with ., so we have to use \\. for regex
        String[] parts = input.nextLine().split("\\."); // Escaped special character

        // Create two Rational numbers
        Rational whole = new Rational(
                new BigInteger(parts[0]), // numerator
                BigInteger.ONE); // denominator
        Rational decimal = new Rational(
                new BigInteger(parts[1]), // numerator
                new BigInteger((int) (Math.pow(10, parts[1].length())) + "")); // denominator

        // Display the result
        System.out.println("The fraction number is " + (whole.add(decimal)));
    }
}
