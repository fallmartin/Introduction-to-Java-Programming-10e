
/**
 * ﻿(Financial application: print a tax table) Listing 3.5 gives a program to
 * compute tax. Write a method for computing tax using the following header:
 *
 * public static double computeTax(int status, double taxableIncome)
 *
 * ﻿Use this method to write a program that prints a tax table for taxable income
 * from $50,000 to $60,000 with intervals of $50 for all the following statuses:
 *
 * @author martinfall
 */
public class PrintTaxTable {

    public static void main(String[] args) {
        // Display the table header
        displayTableHeader();
        
        // Display the table body
        displayTableBody();
    }

    /**
     * Display table header
     */
    public static void displayTableHeader() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "Taxable", "Single", "Married Joint", "Married", "Head of");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "Income", "", "or Qualifying", "Separate", "a House");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "", "", "Widow(er)", "", "");
        System.out.println("------------------------------------------------------"
                + "------------------");
    }
    
    /**
     * Display table body
     */
    public static void displayTableBody() {
        for (double taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 50) {
            System.out.printf("%-15.0f", taxableIncome);
            for (int status = 0; status <= 3; status++) {
                System.out.printf("%-15.0f", computeTax(status, taxableIncome));
            }
            System.out.println();
        }
    }

    /**
     * Compute tax
     *
     * @param status
     * @param taxableIncome
     * @return
     */
    public static double computeTax(int status, double taxableIncome) {

        double tax = 0;

        switch (status) {
            case 0:
                // Compute tax for single filers
                if (taxableIncome <= 8350) {
                    tax = taxableIncome * 0.10;
                } else if (taxableIncome <= 33950) {
                    tax = 8350 * 0.10
                            + (taxableIncome - 8350) * 0.15;
                } else if (taxableIncome <= 82250) {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (taxableIncome - 33950) * 0.25;
                } else if (taxableIncome <= 171550) {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25
                            + (taxableIncome - 82250) * 0.28;
                } else if (taxableIncome <= 372950) {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25
                            + (171550 - 82250) * 0.28
                            + (taxableIncome - 171550) * 0.33;
                } else {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25
                            + (171550 - 82250) * 0.28
                            + (372950 - 171550) * 0.33
                            + (taxableIncome - 372950) * 0.35;
                }
                break;
            case 1:
                // Compute tax for married file jointly or qualifying widow(er)
                if (taxableIncome <= 16700) {
                    tax = taxableIncome * 0.10;
                } else if (taxableIncome <= 67900) {
                    tax = 16700 * 0.10
                            + (taxableIncome - 16700) * 0.15;
                } else if (taxableIncome <= 137050) {
                    tax = 16700 * 0.10
                            + (67900 - 16700) * 0.15
                            + (taxableIncome - 67900) * 0.25;
                } else if (taxableIncome <= 208850) {
                    tax = 16700 * 0.10
                            + (67900 - 16700) * 0.15
                            + (137050 - 67900) * 0.25
                            + (taxableIncome - 137050) * 0.28;
                } else if (taxableIncome <= 372950) {
                    tax = 16700 * 0.10
                            + (67900 - 16700) * 0.15
                            + (137050 - 67900) * 0.25
                            + (208850 - 137050) * 0.28
                            + (taxableIncome - 208850) * 0.33;
                } else {
                    tax = 16700 * 0.10
                            + (67900 - 16700) * 0.15
                            + (137050 - 67900) * 0.25
                            + (208850 - 137050) * 0.28
                            + (372950 - 208850) * 0.33
                            + (taxableIncome - 372950) * 0.35;
                }
                break;
            case 2:
                // Compute tax for married separately
                if (taxableIncome <= 8350) {
                    tax = taxableIncome * 0.10;
                } else if (taxableIncome <= 33950) {
                    tax = 8350 * 0.10
                            + (taxableIncome - 8350) * 0.15;
                } else if (taxableIncome <= 68525) {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (taxableIncome - 33950) * 0.25;
                } else if (taxableIncome <= 104425) {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (68525 - 33950) * 0.25
                            + (taxableIncome - 68525) * 0.28;
                } else if (taxableIncome <= 186475) {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (68525 - 33950) * 0.25
                            + (104425 - 68525) * 0.28
                            + (taxableIncome - 104425) * 0.33;
                } else {
                    tax = 8350 * 0.10
                            + (33950 - 8350) * 0.15
                            + (68525 - 33950) * 0.25
                            + (104425 - 68525) * 0.28
                            + (186475 - 104425) * 0.33
                            + (taxableIncome - 186475) * 0.35;
                }
                break;
            case 3:
                // Compute tax for head of household
                if (taxableIncome <= 11950) {
                    tax = taxableIncome * 0.10;
                } else if (taxableIncome <= 45500) {
                    tax = 11950 * 0.10
                            + (taxableIncome - 11950) * 0.15;
                } else if (taxableIncome <= 117450) {
                    tax = 11950 * 0.10
                            + (45500 - 11950) * 0.15
                            + (taxableIncome - 45500) * 0.25;
                } else if (taxableIncome <= 190200) {
                    tax = 11950 * 0.10
                            + (45500 - 11950) * 0.15
                            + (117451 - 45500) * 0.25
                            + (taxableIncome - 117451) * 0.28;
                } else if (taxableIncome <= 372950) {
                    tax = 11950 * 0.10
                            + (45500 - 11950) * 0.15
                            + (117451 - 45500) * 0.25
                            + (190200 - 117451) * 0.28
                            + (taxableIncome - 190200) * 0.33;
                } else {
                    tax = 11950 * 0.10
                            + (45500 - 11950) * 0.15
                            + (117451 - 45500) * 0.25
                            + (190200 - 117451) * 0.28
                            + (372950 - 190200) * 0.33
                            + (taxableIncome - 372950) * 0.35;
                }
                break;
            default:
                // Display wrong status
                System.out.println("Error: invalid status");
                System.exit(1);
        }

        return tax;
    }
}
