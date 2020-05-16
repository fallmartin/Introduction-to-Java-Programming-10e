
/**
 * (Print calendar) Programming Exercise 3.21 uses Zeller’s congruence to
 * calculate the day of the week. Simplify Listing 6.12, PrintCalendar.java, using
 * Zeller’s algorithm to get the start day of the month.
 *
 * @author martinfall
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class PrintCalendar {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year
        System.out.print("Enter full year (e.g., 2012): ");
        int year = input.nextInt();

        // Prompt the user to enter the month
        System.out.print("Enter month as a number between 1 and 12: ");
        int month = input.nextInt();

        // Print calendar for the month of the year
        printMonth(year, month);
    }

    /**
     * Print the calendar for a month in a year
     *
     * @param year
     * @param month
     */
    public static void printMonth(int year, int month) {
        // Print the headings of the calendar
        printMonthTitle(year, month);

        // Print the body of the calendar
        printMonthBody(year, month);
    }

    /**
     * Print the month title, e.g., March 2012
     *
     * @param year
     * @param month
     */
    public static void printMonthTitle(int year, int month) {
        System.out.println("          " + getMonthName(month) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Print month body
     *
     * @param year
     * @param month
     */
    public static void printMonthBody(int year, int month) {
        // Get start day of the month for the first date in the month
        int startDay = getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i = 0;

        for (i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Get the English name for the month
     *
     * @param month
     * @return
     */
    public static String getMonthName(int month) {
        String monthName = "";

        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }

    /**
     * Get the start day of month/1/year
     *
     * @param year
     * @param month
     * @return
     */
    public static int getStartDay(int year, int month) {
        // Adjust for January and February
        if (month == 1 || month == 2) {
            month = (month == 1) ? 13 : 14; // Adjust the month
            year--; // Adjust the year
        }

        // Perform the operations using Zeller's algorithm
        int dayOfTheWeek = (0 + (26 * (month + 1) / 10) + (year % 100)
                + (year % 100 / 4) + ((year / 100) / 4) + (5 * ((year / 100)))) % 7;

        return dayOfTheWeek;
    }

    /**
     * Get the total number of days since January 1, 1800
     *
     * @param year
     * @param month
     * @return
     */
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Get the total days from 1/1/1800 to 1/1/year
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(year)) {
                total += 366;
            } else {
                total += 365;
            }
        }

        // Add days from January to the month prior to the calendar month
        for (int i = 1; i < month; i++) {
            total += getNumberOfDaysInMonth(year, i);
        }
        return total;
    }

    /**
     * Get the number of days in a month
     *
     * @param year
     * @param month
     * @return
     */
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 0; // If month is incorrect
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