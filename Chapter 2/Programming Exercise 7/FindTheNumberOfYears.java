/*
Write a program that prompts the user to enter the minutes (e.g., 1 billion), 
and displays the number of years and days for the minutes. For simplicity, 
assume a year has 365 days. 

Here is a sample run:

Enter the number of minutes: 1000000000
1000000000 minutes is approximately 1902 years and 214 days
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FindTheNumberOfYears {
    public static void main(String[] args) {
        // Named constants
        final int MINS_IN_HOUR = 60;
        final int HOURS_IN_DAY = 24;
        final int DAYS_IN_YEAR = 365;
        
        // Create a scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the number of minutes
        System.out.print("Enter the number of minutes: ");
        int minutes = input.nextInt();
        
        // Calculate the number of years and days for the minutes
        
        // Calculate the total number of minutes
        int totalNumberOfDays = minutes / (MINS_IN_HOUR * HOURS_IN_DAY);
        
        // Calculate the number of years
        int years = totalNumberOfDays / DAYS_IN_YEAR;
        
        // Calculate the number of days
        int days = totalNumberOfDays % DAYS_IN_YEAR;
        
        // Display the results
        System.out.println(minutes + " minutes is approximately " + years + 
                " years and " + days + " days");
    }
}
