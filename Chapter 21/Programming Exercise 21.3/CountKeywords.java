
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * (Count the keywords in Java source code) Revise the program in Listing 21.7.
 * If a keyword is in a comment or in a string, don’t count it. Pass the Java
 * file name from the command line. Assume that the Java source code is correct
 * and line comments and paragraph comments do not overlap.
 *
 * Output:
 * java CountKeywords CountKeywords.java
 * The number of keywords in CountKeywords.java is 29
 *
 * @author martinfall
 */
public class CountKeywords {

    public static void main(String[] args) throws Exception {
        // Check command-line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords path/to/source/file.java");
            System.exit(1);
        }

        // Check if the file exists
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file " + args[0] + " does not exist.");
            System.exit(2);
        }

        try (Scanner input = new Scanner(file)) {
            System.out.println("The number of keywords in " + file
                    + " is " + countKeywords(file));
        }

    }

    public static int countKeywords(File file) throws Exception {
        // Remove comments
        String source = removeComments(file);

        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(source);
        while (input.hasNext()) {
            String word = input.next();
            if (keywordSet.contains(word)) {
                count++;
            }
        }

        return count;
    }

    private static String removeComments(File file) throws Exception {
        // Read the contents of file into a string
        String source = Files.readString(Paths.get(file.toURI()));

        // Remove comments
        source = source.replaceAll("(\\/\\/.*)|(\\/\\*(.|[\\r\\n])*?\\*\\/)|(\\\"([^\\\"]*)\\\")", "");

        // Return the source code after removing all comments
        return source;
    }
}
