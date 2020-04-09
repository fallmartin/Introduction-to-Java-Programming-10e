
/**
 * Output:
 * The first 50 prime numbers are
 *
 * 2 3 5 7 11 13 17 19 23 29
 * 31 37 41 43 47 53 59 61 67 71
 * 73 79 83 89 97 101 103 107 109 113
 * 127 131 137 139 149 151 157 163 167 173
 * 179 181 191 193 197 199 211 223 227 229
 */
/**
 *
 * @author martinfall
 */
public class PrimeNumber {
// Main method

    public static void main(String[] args) {

        // Declare a constant variable for the number of primes to display
        final int NUMBER_OF_PRIMES = 50;
        // Number of prim numbers to display per line
        final int NUMBER_OF_PRIMES_PER_LINE = 10;
        // Count the number of prime numbers
        int count = 0;
        // Starting number to be tested for primeness
        int number = 2;

        System.out.println("The first 50 prime numbers are\n");

        // Repeatedly find prime numbers
        while (count < NUMBER_OF_PRIMES) {
            // Assume that the number is prime
            boolean isPrime = true;

            // Test the number for primeness
            // Divide the number by 2, 3, 4, ... all the up to number / 2
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                // If the number is divisible by the divisor with no remainder,
                // the number is prime
                if (number % divisor == 0) { // If true, the number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the loop, because the number is not prime
                }
            }

            // If the number is prime, perform the following operations
            if (isPrime) {
                count++; // Increment crount

                // Print a new line after NUMBER_OF_PRIMES_PER_LINE primes are displayed
                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    System.out.println(number);
                } else {
                    System.out.print(number + " ");
                }
            }

            // Check if the next number is prime
            number++;
        }
    }
}
