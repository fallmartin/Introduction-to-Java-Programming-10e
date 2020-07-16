
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
                    "Usage: java ReplaceText filename oldString newString");
            System.exit(1);
        }

        // Check if source file exists
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // Create a new String object
        String outputString = new String();

        // Create input file
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                String inputString = input.nextLine();
                outputString += inputString.replaceAll(args[1], args[2]);

            }
        }
        
        // Uncomment the line below to see changes in the console
        // System.out.println(outputString);

        // Create output file
        try (PrintWriter output = new PrintWriter(file);) {
            output.println(outputString);
        }
    }
}
