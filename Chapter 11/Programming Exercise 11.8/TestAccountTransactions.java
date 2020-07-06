
/**
 * Write a test program that creates an Account with annual interest rate 1.5%,
 * balance 1000, id 1122, and name George. Deposit $30, $40, and $50 to the
 * account and withdraw $5, $4, and $2 from the account. Print an account summary
 * that shows account holder name, interest rate, balance, and all transactions.
 *
 * Output:
 * Account holder's name: George
 * Interest rate: 150.0
 * Balance: 1109.0
 *
 * Mon Jul 06 01:27:24 EDT 2020 D 30.0 1030.0 Description
 * Mon Jul 06 01:27:24 EDT 2020 D 40.0 1070.0 Description
 * Mon Jul 06 01:27:24 EDT 2020 D 50.0 1120.0 Description
 * Mon Jul 06 01:27:24 EDT 2020 W 5.0 1115.0 Description
 * Mon Jul 06 01:27:24 EDT 2020 W 4.0 1111.0 Description
 * Mon Jul 06 01:27:24 EDT 2020 W 2.0 1109.0 Description
 *
 * @author martinfall
 */
public class TestAccountTransactions {

    public static void main(String[] args) {
        // Create an account with id 1122, balance 1000, and name George.
        Account account = new Account(1122, 1000, "George");

        // Set the annual interest rate to 1.5%.
        account.setAnnualInterestRate(1.5);

        // Deposit $30, $40, and $50 to the account.
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);

        // Withdraw $5, $4, and $2 from the account.
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        // Print the account holder's name, interest rate, and balance.
        System.out.println("Account holder's name: " + account.getCustomerName());
        System.out.println("Interest rate: " + account.getAnnualInterestRate() * 100);
        System.out.println("Balance: " + account.getBalance());

        // Print all transactions on the account.
        System.out.println();
        for (Transaction t : account.getTransactions()) {
            System.out.println(t);
        }
    }
}
