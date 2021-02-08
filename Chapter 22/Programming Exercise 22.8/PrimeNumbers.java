
import java.io.*;
import java.util.*;

/**
 * (All prime numbers up to 10,000,000,000) Write a program that finds all prime
 * numbers up to 10,000,000,000. There are approximately 455,052,511 such prime
 * numbers. Your program should meet the following requirements:
 *
 * ■ Your program should store the prime numbers in a binary data file, named
 * PrimeNumbers.dat. When a new prime number is found, the number is appended to
 * the file.
 *
 * ■ To find whether a new number is prime, your program should load the prime
 * numbers from the file to an array of the long type of size 10000. If no
 * number in the array is a divisor for the new number, continue to read the
 * next 10000 prime numbers from the data file, until a divisor is found or all
 * numbers in the file are read. If no divisor is found, the new number is
 * prime.
 *
 * ■ Since this program takes a long time to finish, you should run it as a
 * batch job from a UNIX machine. If the machine is shut down and rebooted, your
 * program should resume by using the prime numbers stored in the binary data
 * file rather than start over from scratch.
 *
 * @author martinfall
 */
public class PrimeNumbers {

    // 10_000_000_000L
    private static final long LIMIT = 10_000_000_000L; // 10,000,000,000
    private static final int BUFFER = 10_000; // 10,000
    private static final int SIZE = 8; // Size of long data type

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        try ( RandomAccessFile raf
                = new RandomAccessFile("PrimeNumbers.dat", "rw")) {

            // Create an array of the long type of size 10000
            ArrayList<Long> primes = new ArrayList<>();

            // Number to be considered for primeness
            long number = -1; // Throwaway value
            if (raf.length() == 0) {
                // 2 is the file is empty at first run
                number = 2; // The first prime number
                raf.writeLong(number);
            } else {
                // Last value of type long saved to the file otherwise
                raf.seek(raf.length() - 8);
                number = raf.readLong() + 1;
            }

            System.out.println("Starting number: " + number);

            while (number < LIMIT) {
                // Boolean flag assuming the number to consider is prime
                boolean isPrime = true;

                // Set the file-pointer to the beginning of the file
                raf.seek(0);

                // While there are values in the file to be read
                while (raf.getFilePointer() < raf.length()) {
                    // Remove all of the elements from the primes array list
                    primes.clear();

                    // Populate the array list with N values
                    for (int i = 0; i < BUFFER && (i * SIZE) < raf.length(); i++) {
                        primes.add(raf.readLong());
                    }

                    for (Long prime : primes) {
                        if (number % prime == 0) {
                            isPrime = false;
                        }
                    }

                    // Write number to raf if the boolean flag isPrime is true
                    if (isPrime) {
                        System.out.println(number); // HERE
                        raf.writeLong(number);
                    }
                    // Uncomment statement below to see array list size at each pass
                    // System.out.println(primes.size());
                }

                // Increment number by 1
                number++;
            }

        }
    }
}
