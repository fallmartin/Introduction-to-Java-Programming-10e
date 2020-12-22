
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (Match grouping symbols) A Java program contains various pairs of grouping
 * symbols, such as:
 *
 * ■ Parentheses: ( and )
 * ■ Braces: { and }
 * ■ Brackets: [ and ]
 *
 * Note that the grouping symbols cannot overlap. For example, (a{b)} is
 * illegal. Write a program to check whether a Java source-code file has correct
 * pairs of grouping symbols. Pass the source-code file name as a command-line
 * argument.
 *
 * Output:
 * Grouping symbols correct
 * Matched pairs of grouping symbols: 75
 * Unmatched pairs of grouping symbols: []
 *
 * Grouping symbols incorrect
 * Matched pairs of grouping symbols: 75
 * Unmatched pairs of grouping symbols: [(, {, ), }]
 *
 * @author martinfall
 */
public class MatchGroupingSymbols {

    public static void main(String[] args) {

        // Check command-line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java MatchGroupingSymbols filename.java");
            System.exit(1);
        }

        // Check if the file exists 
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file " + args[0] + " does not exist.");
            System.exit(2);
        }

        // Check if the file extension is correct
        String ext = args[0].substring(args[0].indexOf(".") + 1);
        if (!ext.equals("java")) {
            System.out.println("The file " + args[0] + " is not a Java source-code file.");
            System.exit(3);
        }

        try (Scanner scanner = new Scanner(file)) {
            // Create a new Stack
            Stack<Character> stack = new Stack<>();

            // Count parenthesis, braces, and brackets
            int pairs = 0;

            while (scanner.hasNext()) {
                String line = scanner.nextLine().strip();
                while (line.length() == 0
                        || line.charAt(0) == '/'
                        || line.charAt(0) == '*') {
                    line = scanner.nextLine().strip();
                }

                for (char c : line.toCharArray()) {
                    if (c == '(' || c == ')' || c == '{' || c == '}'
                            || c == '{' || c == '}') {
                        // If the stack is empty
                        if (stack.isEmpty()) {
                            stack.push(c); // Push c
                        } else {
                            // Match c to peek value in stack and pop if matched
                            if (stack.peek() == '(' && c == ')') {
                                pairs++;
                                stack.pop();
                            } else if (stack.peek() == '{' && c == '}') {
                                pairs++;
                                stack.pop();
                            } else if (stack.peek() == '[' && c == ']') {
                                pairs++;
                                stack.pop();
                            } else { // If none of this is true, push c
                                stack.push(c);
                            }
                        }
                    }
                }
            }

            // Display the results in the console
            System.out.println("Grouping symbols "
                    + (stack.size() > 0 ? "in" : "") + "correct");
            System.out.println("Matched pairs of grouping symbols: " + pairs);
            System.out.println("Unmatched pairs of grouping symbols: " + stack);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchGroupingSymbols.class
                    .getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
