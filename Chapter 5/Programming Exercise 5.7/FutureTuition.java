
/**
 * (Financial application: compute future tuition) Suppose that the tuition for a
 * university is $10,000 this year and increases 5% every year. In one year, the
 * tuition will be $10,500. Write a program that computes the tuition in ten years
 * and the total cost of four years’ worth of tuition after the tenth year.
 * 
 * Enter current annual tuition cost: 10000
 * Enter the rate of annual cost increase (%): 5
 * Enter the expected years until university: 10
 * The tuition in ten years is $16,288.95
 * 
 * In 10 years, you'll need $16,288.95 for freshman year and $70,207.39 for 4 years.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FutureTuition {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the yearly annualTuitionCost for the university
        System.out.print("Enter current annual tuition cost: ");
        double annualTuitionCost = input.nextDouble();

        // Prompt the user to enter the yearly interest
        System.out.print("Enter the rate of annual cost increase (%): ");
        double inflationRate = input.nextDouble();

        // Promt the user to enter the number of years 
        System.out.print("Enter the expected years until university: ");
        int yearsUntilUniversity = input.nextInt();

        // 10 years from the current year inclusively (year0 + 9 years)
        for (int i = 0; i < yearsUntilUniversity; i++) {
            annualTuitionCost += (annualTuitionCost * inflationRate) / 100;
        }

        // Display the results
        System.out.printf("The tuition in ten years is $%,.2f\n", annualTuitionCost);

        // Declare a variable for the cumulative annualTuitionCost over 4 years
        // Assign to it the cost of the first year
        double totalTuition = annualTuitionCost;
        
        System.out.printf("\nIn 10 years, you'll need $%,.2f for freshman year and ", annualTuitionCost);
        for (int i = 0; i < 3; i++) {

            annualTuitionCost += (annualTuitionCost * inflationRate) / 100;
            totalTuition += annualTuitionCost;
        }

        System.out.printf("$%,.2f for 4 years.", totalTuition);
    }
}
