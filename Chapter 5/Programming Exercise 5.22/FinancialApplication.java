
import java.util.Scanner;

/**
 * ﻿(Financial application: loan amortization schedule) The monthly payment for
 * a given loan pays the principal and the interest. The monthly interest is
 * computed by multiplying the monthly interest rate and the balance (the
 * remaining principal). The principal paid for the month is therefore the
 * monthly payment minus the monthly interest. Write a program that lets the
 * user enter the loan amount, ﻿number of years, and interest rate and displays
 * the amortization schedule for the loan. Here is a sample run: see book for
 * details.
 * 
 * Output:
 * 
Loan Amount: 10000
Number of Years: 1
Annual Interest Rate: 7

Monthly Payment: 865.27
Total Payment: 10383.21

Payment#            Interest            Principal           Balance             
1                   58.33               806.93              9193.07             
2                   53.63               811.64              8381.42             
3                   48.89               816.38              7565.05             
4                   44.13               821.14              6743.91             
5                   39.34               825.93              5917.98             
6                   34.52               830.75              5087.24             
7                   29.68               835.59              4251.65             
8                   24.80               840.47              3411.18             
9                   19.90               845.37              2565.81             
10                  14.97               850.30              1715.51             
11                  10.01               855.26              860.25              
12                  5.02                860.25              0.00                
 */
/**
 *
 * @author martinfall
 */
public class FinancialApplication {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the loan amount
        System.out.print("Loan Amount: ");
        double loanAmount = input.nextDouble();

        // Prompt the user to enter the number of years
        System.out.print("Number of Years: ");
        int numberOfYears = input.nextInt();

        // Prompt the user to enter the annual interest rate
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = input.nextDouble();

        // Calculate monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        // Calculate the monthly payment
        double monthlyPayment = (loanAmount * monthlyInterestRate)
                / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));

        // Calculate the total payment
        double totalPayment = monthlyPayment * numberOfYears * 12;

        // Print a new line
        System.out.println();

        // Display the monthly payment
        System.out.printf("Monthly Payment: %.2f%n", monthlyPayment);

        // Display the total payment
        System.out.printf("Total Payment: %.2f%n", totalPayment);

        double balance = loanAmount;

        // String stringFormat
        String stringFormat = "%-20d%-20.2f%-20.2f%-20.2f%n";

        System.out.printf("%n%-20s%-20s%-20s%-20s%n",
                "Payment#", "Interest", "Principal", "Balance");
        for (int i = 1; i <= numberOfYears * 12; i++) {
            double interest = monthlyInterestRate * balance;
            double principal = monthlyPayment - interest;
            balance -= principal;
            System.out.printf(stringFormat, i, interest, principal, balance);
        }
    }
}
