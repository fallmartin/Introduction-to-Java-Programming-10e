
import java.io.*;

/**
 * (Sum all the integers in a binary data file) Suppose a binary data file named
 * Exercise17_03.dat has been created and its data are created using
 * writeInt(int) in DataOutputStream. The file contains an unspecified number of
 * integers. Write a program to find the sum of the integers.
 *
 * Output:
 * 41
 * 78
 * 70
 * 94
 * 27
 * 50
 * 23
 * 84
 * 72
 * 35
 * The sum of all integers in the file is 574
 *
 * @author martinfall
 */
public class Sum {

    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        // Let's create the file in question to test the required program
        try (
                // Create a data output stream
                 DataOutputStream output
                = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("Exercise17_03.dat")));) {
            for (int i = 0; i < 10; i++) {
                int randomInt = (int) (Math.random() * 100);
                System.out.println(randomInt); // To the console
                output.writeInt(randomInt); // Write an integer to output stream
            }
        }

        try (
                // Create a data input stream for the file Exercise17_03.dat
                 DataInputStream input
                = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("Exercise17_03.dat")));) {
            int r, sum = 0;
            while ((r = input.read()) != -1) {
                sum += r;
            }

            System.out.println("The sum of all integers in the file is " + sum);
        }
    }
}
