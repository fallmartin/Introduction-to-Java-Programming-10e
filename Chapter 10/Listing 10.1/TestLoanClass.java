
import java.util.Scanner;

/**
 * Output:
 * Enter annual interest rate, for example, 8.25: 2.5
 * Enter number of years as an integer: 5
 * Enter loan amount, for example, 120000.95: 1000
 * The loan was created on Thu Jun 18 02:16:19 EDT 2020
 * The monthly payment is 17.75
 * The total payment is 1064.84
 *
 * @author martinfall
 */
public class TestLoanClass {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Enter annual interest rate
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();

        // Enter number of years
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();

        // Enter loan amount
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();

        // Create a Loan object
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Display loan date, monthly payment, and total payment
        System.out.printf("The loan was created on %s%n"
                + "The monthly payment is %.2f%n"
                + "The total payment is %.2f%n",
                loan.getLoanDate().toString(),
                loan.getMonthlyPayment(),
                loan.getTotalPayment());
    }
}
