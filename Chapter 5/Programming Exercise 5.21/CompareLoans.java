
import java.util.Scanner;

/**
 * ﻿(Financial application: compare loans with various interest rates) Write a
 * program that lets the user enter the loan amount and loan period in number of
 * years and displays the monthly and total payments for each interest rate
 * starting from 5% to 8%, with an increment of 1/8. Here is a sample run:
 * 
 * Output:
 * 
Loan Amount: 10000
Number of Years: 5
Interest Rate       Monthly Payment     Total Payment       
5.000%               $188.71              $11,322.74           
5.125%               $189.29              $11,357.13           
5.250%               $189.86              $11,391.59           
5.375%               $190.44              $11,426.11           
5.500%               $191.01              $11,460.70           
5.625%               $191.59              $11,495.35           
5.750%               $192.17              $11,530.06           
5.875%               $192.75              $11,564.84           
6.000%               $193.33              $11,599.68           
6.125%               $193.91              $11,634.59           
6.250%               $194.49              $11,669.56           
6.375%               $195.08              $11,704.59           
6.500%               $195.66              $11,739.69           
6.625%               $196.25              $11,774.85           
6.750%               $196.83              $11,810.08           
6.875%               $197.42              $11,845.37           
7.000%               $198.01              $11,880.72           
7.125%               $198.60              $11,916.14           
7.250%               $199.19              $11,951.62           
7.375%               $199.79              $11,987.16           
7.500%               $200.38              $12,022.77           
7.625%               $200.97              $12,058.44           
7.750%               $201.57              $12,094.18           
7.875%               $202.17              $12,129.97           
8.000%               $202.76              $12,165.84           
 * 
 */
/**
 *
 * @author martinfall
 */
public class CompareLoans {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the loan amount
        System.out.print("Loan Amount: ");
        double loanAmount = input.nextDouble();

        // Prompt user to enter the number of years
        System.out.print("Number of Years: ");
        int numberOfYears = input.nextInt();

        System.out.printf("%-20s%-20s%-20s",
                "Interest Rate", "Monthly Payment", "Total Payment");
        
        System.out.println();

        for (double annualInterestRate = 5; annualInterestRate <= 8; annualInterestRate += 1.0 / 8) {
            // Obtain monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            // Calculate monthly payment
            double monthlyPayment = (loanAmount * monthlyInterestRate)
                    / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));

            // Calculate total payment
            double totalPayment = monthlyPayment * numberOfYears * 12;
            
            // Display interest rate, monthly payment, and total payment
            System.out.printf("%5.3f%-15s %s%,-20.2f%s%,-20.2f%n",
                    annualInterestRate, "%", "$", monthlyPayment, "$", totalPayment);
        }
    }
}
