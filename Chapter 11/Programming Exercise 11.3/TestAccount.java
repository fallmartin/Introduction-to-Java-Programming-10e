
/**
 * Creating an Account object
 * Balance: 1000.0
 * Monthly interest: 0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 *
 * Creating a CheckingAccount object
 * Balance: 1000.0
 * Monthly interest: 0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 *
 * Withdraw 1100
 * Balance: -100.0
 * Monthly interest: -0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 *
 * Withdraw 300
 * Balance: -100.0
 * Monthly interest: -0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 * Creating a SavingsAccount object
 * Balance: 1000.0
 * Monthly interest: 0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 *
 * Withdraw 1100
 * Balance: 1000.0
 * Monthly interest: 0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 *
 * Withdraw 300
 * Balance: 700.0
 * Monthly interest: 0.0
 * Date created: Sun Jul 05 04:12:50 EDT 2020
 *
 * @author martinfall
 */
public class TestAccount {

    public static void main(String[] args) {
        // Create an Account object
        System.out.println("Creating an Account object");
        Account account = new Account(0, 1000);
        System.out.println(account.toString());
        System.out.println();

        // Create a CheckingAccount object
        System.out.println("Creating a CheckingAccount object");
        CheckingAccount checking = new CheckingAccount(1, 1000, 100);
        System.out.println(checking.toString());
        System.out.println();

        System.out.println("Withdraw 1100");
        checking.withdraw(1100);
        System.out.println(checking.toString());
        System.out.println();

        System.out.println("Withdraw 300");
        checking.withdraw(300);
        System.out.println(checking.toString());

        // Create a SavingsAccount object
        System.out.println("Creating a SavingsAccount object");
        SavingsAccount savings = new SavingsAccount(2, 1000);
        System.out.println(savings.toString());
        System.out.println();

        System.out.println("Withdraw 1100");
        savings.withdraw(1100);
        System.out.println(savings.toString());
        System.out.println();

        System.out.println("Withdraw 300");
        savings.withdraw(300);
        System.out.println(savings.toString());
    }
}
