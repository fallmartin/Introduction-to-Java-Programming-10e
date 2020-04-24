
/**
 * ﻿(Display current date and time) Listing 2.7, ShowCurrentTime.java, displays the
 * current time. Improve this example to display the current date and time. The
 * calendar example in Listing 6.12, PrintCalendar.java, should give you some
 * ideas on how to find the year, month, and day.
 *
 * Output:
 * Today's date is 4/24/2020
 * The current time is 1:07:09
 *
 * @author martinfall
 */
public class CurrentDateAndTime {

    static int year = 1970;

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {

        // Get the total milliseconds elapsed sing Unix epoch
        long totalMilliseconds = System.currentTimeMillis();

        // Pass total milliseconds to displayDateTime
        displayDateTime(totalMilliseconds);
    }

    /**
     * Display date and time
     *
     * @param totalMilliseconds
     */
    public static void displayDateTime(long totalMilliseconds) {
        // Display the current date 
        showCurrentDate(totalMilliseconds);

        // Display the current time
        showCurrentTime(totalMilliseconds);
    }

    /**
     * Display the current month/day/year
     *
     * @param totalMilliseconds
     */
    public static void showCurrentDate(long totalMilliseconds) {
        // Total number of days
        long totalDays = getTotalDays(totalMilliseconds);

        // Elapsed days in the current year
        long daysInCurrentYear = getDaysElapsedInCurrentYear(totalDays);

        System.out.println("Today's date is "
                + getMonth(daysInCurrentYear) + "/"
                + getDay(daysInCurrentYear) + "/" + year);

    }

    /**
     * Use the System method currentTimeMillis to calculate the current time
     *
     * @param totalMilliseconds
     */
    public static void showCurrentTime(long totalMilliseconds) {
        // Total number of seconds
        long totalSeconds = totalMilliseconds / 1000;
        // Current second
        long currentSecond = totalSeconds % 60;

        // Total number of minutes
        long totalMinutes = totalSeconds / 60;
        // Current minute
        long currentMinute = totalMinutes % 60;

        // Total number of hours
        long totalHours = totalMinutes / 60;
        // Current hour
        long currentHour = totalHours % 24;

        // Adjust the hour for the time zone
        currentHour -= 4;

        //System.out.print(" " + currentHour + ":" + currentMinute + ":" + currentSecond);
        System.out.printf("The current time is %d:%02d:%02d%n", currentHour, currentMinute, currentSecond);
    }

    /**
     * Get the total days elasped since January 1, 1070
     *
     * @param totalMilliseconds
     * @return
     */
    public static long getTotalDays(long totalMilliseconds) {
        long totalDays = totalMilliseconds / 86400000;
        return (totalMilliseconds % 86400000) > 0 ? totalDays + 1 : totalDays;
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

    /**
     * Get the number of days elapsed in the current year and update the year
     *
     * @param totalDays
     * @return
     */
    public static long getDaysElapsedInCurrentYear(long totalDays) {
        // 
        for (int i = 1970; i < 2020; i++) {
            if (isLeapYear(i)) {
                totalDays -= 366;
            } else {
                totalDays -= 365;
            }
            year++;
        }
        return totalDays;
    }

    /**
     * Get the current month from the elapsed days in the current year
     *
     * @param daysInCurrentYear
     * @return
     */
    public static int getMonth(long daysInCurrentYear) {
        int temp = 1;
        for (int month = 1; month <= 12 && daysInCurrentYear >= 28; month++) {
            if (month == 1 || month == 3 || month == 5 || month == 7
                    || month == 8 || month == 10 || month == 12) {
                daysInCurrentYear -= 31;
                temp++;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                daysInCurrentYear -= 30;
                temp++;
            } else if (month == 2) {
                if (isLeapYear(year)) {
                    daysInCurrentYear -= 29;
                    temp++;
                } else {
                    daysInCurrentYear -= 28;
                    temp++;
                }
            }
        }
        return temp;
    }

    /**
     * Get the day from the elapsed days in the current year
     *
     * @param daysInCurrentYear
     * @return
     */
    public static long getDay(long daysInCurrentYear) {

        for (int month = 1; month <= 12 && daysInCurrentYear >= 28; month++) {
            // System.out.println(daysInCurrentYear);
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysInCurrentYear -= 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    daysInCurrentYear -= 30;
                    break;
                case 2:
                    if (isLeapYear(year)) {
                        daysInCurrentYear -= 29;
                    } else {
                        daysInCurrentYear -= 28;
                    }
                    break;
                default:
                    break;
            }
        }
        return daysInCurrentYear;
    }
}
