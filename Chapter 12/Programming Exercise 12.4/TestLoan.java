
/**
 * Output:
 * Loan amount: 1000.0
 * Interest rate: 2.5
 * Number of years: 1
 *
 * Loan amount: 275000.0
 * Interest rate: 10.0
 * Number of years: 30
 *
 * Illegal Argument Exception: <= 0
 * @
 *
 * author martinfall
 */
public class TestLoan {

    public static void main(String[] args) {
        // Create a new Loan object with default constructor
        Loan loan1 = new Loan();
        System.out.println(loan1.toString());

        // Create a new Loan object with valid values
        Loan loan2 = new Loan(10, 30, 275000);
        System.out.println(loan2.toString());

        try {
            loan2.setLoanAmount(-200);
        } catch (IllegalArgumentException ex) {
            System.out.println("Illegal Argument Exception: <= 0");
        }
    }
}
