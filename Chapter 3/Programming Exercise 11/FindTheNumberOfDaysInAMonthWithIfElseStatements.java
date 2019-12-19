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
public class FindTheNumberOfDaysInAMonthWithIfElseStatements {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt he user to enter the month and year
        System.out.print("Enter the month and year: ");

        // Collect the input from user
        int month = input.nextInt();
        int year = input.nextInt();

        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            System.out.println(31);

        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println(30);
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(29);
            } else {
                System.out.println(28);
            }
        }
    }
}
