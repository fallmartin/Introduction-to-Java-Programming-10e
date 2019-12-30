
/**
 * (Financial: compare costs) Suppose you shop for rice in two different packages.
 * You would like to write a program to compare the cost. The program prompts the
 * user to enter the weight and price of the each package and displays the one with
 * the better price. Here is a sample run:
 *
 * Enter weight and price for package 1: 50 24.59
 * Enter weight and price for package 2: 25 11.99
 * Package 2 has a better price.
 *
 * Enter weight and price for package 1: 50 25
 * Enter weight and price for package 2: 25 12.5
 * Two packages have the same price.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FinancialCompareCosts {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter weight and price for package 1
        System.out.print("Enter weight and price for package 1: ");

        // Collect input from the user
        double weight1 = input.nextDouble();
        double price1 = input.nextDouble();

        // Prompt the user to enter weight and price for package 2
        System.out.print("Enter weight and price for package 2: ");

        // Collect input from the user
        double weight2 = input.nextDouble();
        double price2 = input.nextDouble();

        // Compare the price per unit of weight for both packages
        if ((weight1 / price1) > (weight2 / price2)) {
            System.out.println("Package 1 has a better price.");
        } else if ((weight1 / price1) == (weight2 / price2)) {
            System.out.println("Two packages have the same price.");
        } else {
            System.out.println("Package 2 has a better price.");
        }

    }
}
