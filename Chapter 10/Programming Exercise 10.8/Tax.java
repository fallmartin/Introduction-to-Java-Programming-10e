
/**
 * (Financial: the Tax class) Programming Exercise 8.12 writes a program for
 * computing taxes using arrays. Design a class named Tax to contain the following
 * instance data fields:
 *
 * ■ int filingStatus: One of the four tax-filing statuses: 0—single filer, 1—
 * married filing jointly or qualifying widow(er), 2—married filing separately,
 * and 3—head of household. Use the public static constants SINGLE_FILER
 * (0), MARRIED_JOINTLY_OR_QUALIFYING_WIDOW(ER) (1), MARRIED_
 * SEPARATELY (2), HEAD_OF_HOUSEHOLD (3) to represent the statuses.
 * ■ int[][] brackets: Stores the tax brackets for each filing status.
 * ■ double[] rates: Stores the tax rates for each bracket.
 * ■ double taxableIncome: Stores the taxable income.
 *
 * Provide the getter and setter methods for each data field and the getTax()
 * method that returns the tax. Also provide a no-arg constructor and the
 * constructor Tax(filingStatus, brackets, rates, taxableIncome).
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that uses the Tax class to print the 2001 and 2009 tax tables for taxable
 * income from $50,000 to $60,000 with intervals of $1,000 for all four statuses.
 * The tax rates for the year 2009 were given in Table 3.2. The tax rates for 2001
 * are shown in Table 10.1.
 *
 * @author martinfall
 */
public class Tax {

    // Constants for filint statuses
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus; // One of the four tax-filing statuses
    private int[][] brackets; // Stores the tax brackets for each income
    private double[] rates; // Stores the tax rates for each bracket
    private double taxableIncome; // Stores the taxable income

    // No-arg constructor
    public Tax() {
    }

    // Parameterized constructor
    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;

    }

    // Accessor amethods for each data field
    public int getFilingStatus() {
        return filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    // Mutator methods for each data field
    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    // getTax() method that returns the tax
    public double getTax() {
        double tax = 0;
        double taxedIncome = 0;

        // The first bracket interval ranging from 0 to brackets[filingStatus][0]
        tax += brackets[filingStatus][0] * rates[0];

        // All remaining bracket intervals
        for (int i = rates.length - 2; i >= 0; i--) {
            if (taxableIncome > brackets[filingStatus][i]) {
                taxedIncome = taxableIncome - brackets[filingStatus][i];
                tax += taxedIncome * rates[i + 1];
                taxableIncome -= taxedIncome;
            }
        }
        // Return the aggregated result stored in var tax
        return tax;
    }
}
