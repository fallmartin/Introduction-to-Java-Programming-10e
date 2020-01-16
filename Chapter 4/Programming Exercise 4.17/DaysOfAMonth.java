
/**
 * Write a program that prompts the user to enter a year and the first three
 * letters of a month name (with the first letter in uppercase) and displays the
 * number of days in the month. Here is a sample run:
 *
 * Enter a year: 2001
 * Enter a month: Jan
 * Jan 2001 has 31 days
 *
 * Enter a year: 2016
 * Enter a month: Feb
 * Jan 2016 has 29 days
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class DaysOfAMonth {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a year
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Boolean flag for leap year
        boolean isLeap = false;

        // Test the year and raise the flag if it is a leap year
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            isLeap = true;
        }

        // Prompt the user to enter a month
        System.out.print("Enter a month: ");
        String month = input.next();

        // Switch through months
        switch (month) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                System.out.printf("%s %d has 31 days", month, year);
                break;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                System.out.printf("%s %d has 30 days", month, year);
                break;
            case "Feb":
                System.out.printf("%s %d has 31 days", month, year);
                System.out.println(isLeap ? 29 : 28);
                System.out.print(month + " " + year + " has "
                        + (isLeap ? 29 : 28) + " days"); // 28 or 29 days
                break;
        }
    }
}
