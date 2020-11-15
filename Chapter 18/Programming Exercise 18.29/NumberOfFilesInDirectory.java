
import java.io.File;
import java.util.Scanner;

/**
 * (Number of files in a directory) Write a program that prompts the user to
 * enter a directory and displays the number of the files in the directory.
 *
 * Output:
 * Enter a directory: ***
 * The directory *** contains 14 files
 *
 * @author martinfall
 */
public class NumberOfFilesInDirectory {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Prompt the user to enter a directory
        System.out.print("Enter a directory: ");
        Scanner input = new Scanner(System.in);
        File file = new File(input.nextLine());

        // Calculate the number of files in the directory
        int numberOfFiles = getNumberOfFiles(file);

        // Display the number of files in the directory
        System.out.println("The directory " + file.getName() + " contains "
                + numberOfFiles + " files");
    }

    /**
     * Returns the number of the files in the directory.
     *
     * @param file
     * @return
     */
    public static int getNumberOfFiles(File file) {
        return getNumberOfFiles(file, 0); // Call auxiliary method
    }

    /**
     * Tail recursive helper method with auxiliary parameter number of files.
     *
     * @param file
     * @param numberOfFiles
     * @return
     */
    public static int getNumberOfFiles(File file, int numberOfFiles) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // List the directory contents

            for (File f : files) { // For each object in the array
                numberOfFiles += getNumberOfFiles(f); // Recursive call
            }
        } else { // Base call or stopping condition
            // System.out.println(file.getPath());
            numberOfFiles++;
        }

        return numberOfFiles; // Return the total number of files
    }
}
