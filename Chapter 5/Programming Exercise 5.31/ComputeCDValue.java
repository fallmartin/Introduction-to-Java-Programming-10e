
import java.util.Scanner;

/**
 * ﻿(Financial application: compute CD value) Suppose you put $10,000 into a CD
 * with an annual percentage yield of 5.75%. After one month, the CD is worth
 * 10000 + 10000 * 5.75 / 1200 = 10047.92 After two months, the CD is worth
 * 10047.91 + 10047.91 * 5.75 / 1200 = 10096.06 After three months, the CD is
 * worth 10096.06 + 10096.06 * 5.75 / 1200 = 10144.44 and so on. Write a program
 * that prompts the user to enter an amount (e.g., 10000), the annual percentage
 * yield (e.g., 5.75), and the number of months (e.g., 18) and displays a table
 * as shown in the sample run.
 * 
 * Output:
 * 
Enter the initial deposit amount (e.g., 10000): 10000
Enter the annual percentage yield (e.g., 5.75): 5.75
Enter the maturity period in number of months (e.g., 18): 18
Month          CD Value       
1              10047.92       
2              10096.06       
3              10144.44       
4              10193.05       
5              10241.89       
6              10290.97       
7              10340.28       
8              10389.82       
9              10439.61       
10             10489.63       
11             10539.89       
12             10590.40       
13             10641.14       
14             10692.13       
15             10743.37       
16             10794.84       
17             10846.57       
18             10898.54       
 */
/**
 *
 * @author martinfall
 */
public class ComputeCDValue {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user for data input
        System.out.print("Enter the initial deposit amount (e.g., 10000): ");
        double initialDepositAmount = input.nextDouble();
        
        System.out.print("Enter the annual percentage yield (e.g., 5.75): ");
        double annualPercentageYield = input.nextDouble();
        
        System.out.print("Enter the maturity period in number of months (e.g., 18): ");
        int numberOfMonths = input.nextInt();
        
        // Declare CD value variable and initialize it to 0
        double cdValue = initialDepositAmount;
        
        String format = "%-15s%-15s%n";
        
        System.out.printf(format, "Month", "CD Value");
        // Displays a table as shown in the sample run.
        for (int i = 1; i <= numberOfMonths; i++) {
            // Calculate the value of the CD at month i
            cdValue = cdValue + cdValue * annualPercentageYield / 1200;
            // Display the result
            System.out.printf("%-15d%-15.2f%n", i, cdValue);
        }
    }
}
