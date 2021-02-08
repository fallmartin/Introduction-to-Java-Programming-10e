package numberofprimenumbers;

import java.io.*;
import java.util.*;

/**
 * (Number of prime numbers) Programming Exercise 22.8 stores the prime numbers
 * in a file named PrimeNumbers.dat. Write a program that finds the number of
 * prime numbers that are less than or equal to 10, 100, 1,000, 10,000,
 * 100,000, 1,000,000, 10,000,000, 100,000,000, 1,000,000,000, and
 * 10,000,000,000. Your program should read the data from PrimeNumbers.dat.
 *
 * Output:
 * All data were read
 * There are 4 prime numbers that are less than or equal to 10
 * There are 20 prime numbers that are less than or equal to 100
 * There are 142 prime numbers that are less than or equal to 1,000
 * There are 1,060 prime numbers that are less than or equal to 10,000
 * There are 8,362 prime numbers that are less than or equal to 100,000
 * ...
 *
 * @author martinfall
 */
public class NumberOfPrimeNumbers {

    // Initialize a counter array variable to hold counts at each step
    static int[] counter = new int[10];

    // Initialize a boolean array to track each benchmark step completion
    static boolean[] complete = new boolean[10];

    /**
     * Main method with driver code.
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        // Create a new file object and test if the file exists
        File file = new File("src/numberofprimenumbers/PrimeNumbers.dat");
        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist.");
            System.exit(0);
        }

        // Create a new input stream
        try ( DataInputStream input
                = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)))) {

            // Initialize index and benchmark variables
            int index = 0;
            int benchmark = 10;

            // Read values from the file
            while (true) {
                // Read in a file from the file
                long value = input.readLong();

                // If the file is less than the benchmark
                if (value <= benchmark) {
                    counter[index]++;
                } else {
                    // Update the completed array
                    complete[index] = true;

                    // Increment index and benchmark
                    index++;
                    benchmark *= 10;

                }

            }
        } catch (EOFException ex) {
            System.out.println("All data were read");
        }

        printResults();
        // System.out.println(Arrays.toString(counter));
    }

    /**
     * Print the results to the console.
     */
    public static void printResults() {
        int index = 0;
        int benchmark = 10;
        for (int count : counter) {
            if (complete[index]) {
                System.out.printf("There are %,d prime numbers that are less "
                        + "than or equal to %,d%n", counter[index], benchmark);
            }

            // Update the index and benchmark variables
            index++;
            benchmark *= 10;
        }
    }
}
