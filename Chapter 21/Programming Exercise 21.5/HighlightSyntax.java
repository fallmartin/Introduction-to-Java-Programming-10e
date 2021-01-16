
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Syntax highlighting) Write a program that converts a Java file into an HTML
 * file. In the HTML file, the keywords, comments, and literals are displayed in
 * bold navy, green, and blue, respectively. Use the command line to pass a Java
 * file and an HTML file. For example, the following command
 *
 * java Exercise21_05 Welcome.java Welcome.html
 *
 * converts Welcome.java into Welcome.html. Figure 21.8a shows a Java file. The
 * corresponding HTML file is shown in Figure 21.8b.
 *
 * @author martinfall
 */
public class HighlightSyntax {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        /**
         * Check command-line parameter usage.
         */
        if (args.length != 2) {
            System.out.println("Usage: java HighlightSyntax "
                    + "Welcome.java Welcome.html");
            System.exit(1);
        }

        /**
         * Ensure that the source file exists and is a java file.
         */
        String source = args[0];
        String sourceExt = args[0].substring(args[0].lastIndexOf(".") + 1);
        File sourceFile = new File(source);

        // Exit if the source file does not exist
        if (!sourceFile.exists()) {
            System.out.println("The source file " + args[0]
                    + " does not exist.");
            System.exit(2);
        }

        // Exit if the source file is not a valid java file
        if (!sourceExt.equals("java")) {
            System.out.println("The source file " + args[0]
                    + " is not a valid java file.");
            System.exit(3);
        }

        /**
         * Ensure that the target file does not exists.
         */
        String target = args[1];
        File targetFile = new File(target);
        if (targetFile.exists()) {
            System.out.println("The target file " + args[1] + " already exists.");
            // System.exit(4);
        }

        /**
         * Generate the HTML file from the source file.
         */
        generateHTML(sourceFile, targetFile);
    }

    public static void generateHTML(File sourceFile, File targetFile) throws Exception {
        /**
         * This is where the magic happens.
         */
        try (PrintWriter writer = new PrintWriter(targetFile)) {
            // Read the contents of the source file into a string
            String str = Files.readString(Paths.get(sourceFile.toURI()));
            String HTML = prettify(str);

            // Doctype
            String htmlString = "<!doctype html>\n";

            // Head
            htmlString += "<html lang=\"en\">\n";
            htmlString += "<head>\n";
            htmlString += "<title>" + sourceFile.getName() + "</title>\n";
            htmlString += "</head>\n";

            // Body
            htmlString += "<body>\n";
            htmlString += "<pre>\n";

            // Insert the body one line at a time
            Scanner scanner = new Scanner(HTML);
            while (scanner.hasNext()) {
                htmlString += scanner.nextLine() + "\n";
            }

            htmlString += "</pre>\n";
            htmlString += "<body>\n";
            htmlString += "</html>";

            // Write the HTML string to the file
            writer.write(htmlString);
        }
    }

    public static String prettify(String HTML) throws Exception {

        /**
         * Prettify the literals.
         */
        Pattern literalsPattern = Pattern.compile("(\\\".*?(?<!\\\\\\\\)\\\")");
        Matcher literalsMatcher = literalsPattern.matcher(HTML);
        while (literalsMatcher.find()) {
            String literal = literalsMatcher.group();
            String replacer = "<span style=\"color:blue; font-weight:bold\">"
                    + literal + "</span>";

            HTML = HTML.replace(literal, replacer);
        }

        /**
         * Prettify the multi-line comments. |(\/\/.*)
         */
        Pattern comments = Pattern.compile("(\\/\\*\\*).*?(\\*\\/)",
                Pattern.MULTILINE | Pattern.DOTALL);
        Matcher commentsMatcher = comments.matcher(HTML);
        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            String replacer = "<span style=\"color:green; font-weight:bold\">"
                    + comment + "</span>";

            HTML = HTML.replace(comment, replacer);
        }

        /**
         * Prettify the single-line comments.
         */
        comments = Pattern.compile("(\\/\\/.*)");
        commentsMatcher = comments.matcher(HTML);
        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            String replacer = "<span style=\"color:green; font-weight:bold\">"
                    + comment + "</span>";

            HTML = HTML.replace(comment, replacer);
        }

        /**
         * Prettify the keywords.
         */
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

        // Create a set of keywords
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

        // Create a scanner
        Scanner scanner = new Scanner(HTML);
        String prettyHTML = "";

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.trim().startsWith("/**")
                    || line.trim().startsWith("//")
                    || line.trim().startsWith("*")) {
                prettyHTML += line + "\n";
            } else {
                String[] tokens = line.split(" ");
                String temp = "";

                // Iterate over the tokens and stylize the keywords as needed
                for (String token : tokens) {
                    if (keywordSet.contains(token)) {
                        token = "<span style=\"color:navy;font-weight:bold\">"
                                + token
                                + "</span>";
                    }
                    temp += token + " ";
                }
                prettyHTML += temp + "\n";
            }
        }

        return prettyHTML; // Return the prettified HTML code
    }
}
