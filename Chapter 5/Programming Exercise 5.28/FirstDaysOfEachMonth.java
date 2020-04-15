
import java.util.Scanner;

/**
 * ﻿(Display the first days of each month) Write a program that prompts the user
 * to enter the year and first day of the year, and displays the first day of
 * each month in the year. For example, if the user entered the year 2013, and 2
 * for Tuesday, January 1, 2013, your program should display the following
 * output: January 1, 2013 is Tuesday ... December 1, 2013 is Sunday
 *
 * Output:
 *
 * Enter the year: 2013 
 * Enter the first day of the year. 
 * Enter 0 for Sunday, 1 for Monday, 2 for Tuesday, ... 2 
 * 
 * January 1, 2013 is Tuesday 
 * February 1, 2013 is Friday 
 * March 1, 2013 is Friday 
 * April 1, 2013 is Monday 
 * May 1, 2013 is Wednesday
 * June 1, 2013 is Saturday 
 * July 1, 2013 is Monday 
 * August 1, 2013 is Thursday 
 * September 1, 2013 is Sunday 
 * October 1, 2013 is Tuesday 
 * November 1, 2013 is Friday 
 * December 1, 2013 is Sunday
 */
/**
 *
 * @author martinfall
 */
public class FirstDaysOfEachMonth {

    public static void main(String[] args) {
        // Declare boolean flag for leap year and set to false
        boolean isLeap = false;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year
        System.out.print("Enter the year: ");
        int year = input.nextInt();

        // Is is a leap year?
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            isLeap = true;
        }

        // Prompt the user to enter the first day of the year
        System.out.println("Enter the first day of the year.");
        System.out.print("Enter 0 for Sunday, 1 for Monday, 2 for Tuesday, ... ");
        int day = input.nextInt();
        
        // Print a new line
        System.out.println();

        // System.out.println(isLeap); // Test boolean flag
        for (int month = 1; month <= 12; month++) {
            String s = ""; // Create an empty string and populate through the loop

            // Concatenate month to string s
            switch (month) {
                case 1:
                    s += "January";
                    break;
                case 2:
                    s += "February";
                    break;
                case 3:
                    s += "March";
                    break;
                case 4:
                    s += "April";
                    break;
                case 5:
                    s += "May";
                    break;
                case 6:
                    s += "June";
                    break;
                case 7:
                    s += "July";
                    break;
                case 8:
                    s += "August";
                    break;
                case 9:
                    s += "September";
                    break;
                case 10:
                    s += "October";
                    break;
                case 11:
                    s += "November";
                    break;
                case 12:
                    s += "December";
                    break;
            }

            // Concatenate 1 and the year to string s
            s += " 1, " + year + " is ";

            // Calculate the day from the first day of the year
            day %= 7;

            // Switch the days from 0 - 6 (Sunday to Saturday)
            switch (day) {
                case 0:
                    s += "Sunday";
                    break;
                case 1:
                    s += "Monday";
                    break;
                case 2:
                    s += "Tuesday";
                    break;
                case 3:
                    s += "Wednesday";
                    break;
                case 4:
                    s += "Thursday";
                    break;
                case 5:
                    s += "Friday";
                    break;
                case 6:
                    s += "Saturday";
                    break;
            }

            // Add the number of days in the previous month to day
            // If the previous month has 31 days
            switch (month) { // use a fall through switch case pattern
                // If the previous month has 30 days
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    day += 30;
                    break;
                default:
                    if (isLeap) {
                        day += 29;
                    } else {
                        day += 28;
                    }
                    break;
            }

            System.out.println(s);
        }
    }
}
