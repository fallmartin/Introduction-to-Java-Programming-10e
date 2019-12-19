
/**
 * (Find the number of days in a month) Write a program that prompts the user
 * to enter the month and year and displays the number of days in the month. For
 * example, if the user entered month 2 and year 2012, the program should display
 * that February 2012 had 29 days. If the user entered month 3 and year 2015, the
 * program should display that March 2015 had 31 days.
 */
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author martinfall
 */
public class FindTheNumberOfDaysInAMonth {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt he user to enter the month and year
        System.out.print("Enter the month and year: ");

        // Collect the input from user
        int month = input.nextInt();
        int year = input.nextInt();

        // Create a new Calendar object and instanitate it with year and month
        YearMonth y = YearMonth.of(year, month);

        // Display the number of days in the month
        System.out.println(y.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + y.getYear() + " had "
                + y.lengthOfMonth() + " days.");
    }
}
