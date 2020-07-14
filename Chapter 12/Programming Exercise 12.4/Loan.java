
/**
 * (IllegalArgumentException) Modify the Loan class in Listing 10.2 to
 * throw IllegalArgumentException if the loan amount, interest rate, or
 * number of years is less than or equal to zero.
 *
 * @author martinfall
 */
public class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /**
     * Default constructor throws IllegalArgumentException exception.
     */
    public Loan() throws IllegalArgumentException {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate, number of years,
     * and loan amount (throws IllegalArgumentException exception).
     *
     * @param annualInterestRate
     * @param numberOfYears
     * @param loanAmount
     */
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount)
            throws IllegalArgumentException {
        // this.annualInterestRate = annualInterestRate;
        setAnnualInterestRate(annualInterestRate);
        // this.numberOfYears = numberOfYears;
        setNumberOfYears(numberOfYears);
        // this.loanAmount = loanAmount;
        setLoanAmount(loanAmount);
        loanDate = new java.util.Date();
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
     * Set a new annualInterestRate
     *
     * @param annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate)
            throws IllegalArgumentException {
        if (annualInterestRate > 0) {
            this.annualInterestRate = annualInterestRate;
        } else {
            throw new IllegalArgumentException();
        }

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
     * Set a new numberOfYears
     *
     * @param numberOfYears
     */
    public void setNumberOfYears(int numberOfYears)
            throws IllegalArgumentException {
        if (numberOfYears > 0) {
            this.numberOfYears = numberOfYears;
        } else {
            throw new IllegalArgumentException();
        }
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
     * Set a newloanAmount
     *
     * @param loanAmount
     */
    public void setLoanAmount(double loanAmount)
            throws IllegalArgumentException {
        if (loanAmount > 0) {
            this.loanAmount = loanAmount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Find monthly payment
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
     * Find total payment
     *
     * @return
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /**
     * Return loan date
     *
     * @return
     */
    public java.util.Date getLoanDate() {
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
