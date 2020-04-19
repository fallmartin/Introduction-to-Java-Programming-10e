/**
 * 
 * The first 50 prime numbers are 

2    3    5    7    11   13   17   19   23   29   
31   37   41   43   47   53   59   61   67   71   
73   79   83   89   97   101  103  107  109  113  
127  131  137  139  149  151  157  163  167  173  
179  181  191  193  197  199  211  223  227  229  
 * 
 */

/**
 *
 * @author martinfall
 */
public class PrimeNumberMethod {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The first 50 prime numbers are \n");
        printPrimeNumbers(50);
    }

    /**
     * Print prime numbers
     *
     * @param numberOfPrimes
     */
    public static void printPrimeNumbers(int numberOfPrimes) {
        final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 numbers per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        // Repeatedly find prime numbers
        while (count < numberOfPrimes) {
            // Print the prime number and increase the count
            if (isPrime(number)) {
                count++; // Increase the count

                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.printf("%-5s\n", number);
                } else {
                    System.out.printf("%-5s", number);
                }
            }
            // Check whether the number is prime
            number++;
        }
    }

    /**
     * Check whether number is prime
     *
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
                return false; // Number is not a prime
            }
        }
        return true; // Number is prime
    }
}
