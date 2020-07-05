
/**
 * (Subclasses of Account) In Programming Exercise 9.7, the Account class was
 * defined to model a bank account. An account has the properties account number,
 * balance, annual interest rate, and date created, and methods to deposit and
 * withdraw funds. Create two subclasses for checking and saving accounts. A
 * checking account has an overdraft limit, but a savings account cannot be
 * overdrawn.
 *
 * Draw the UML diagram for the classes and then implement them. Write
 * a test program that creates objects of Account, SavingsAccount, and
 * CheckingAccount and invokes their toString() methods.
 *
 * @author martinfall
 */
public class SavingsAccount extends Account {

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (this.getBalance() - amount >= 0) {
            this.setBalance(this.getBalance() - amount);
        }
    }
}
