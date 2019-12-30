
/**
 * (Financials: currency exchange) Write a program that prompts the user to enter
 * the exchange rate from currency in U.S. dollars to Chinese RMB. Prompt the user
 * to enter 0 to convert from U.S. dollars to Chinese RMB and 1 to convert from
 * Chinese RMB and U.S. dollars. Prompt the user to enter the amount in
 * U.S. dollars or Chinese RMB to convert it to Chinese RMB or U.S. dollars,
 * respectively. Here are the sample runs:
 *
 * Enter the exchange rate from dollars to RMB: 6.81
 * Enter 0 to convert dollars to RMB and 1 vice versa: 0
 * Enter the dollar amount: 100
 * $100.0 is 681.0 yuan
 *
 * Enter the exchange rate from dollars to RMB: 6.81
 * Enter 0 to convert dollars to RMB and 1 vice versa: 1
 * Enter the RMB amount: 10000
 * 10000.0 yuan is $1468.43
 *
 * Enter the exchange rate from dollars to RMB: 6.81
 * Enter 0 to convert dollars to RMB and 1 vice versa: 5
 * Incorrect input
 */
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FinancialsCurrencyExchange {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the exchange rate from dollars to RMB
        System.out.print("Enter the exchange rate from dollars to RMB: ");

        // Collect input from the user
        double exchangeRate = input.nextDouble();

        // Prompt the user to enter 0 to convert dollars to RMB and 1 vice versa
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");

        // Collect input from the user
        int choice = input.nextInt();

        // Catch incorrect input from user from choice variable
        // Only 1 and 0 are allowed
        if (choice != 0 && choice != 1) {
            System.out.println("Incorrect input");
            // Terminate JVM 
            System.exit(0);
        } else {
            if (choice == 0) {
                // Prompt the user to enter the dollar amount
                System.out.print("Enter the dollar amount: ");

                // Collect input from the user
                double dollarAmount = input.nextDouble();

                // Display the results
                System.out.println("$" + String.format(Locale.US, "%.2f", dollarAmount) 
                        + " is "
                        + String.format(Locale.US, "%.2f", dollarAmount * exchangeRate) 
                        + " yuan");
            } else if (choice == 1) {
                // Prompt the user to enter the RMB amount
                System.out.print("Enter the RMB amount: ");

                // Collect input from the user
                double RMBAmount = input.nextDouble();

                // Display the results
                System.out.println(String.format(Locale.US, "%.2f", RMBAmount)
                        + " yuan is $"
                        + String.format(Locale.US, "%.2f", RMBAmount / exchangeRate));
            }
        }
    }
}
