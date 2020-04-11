/**
 * (Find the smallest n such that n^2 > 12,000) Use a while loop to find the 
 * smallest integer n such that n2 is greater than 12,000.
 * 
 * Output:
 * The smallest n such that n^2 > 12,000 is 110
 */

/**
 *
 * @author martinfall
 */
public class SmallestN {
    public static void main(String[] args) {
        final int LIMIT = 12000;
        int n = 100; // Easy to determine that n > 100 since 100^2 = 10,000
        while (Math.pow(n, 2) <= LIMIT) {
            n++;
        }
        System.out.println("The smallest n such that n^2 > 12,000 is " + n);
    }
}
