package listing_23_12;

import java.io.*;
import java.util.*;

/**
 *
 * @author martinfall
 */
public class SortLargeFile {

    /**
     * Sort original file into sorted segments.
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
