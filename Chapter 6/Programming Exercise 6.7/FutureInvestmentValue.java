
import java.util.Scanner;

/**
 * ﻿(Financial application: compute the future investment value) Write a method
 * that computes future investment value at a given interest rate for a
 * specified number of years. The future investment is determined using the
 * formula in Programming Exercise 2.21.
 *
 * Use the following method header:
 *
 * public static double futureInvestmentValue( double investmentAmount, double
 * monthlyInterestRate, int years)
 *
 * For example, futureInvestmentValue(10000, 0.05/12, 5) returns 12833.59.
 *
 * Write a test program that prompts the user to enter the investment amount
 * (e.g., 1000) and the interest rate (e.g., 9%) and prints a table that
 * displays future value for the years from 1 to 30, as shown below:
 *
 * See textbook for example
 */
/**
 *
 * @author martinfall
 */
public class FutureInvestmentValue {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter investment amount
        System.out.print("The amount invested: ");
        double investmentAmount = input.nextDouble();

        // Prompt the user to enter annual interest rate in percentage
        System.out.print("Annual interest rate: ");
        double annualInterestRate = input.nextDouble();
        double monthlyInterestRate = annualInterestRate / 1200;

        // Prompt the user to enter the number of years
        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        System.out.printf("%-15s%15s%n", "Years", "Future Value");

        for (int i = 1; i <= years; i++) {
            System.out.printf("%-15d%,15.2f%n",
                    i, futureInvestmentValue(investmentAmount, monthlyInterestRate, i));
        }

    }

    /**
     * Reads in investment amount, annual interest rate, and number of years,
     * and displays the future investment value
     *
     * @param investmentAmount
     * @param monthlyInterestRate
     * @param years
     * @return
     */
    public static double futureInvestmentValue(
            double investmentAmount, double monthlyInterestRate, int years) {

        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }
}
