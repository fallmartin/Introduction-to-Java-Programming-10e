
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * (Rename files) Suppose you have a lot of files in a directory named
 * Exercisei_j, where i and j are digits. Write a program that pads a 0 before
 * i if i is a single digit. For example, a file named Exercise2_1 in a
 * directory
 * will be renamed to Exercise02_1. In Java, when you pass the symbol * from the
 * command line, it refers to all files in the directory (see Supplement III.V).
 * Use the following command to run your program.
 *
 * java Exercise12_28
 *
 *
 * @author martinfall
 */
public class RenameFiles {

    public static void main(String[] args) throws IOException {
        // Check command line parameter usage
        if (args.length < 1) { // If the parameter is less than 1
            System.out.println("Usage: java RenameFiles *");
            System.exit(1);
        }

        // Create an empty ArrayList of File objects
        ArrayList<File> list = new ArrayList<>();

        // Add files to the list
        for (String s : args) { // * expands all files in the directory
            // Create a new File object
            File f = new File(s);
            
            // If f is a file (not a directory) and the name matches 
            // the requirements of the exercise
            if (f.isFile() && f.getName().matches("Exercise\\d_\\d.*")) {
                list.add(f); // Add to the ArrayList of File objects
            }
        }

        list.forEach((f) -> {
            StringBuilder newName = new StringBuilder(f.getName()); // Build a string
            newName.insert(8, '0'); // Insert a 0 after Exercise and before digit
            f.renameTo(new File(newName.toString())); // Rename file
        });
    }
}
