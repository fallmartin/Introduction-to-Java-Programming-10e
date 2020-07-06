
import java.util.ArrayList;
import java.util.Date;

/**
 * (New Account class) An Account class was specified in Programming
 * Exercise 9.7. Design a new Account class as follows:
 *
 * ■ Add a new data field name of the String type to store the name of the
 * customer.
 * ■ Add a new constructor that constructs an account with the specified name,
 * id, and balance.
 * ■ Add a new data field named transactions whose type is ArrayList
 * that stores the transaction for the accounts. Each transaction is an instance
 * of the Transaction class. The Transaction class is defined as shown in
 * Figure 11.6.
 * ■ Modify the withdraw and deposit methods to add a transaction to the
 * transactions array list.
 * ■ All other properties and methods are the same as in Programming Exercise
 * 9.7.
 * 
 * Write a test program that creates an Account with annual interest rate 1.5%,
 * balance 1000, id 1122, and name George. Deposit $30, $40, and $50 to the
 * account and withdraw $5, $4, and $2 from the account. Print an account
 * summary
 * that shows account holder name, interest rate, balance, and all transactions.
 *
 * @author martinfall
 */
public class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private String customerName;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * No-args constructor for the Account class.
     */
    public Account() {
        this(0, 0.0);
    }

    /**
     * Constructs an account with the specified name and id.
     *
     * @param id
     * @param balance
     */
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    /**
     * Constructs an account with the specified name, id, and balance.
     *
     * @param id
     * @param balance
     * @param customerName
     */
    public Account(int id, double balance, String customerName) {
        this(id, balance);
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
        this.customerName = customerName;
    }

    // Getters and setters for private data fields id, balance, and annual interest rate
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    // Getter and setter methods for private data field customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    // Getter method for transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Getter for the private data field dateCreated
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Returns the monthly interest rate as floating point number, NOT
     * percentage.
     *
     * @return
     */
    public double getMonthlyInterestRate() {
        return getAnnualInterestRate() / 1200;
    }

    /**
     * Returns the monthly interest in terms of monetary units.
     *
     * @return
     */
    public double getMonthlyInterest() {
        return getBalance() * getMonthlyInterestRate();
    }

    /**
     * Withdraw amount from balance.
     *
     * @param amount
     */
    public void withdraw(double amount) {
        transactions.add(new Transaction('W', amount, (getBalance() - amount), "Description"));
        setBalance(getBalance() - amount);
    }

    /**
     * Deposit amount to balance.
     *
     * @param amount
     */
    public void deposit(double amount) {
        transactions.add(new Transaction('D', amount, (getBalance() + amount), "Description"));
        setBalance(getBalance() + amount);
    }

    @Override
    public String toString() {
        return "Balance: " + getBalance()
                + "\nMonthly interest: " + getMonthlyInterest()
                + "\nDate created: " + getDateCreated();
    }
}
