
import java.io.*;

/**
 * (Update count) Suppose you wish to track how many times a program has been
 * executed. You can store an int to count the file. Increase the count by 1
 * each time this program is executed. Let the program be Exercise17_08 and
 * store the count in Exercise17_08.dat.
 *
 * @author martinfall
 */
public class UpdateCount {

    public static void main(String[] args)
            throws FileNotFoundException, IOException {

        int count = 0;

        try (
                // Create an object output stream
                 RandomAccessFile raf
                = new RandomAccessFile("Exercise17_08", "rw");) {
            // If the program hasn't executed yet
            if (raf.length() == 0) {
                // Move the file pointer to the end (which is the beginning)
                raf.seek(raf.length());
                // Write in the count value of 1
                raf.writeInt(1);
            } else {
                // At every subsequent execution
                // Seek the lenght - 4 bytes position (an int is 4 bytes)
                raf.seek(raf.length() - 4);
                // Write in the current int at that position + 1
                raf.writeInt(raf.readInt() + 1);
            }

            // Move the file pointer to the lenght - 4 bytes position
            raf.seek(raf.length() - 4);
            // Display the number of total executions to the console
            System.out.println(raf.readInt());
        }
    }
}
