/*
(Population projection) Rewrite Programming Exercise 1.11 to prompt the user
to enter the number of years and displays the population after the number of years.
Use the hint in Programming Exercise 1.11 for this program. The population
should be cast into an integer. 

Here is a sample run of the program:

Enter the number of years: 5
The population in 5 years is 325932970

Actual output:
Enter the number of years: 5
The population in 5 years is 325932966
*/

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ProjectPopulation {
    public static void main(String[] args) {
        // Named constant variable to hold the number of seconds per year
        final int SECONDS_PER_YEAR = 31536000;
        
        // Starting population variable
        int population = 312032486;
        
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the number of years
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();
        
        int births = SECONDS_PER_YEAR / 7;
        int immigrants = SECONDS_PER_YEAR / 45;
        int deaths = SECONDS_PER_YEAR / 13;
        
        int yearlyIncrease = births + immigrants - deaths;
        
        // Display the population after the number of years entered
        System.out.println("The population in " + years + " years is " +
                (population + (yearlyIncrease * years)));
    }
}
