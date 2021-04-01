package externalsort;

import java.io.*;

/**
 * Sample Output:
 *
 * @author martinfall
 */
public class LargeDataFiles {

    // Size of the initial large data file
    private static final int SIZE = 5_000_000;

    /**
     * Creates the large files needed to test the external sort algorithm.
     *
     * @return
     * @throws IOException
     */
    public static File[] initFiles() throws IOException {
        // Create the array of files to return to the caller method.
        File[] files = new File[6]; // 6 files

        // Console message
        System.out.println("\nCreating the necessary files for testing.\n");

        for (int multiplier = 1; multiplier <= 6; multiplier++) {
            File largeFile = createLargeFile(multiplier);
            files[multiplier - 1] = largeFile;
        }

        return files;
    }

    /**
     * Creates the parent directory.
     *
     * @param directoryName
     * @return
     */
    private static File createParentDirectory(String directoryName) {

        // Create a new parent file object
        File parent = new File(directoryName);

        // Creating the directory
        boolean dirCreated = parent.mkdir();

        // Test the directory
        if (dirCreated) {
            System.out.println("Directory created successfully");
        } else {
            if (parent.exists() && parent.isDirectory()) {
                System.out.println("Directory already exists");
            } else {
                System.out.println("Sorry couldn’t create specified directory");
            }
        }

        // Display the string form of this abstract pathname to console
        System.out.println(parent.getPath());

        // Return the parent to the caller method
        return parent;
    }

    /**
     * Creates a large file in the parent directory containing the specified
     * number of integers.
     *
     * @param parent
     * @throws IOException
     */
    private static File createLargeFile(long i) throws IOException {

        // Build the filename and create a file object
        String filename = "largedata" + i + ".dat";
        File file = new File(filename);

        // Create the input file
        System.out.println("Creating " + file.getPath() + "...");
        try ( DataOutputStream output
                = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(file), 512))) {
            long currentNumberOfIntegers = SIZE * i;

            // Generate the integers with a for loop
            for (int j = 0; j < currentNumberOfIntegers; j++) {
                output.writeInt((int) (Math.random() * currentNumberOfIntegers));
            }
        }

        // Test the large file and display the results in the console
        testLargeFile(file);

        // Return the file to the caller method
        return file;
    }

    /**
     * Returns the number of integers in the file.
     *
     * @param file
     * @throws IOException
     */
    private static void testLargeFile(File file) throws IOException {

        System.out.println("Testing " + file.getName() + " in directory "
                + file.getParent());

        // Create the input file
        try ( DataInputStream input
                = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file), 512))) {
            // 4 bytes per integer
            int numberOfAvailableIntegers = input.available() / 4;

            // Display the number of integers to the console
            System.out.println(String.format("%,d", numberOfAvailableIntegers)
                    + " integers in " + file.getPath());

            // Display the first 5 integers to the console
            for (int i = 0; i < 5; i++) {
                System.out.print(input.readInt() + " ");
            }
            System.out.println("\n");
        }
    }
}
