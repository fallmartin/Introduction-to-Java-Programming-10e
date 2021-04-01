package externalsort;

import java.io.*;

/**
 * (Execution time for external sorting) Write a program that obtains the
 * execution time of external sorts for integers of size 5,000,000, 10,000,000,
 * 15,000,000, 20,000,000, 25,000,000, and 30,000,000. Your program should print
 * a table like this:
 *
 * @author martinfall
 */
public class ExternalSortDriver {

    /**
     * Main method with driver code.
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws Exception {
        // Create an array to store the performance times of each file
        long[] times = new long[6]; // 6 files to process

        // Create the large files needed to test the external sort algorithm
        File[] files = LargeDataFiles.initFiles();

        // Perform external sort on each file and record the resulting times
        for (int i = 0; i < files.length; i++) {
            String sourceFile = files[i].getName();
            String targetFile = "sortedfile" + (i + 1) + ".dat";
            System.out.println(sourceFile);
            System.out.println(targetFile);

            // Start the clock
            long startTime = System.currentTimeMillis();

            ExternalSort.sort(sourceFile, targetFile); // Perform the task

            // Stop the clock
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            times[i] = executionTime;
        }

        // Print the table header
        printTableHeader();

        // Print the data in the table in the required format
        System.out.print("| Time       |");
        for (int i = 0; i < times.length; i++) {
            // Build the contents of current table cell
            String format = String.format("%,12d|", times[i]);
            System.out.print(format); // Print to the console

            // If last in the cell, write the line separator string to console
            if (i == times.length - 1) {
                System.out.println();
            }
        }

        // Print the bottom border of the table
        printTableLine();

    }

    /**
     * Print the table header to the console.
     */
    private static void printTableHeader() {
        printTableLine();
        printTableColumnNames();
        printTableLine();
    }

    /**
     * Prints a formatted line separator string to the console.
     */
    private static void printTableLine() {
        System.out.println("+------------+------------+------------+"
                + "------------+------------+------------+------------+");
    }

    /**
     * Prints the name of each column to the console.
     */
    private static void printTableColumnNames() {
        System.out.println("| File size  |  5,000,000 | 10,000,000 |"
                + " 15,000,000 | 20,000,000 | 25,000,000 | 30,000,000 |");
    }

}
