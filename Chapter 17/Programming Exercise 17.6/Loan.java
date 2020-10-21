
import java.io.*;
import java.util.Date;

/**
 *
 * @author martinfall
 */
public class Loan implements Serializable {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate; // Date is serializable

    /**
     * Default constructor.
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate,
     * number of years, and loan amount.
     *
     * @param annualInterestRate
     * @param numberOfYears
     * @param loanAmount
     */
    public Loan(double annualInterestRate, int numberOfYears,
            double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    /**
     * Return annualInterestRate.
     *
     * @return
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate.
     *
     * @param annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears.
     *
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears.
     *
     * @param numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return loanAmount.
     *
     * @return
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set a newloanAmount.
     *
     * @param loanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment.
     *
     * @return
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /**
     * Find total payment.
     *
     * @return
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /**
     * Return loan date.
     *
     * @return
     */
    public Date getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loan amount: ").append(this.getLoanAmount()).append("\n");
        sb.append("Interest rate: ").append(this.getAnnualInterestRate()).append("\n");
        sb.append("Number of years: ").append(this.getNumberOfYears());
        return sb.toString() + "\n";
    }
}
