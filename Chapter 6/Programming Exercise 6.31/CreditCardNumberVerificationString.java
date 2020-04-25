
import java.util.Scanner;

/**
 *
 *
 * @author martinfall
 */
public class CreditCardNumberVerificationString {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a credit card number for verification
        System.out.println("Enter a credit card number for verification: ");
        String creditCardNumber = input.nextLine();

        System.out.println(creditCardNumber
                + ((isValid(creditCardNumber)) ? " is valid" : " is invalid"));
    }

    /**
     * Check the credit card number for length, prefix, and Luhn algorithm
     *
     * @param number
     * @return
     */
    public static boolean isValid(String number) {
        return runLuhnCheck(number) && checkPrefix(number) && checkSize(number);
    }

    /**
     * Run the Luhn check
     *
     * @param number
     * @return
     */
    public static boolean runLuhnCheck(String number) {
        return ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    }

    /**
     * Get the results from step 1 and step 2
     *
     * @param number
     * @return
     */
    public static int sumOfDoubleEvenPlace(String number) {
        int sum = 0;

        for (int i = number.length() - 2; i >= 0; i -= 2) {
            int num = Integer.parseInt(number.charAt(i) + "") * 2;
            sum += num > 9 ? ((num / 10) + (num % 10)) : num;
        }
        return sum;
    }

    public static int sumOfOddPlace(String number) {
        int sum = 0;

        for (int i = number.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        return sum;
    }

    /**
     * Check the prefix of the credit card number
     *
     * @param number
     * @return
     */
    public static boolean checkPrefix(String number) {
        return (number.substring(0, 2).equals("37")
                || number.substring(0, 1).equals("4")
                || number.substring(0, 1).equals("5")
                || number.substring(0, 1).equals("6"));
    }

    /**
     * Check if credit card number is between 13 and 16 digits
     *
     * @param number
     * @return
     */
    public static boolean checkSize(String number) {
        return (number.length() >= 13 && number.length() <= 16);
    }
}
