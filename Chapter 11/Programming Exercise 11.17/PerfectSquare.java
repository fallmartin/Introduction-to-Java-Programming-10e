
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * (Algebra: perfect square) Write a program that prompts the user to enter an
 * integer m and find the smallest integer n such that m * n is a perfect
 * square. (Hint: Store all smallest factors of m into an array list. n is the
 * product of the factors that appear an odd number of times in the array list.
 * For example, consider m = 90, store the factors 2, 3, 3, 5 in an array list.
 * 2 and 5 appear an odd number of times in the array list. So, n is 10.)
 * Here are sample runs:
 *
 * Enter an integer m: 1500
 * The smallest number n for m * n to be a perfect square is 15
 * m * n is 22500
 *
 * Enter an integer m: 63
 * The smallest number n for m * n to be a perfect square is 7
 * m * n is 441
 *
 * @author martinfall
 */
public class PerfectSquare {

    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer m.
        System.out.print("Enter an integer m: ");
        int m = input.nextInt();

        // Create a new ArrayList of type Integer
        ArrayList<Integer> factors = findFactors(m);

        // Uncomment the following line to display the list of factors to console
        // System.out.println(factors);

        // Multiply factors that appear an odd number of times in the array list
        int n = processFactors(factors);

        // Display the result
        System.out.println("The smallest number n for m * n to be "
                + "a perfect square is " + n);
        System.out.println("m * n is " + m * n);

    }

    /**
     * Returns all the smallest factors of m into an array list.
     *
     * @param m
     * @return
     */
    public static ArrayList<Integer> findFactors(int m) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= m;) {
            if (m % i == 0) {
                factors.add(i);
                m = m / i;
            } else {
                i++;
            }
        }

        return factors;
    }

    /**
     * Process the smallest factors of m and returns the smallest integer n such
     * that m * n is a perfect square.
     *
     * @param factors
     * @return
     */
    public static int processFactors(ArrayList<Integer> factors) {
        // Declare a new variable n
        int n = 1;

        // Create an array list without duplicate factors
        ArrayList<Integer> factorsNoDuplicates = new ArrayList<>();
        for (int i = 0; i < factors.size(); i++) {
            if (!factorsNoDuplicates.contains(factors.get(i))) {
                factorsNoDuplicates.add(factors.get(i));
            }
        }

        // Display the list of factors without duplicates
        // System.out.println(factorsNoDuplicates);
        // Loop through 
        for (int i = 0; i < factorsNoDuplicates.size(); i++) {
            int instances = count(factorsNoDuplicates.get(i), factors);
            // Display the number of times a number appears in our list
            // System.out.println(instances);

            if (instances % 2 == 1) {
                n *= factorsNoDuplicates.get(i);
            }
        }

        return n;
    }

    /**
     * Returns the number of times number appears in factors.
     *
     * @param number
     * @param factors
     * @return
     */
    public static int count(Integer number, ArrayList<Integer> factors) {
        int counter = 0;

        for (int i = 0; i < factors.size(); i++) {
            if (Objects.equals(factors.get(i), number)) {
                counter++;
            }
        }
        return counter;
    }
}
