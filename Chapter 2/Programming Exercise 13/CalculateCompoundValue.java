/*
(Financial application: compound value) Suppose you save $100 each month
into a savings account with the annual interest rate 5%. Thus, the monthly interest
rate is 0.05/12 = 0.00417. After the first month, the value in the account
becomes

100 * (1 + 0.00417) = 100.417

After the second month, the value in the account becomes

(100 + 100.417) * (1 + 0.00417) = 201.252

After the third month, the value in the account becomes

(100 + 201.252) * (1 + 0.00417) = 302.507

and so on.

Write a program that prompts the user to enter a monthly saving amount and
displays the account value after the sixth month. (In Exercise 5.30, you will use a
loop to simplify the code and display the account value for any month.)

Enter the monthly saving amount: 100
After the sixth month, the account value is $608.81

Actual output:
Enter the monthly saving amount: 100
After the sixth month, the account value is $608.811017705596
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CalculateCompoundValue {
    public static void main(String[] args) {
        final double ANNUAL_INTEREST_RATE = 0.05;
        double monthlyInterestRate = ANNUAL_INTEREST_RATE / 12;
        double accountValue = 0;
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the monthly saving amount
        System.out.print("Enter the monthly saving amount: ");
        double amount = input.nextDouble();
        
        // Calculate the value of the account after six months
        for (int i = 0; i < 6; i++) {
            accountValue = (amount + accountValue) * (1 + monthlyInterestRate);
        }
        
        // Display the account value
        System.out.println("After the sixth month, the account value is $" + 
                accountValue);
    }
}
