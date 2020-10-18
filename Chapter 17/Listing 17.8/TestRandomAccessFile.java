package TestRandomAccessFile;

import java.io.*;

/**
 * Output:
 *
 * Current file length is 800
 * The first number is 0
 * The second number is 1
 * The tenth number is 9
 * The new length is 804
 * The eleventh number is 555
 *
 * @author martinfall
 */
public class TestRandomAccessFile {

    public static void main(String[] args) throws IOException {
        try (
                // Create a random access file
                 RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");) {
            // Clear the file to destroy the old contents if exists
            inout.setLength(0);

            // Write new integers to the file
            for (int i = 0; i < 200; i++) {
                inout.writeInt(i);
            }

            // Display the current lenght of this file
            System.out.println("Current file length is " + inout.length());

            // Retrieve the first number
            inout.seek(0); // Move the file pointer to the beginning
            System.out.println("The first number is " + inout.readInt());

            // Retrieve the second number
            inout.seek(1 * 4); // Move the file pointer to the second number
            System.out.println("The second number is " + inout.readInt());

            // Retrieve the tenth number
            inout.seek(9 * 4);
            System.out.println("The tenth number is " + inout.readInt());

            // Modify the eleventh number
            inout.writeInt(555);

            // Append a new number
            inout.seek(inout.length()); // Move the file pointer to the end
            inout.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + inout.length());

            // Retrieve the new eleventh number
            inout.seek(10 * 4); // Move the file pointer to the eveventh number
            System.out.println("The eleventh number is " + inout.readInt());
        }
    }
}
