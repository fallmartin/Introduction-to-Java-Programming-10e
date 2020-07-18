
/**
 * (Replace text) Revise Programming Exercise 12.16 to replace a string in a file
 * with a new string for all files in the specified directory using the command:
 *
 * java Exercise12_22 dir oldString newString
 *
 * I amended the specs of this exercise to focus on modifying .java source files
 * using a FilenameFilter object.
 *
 * @author martinfall
 */
import java.io.*;
import java.util.*;

/**
 * (Replace text) Listing 12.16, ReplaceText.java, gives a program that replaces
 * text in a source file and saves the change into a new file. Revise the
 * program to save the change into the original file. For example, invoking
 *
 * java Exercise12_16 file oldString newString
 *
 * replaces oldString in the source file with newString.
 *
 * @author martinfall
 */
public class ReplaceText {

    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 3) {
            System.out.println(
                    "java Exercise12_22 dir oldString newString");
            System.exit(1);
        }

        // Check if source file exists
        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.out.println("Source directory " + args[0] + " does not exist");
            System.exit(2);
        }

        // Check if the file is a directory
        if (!directory.isDirectory()) {
            System.out.println("Source directory " + args[0] + " is not a directory");
            System.exit(3);
        }

        // Create a FilenameFilter object that filters java source files
        FilenameFilter filterSourceFiles = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".java")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        // Create an array of File objects containing the source files to modify
        File[] listOfFiles = directory.listFiles(filterSourceFiles);

        for (File file : listOfFiles) {
            // Create an empty string
            String str = "";

            // Create input file
            try (Scanner input = new Scanner(file);) {
                while (input.hasNext()) {
                    str += input.nextLine() + "\n";
                }
            }

            // Replace oldString with newString
            str = str.replaceAll(args[1], args[2]);

            // Uncomment the line below to see changes in the console
            // System.out.println(outputString);
            // Create output file
            try (PrintWriter output = new PrintWriter(file);) {
                output.println(str);
            }
        }
    }
}
