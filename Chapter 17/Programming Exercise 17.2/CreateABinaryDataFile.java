
import java.io.*;
import java.util.Random;

/**
 * (Create a binary data file) Write a program to create a file named
 * Exercise17_02.dat if it does not exist. Append new data to it if it already
 * exists. Write 100 integers created randomly into the file using binary I/O.
 *
 * @author martinfall
 */
public class CreateABinaryDataFile {

    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        try (
                // Create a file output stream for file Exercise17_02.dat
                 DataOutputStream output
                = new DataOutputStream(new FileOutputStream("Exercise17_02.dat", true));) {
            // Create a new random object
            Random r = new Random();

            // Write 100 integers created randomly into file using binary I/O
            for (int i = 0; i < 100; i++) {
                output.writeInt(r.nextInt());
            }
        }
    }
}
