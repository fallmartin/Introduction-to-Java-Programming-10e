
import java.util.Stack;

/**
 * Input: java EvaluateExpression "99 + 728 * 2 - 728"
 * Output: 827
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
        if (args.length != 1) {
            System.out.println("Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }
    }

    /**
     * Evaluate an expression
     *
     * @param expression
     * @return
     */
    public static int evaluateExpression(String expression) {
        // Create operand stack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operator stack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, -, /, and *
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: scan tokens
        for (String token : tokens) {
            if (token.length() == 0) { // Blank space
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
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // Process all the *, / in the top of the operator stack
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '*'
                        || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
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
                // operandStack.push(new Integer(token)); // deprecated
                operandStack.push(Integer.valueOf(token));
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
     * Inserts blanks around (, ), +, -, /, and *.
     *
     * @param s
     * @return
     */
    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }

    /**
     * Process an operator: take an operator from the operatorStack and apply it
     * on the operands in the operandStack.
     *
     * @param operandStack
     * @param operatorStack
     */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();

        if (op == '+') { // process +
            operandStack.push(op2 + op1);
        } else if (op == '-') { // process -
            operandStack.push(op2 - op1);
        } else if (op == '*') { // process *
            operandStack.push(op2 * op1);
        } else if (op == '/') { // process /
            operandStack.push(op2 / op1);
        }
    }
}
