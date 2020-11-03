
/**
 * Output:
 * 
 * 0! = 1
 * 1! = 1
 * 2! = 2
 * 3! = 6
 * 4! = 24
 * 5! = 120
 * 6! = 720
 * 7! = 5040
 * 8! = 40320
 * 9! = 362880
 * 10! = 3628800
 *
 * @author martinfall
 */
public class ComputeFactorialTailRecursion {

    /**
     * Return the factorial for a specified number.
     *
     * @param n
     * @return
     */
    public static long factorial(int n) {
        return factorial(n, 1);
    }

    /**
     * Auxiliary tail-recursive method for factorial.
     *
     * @param n
     * @param result
     * @return
     */
    public static long factorial(int n, int result) {
        if (n == 0) { // Base case
            return result;
        } else {
            return factorial(n - 1, n * result); // Recursive call
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }
}
