
import java.util.Scanner;

/**
 * (Sum series) Write a recursive method to compute the following series:
 *
 * m(i) = 1 + 1/2 + 1/3 + ... + 1/i
 *
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 *
 * Output:
 * m(1) = 1.0
 * m(2) = 1.5
 * m(3) = 1.8333333333333333
 * m(4) = 2.083333333333333
 * m(5) = 2.283333333333333
 * m(6) = 2.45
 * m(7) = 2.592857142857143
 * m(8) = 2.717857142857143
 * m(9) = 2.828968253968254
 * m(10) = 2.928968253968254
 *
 * @author martinfall
 */
public class SumSeries {

    /**
     * Returns the sum of the series m.
     *
     * @param i
     * @return
     */
    public static double m(int i) {
        // Recursive helper method with auxiliary parameters
        return m(i, 1); // Call auxiliary method
    }

    /**
     * Auxiliary tail-recursive method for m.
     *
     * @param i
     * @param result
     * @return
     */
    public static double m(int i, double result) {
        if (i == 1) {
            return result;
        } else {
            // System.out.println(1.0 / i);
            return m(i - 1, result + (1.0 / i));
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("m(" + i + ") = " + m(i));
        }
    }
}
