
import java.io.File;
import java.util.*;

/**
 * (Directory size) Rewrite Programming Exercise 18.28 using a stack instead of
 * a queue.
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
        System.out.println(getSize(new File(directory)) + " bytes");
        System.out.println(getSizeWithStack(new File(directory)) + " bytes");
    }

    public static long getSize(File file) {
        long size = 0; // Store the total size of all files

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]); // Recursive call
            }
        } else { // Base case
            size += file.length();
        }

        return size;
    }

    public static long getSizeWithStack(File file) {
        Stack<File> directoryStack = new Stack<>();
        long size = 0;

        if (file.isDirectory()) {
            // add directory to the queue
            directoryStack.push(file);
        } else {
            size += file.length();
        }

        while (!directoryStack.isEmpty()) {
            File[] currDirectory = directoryStack.pop().listFiles();

            for (File currFile : currDirectory) {
                if (currFile.isDirectory()) {
                    directoryStack.push(currFile);
                } else {
                    size += currFile.length();
                }
            }
        }

        return size;
    }
}
