
/**
 * (Find future dates) Write a program that prompts the user to enter an integer
 * for today’s day of the week (Sunday is 0, Monday is 1, …, and Saturday is 6).
 * Also prompt the user to enter the number of days after today for a future day
 * and display the future day of the week. Here is a sample run:
 *
 * Enter today's day: 1
 * Enter the number of days elapsed since today: 3
 * Today is Monday and the future day is Thursday
 *
 * Enter today's day: 0
 * Enter the number of days elapsed since today: 31
 * Today is Sunday and the future day is Wednesday
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FindFutureDates {

    static String findTheDayOfTheWeek(int dayNumber) {
        String day = "";

        switch (dayNumber) {
            case 0:
                day = "Sunday";
                break;
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
        }
        return day;
    }

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter today's day
        System.out.print("Enter today's day: ");
        int todaysDay = input.nextInt();

        // Prompt the user to enter the number of days elapsed since today
        System.out.print("Enter the number of days elapsed since today: ");
        int numberOfDaysElapsed = input.nextInt();

        // Calculate the future day of the week
        int futureDayOfTheWeek = todaysDay + (numberOfDaysElapsed % 7);

        // Display the future day of the week
        System.out.println("Today is " + findTheDayOfTheWeek(todaysDay)
                + " and the future day is " + findTheDayOfTheWeek(futureDayOfTheWeek));
    }
}
