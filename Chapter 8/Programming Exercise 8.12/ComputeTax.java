
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Financial application: compute tax) Rewrite Listing 3.5, ComputeTax.java,
 * using arrays. For each filing status, there are six tax rates. Each rate is
 * applied to a certain amount of taxable income. For example, from the taxable
 * income of $400,000 for a single filer, $8,350 is taxed at 10%, (33,950 -
 * 8,350)
 * at 15%, (82,250 - 33,950) at 25%, (171,550 - 82,550) at 28%, (372,550 -
 * 82,250)
 * at 33%, and (400,000 - 372,950) at 36%. The six rates are the same for all
 * filing statuses, which can be represented in the following array:
 *
 * double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
 *
 * The brackets for each rate for all the filing statuses can be represented in
 * a
 * two-dimensional array as follows:
 *
 * int[][] brackets = {
 * {8350, 33950, 82250, 171550, 372950}, // Single filer
 * {16700, 67900, 137050, 20885, 372950}, // Married jointly
 * // -or qualifying widow(er)
 * {8350, 33950, 68525, 104425, 186475}, // Married separately
 * {11950, 45500, 117450, 190200, 372950} // Head of household
 * };
 *
 * Suppose the taxable income is $400,000 for single filers. The tax can be
 * computed as follows:
 * tax = brackets[0][0] * rates[0] +
 * (brackets[0][1] – brackets[0][0]) * rates[1] +
 * (brackets[0][2] – brackets[0][1]) * rates[2] +
 * (brackets[0][3] – brackets[0][2]) * rates[3] +
 * (brackets[0][4] – brackets[0][3]) * rates[4] +
 * (400000 – brackets[0][4]) * rates[5]
 *
 * @author martinfall
 */
public class ComputeTax {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the filing status
        System.out.println("(0-single filer, 1-married jointly or qualifying widow(er),");
        System.out.println("2-married separately, 3-head of household)");
        System.out.print("Enter your filing status: ");
        // Collect filing status from user
        int status = input.nextInt();

        // Prompt the user to enter the taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        // Compute the tax
        double tax = calculateTax(income, getBracket(status));

        // Display the result using a formatted string
        System.out.printf("Tax is $%,.2f%n", (int) (tax * 100) / 100.0);
    }

    /**
     * Calculate the tax
     *
     * @param income
     * @param bracket
     * @return
     */
    public static double calculateTax(double income, int[] bracket) {
        double tax = 0;

        // The six rates for all filing statuses
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        if (income <= bracket[0]) {
            tax = income * rates[0];
        } else if (income <= bracket[1]) {
            tax = bracket[0] * rates[0]
                    + (income - bracket[1]) * rates[1];
        } else if (income <= bracket[2]) {
            tax = bracket[0] * rates[0]
                    + (bracket[1] - bracket[0]) * rates[1]
                    + (income - bracket[1]) * rates[2];
        } else if (income <= 171550) {
            tax = bracket[0] * rates[0]
                    + (bracket[1] - bracket[0]) * rates[1]
                    + (bracket[2] - bracket[1]) * rates[2]
                    + (income - bracket[2]) * rates[3];
        } else if (income <= 372950) {
            tax = bracket[0] * rates[0]
                    + (bracket[1] - bracket[0]) * rates[1]
                    + (bracket[2] - bracket[1]) * rates[2]
                    + (bracket[3] - bracket[2]) * rates[3]
                    + (income - bracket[3]) * rates[5];
        } else {
            tax = bracket[0] * rates[0]
                    + (bracket[1] - bracket[0]) * rates[1]
                    + (bracket[2] - bracket[1]) * rates[2]
                    + (bracket[3] - bracket[2]) * rates[3]
                    + (bracket[4] - bracket[3]) * rates[4]
                    + (income - bracket[4]) * rates[5];
        }
        return tax;
    }

    /**
     * Return the bracket for the corresponding filing status
     *
     * @param status
     * @return
     */
    public static int[] getBracket(int status) {
        // Array representing the brackets for each rate for all filing statuses
        int[][] brackets = {
            {8350, 33950, 82250, 171550, 372950}, // Single filer
            {16700, 67900, 137050, 20885, 372950}, // Married jointly or qualifying widow(er)
            {8350, 33950, 68525, 104425, 186475}, // Married separately
            {11950, 45500, 117450, 190200, 372950} // Head of household
        };

        if (status < 0 || status > 4) {
            // Display wrong status
            System.out.println("Error: invalid status");
            System.exit(1);
        }
        return brackets[status];
    }
}
