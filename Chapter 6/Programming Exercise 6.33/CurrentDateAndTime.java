
/**
 * (Current date and time) Invoking System.currentTimeMillis() returns the
 * elapsed time in milliseconds since midnight of January 1, 1970. Write a
 * program that displays the date and time. Here is a sample run:
 *
 * Output:
 * Current date and time is April 25, 2020, 4:17:17 PM
 * ﻿Current date and time is April 25, 2020, 4:19:18 PM
 * Current date and time is April 25, 2020, 4:19:49 PM
 *
 * @author martinfall
 */
public class CurrentDateAndTime {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare a variable and initialize to seonds passed since Jan 1, 1970
        long totalSeconds = convertMillisecondsToSeconds(System.currentTimeMillis());

        // Display the date and time
        displayDateTime(totalSeconds);
    }

    /**
     * Display the date and time
     *
     * @param totalSeconds
     */
    public static void displayDateTime(long totalSeconds) {
        System.out.print("Current date and time is ");
        displayDate(totalSeconds);
        displayTime(totalSeconds);
    }

    /**
     * Display the current date in MM D, YYYY format
     *
     * @param totalSeconds
     */
    public static void displayDate(long totalSeconds) {
        long currentYear = 1970; // Unix epoch year
        long totalDays = convertSecondsToDays(totalSeconds); // days elapsed since Unix epoch

        // Obtain current year
        while (totalDays >= 365) {
            totalDays -= (isLeapYear(currentYear) ? 366 : 365); // Remove 1 year
            currentYear++; // Increment year
        }

        // Obtain current month
        int month = 1;
        while (totalDays >= (isLeapYear(currentYear) ? 29 : 28)) {

            if (month == 1 || month == 3 || month == 5 || month == 7
                    || month == 8 || month == 10 || month == 12) {
                totalDays -= 31;
                month++;
            } else if (month == 2) {
                totalDays -= isLeapYear(currentYear) ? 29 : 28;
                month++;
            } else {
                totalDays -= 30;
                month++;
            }
        }

        // String format: ﻿Current date and time is May 16, 2012 10:34:23
        String format = "%s %d, %d, ";

        // If there are additional seconds after that don't make up a full day,
        // increment the day to show that we are in the midst of another day
        if (totalSeconds % 86400 != 0) {
            totalDays++;
        }

        // Display date in MM D, YYYY format
        System.out.printf(format, getMonthLiteral(month), totalDays, currentYear);
    }

    /**
     * Convert the month number to a name
     *
     * @param month
     * @return
     */
    public static String getMonthLiteral(int month) {
        String monthLiteral = "";
        // Convert month variable from 

        switch (month) {
            case 1:
                monthLiteral = "January";
                break;
            case 2:
                monthLiteral = "February";
                break;
            case 3:
                monthLiteral = "March";
                break;
            case 4:
                monthLiteral = "April";
                break;
            case 5:
                monthLiteral = "May";
                break;
            case 6:
                monthLiteral = "June";
                break;
            case 7:
                monthLiteral = "July";
                break;
            case 8:
                monthLiteral = "August";
                break;
            case 9:
                monthLiteral = "September";
                break;
            case 10:
                monthLiteral = "October";
                break;
            case 11:
                monthLiteral = "November";
                break;
            case 12:
                monthLiteral = "December";
                break;
        }

        return monthLiteral;
    }

    /**
     * Check if the year is a leap year
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(long year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Convert seconds to days
     *
     * @param totalSeconds
     * @return
     */
    public static long convertSecondsToDays(long totalSeconds) {
        return totalSeconds / 86400;
    }

    /**
     * Display time in HH:MM:SS AM/PM format
     *
     * @param totalSeconds
     */
    public static void displayTime(long totalSeconds) {
        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;

        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        // Adjust for time zone
        currentHour -= 4; // Can be written as a separate method for different time zones

        String format = "%d:%02d:%02d %s";
        System.out.printf(format,
                formatHour(currentHour), currentMinute, currentSecond, setAmOrPm(currentHour));
    }

    /**
     * Format the hour for 12-hour clock
     *
     * @param currentHour
     * @return
     */
    public static long formatHour(long currentHour) {
        return currentHour < 12 ? currentHour : currentHour - 12;
    }

    /**
     * Determine AM or PM
     *
     * @param currentHour
     * @return
     */
    public static String setAmOrPm(long currentHour) {
        return currentHour > 12 ? "PM" : "AM";
    }

    /**
     * Convert milliseconds to seconds
     *
     * @param milliseconds
     * @return
     */
    public static long convertMillisecondsToSeconds(long milliseconds) {
        return milliseconds / 1000;
    }
}
