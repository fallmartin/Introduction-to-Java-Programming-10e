
/**
 * ﻿(Number of days in a year) Write a method that returns the number of days in a
 * year using the following header:
 *
 * public static int numberOfDaysInAYear(int year)
 *
 * Write a test program that displays the number of days in year from 2000 to 2020.
 *
 * @author martinfall
 */
public class NumberOfDaysInAYear {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int year = 2000; year <= 2020; year++) {
            System.out.println("The year " + year + " has "
                    + numberOfDaysInAYear(year) + " days.");
        }
    }

    /**
     * Returns the number of days in a year
     *
     * @param year
     * @return
     */
    public static int numberOfDaysInAYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    /**
     * Determine if it is a leap year
     *
     * @param year
     * @return
     */
    public static Boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
