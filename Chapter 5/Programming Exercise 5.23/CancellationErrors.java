
/**
 * (Demonstrate cancellation errors) A cancellation error occurs when you are
 * manipulating a very large number with a very small number. The large number
 * may cancel out the smaller number. For example, the result of 100000000.0 +
 * 0.000000001 is equal to 100000000.0. To avoid cancellation errors and obtain
 * more accurate results, carefully select the order of computation. For example, in
 * computing the following series, you will obtain more accurate results by
 * computing from right to left rather than from left to right:
 * 1 + 1/2 + 1/3 + ... + 1/n
 * Write a program that compares the results of the summation of the preceding
 * series, computing from left to right and from right to left with n = 50000
 *
 * Output:
 * From right to left: 11.397003949278519
 * From left to right: 11.397003949278504
 * Computing from right to left is more accurate.
 */
/**
 *
 * @author martinfall
 */
public class CancellationErrors {

    public static void main(String[] args) {
        // Declare a variable constant N and assign it the value 5000
        final int N = 50000;

        // Compute from right to left
        double sigmaR2L = 0; // sigma from right to left
        for (int i = N; i >= 1; i--) {
            sigmaR2L += 1.0 / i;
        }

        // Compute from left to right
        double sigmaL2R = 0; // sigma from left to right
        for (int i = 1; i <= N; i++) {
            sigmaL2R += 1.0 / i;
        }

        // Result from online sigma calculator 11.397003949278504
        System.out.println("From right to left: " + sigmaR2L);
        System.out.println("From left to right: " + sigmaL2R);

        if (sigmaR2L > sigmaL2R) {
            System.out.println("Computing from right to left is more accurate.");
        } else {
            System.out.println("Computing from left to right is more accurate.");
        }
    }
}
