
/**
 * (Science: day of the week) Zeller’s congruence is an algorithm developed by
 * Christian Zeller to calculate the day of the week. The formula is
 *
 * h = (q + (26 * (m + 1) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
 *
 * where
 * h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday,
 * 4: Wednesday, 5: Thursday, 6: Friday).
 *
 * q is the day of the month.
 *
 * m is the month (3: March, 4: April, …, 12: December).
 * January and February are counted as months 13 and 14 of the previous year.
 *
 * j is the century (i.e., year 100).
 *
 * k is the year of the century (i.e., year % 100).
 *
 * Note that the division in the formula performs an integer division. Write a
 * program that prompts the user to enter a year, month, and day of the month, and
 * displays the name of the day of the week. Here are some sample runs:
 *
 * Enter year: (e.g., 2012): 2015
 * Enter month: 1-12: 1
 * Enter the day of the month: 1-31: 25
 * Day of the week is Sunday
 *
 * Enter year: (e.g., 2012): 2012
 * Enter month: 1-12: 5
 * Enter the day of the month: 1-31: 12
 * Day of the week is Saturday
 *
 * (Hint: January and February are counted as 13 and 14 in the formula, so you need
 * to convert the user input 1 to 13 and 2 to 14 for the month and change the year
 * to the previous year.)
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year
        System.out.print("Enter year: (e.g., 2012): ");
        int year = input.nextInt();

        // Prompt the user to enter the month
        System.out.print("Enter month: 1-12: ");
        int month = input.nextInt();

        // Prompt the user to enter the day of the month
        System.out.print("Enter the day of the month: 1-31: ");
        int dayOfTheMonth = input.nextInt();

        // Adjust for January and February
        if (month == 1 || month == 2) {
            month = (month == 1) ? 13 : 14; // Adjust the month
            year--; // Adjust the year
        }

        // Perform the operations using Zeller's algorithm
        int dayOfTheWeek = (dayOfTheMonth + (26 * (month + 1) / 10) + (year % 100)
                + (year % 100 / 4) + ((year / 100) / 4) + (5 * ((year / 100)))) % 7;

        // Create a variable to hold the day of the week
        String dayLiteral = "";

        // Switch through cases 0-6 to determine the day of the week
        switch (dayOfTheWeek) {
            case 0:
                dayLiteral = "Saturday";
                break;
            case 1:
                dayLiteral = "Sunday";
                break;
            case 2:
                dayLiteral = "Monday";
                break;
            case 3:
                dayLiteral = "Tuesday";
                break;
            case 4:
                dayLiteral = "Wednesday";
                break;
            case 5:
                dayLiteral = "Thursday";
                break;
            case 6:
                dayLiteral = "Friday";
                break;
            default:
                dayLiteral = "Not a valid day of the week";
                break;
        }

        // Display of the day of the week
        // System.out.println("Day of the week is " + dayOfTheWeek);
        System.out.println("Day of the week is " + dayLiteral);
    }
}
