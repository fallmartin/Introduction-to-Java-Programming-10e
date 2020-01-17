
/**
 * Write a program that reads the following information and prints a payroll statement:
 * Employee’s name (e.g., Smith)
 * Number of hours worked in a week (e.g., 10)
 * Hourly pay rate (e.g., 9.75)
 * Federal tax withholding rate (e.g., 20%)
 * State tax withholding rate (e.g., 9%)
 *
 * A sample run is shown below:
 *
 * Enter employee's name: Smith
 * Enter number of hours worked in a week: 10
 * Enter hourly pay rate: 9.75
 * Enter federal tax withholding rate: 0.20
 * Enter state tax withholding rate: 0.09
 *
 * Employee Name: Smith
 * Hours Worked: 10.0
 * Pay Rate: $9.75
 * Gross Pay: $97.5
 * Deductions:
 *   Federal Withholding (20.0%): $19.5
 *   State Withholding (9.0%): $8.77
 *   Total Deduction: $28.27
 * Net Pay: $69.22
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FinancialApplicationPayroll {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter employee's name
        System.out.print("Enter employee's name: ");
        String name = input.nextLine();

        // Prompt the user to enter the number of hours worked in a week
        System.out.print("Enter number of hours worked in a week: ");
        double hours = input.nextDouble();

        // Prompt the user to enter the hourly pay rate
        System.out.print("Enter hourly pay rate: ");
        double rate = input.nextDouble();

        // Prompt the user to enter the federal tax withholding rate
        System.out.print("Enter federal tax withholding rate: ");
        double fedTax = input.nextDouble();

        // Prompt the user to enter the state tax withholding rate
        System.out.print("Enter state tax withholding rate: ");
        double stateTax = input.nextDouble();

        System.out.println();

        // Display the results
        System.out.println("Employee Name: " + name);
        System.out.println("Hours Worked: " + hours);
        System.out.println("Pay Rate: $" + rate);

        // Calculate and display gross pay
        double gross = hours * rate;
        System.out.println("Gross Pay: $" + gross);

        System.out.println("Deductions:");

        // Calculate and display fed withholding
        double fedWithhold = gross * fedTax;
        System.out.println("\tFederal Withholding("
                + (fedTax * 100) + "%): $"
                + (int) (fedWithhold * 100) / 100.0);

        // Calculate and display state withholding
        double stateWithhold = gross * stateTax;
        System.out.println("\tState Withholding ("
                + (stateTax * 100) + "%): $"
                + (int) (stateWithhold * 100) / 100.0);

        // Calculate and display total deduction
        double totalDeduction = fedWithhold + stateWithhold;
        System.out.println("\tTotal Deduction: $"
                + (int) (totalDeduction * 100) / 100.0);

        // Calculate and display net pay
        System.out.println("\tNet Pay: $"
                + (int) ((gross - totalDeduction) * 100) / 100.0);
    }
}
