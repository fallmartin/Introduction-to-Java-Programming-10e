
import java.util.Scanner;

/**
 * Revision: ﻿(Financial application: find the sales amount) Rewrite Programming
 * Exercise 5.39 as follows: - Use a for loop instead of a do-while loop. - Let
 * the user enter COMMISSION_SOUGHT instead of fixing it as a constant.
 *
 * Output: Enter the commission sought: 25000 $210,833.35 in sales generates a
 * $25,000.00 commission which results in a $30,000.00 yearly salary.
 *
 */
/**
 * (Financial application: find the sales amount) You have just started a sales
 * job in a department store. Your pay consists of a base salary and a
 * commission. The base salary is $5,000. The scheme shown below is used to
 * determine the commission rate.
 *
 * Sales Amount Commission Rate $0.01–$5,000 8 percent $5,000.01–$10,000 10
 * percent $10,000.01 and above 12 percent
 *
 * Note that this is a graduated rate. The rate for the first $5,000 is at 8%,
 * the next $5000 is at 10%, and the rest is at 12%. If the sales amount is
 * 25,000, the commission is 5,000 * 8% + 5,000 * 10% + 15,000 * 12% = 2,700.
 *
 * Your goal is to earn $30,000 a year. Write a program that finds the minimum
 * sales you have to generate in order to make $30,000.
 *
 * Output: $210,835.00 in sales generates a $25,000.08 commission which results
 * in a $30,000.00 yearly salary.
 */
/**
 *
 * @author martinfall
 */
public class SalesAmount {

    public static void main(String[] args) {
        // Declare and initialize program variables
        double salesAmount = 0; // Incremented by 1c each iteration of the loop
        double earnedCommission = 0; // calculate
        double baseSalary = 5000;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the commission sought
        System.out.print("Enter the commission sought: ");
        double commissionSought = input.nextDouble();

        // The base salary is $5,000, and the goal is to earn $30,000 a year.
        // That means that the earned commission has to be $25,000 to meet the goal.
        for (; earnedCommission <= commissionSought; salesAmount += 0.01) {
            // Reset the earned commission to 0 at each iteration of sales amount
            earnedCommission = 0;
            // 1st commission option
            if (salesAmount >= 0.01 && salesAmount <= 5000) {
                earnedCommission += salesAmount * 0.08;
            }
            // 2nd commission option
            if (salesAmount >= 5000.01 && salesAmount <= 10000) {
                earnedCommission += (5000 * 0.08) + ((salesAmount - 5000) * 0.10);
            }
            // 3rd commission option
            if (salesAmount >= 10000.01) {
                earnedCommission += (5000 * 0.08) + (5000 * 0.10)
                        + ((salesAmount - 10000) * 0.12);
            }
        }

        // Display the sales amount
        System.out.printf("$%,.2f in sales generates a $%,.2f commission "
                + "%nwhich results in a $%,.2f yearly salary.",
                salesAmount, earnedCommission, baseSalary + earnedCommission);
    }
}
