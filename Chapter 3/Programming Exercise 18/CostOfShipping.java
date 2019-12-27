
/**
 * (Cost of shipping) A shipping company uses the following function to calculate
 * the cost (in dollars) of shipping based on the weight of the package (in pounds).
 *
 * c(w) = 3.5, if 0 < w <= 1
 * c(w) = 5.5, if 1 < w <= 3
 * c(w) = 8.5, if 3 < w <= 10
 * c(w) = 10.5, if 10 < w <= 20
 *
 * Write a program that prompts the user to enter the weight of the package and
 * display the shipping cost. If the weight is greater than 50, display a message
 * “the package cannot be shipped.”
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CostOfShipping {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the weight of the package
        System.out.print("Enter the weight of the package: ");

        // Collect input from the user
        double packageWeight = input.nextDouble();

        // Create a costOfShipping variable
        double costOfShipping = 0;

        // c(w) = 3.5, if 0 < w <= 1
        if (packageWeight > 0 && packageWeight <= 1) {
            costOfShipping = packageWeight * 3.5;
        } //* c(w) = 5.5, if 1 < w <= 3
        else if (packageWeight > 1 && packageWeight <= 3) {
            costOfShipping = packageWeight * 5.5;
        } // c(w) = 8.5, if 3 < w <= 10
        else if (packageWeight > 3 && packageWeight <= 10) {
            costOfShipping = packageWeight * 8.5;
        } // c(w) = 10.5, if 10 < w <= 20
        else if (packageWeight > 10 && packageWeight <= 20) {
            costOfShipping = packageWeight * 10.5;
        } // If the weight is greater than 50, display a message 
        // “the package cannot be shipped.”
        else if (packageWeight > 50) {
            System.out.println("The package cannot be shipped.");
        }

        // Display the cost of shipping
        System.out.println("The shipping cost is $" + costOfShipping);
    }
}
