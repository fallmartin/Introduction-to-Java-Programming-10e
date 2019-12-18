/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ComputeChange {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the amount as a decimal number, such as 11.56.
        System.out.print("Enter the amount as a decimal number, such as 11.56: ");
        double amount = input.nextDouble();

        // Convert the amount into cents
        int remainingAmount = (int) (amount * 100);

        // Divide the cents by 100 to find the number of dollars.
        int numberOfDollars = remainingAmount / 100;

        // Obtain the remaining cents using the cents remainder 100.
        remainingAmount %= 100;

        // Divide the remaining cents by 25 to find the number of quarters.
        int numberOfQuarters = remainingAmount / 25;

        // Obtain the remaining cents using the cents remainder 25.
        remainingAmount %= 25;

        // Divide the remaining cents by 10 to find the number of dimes.
        int numberOfDimes = remainingAmount / 10;

        // Obtain the remaining cents using the cents remainder 10.
        remainingAmount %= 10;

        // Divide the remaining cents by 5 to find the number of nickels.
        int numberOfNickels = remainingAmount / 5;

        // Obtain the remaining cents using the cents remainder 5.
        remainingAmount %= 5;

        // The remaining cents are the pennies.
        int numberOfPennies = remainingAmount;

        // Create temporary String variable 
        String tmp = "";

        // Display results
        System.out.println("Your amount " + amount + " consists of ");
        if (numberOfDollars > 0) {
            tmp = numberOfDollars == 1 ? "dollar" : "dollars";
            System.out.println(numberOfDollars + " " + tmp);
        }
        if (numberOfQuarters > 0) {
            tmp = numberOfQuarters == 1 ? "quarter" : "quarters";
            System.out.println(numberOfQuarters + " " + tmp);
        }
        if (numberOfDimes > 0) {
            tmp = numberOfDimes == 1 ? "dime" : "dimes";
            System.out.println(numberOfDimes + " " + tmp);
        }
        if (numberOfNickels > 0) {
            tmp = numberOfNickels == 1 ? "nickel" : "nickels";
            System.out.println(numberOfNickels + " " + tmp);
        }
        if (numberOfPennies > 0) {
            tmp = numberOfPennies == 1 ? "penny" : "pennies";
            System.out.println(numberOfPennies + " " + tmp);
        }
    }
}
