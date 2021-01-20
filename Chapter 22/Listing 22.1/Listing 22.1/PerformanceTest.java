
/**
 * Sample Output:
 * Execution time for n = 1000000 is 6 milliseconds.
 * Execution time for n = 10000000 is 13 milliseconds.
 * Execution time for n = 100000000 is 78 milliseconds.
 * Execution time for n = 1000000000 is 888 milliseconds.
 *
 * @author martinfall
 */
public class PerformanceTest {

    /**
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getTime(1000000);
        getTime(10000000);
        getTime(100000000);
        getTime(1000000000);
    }

    public static void getTime(long n) {
        long startTime = System.currentTimeMillis();
        long k = 0;

        for (int i = 0; i <= n; i++) {
            k = k + 5;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time for n = " + n
                + " is " + (endTime - startTime) + " milliseconds.");
    }

}
