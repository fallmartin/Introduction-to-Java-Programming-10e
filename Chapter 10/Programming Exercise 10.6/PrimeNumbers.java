
/**
 * (Displaying the prime numbers) Write a program that displays all the prime
 * numbers less than 120 in decreasing order. Use the StackOfIntegers class
 * to store the prime numbers (e.g., 2, 3, 5, ...) and retrieve and display them
 * in reverse order.
 *
 * Output:
 * 113 109 107 103 101 97 89 83 79 73 71 67 61 59 53 47 43 41 37 31 29 23 19 17 13 11 7 5 3 2
 *
 * @author martinfall
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        // Create a new StackOfIntegers object
        StackOfIntegers stack = new StackOfIntegers();

        // Populate the stack with primes
        for (int i = 2; i < 120; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }

        // Print the stack to console in reverse order
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
