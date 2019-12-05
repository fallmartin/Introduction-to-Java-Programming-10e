/*
 * (Financial application: calculate future investment value) Write a program that
reads in investment amount, annual interest rate, and number of years, and displays
the future investment value using the following formula:

futureInvestmentValue = 
        investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12)

For example, if you enter amount 1000, annual interest rate 3.25%, and number
of years 1, the future investment value is 1032.98.

Here is a sample run:

Enter investment amount: 1000.56
Enter annual interest rate in percentage: 4.25
Enter number of years: 1
Accumulated value is $1043.92

Actual output:
Enter investment amount: 1000.56
Enter annual interest rate in percentage: 4.25
Enter number of years: 1
Accumulated value is $1043.9219854307503
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FutureInvestmentValue {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter investment amount
        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        // Prompt the user to enter annual interest rate in percentage
        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestRate = input.nextDouble();
        double monthlyInterestRate = annualInterestRate / 1200;

        // Prompt the user to enter the number of years
        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        // Calculate future investment value
        double futureInvestmentValue
                = investmentAmount
                * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);

        // Display the results
        System.out.println("Accumulated value is $" + futureInvestmentValue);
    }
}
