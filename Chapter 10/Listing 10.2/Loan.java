
import java.util.Date;

/**
 *
 * @author martinfall
 */
public class Loan {

    // The annual interest rate of the loan (default: 2.5).
    private double annualInterestRate;
    // The number of years for the loan (default: 1).
    private int numberOfYears;
    // The loan amount (default: 1000).
    private double loanAmount;
    // The date this loan was created.
    private Date loanDate;

    /**
     * Constructs a default Loan object.
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate, number of years,
     * and loan amount
     *
     * @param annualInterestRate
     * @param numberOfYears
     * @param loanAmount
     */
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    /**
     * Return annualInterestRate
     *
     * @return
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Return numberOfYears
     *
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Return loanAmount
     *
     * @return
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Return loan date
     *
     * @return
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * Set a new annualInterestRate
     *
     * @param annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Set a new numberOfYears
     *
     * @param numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Set a new loanAmount
     *
     * @param loanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     *
     * @return
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = getAnnualInterestRate() / 1200;
        double montlyPayment = loanAmount * monthlyInterestRate
                / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return montlyPayment;
    }

    // Returns the total payment for this loan.
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
}
