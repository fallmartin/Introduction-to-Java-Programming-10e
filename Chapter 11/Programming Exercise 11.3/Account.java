
import java.util.Date;

/**
 * (The Account class) Design a class named Account that contains:
 *
 * ■ A private int data field named id for the account (default 0).
 * ■ A private double data field named balance for the account (default 0).
 * ■ A private double data field named annualInterestRate that stores the
 * current
 * interest rate (default 0). Assume all accounts have the same interest rate.
 * ■ A private Date data field named dateCreated that stores the date when the
 * account was created.
 * ■ A no-arg constructor that creates a default account.
 * ■ A constructor that creates an account with the specified id and initial
 * balance.
 * ■ The accessor and mutator methods for id, balance, and annualInterestRate.
 * ■ The accessor method for dateCreated.
 * ■ A method named getMonthlyInterestRate() that returns the monthly
 * interest rate.
 * ■ A method named getMonthlyInterest() that returns the monthly interest.
 * ■ A method named withdraw that withdraws a specified amount from the
 * account.
 * ■ A method named deposit that deposits a specified amount to the account.
 *
 * Draw the UML diagram for the class and then implement the class. (Hint: The
 * method getMonthlyInterest() is to return monthly interest, not the interest
 * rate.
 *
 * Monthly interest is balance * monthlyInterestRate. monthlyInterestRate
 * is annualInterestRate / 12. Note that annualInterestRate is a percentage,
 * e.g., like 4.5%. You need to divide it by 100.)
 *
 * Write a test program that creates an Account object with an account ID of
 * 1122, a balance of $20,000, and an annual interest rate of 4.5%. Use the
 * withdraw method to withdraw $2,500, use the deposit method to deposit $3,000,
 * and print the balance, the monthly interest, and the date when this account
 * was created.
 *
 * @author martinfall
 */
public class Account {

    // DATA FIELDS
    // A private int data field named id for the account (default 0)
    private int id;
    // A private double data field named balance for the account (default 0)
    private double balance;
    // A private double data field named annualInterestRate that stores the current
    // interest rate (default 0). Assume all accounts have the same interest rate
    private double annualInterestRate;
    // A private Date data field named dateCreated that stores the date when the
    // account was created
    private Date dateCreated;

    // CONSTRUCTORS
    // I decided to set the default values for data fields in the constructor
    // A no-arg constructor that creates a default account
    public Account() {
        this(0, 0.0);
    }

    // A constructor that creates an account with the specified id and initial balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    // The accessor and mutator methods for id, balance, and annualInterestRate
    // Getters
    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // The accessor method for dateCreated
    public Date getDateCreated() {
        return dateCreated;
    }

    //A method named getMonthlyInterestRate() that returns the monthly
    // interest rate.
    public double getMonthlyInterestRate() {
        return getAnnualInterestRate() / 1200; // Divided by 100 and by 12 months
    }

    // A method named getMonthlyInterest() that returns the monthly interest
    public double getMonthlyInterest() {
        return getBalance() * getMonthlyInterestRate();
    }

    // A method named withdraw that withdraws a specified amount from the account
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }

    // A method named deposit that deposits a specified amount to the account
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    // Print the balance, the monthly interest, and the date when this account 
    // was created.
    @Override
    public String toString() {
        return "Balance: " + getBalance()
                + "\nMonthly interest: " + getMonthlyInterest()
                + "\nDate created: " + getDateCreated();
    }
}
