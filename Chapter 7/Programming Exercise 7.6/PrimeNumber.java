
/**
 * (Revise Listing 5.15, PrimeNumber.java) Listing 5.15 determines whether a
 * number n is prime by checking whether 2, 3, 4, 5, 6, ..., n/2 is a divisor.
 * If a divisor is found, n is not prime. A more efficient approach is to check
 * whether any of the prime numbers less than or equal to the square root of n
 * can divide n evenly. If not, n is prime. Rewrite Listing 5.15 to display the
 * first 50 prime numbers using this approach. You need to use an array to store
 * the prime numbers and later use them to check whether they are possible
 * divisors for n.
 *
 * @author martinfall
 */
public class PrimeNumber {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 50;

        // Create an array 
        int[] listOfPrimes = new int[NUMBER_OF_PRIMES];

        // Create a counter and a number assumed to be prime initially
        int arrayIndex = 0;
        int number = 2;

        // Add the first prime to the array
        listOfPrimes[arrayIndex] = number;

        // Populate the array with primes
        populateArray(arrayIndex, NUMBER_OF_PRIMES, number, listOfPrimes);

        // Display the primes
        // System.out.println(Arrays.toString(listOfPrimes));
        displayArray(listOfPrimes);
    }

    /**
     * Populate the array
     *
     * @param arrayIndex
     * @param NUMBER_OF_PRIMES
     * @param number
     * @param listOfPrimes
     */
    public static void populateArray(
            int arrayIndex, // Array index
            final int NUMBER_OF_PRIMES, // Number of primes
            int number, // Initial number being tested
            int[] listOfPrimes) { // Array of primes
        while (arrayIndex < NUMBER_OF_PRIMES - 1) { // While less than 50 - 1
            number++; // Increment number
            if (checkPrimeness(listOfPrimes, number)) { // If the number is prime
                arrayIndex++; // Increment the index
                listOfPrimes[arrayIndex] = number; // Add the next prime to array
            }
        }
    }

    /**
     * Check if a number is prime based on the numbers in the array
     *
     * @param listOfPrimes
     * @param number
     * @return
     */
    public static boolean checkPrimeness(int[] listOfPrimes, int number) {
        boolean flag = true;

        for (int i = 0; listOfPrimes[i] <= (int) (Math.sqrt(number)); i++) {
            if (number % listOfPrimes[i] == 0) {
                flag = false;
            }
        }

        return flag;
    }

    /**
     * Display the array
     *
     * @param listOfPrimes
     */
    public static void displayArray(int[] listOfPrimes) {
        String format = "%-5d";
        int counter = 0;

        // Loop through the array
        for (int i = 0; i < listOfPrimes.length; i++) {
            System.out.printf(format, listOfPrimes[i]);
            counter++;
            if (counter % 10 == 0) {
                System.out.println();
            }
        }
    }
}
