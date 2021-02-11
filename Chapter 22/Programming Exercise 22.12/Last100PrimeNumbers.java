package last100primenumbers;

import java.io.*;
import java.util.*;

/**
 * (Last 100 prime numbers) Programming Exercise 22.8 stores the prime numbers
 * in a file named PrimeNumbers.dat. Write an efficient program that reads the
 * last 100 numbers in the file. (Hint: Don’t read all numbers from the file.
 * Skip all numbers before the last 100 numbers in the file.)
 *
 * Output:
 * Enter the pathname for the file PrimeNumbers.dat:
 * src/last100primenumbers/PrimeNumbers.dat
 * Reading PrimeNumbers.dat...
 * 101399	101411	101419	101429	101449
 * 101467	101477	101483	101489	101501
 * 101503	101513	101527	101531	101533
 * 101537	101561	101573	101581	101599
 * 101603	101611	101627	101641	101653
 * 101663	101681	101693	101701	101719
 * 101723	101737	101741	101747	101749
 * 101771	101789	101797	101807	101833
 * 101837	101839	101863	101869	101873
 * 101879	101891	101917	101921	101929
 * 101939	101957	101963	101977	101987
 * 101999	102001	102013	102019	102023
 * 102031	102043	102059	102061	102071
 * 102077	102079	102101	102103	102107
 * 102121	102139	102149	102161	102181
 * 102191	102197	102199	102203	102217
 * 102229	102233	102241	102251	102253
 * 102259	102293	102299	102301	102317
 * 102329	102337	102359	102367	102397
 * 102407	102409	102433	102437	102451
 *
 * @author martinfall
 */
public class Last100PrimeNumbers {

    // Constant data fields
    private static final int NUMBER_OF_PRIMES_READ = 100;
    private static final int BYTES_PER_LONG = 8;
    private static final int LEN = NUMBER_OF_PRIMES_READ * BYTES_PER_LONG;

    // Create an array to store the values read from raf
    private static final long[] last100primes = new long[NUMBER_OF_PRIMES_READ];

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        // Create a new Scanner with a try-with-resources block
        try ( Scanner scanner = new Scanner(System.in)) {
            // Accept input for the file
            System.out.println("Enter the pathname for the file PrimeNumbers.dat:");
            String pathname = scanner.nextLine();

            // Create a File object from the pathname of the file
            // src/last100primenumbers/PrimeNumbers.dat
            File file = new File(pathname);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("Enter a valid pathname for PrimeNumbers.dat");
                System.exit(0); // Exit the program if the file is not valid
            } else {
                System.out.println("Reading " + file.getName() + "...");
            }

            // Create a data input stream to read long values from the file
            try ( RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                // Set the file-pointer offset to 
                // length - (number of primes * length of each long in bytes)
                raf.seek(raf.length() - LEN);

                for (int i = 0; i < NUMBER_OF_PRIMES_READ; i++) {
                    last100primes[i] = raf.readLong();
                }
            }
        }

        // Display the last 100 primes
        for (int i = 0; i < last100primes.length; i++) {
            System.out.print(last100primes[i] + "\t");

            // Go to a new line every 5 numbers
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }
}
