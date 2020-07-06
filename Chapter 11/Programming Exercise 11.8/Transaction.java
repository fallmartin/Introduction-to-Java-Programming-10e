
import java.util.Date;

/**
 *
 * @author martinfall
 */
class Transaction {

    // The date of this transaction.
    private Date date;
    // The type of the transaction, such as 'W' for withdrawal, 'D' for deposit.
    private char type;
    // The amount of the transaction.
    private double amount;
    // The new balance after this transaction.
    private double balance;
    // The description of this transaction.
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " " + type + " " + amount + " " + balance + " " + description;
    }
    
    

}
