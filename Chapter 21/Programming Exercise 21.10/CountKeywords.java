
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

/**
 * (Count the occurrences of each keyword) Rewrite Listing 21.7 CountKeywords.
 * java to read in a Java source code file and count the occurrence of each
 * keyword in the file, but don’t count the keyword if it is in a comment or in
 * a string literal.
 *
 * Output:
 * The number of keywords in CountKeywords.java is 30
 *
 * @author martinfall
 */
public class CountKeywords {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // Create a new Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a java source file: ");
        String filename = input.nextLine();

        // Create a new file 
        File file = new File(filename);

        // Process the file
        if (file.exists()) {
            System.out.println("The number of keywords in " + file.getName()
                    + " is " + countKeywords(file));
        } else {
            System.out.println("File " + file.getName() + " does not exist.");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Read the contents of file into a string
        String text = Files.readString(Paths.get(file.toURI()));

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

        // Create a hash set from the array of keywords
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

        // Create and initialize a counter variable
        int count = 0;

        // Remove the comments and literals from the string
        text = clean(text);

        // Iterate over tokens in string and increment count as needed
        Scanner input = new Scanner(text);
        while (input.hasNext()) {
            String word = input.next();
            if (keywordSet.contains(word)) {
                count++;
            }
        }

        return count; // Return the count to the caller method
    }

    public static String clean(String text) {

        /**
         * Remove the literals.
         */
        Pattern literalsPattern = Pattern.compile("(\\\".*?(?<!\\\\\\\\)\\\")");
        Matcher literalsMatcher = literalsPattern.matcher(text);
        while (literalsMatcher.find()) {
            String literal = literalsMatcher.group();
            text = text.replace(literal, " ");
        }

        /**
         * Remove the multi-line comments.
         */
        Pattern comments = Pattern.compile("(\\/\\*\\*).*?(\\*\\/)",
                Pattern.MULTILINE | Pattern.DOTALL);
        Matcher commentsMatcher = comments.matcher(text);
        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            text = text.replace(comment, " ");
        }

        /**
         * Remove the single-line comments.
         */
        comments = Pattern.compile("(\\/\\/.*)");
        commentsMatcher = comments.matcher(text);
        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            text = text.replace(comment, " ");
        }

        return text; // Return the string without literals and comments
    }
}
