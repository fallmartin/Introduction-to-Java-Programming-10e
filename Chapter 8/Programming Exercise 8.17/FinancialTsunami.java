
import java.util.Scanner;

/**
 * (Financial tsunami) Banks lend money to each other. In tough economic times,
 * if a bank goes bankrupt, it may not be able to pay back the loan. A bank’s
 * total assets are its current balance plus its loans to other banks. The
 * diagram
 * in Figure 8.8 shows five banks. The banks’ current balances are 25, 125, 175,
 * 75, and 181 million dollars, respectively. The directed edge from node 1 to
 * node 2 indicates that bank 1 lends 40 million dollars to bank 2.
 *
 * If a bank’s total assets are under a certain limit, the bank is unsafe. The
 * money it borrowed cannot be returned to the lender, and the lender cannot
 * count
 * the loan in its total assets. Consequently, the lender may also be unsafe, if
 * its total assets are under the limit. Write a program to find all the unsafe
 * banks. Your program reads the input as follows. It first reads two integers n
 * and limit, where n indicates the number of banks and limit is the minimum
 * total
 * assets for keeping a bank safe. It then reads n lines that describe the
 * information for n banks with IDs from 0 to n-1. The first number in the line
 * is
 * the bank’s balance, the second number indicates the number of banks that
 * borrowed money from the bank, and the rest are pairs of two numbers. Each
 * pair
 * describes a borrower. The first number in the pair is the borrower’s ID and
 * the
 * second is the amount borrowed. For example, the input for the five banks in
 * Figure 8.8 is as follows (note that the limit is 201):
 *
 * 5 201
 * 25 2 1 100.5 4 320.5
 * 125 2 2 40 3 85
 * 175 2 0 125 3 75
 * 75 1 0 125
 * 181 1 2 125
 *
 * The total assets of bank 3 are (75 + 125), which is under 201, so bank 3 is
 * unsafe. After bank 3 becomes unsafe, the total assets of bank 1 fall below
 * (125 + 40). Thus, bank 1 is also unsafe. The output of the program should be
 * Unsafe banks are 3 1
 * (Hint: Use a two-dimensional array borrowers to represent loans.
 * borrowers[i][j] indicates the loan that bank i loans to bank j. Once bank j
 * becomes unsafe, borrowers[i][j] should be set to 0.)
 *
 * @author martinfall
 */
public class FinancialTsunami {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of banks and 
        System.out.print("Enter the number of banks: ");
        int n = input.nextInt();
        // Prompt tthe user to enter the minimum total assets for keeping a bank safe
        System.out.print("Enter the minimum total assets for keeping a bank safe: ");
        double limit = input.nextDouble();

        // Create arrays
        double[] balances = new double[n]; // Balances
        double[][] borrowers = new double[n][n]; // Borrowers array

        for (int i = 0; i < n; i++) {
            balances[i] = input.nextDouble();
            int numberOfBorrowers = input.nextInt();

            for (int k = 0; k < numberOfBorrowers; k++) {
                int j = input.nextInt();
                double loan = input.nextDouble();
                borrowers[i][j] = loan;
            }
        }

        /*
        25 2 1 100.5 4 320.5
        125 2 2 40 3 85
        175 2 0 125 3 75
        75 1 0 125
        181 1 2 125
         */
        int[] unsafe = cascadeFailure(limit, balances, borrowers);

        // Print the results as required
        printResults(unsafe);
    }

    /**
     * Financial tsunami
     *
     * @param limit
     * @param balances
     * @param borrowers
     * @return
     */
    public static int[] cascadeFailure(double limit, double[] balances, double[][] borrowers) {
        boolean flag; // Boolean flag

        // Create an array to hold safe (0) and unsafe (1) banks
        int[] unsafe = new int[balances.length];

        do {
            flag = false; // drop the flag

            // Grab updated assets after each pass of the do-while loop
            double[] assets = getAssets(balances, borrowers);

            // For each element in assets
            for (int i = 0; i < assets.length; i++) {
                // If the bank's assets are less than the limit and
                // this is not yet reflected in the array unsafe
                if (assets[i] < limit && unsafe[i] == 0) {
                    unsafe[i] = 1; // Update unsafe

                    // Zero out the bank's assets
                    for (int j = 0; j < borrowers.length; j++) {
                        borrowers[j][i] = 0.0;
                    }
                    flag = true; // Raise the flag
                }
            }

        } while (flag); // Execute the loop while the flag is raised
        return unsafe;
    }

    /**
     * Get assets for each bank
     *
     * @param balances
     * @param borrowers
     * @return
     */
    public static double[] getAssets(double[] balances, double[][] borrowers) {
        double[] assets = new double[borrowers.length];

        for (int bank = 0; bank < balances.length; bank++) {
            double totalAssets = balances[bank];
            for (int borrower = 0; borrower < borrowers.length; borrower++) {
                totalAssets += borrowers[bank][borrower];
            }
            assets[bank] = totalAssets;
        }
        return assets;
    }

    /**
     * Print results using StringBuilder
     *
     * @param unsafe
     */
    public static void printResults(int[] unsafe) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < unsafe.length; i++) {
            if (unsafe[i] == 1) {
                sb.append(i).append(" ");
            }
        }

        if (sb.equals("")) {
            System.out.println("All banks are safe.");
        } else {
            sb.insert(0, "Unsafe banks are ");
        }
        System.out.println(sb);
    }
}
