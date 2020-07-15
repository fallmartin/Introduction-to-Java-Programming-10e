
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Write a program that converts the Java source code from the next-line brace
 * style to the end-of-line brace style. For example, the following Java source
 * in (a) uses the next-line brace style. Your program converts it to the
 * end-of-line brace style in (b).
 *
 * Your program can be invoked from the command line with the Java sourcecode
 * file as the argument. It converts the Java source code to a new format. For
 * example, the following command converts the Java source-code file Test.java
 * to the end-of-line brace style.
 * java Exercise12_12 Test.java
 *
 * @author martinfall
 */
public class ReformatJavaSourceCode {

    public static void main(String[] args) throws FileNotFoundException {
        // Check command line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java ReformatJavaSourceCode [file name].java");
            System.exit(1);
        }

        // Create a new File object
        File file = new File(args[0]);

        // Check if source file exists
        if (!file.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // Create a new String object
        String s = "", temp = "";
        String regex = "\n\\s*\\{";
        

        // Create input file
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                s += input.nextLine() + "\n";
            }
            temp = s.replaceAll(regex, " {\n");
        }

        // Create output file
        try (
                // // Create ioutput files
                PrintWriter output = new PrintWriter(file);) {
            output.print(temp);
        }
    }
}
