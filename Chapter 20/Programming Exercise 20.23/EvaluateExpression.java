
import java.util.*;

/**
 * (Evaluate expression) Modify Listing 20.9 EvaluateExpression.java to add
 * operators ^ for exponent and % for modulus. For example, 3 ^ 2 is 9 and 3 % 2
 * is 1. The ^ operator has the highest precedence and the % operator has the
 * same precedence as the * and / operators. Your program should prompt the user
 * to enter an expression. Here is a sample run of the program:
 *
 * Enter an expression: (5 * 2 ^ 3 + 2 * 3 % 2) * 4
 * (5 * 2 ^ 3 + 2 * 3 % 2) * 4 = 160
 *
 * @author martinfall
 */
public class EvaluateExpression {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check number of arguments passed 
        // args.length should be 0 since we're collecting input from scanner
        if (args.length != 0) {
            System.out.println(
                    "Usage: java EvaluateExpression");
            System.exit(1);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            // Accepting input from user
            System.out.print("Enter an expression: ");
            String expression = scanner.nextLine();

            // Display the result
            System.out.print(expression + " = ");
            System.out.println(evaluateExpression(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + ex.toString());
        }
    }

    /**
     * Evaluate an expression
     *
     * @param expression
     * @return
     */
    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around ^, (, ), +, -, /, and *
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: Scan tokens
        for (String token : tokens) {
            if (token.length() == 0) // Blank space
            {
                continue; // Back to the while loop to extract the next token
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // Process all +, -, *, / in the top of the operator stack 
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '+'
                        || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*'
                        || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*'
                    || token.charAt(0) == '/'
                    || token.charAt(0) == '%') {
                // Process all *, /, % in the top of the operator stack 
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '*'
                        || operatorStack.peek() == '/'
                        || operatorStack.peek() == '%')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '^') {
                // Process all ^ in the top of the operator stack 
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the ^ operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else { // An operand scanned
                // Push an operand to the stack
                operandStack.push(new Integer(token));
            }
        }

        // Phase 2: process all the remaining operators in the stack 
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop();
    }

    /**
     * Process one operator: Take an operator from operatorStack and
     * apply it on the operands in the operandStack
     *
     * @param operandStack
     * @param operatorStack
     */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+') {
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            operandStack.push(op2 - op1);
        } else if (op == '*') {
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            operandStack.push(op2 / op1);
        } else if (op == '%') { // Modulus
            operandStack.push(op2 % op1);
        } else if (op == '^') { // Power
            operandStack.push((int) Math.pow(op2, op1)); // Autoboxing to Integer
        }
    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/'
                    || s.charAt(i) == '%' || s.charAt(i) == '^') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }
}
