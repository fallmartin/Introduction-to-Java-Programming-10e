
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Math: combinations) Write a program that prompts the user to enter 10
 * integers and displays all combinations of picking two numbers from the 10.
 *
 * Assumptions: When the order of items doesn’t matter, that’s called a
 * Combination. Since we are not allowed to repeat items, we use the nCr formula
 * which results in 45 possible combinations for n = 10;
 * https://www.statisticshowto.com/calculators/permutation-calculator-and-combination-calculator/
 *
 * @author martinfall
 */
public class Combinations {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 10; // number of items in set
        int r = 2; // number of items selected from the set

        // Create a new array
        int[] list = new int[n];

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter 10 integers
        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        // Create an array to hold the combinations
        int[] combinations = new int[nChooseR(n, r)];

        System.out.println("There are " + combinations.length
                + " combinations of picking two numbers from the set of " + n);

        // Populate the array
        populateArray(combinations, list);

        // Display array
        printResults(combinations);
    }

    /**
     * Populate the array
     *
     * @param combinations
     * @param list
     * @throws NumberFormatException
     */
    public static void populateArray(int[] combinations, int[] list) {
        for (int i = 0; i < combinations.length; i++) {
            for (int j = 0; j < list.length; j++) {
                for (int k = 0; k < list.length; k++) {
                    String num1String = Integer.toString(list[j]);
                    String num2String = Integer.toString(list[k]);

                    String tempCombination1 = num1String + num2String;
                    String tempCombination2 = num2String + num1String;

                    int temp1 = Integer.parseInt(tempCombination1);
                    int temp2 = Integer.parseInt(tempCombination2);

                    // System.out.println(temp1 + " and " + temp2);
                    Arrays.sort(combinations);

                    if (Arrays.binarySearch(combinations, temp1) < 0
                            && Arrays.binarySearch(combinations, temp2) < 0
                            && temp1 != temp2) {
                        combinations[i] = temp1;
                    }
                }
            }
            if (true) {
                // Add to combinations array
            }
        }
    }

    /**
     * Calculate n choose r
     *
     * @param n
     * @param r
     * @return
     */
    public static int nChooseR(int n, int r) {
        int combinations = 0;

        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    /**
     * Factorial calculator for nCr formula
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Print the program's results
     *
     * @param combinations
     */
    public static void printResults(int[] combinations) {
        for (int i = 1; i <= combinations.length; i++) {
            System.out.print((i % 10) == 0 ? combinations[i - 1] + "\n" : combinations[i - 1] + "\t");
        }
    }
}
