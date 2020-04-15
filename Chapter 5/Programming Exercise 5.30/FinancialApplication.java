
import java.util.Scanner;

/**
 * ﻿(Financial application: compound value) Suppose you save $100 each month
 * into a savings account with the annual interest rate 5%. So, the monthly
 * interest rate is 0.05 / 12 = 0.00417. After the first month, the value in the
 * account becomes 100 * (1 + 0.00417) = 100.417 After the second month, the
 * value in the account becomes (100 + 100.417) * (1 + 0.00417) = 201.252 After
 * the third month, the value in the account becomes (100 + 201.252) * (1 +
 * 0.00417) = 302.507 and so on. Write a program that prompts the user to enter
 * an amount (e.g., 100), the annual interest rate (e.g., 5), and the number of
 * months (e.g., 6) and displays the amount in the savings account after the
 * given month.
 * 
 * Output:
 * Enter enter an amount (e.g., 100): 100
Enter the annual interest rate (e.g., 5): 5
Enter the number of months (e.g., 6): 6
After 0 months, the value in the account becomes $100.42
After 1 month, the value in the account becomes $201.25
After 2 month, the value in the account becomes $302.51
After 3 month, the value in the account becomes $404.18
After 4 month, the value in the account becomes $506.28
After 5 month, the value in the account becomes $608.81
 */
/**
 *
 * @author martinfall
 */
public class FinancialApplication {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter enter an amount (e.g., 100)
        System.out.print("Enter enter an amount (e.g., 100): ");
        double monthlyAmountContributed = input.nextDouble();

        // Prompt the user to enter the annual interest rate (e.g., 5)
        System.out.print("Enter the annual interest rate (e.g., 5): ");
        double interestRate = input.nextDouble();

        // Prompt the user to enter the number of months (e.g., 6)
        System.out.print("Enter the number of months (e.g., 6): ");
        int numberOfMonths = input.nextInt();

        // Calculate the monthly interest rate
        double monthlyInterestRate = (interestRate / 100) / 12;

        double accountValue = 0;

        // Loop through the number of months using a for loop
        for (int i = 0; i < numberOfMonths; i++) {
            accountValue = (monthlyAmountContributed + accountValue)
                    * (1 + monthlyInterestRate);
            System.out.print("After " + i + " month" + (i > 0 ? "" : "s") 
                    + ", the value in the account becomes ");
            System.out.printf("$%,.2f%n", accountValue);
        }
    }
}
