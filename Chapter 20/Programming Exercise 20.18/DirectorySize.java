
import java.util.*;
import java.io.File;

/**
 * (Directory size) Listing 18.7, DirectorySize.java, gives a recursive method
 * for finding a directory size. Rewrite this method without using recursion.
 * Your program should use a queue to store the subdirectories under a
 * directory. The algorithm can be described as follows:
 *
 * Output:
 * Enter a directory or a file:
 *
 * Using Recursion
 * 116905 bytes
 *
 * Using Iteration
 * 116905 bytes
 *
 * @author martinfall
 */
public class DirectorySize {

    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        System.out.println("Using Recursion");
        System.out.println(getSizeRecursion(new File(directory)) + " bytes");
        System.out.println("\nUsing Iteration");
        System.out.println(getSizeIteration(new File(directory)) + " bytes");
    }

    /**
     * Returns the size of a file or directory using recursion.
     *
     * @param file
     * @return
     */
    public static long getSizeRecursion(File file) {
        long size = 0; // Store the total size of all files

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSizeRecursion(files[i]); // Recursive call
            }
        } else { // Base case
            size += file.length();
        }

        return size;
    }

    /**
     * Returns the size of a file or directory using iteration.
     *
     * @param file
     * @return
     */
    public static long getSizeIteration(File file) {
        long size = 0;

        // Create a queue
        Queue<File> directoryQueue = new PriorityQueue<>();

        // If the file is a directory
        if (file.isDirectory()) {
            // Add it to the queue
            directoryQueue.offer(file);
        } else {
            // Otherwise add its size to the local accumulator var size
            size += file.length();
        }

        // While there are directories in the queue
        while (!directoryQueue.isEmpty()) {
            // Poll the directory queue for a directory
            File directory = directoryQueue.poll();

            // For each file in the directory
            for (File f : directory.listFiles()) {
                // If the file is a directory
                if (f.isDirectory()) {
                    // Add it to the queue
                    directoryQueue.offer(f);
                } else {
                    // Otherwise, add the file size to the accumulator var size
                    size += f.length();
                }
            }
        }

        // Return size
        return size;
    }
}
