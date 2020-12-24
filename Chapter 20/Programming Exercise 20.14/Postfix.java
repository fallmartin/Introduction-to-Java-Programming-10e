
import java.util.*;

/**
 * (Postfix notation) Postfix notation is a way of writing expressions without
 * using parentheses. For example, the expression (1 + 2) * 3 would be written
 * as 1 2 + 3 *. A postfix expression is evaluated using a stack. Scan a postfix
 * expression from left to right. A variable or constant is pushed into the
 * stack. When an operator is encountered, apply the operator with the top two
 * operands in the stack and replace the two operands with the result. The
 * following diagram shows how to evaluate 1 2 + 3 *.
 *
 * Write a program to evaluate postfix expressions. Pass the expression as a
 * command-line argument in one string.
 *
 * Output:
 *
 * java Postfix "1 2 + 3 *"
 * 9
 *
 * @author martinfall
 */
public class Postfix {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check command-line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java Prefix \"expression\"");
            System.exit(1); // Exit program after displaying correct usage
        }

        // Create an operand stack
        Stack<Integer> operandStack = new Stack<>();

        String[] tokens = args[0].split("\\s+");

        for (String token : tokens) {
            if (!operandStack.isEmpty() && "+-*/".contains(token)) {
                processOperator(operandStack, token);
            } else if (token.matches("[0-9]+")) {
                operandStack.push(Integer.parseInt(token));
            }
        }

        System.out.println(operandStack.pop());
    }

    private static void processOperator(
            Stack<Integer> operandStack, String token) {
        int operand1 = operandStack.pop();
        int operand2 = operandStack.pop();

        switch (token) {
            case "+":
                operandStack.push(operand2 + operand1);
                break;
            case "-":
                operandStack.push(operand2 - operand1);
                break;
            case "*":
                operandStack.push(operand2 * operand1);
                break;
            case "/":
                operandStack.push(operand2 / operand1);
                break;
        }
    }
}
