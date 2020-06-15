
/**
 * Write a test program that creates an Account object with an account ID of
 * 1122, a balance of $20,000, and an annual interest rate of 4.5%. Use the
 * withdraw method to withdraw $2,500, use the deposit method to deposit $3,000,
 * and print the balance, the monthly interest, and the date when this account
 * was created.
 *
 * Output:
 * Balance: 20500.0
 * Monthly interest: 76.875
 *
 * @author martinfall
 */
public class TestAccount {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Account object with ID of 1122 and balance of $20,000
        Account account = new Account(1122, 20000);

        // Set the account's annual interest rate to 4.5%
        account.setAnnualInterestRate(4.5);

        // Use the withdraw method to withdraw $2,500
        account.withdraw(2500);

        // Use the deposit method to deposit $3,000
        account.deposit(3000);

        // print the balance, the monthly interest, and the date when this account
        // was created
        System.out.println(account.toString());
    }
}
