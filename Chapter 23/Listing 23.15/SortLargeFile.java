package listing_23_15;

import java.io.*;
import java.util.*;

/**
 *
 * @author martinfall
 */
public class SortLargeFile {

    /**
     * Reads each segment of data from a file, sorts the segment, and stores the
     * sorted segments into a new file.The method returns the number of
     * segments.(Sort original file into sorted segments.)
     *
     * @param segmentSize
     * @param originalFile
     * @param f1
     * @return
     * @throws java.lang.Exception
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
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @throws java.lang.Exception
     */
    private static void copyHalfToF2(int numberOfSegments, int segmentSize,
            DataInputStream f1, DataOutputStream f2) throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());
        }
    }

    /**
     * Merges a pair of segments in f1.dat and f2.dat.
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     * @throws java.lang.Exception
     */
    private static void mergeSegments(int numberOfSegments, int segmentSize,
            DataInputStream f1, DataInputStream f2, DataOutputStream f3)
            throws Exception {
        for (int i = 0; i < numberOfSegments; i++) {
            mergeTwoSegments(segmentSize, f1, f2, f3);
        }

        // If f1 has one extra segment, copy it to f3
        while (f1.available() > 0) {
            f3.writeInt(f1.readInt());
        }
    }

    /**
     * Merges two segments.
     *
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     * @throws java.lang.Exception
     */
    public static void mergeTwoSegments(int segmentSize,
            DataInputStream f1, DataInputStream f2, DataOutputStream f3)
            throws Exception {
        int intFromF1 = f1.readInt();
        int intFromF2 = f2.readInt();

        int f1Count = 1;
        int f2Count = 1;

        while (true) {
            if (intFromF1 < intFromF2) {
                f3.writeInt(intFromF1);
                if (f1.available() == 0 || f1Count++ >= segmentSize) {
                    f3.write(intFromF2);
                    break;
                } else {
                    intFromF1 = f1.readInt();
                }
            } else {
                f3.writeInt(intFromF2);
                if (f2.available() == 0 || f2Count++ >= segmentSize) {
                    f3.writeInt(intFromF1);
                    break;
                } else {
                    intFromF2 = f2.readInt();
                }
            }
        }

        while (f1.available() > 0 && f1Count++ < segmentSize) {
            f3.writeInt(f1.readInt());
        }

        while (f2.available() > 0 && f2Count++ < segmentSize) {
            f3.writeInt(f2.readInt());
        }
    }

    /**
     *
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DataOutputStream output
                = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("largedata.dat")));

        for (int i = 0; i < 800004; i++) {
            output.writeInt((int) (Math.random() * 1_000_000));
        }

        output.close();

        // Display first 100 numbers
        DataInputStream input
                = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("largedata.dat")));

        for (int i = 0; i < 100; i++) {
            System.out.print(input.readInt() + " ");
        }

        input.close();
    }

}
