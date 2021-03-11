package listing_23_16;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martinfall
 */
public class SortLargeFile {

    public static final int MAX_ARRAY_SIZE = 43;
    public static final int BUFFER_SIZE = 100000;

    /**
     * Helper method that prints the number of integers in the file.
     *
     * @param filename
     * @param print
     */
    public static void printCount(String filename, boolean print) {
        try ( DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(filename)))) {
            int count = 0;
            while (input.available() > 0) {
                input.readInt();
                count++;
            }

            if (print == true) {
                System.out.println(count + " integers in the file");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /**
         * Before you run this program, first run Listing 23.11,
         * CreateLargeFile.java, to create the file largedata.dat.
         */

        // Sort largedata.dat to sortedfile.dat
        sort("largedata.dat", "sortedfile.dat");

        // Display the first 100 numbers in the sorted file
        displayFile("sortedfile.dat");
    }

    public static void sort(String sourceFile, String targetFile)
            throws Exception {
        // Implement Phase 1: Create initial segments
        int numberOfSegments
                = initializeSegments(BUFFER_SIZE, sourceFile, "f1.dat");

        // Implement Phase 2: Merge segments recursively
        merge(numberOfSegments, MAX_ARRAY_SIZE,
                "f1.dat", "f2.dat", "f3.dat", targetFile);
    }

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

    public static void merge(int numberOfSegments, int segmentSize,
            String f1, String f2, String f3, String targetfile)
            throws Exception {
        if (numberOfSegments > 1) {
            mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
            merge((numberOfSegments + 1) / 2, segmentSize * 2,
                    f3, f1, f2, targetfile);
        } else { // Rename f1 as the final sorted file
            File sortedFile = new File(targetfile);
            if (sortedFile.exists()) {
                sortedFile.delete();
            }
            new File(f1).renameTo(sortedFile);
        }
    }

    public static void mergeOneStep(int numberOfSegments, int segmentSize,
            String f1, String f2, String f3) throws Exception {
        DataInputStream f1Input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));

        DataOutputStream f2Output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));

        // Copy half number of segments from f1 to f2
        copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
        f2Output.close();

        // Merge remaining segments in f1 with segments in f2 into f3
        DataInputStream f2Input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
        DataOutputStream f3Output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));

        mergeSegments(numberOfSegments / 2, segmentSize, f1Input, f2Input, f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();
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
    private static void mergeTwoSegments(int segmentSize,
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
     * Display the first 100 numbers in the specified file.
     *
     * @param filename
     */
    public static void displayFile(String filename) {
        try {
            DataInputStream input
                    = new DataInputStream(new FileInputStream(filename));
            for (int i = 0; i < 100; i++) {
                System.out.print(input.readInt() + " ");
            }
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
