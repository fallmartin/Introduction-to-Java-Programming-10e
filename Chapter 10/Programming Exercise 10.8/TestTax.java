
/**
 * Write a test program that uses the Tax class to print the 2001 and 2009 tax
 * tables for taxable income from $50,000 to $60,000 with intervals of $1,000 for
 * all four statuses. The tax rates for the year 2009 were given in Table 3.2.
 * The tax rates for 2001 are shown in Table 10.1.
 *
 * Output:
 * 
 * 2001 United States Federal Personal Tax Rates
 *
 * Taxable             Single              Married Jointly     Married             Head of
 * Income              Filer               Qualified Widow(er) Separately          Household
 * ----------------------------------------------------------------------------------------------------
 * 50000.00            10368.75            8100.00             10925.00            9218.75
 * 51000.00            10643.75            8375.00             11200.00            9493.75
 * 52000.00            10918.75            8650.00             11475.00            9768.75
 * 53000.00            11193.75            8925.00             11750.00            10043.75
 * 54000.00            11468.75            9200.00             12025.00            10318.75
 * 55000.00            11743.75            9475.00             12311.25            10593.75
 * 56000.00            12018.75            9750.00             12616.25            10868.75
 * 57000.00            12293.75            10025.00            12921.25            11143.75
 * 58000.00            12568.75            10300.00            13226.25            11418.75
 * 59000.00            12843.75            10575.00            13531.25            11693.75
 * 60000.00            13118.75            10850.00            13836.25            11968.75
 *
 * 2009 United States Federal Personal Tax Rates
 *
 * Taxable             Single              Married Jointly     Married             Head of
 * Income              Filer               Qualified Widow(er) Separately          Household
 * ----------------------------------------------------------------------------------------------------
 * 50000.00            8687.50             6665.00             8687.50             7352.50
 * 51000.00            8937.50             6815.00             8937.50             7602.50
 * 52000.00            9187.50             6965.00             9187.50             7852.50
 * 53000.00            9437.50             7115.00             9437.50             8102.50
 * 54000.00            9687.50             7265.00             9687.50             8352.50
 * 55000.00            9937.50             7415.00             9937.50             8602.50
 * 56000.00            10187.50            7565.00             10187.50            8852.50
 * 57000.00            10437.50            7715.00             10437.50            9102.50
 * 58000.00            10687.50            7865.00             10687.50            9352.50
 * 59000.00            10937.50            8015.00             10937.50            9602.50
 * 60000.00            11187.50            8165.00             11187.50            9852.50
 *
 * @author martinfall
 */
public class TestTax {

    public static void main(String[] args) {

        // 2001 United States Federal Personal Tax Rates
        int[][] brackets2001 = {
            {27050, 65550, 136750, 297350}, // Single filer
            {45200, 109250, 166500, 297350}, // Married jointly or qualifying widow(er)
            {22600, 54625, 83250, 148675}, // Married separately
            {36250, 93650, 151650, 297350} // Head of household
        };

        double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

        System.out.println("2001 United States Federal Personal Tax Rates\n");
        printTaxTables(brackets2001, rates2001);
        System.out.println(); // Formatted new line

        // 2009 United States Federal Personal Tax Rates
        int[][] brackets2009 = {
            {8350, 33950, 82250, 171550, 372950}, // Single filer
            {16700, 67900, 137050, 20885, 372950}, // Married jointly or qualifying widow(er)
            {8350, 33950, 68525, 104425, 186475}, // Married separately
            {11950, 45500, 117450, 190200, 372950} // Head of household
        };

        double[] rates2009 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        System.out.println("2009 United States Federal Personal Tax Rates\n");
        printTaxTables(brackets2009, rates2009);
        System.out.println(); // Formatted new line
    }

    public static void printTaxTables(int[][] brackets, double[] rates) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                "Taxable", "Single", "Married Jointly", "Married", "Head of");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                "Income", "Filer", "Qualified Widow(er)", "Separately", "Household");
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
            // String title = String.format("Taxable income: $%,.2f", (double) taxableIncome);
            System.out.printf("%-20.2f", (double) taxableIncome);
            for (int filingStatus = Tax.SINGLE_FILER;
                    filingStatus <= Tax.HEAD_OF_HOUSEHOLD;
                    filingStatus++) {
                // Construct a new Tax object
                Tax tax = new Tax(filingStatus, brackets, rates, taxableIncome);
                // System.out.println(tax.getFilingStatus());
                // System.out.println(Arrays.deepToString(tax.getBrackets()));
                // System.out.println(Arrays.toString(tax.getRates()));
                // System.out.println(tax.getTaxableIncome());
                System.out.printf("%-20.2f", tax.getTax());
            }
            System.out.println();
        }
    }

}
