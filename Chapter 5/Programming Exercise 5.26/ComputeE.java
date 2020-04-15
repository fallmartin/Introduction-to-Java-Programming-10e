
/**
 * (Compute e) You can approximate e using the following series:
 * e = 1 + 1 / 1! + 1 / 2! + 1 / 3! + 1 / 4! + ... + 1 / i!
 * 
 * Write a program that displays the e value for i = 10000, 20000, …, and
 * 100000. (Hint: Because i! = i * (i - 1) * c * 2 * 1, then
 * 
 * 1 / i! is 1 / (i(i - 1)!)
 * 
 * Initialize e and item to be 1 and keep adding a new item to e. The new item is
 * the previous item divided by i for i = 2, 3, 4, ....)
 * Output:
 *
 * When n is equal to 10,000, e is equal to 2.71828182845904550000.
 * When n is equal to 20,000, e is equal to 2.71828182845904550000.
 * When n is equal to 30,000, e is equal to 2.71828182845904550000.
 * When n is equal to 40,000, e is equal to 2.71828182845904550000.
 * When n is equal to 50,000, e is equal to 2.71828182845904550000.
 * When n is equal to 60,000, e is equal to 2.71828182845904550000.
 * When n is equal to 70,000, e is equal to 2.71828182845904550000.
 * When n is equal to 80,000, e is equal to 2.71828182845904550000.
 * When n is equal to 90,000, e is equal to 2.71828182845904550000.
 * When n is equal to 100,000, e is equal to 2.71828182845904550000.
 *
 */
/**
 *
 * @author martinfall
 */
public class ComputeE {

    public static void main(String[] args) {
        // String format for printf
        String fmt = "When n is equal to %,d, e is equal to %.20f.%n";

        // Loop through the prerequisite intervals with increments of 10,000
        for (int n = 10000; n <= 100000; n += 10000) {
            // Reset e to 1 at every iteration
            double e = 1;
            // Calculate the term item to add to e at each step until n
            for (int i = 1; i <= n; i++) {
                double item = 1;
                for (int j = 1; j <= i; j++) {
                    item *= j;
                }
                e += Math.pow(item, -1); // Use Math.pow to get the inverse
            }
            // Display e at each interval
            System.out.printf(fmt, n, e);
        }

    }
}
