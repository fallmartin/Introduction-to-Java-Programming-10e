
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class RemoveText {

    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java RemoveText "
                    + "[string to remove from file] [file name]");
            System.exit(1);
        }

        // Create a new File object
        File file = new File(args[1]);

        // Check if source file exists
        if (!file.exists()) {
            System.out.println("Source file " + args[1] + " does not exist");
            System.exit(2);
        }

        String s = "";

        try (
                // // Create input files
                Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                s += input.nextLine() + "\n";
            }
            s = s.replaceAll(args[0], "");
        }

        try (
                // // Create ioutput files
                PrintWriter output = new PrintWriter(file);) {
            output.print(s);
        }
    }
}
