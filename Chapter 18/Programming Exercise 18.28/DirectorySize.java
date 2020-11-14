
import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;
import java.util.Stack;

/**
 * (Nonrecursive directory size) Rewrite Listing 18.7, DirectorySize.java,
 * without using recursion.
 *
 * @author martinfall
 */
public class DirectorySize {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        System.out.println(getSizeIteration(new File(directory)) + " bytes");
    }

    public static long getSizeRecursion(File file) {
        long size = 0; // Store the total size of all files

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSizeRecursion(files[i]); // Recursive call
            }
        } else {
            size += file.length(); // Base case
        }
        return size;
    }

    /**
     * Returns the size of a directory using iteration.
     *
     * @param file
     * @return
     */
    public static long getSizeIteration(File file) {
        long size = 0; // Local variable to hold the cumulative size value

        // Two stack objects for directories and normal files
        Stack<File> directories = new Stack<>();
        Stack<File> files = new Stack<>();

        // If the file is a normal file and not a directory, return its length
        if (file.isFile()) {
            return file.length();
        }

        // Push the root dir to the directories stack
        directories.push(file);

        // While the directories stack is not empty
        while (!directories.isEmpty()) {
            // Pop a directory and create a list of contents
            File[] list = directories.pop().listFiles();

            // Optional display to console
            // System.out.println(Arrays.toString(list));
            // If the list is not null
            if (list != null) {
                // For each item in the list
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isDirectory()) { // Add to directories if dir
                        directories.push(list[i]);
                    } else if (list[i].isFile()) { // Add to files if file
                        files.push(list[i]);
                    }
                }
            }

        }

        // Print the files to the console while calculating total size
        for (File f : files) {
            // Uncomment the following line to see file paths in the console
            // System.out.println(f.getPath());
            size += f.length();
        }

        return size;
    }

    /**
     * Helper method that returns an array of files that are not hidden.
     *
     * @param file
     * @return
     */
    public static File[] getFiles(File file) {
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.isHidden();
            }
        });
    }
}
