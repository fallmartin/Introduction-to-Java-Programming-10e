package externalsort;

import java.io.*;
import java.util.*;

/**
 *
 * @author martinfall
 */
public class ExternalSort {

    private static final int MAX_ARRAY_SIZE = 100_000;
    private static final int BUFFER_SIZE = 100_000;

    /**
     * External sort implementation.
     *
     * @param sourceFile
     * @param targetFile
     * @throws Exception
     */
    public static void sort(String sourceFile, String targetFile)
            throws Exception {
        // Implement Phase 1: Create initial segments
        int numberOfSegments
                = initializeSegments(MAX_ARRAY_SIZE, sourceFile, "f1.dat");

        // Implement Phase 2: merge segments recursively
        merge(numberOfSegments, MAX_ARRAY_SIZE,
                "f1.dat", "f2.dat", "f3.dat", targetFile);

    }

    /**
     * Sort original file into sorted segments.
     *
     * @param segmentSize
     * @param originalFile
     * @param f1
     * @return
     * @throws Exception
     */
    public static int initializeSegments(int segmentSize,
            String originalFile, String f1) throws Exception {

        // Create an array with the maximum size
        int[] list = new int[segmentSize];

        DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(originalFile)));

        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f1)));

        int numberOfSegments = 0;
        while (input.available() > 0) {
            numberOfSegments++;
            int i = 0;
            for (; input.available() > 0 && i < segmentSize; i++) {
                list[i] = input.readInt();
            }

            // Sort an array[0 - (i - 1)]
            Arrays.sort(list, 0, i);

            // Write the array to f1.dat
            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);
            }
        }

        input.close();
        output.close();

        return numberOfSegments;
    }

    /**
     * Merge the files recursively.
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     * @param targetFile
     * @throws java.lang.Exception
     */
    public static void merge(int numberOfSegments, int segmentSize,
            String f1, String f2, String f3, String targetFile)
            throws Exception {
        if (numberOfSegments > 1) {
            mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
            merge((numberOfSegments + 1) / 2, segmentSize * 2,
                    f3, f1, f2, targetFile);
        } else {
            // Rename f1 as the final sorted file
            File sortedFile = new File(targetFile);
            if (sortedFile.exists()) {
                sortedFile.delete();
            }

            new File(f1).renameTo(sortedFile);

            // Display the first 100 numbers in the sorted file
            displayFile(sortedFile.getName());
        }
    }

    /**
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     * @throws Exception
     */
    public static void mergeOneStep(int numberOfSegments, int segmentSize,
            String f1, String f2, String f3) throws Exception {
        DataInputStream f1Input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
        DataOutputStream f2Output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));

        // Copy half number of segments from f1.dat to f2.dat
        copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
        f2Output.close();

        // Merge remaining segments in f1 with segments in f2 into f3
        DataInputStream f2Input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
        DataOutputStream f3Output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));
        mergeSegments(numberOfSegments / 2,
                segmentSize, f1Input, f2Input, f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();
    }

    /**
     * Copy first half segments.
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @throws IOException
     */
    public static void copyHalfToF2(int numberOfSegments, int segmentSize,
            DataInputStream f1, DataOutputStream f2) throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());
        }
    }

    /**
     * Merges all segments.
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     * @throws Exception
     */
    public static void mergeSegments(int numberOfSegments, int segmentSize,
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
     * @throws Exception
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
                    f3.writeInt(intFromF2);
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
     * @throws java.lang.Exception
     */
    public static void displayFile(String filename) throws Exception {
        System.out.println("Displaying " + filename);

        try ( DataInputStream input
                = new DataInputStream(new BufferedInputStream(
                        new FileInputStream(filename)))) {
            int newLine = 0;

            for (int i = 0; i < 100; i++) {
                System.out.print(input.readInt() + "\t");

                newLine++;
                if (newLine == 10) {
                    newLine = 0;
                    System.out.println();
                }
            }
            input.close();
        }

        // Prints the line separator string to the console
        System.out.println();
    }
}
