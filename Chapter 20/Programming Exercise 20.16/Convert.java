
import java.util.*;

/**
 * (Convert infix to postfix) Write a method that converts an infix expression
 * into a postfix expression using the following header.
 *
 * public static String infixToPostfix(String expression)
 *
 * For example, the method should convert the infix expression
 * (1 + 2) * 3 to 1 2 + 3 * and 2 * (1 + 3) to 2 1 3 + *.
 *
 * Output:
 * Infix: (1 + 2) * 3
 * Postfix: 1 2 + 3 *
 *
 * Infix: 2 * (1 + 3)
 * Postfix: 2 1 3 + *
 *
 * @author martinfall
 */
public class Convert {

    /**
     * This implementations implements addition, subtraction, multiplication,
     * and division.
     *
     * The implementation is based on the shunting-yard algorithm developed by
     * Edsger Dijkstra, as described at the following link.
     * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     *
     * @param expression
     * @return
     */
    public static String infixToPostfix(String expression) {
        // String postfix = "";
        Stack<String> operatorStack = new Stack<>();
        String postfix = "";

        String[] tokens = toStringArray(expression);

        for (String token : tokens) {
            if (token.matches("[0-9]+")) {
                postfix += token + " ";
            } else if (token.matches("[-+/*]")) {
                while (!operatorStack.isEmpty()
                        && token.matches("[/*]") && !token.matches("[(]")) {
                    postfix += operatorStack.pop() + " ";
                }
                operatorStack.push(token);
            } else if (token.matches("[(]")) {
                operatorStack.push(token);
            } else if (token.matches("[)]")) {
                while (!operatorStack.peek().matches("[(]")) {
                    postfix += operatorStack.pop() + " ";
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix += operatorStack.pop() + " ";
        }

        return postfix;
    }

    /**
     * Returns the array of strings computed by splitting this expression string
     * around matches of one or more whitespace characters.
     *
     * @param expression
     * @return
     */
    public static String[] toStringArray(String expression) {
        String padded = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+'
                    || expression.charAt(i) == '-'
                    || expression.charAt(i) == '*'
                    || expression.charAt(i) == '/'
                    || expression.charAt(i) == '('
                    || expression.charAt(i) == ')') {
                padded += " " + expression.charAt(i) + " ";
            } else {
                padded += expression.charAt(i);
            }
        }
        return padded.trim().split("\\s+");
    }

    /**
     * Main method with driver code to test the infixToPostfix method.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Infix: (1 + 2) * 3");
        System.out.println("Postfix: " + infixToPostfix("(1 + 2) * 3"));

        System.out.println("\nInfix: 2 * (1 + 3)");
        System.out.println("Postfix: " + infixToPostfix("2 * (1 + 3)"));
    }
}
