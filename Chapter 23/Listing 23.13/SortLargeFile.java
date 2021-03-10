package listing_23_13;

import java.io.*;
import java.util.*;

/**
 *
 * @author martinfall
 */
public class SortLargeFile {

    /**
     * Reads each segment of data from a file, sorts the segment, and stores the
     * sorted segments into a new file. The method returns the number of
     * segments. (Sort original file into sorted segments.)
     *
     * @return
     */
    private static int initializeSegments(
            int segmentSize, String originalFile, String f1) throws Exception {
        int[] list = new int[segmentSize];

        // Read int values from the original file using the input stream
        DataInputStream input
                = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(originalFile)));

        // Write sorted int values to the temp file f1 using the output stream
        DataOutputStream output
                = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(f1)));

        int numberOfSegments = 0; // Count the number of segments

        // While there are values to be read
        while (input.available() > 0) {
            numberOfSegments++; // Increment the segments counter

            int i = 0;
            for (; input.available() > 0 && i < segmentSize; i++) {
                list[i] = input.readInt();
            }

            // Sort an array list[0...i - 1]
            // 0...i - 1 because the array may not be entirely full
            Arrays.sort(list, 0, i);

            // Write the array to f1.dat
            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);
            }
        }

        // Close the input and output streams and return the number of segments
        input.close();
        output.close();

        return numberOfSegments;
    }

    /**
     * Copies the first half of the segments in f1.dat to f2.dat.
     */
    private static void copyHalfToF2(int numberOfSegments, int segmentSize,
            DataInputStream f1, DataOutputStream f2) throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
