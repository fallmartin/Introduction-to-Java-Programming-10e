
import java.io.File;
import java.util.ArrayList;

/**
 * (Rename files) Suppose you have a lot of files in a directory named
 * Exercisei_j, where i and j are digits. Write a program that pads a 0 before j
 * if j is a single digit. For example, a file named Exercise2_1 in a directory
 * will be renamed to Exercise2_01. In Java, when you pass the symbol * from the
 * command line, it refers to all files in the directory (see Supplement III.V).
 * Use the following command to run your program.
 *
 * java Exercise12_29 *
 *
 *
 * @author martinfall
 */
public class RenameFiles {

    public static void main(String[] args) {
        // Check the command line parameter usage
        if (args.length < 1) {
            System.out.println("Usage: java RenameFiles *");
            System.exit(1);
        }

        // Create an ArrayList of File objects
        ArrayList<File> list = new ArrayList<>();

        // Expand the *
        for (String s : args) {
            // Create a new File object
            File f = new File(s);
            
            // Check if f is a file and fits the exercise description
            if (f.isFile() && f.getName().matches("Exercise\\d.*_\\d.txt")) {
                list.add(f); // Add to the ArrayList of File objects
            }
        }

        /*
        The following logic assumes that all files in the folder have i such that
        i is less than 10. If i is greater than 10, then we have to shift the 
        offset by 1.
         */
        for (File f : list) {
            StringBuilder newName = new StringBuilder(f.getName()); // Build a string
            if (newName.length() == 11) {
                newName = newName.insert(10, 0);
            } else {
                newName = newName.insert(11, 0);
            }
            // Rename the file
            f.renameTo(new File(newName.toString()));
        }
    }
}
