package combinations;

import java.util.*;

/**
 * (Game: solution ratio for 24-point game) When you pick four cards from a deck
 * of 52 cards for the 24-point game introduced in Programming Exercise 20.13,
 * the four cards may not have a 24-point solution.
 *
 * What is the number of all possible picks of four cards from 52 cards?
 *
 * Among all possible picks, how many of them have 24-point solutions?
 *
 * What is the success ratio—that is, (number of picks with solutions)/ (number
 * of all possible picks of four cards)?
 *
 * Write a program to find these answers
 *
 * Output:
 * Number of all possible picks of four cards: 270,725
 * Number of picks with solutions: 89,810
 * Success ratio: 33.17%
 *
 * @author martinfall
 */
public class Combinations {

    private static final int N = 52;
    private static final int K = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Generate a list of all possible combinations of 4 cards from 52 cards
        List<Integer[]> combinations = generate(N, K);

        // Question 1
        System.out.print("Number of all possible picks of four cards: ");
        int picks = combinations.size(); // Size of combinations
        System.out.println(String.format("%,d", picks));

        // Question 2
        System.out.print("Number of picks with solutions: ");
        long solutions = count(combinations); // Number of solutions
        System.out.println(String.format("%,d", solutions));

        // Question 3
        System.out.print("Success ratio: "); // Success ratio as described
        System.out.println(String.format("%.2f%%",
                ((double) solutions * 100 / picks)));
    }

    /**
     * Returns a list of all possible combinations of k elements from n
     * elements. This implementations makes us of the subset sum algorithmic
     * logic to either include or exclude each element while building a tree
     * with branches of order k.
     *
     * @param n
     * @param k
     * @return
     */
    public static List<Integer[]> generate(int n, int k) {
        List<Integer[]> combinations = new ArrayList<>();
        Integer[] temp = new Integer[k];

        helper(combinations, temp, 1, n, 0);

        return combinations;
    }

    /**
     * Recursive helper method for the generate method.
     *
     * @param combinations
     * @param data
     * @param start
     * @param end
     * @param index
     */
    private static void helper(List<Integer[]> combinations, Integer[] data,
            int start, int end, int index) {
        // If the data array is full
        if (index == data.length) {
            Integer[] combination = data.clone(); // Add a clone to combinations
            combinations.add(combination);
        } else if (start <= end) { // Otherwise
            // Add the value of start at index index
            data[index] = start;

            // Perform two recursive call (include/exclude the next element)
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    /**
     * Returns the number of successful picks that result in 24 points.
     *
     * @param combinations
     * @return
     */
    public static long count(List<Integer[]> combinations) {
        // Possible patters of Numbers and Operators
        String[] patterns = new String[]{
            "((N O N) O N) O N",
            "(N O (N O N)) O N",
            "N O ((N O N) O N)",
            "N O (N O (N O N))",
            "(N O N) O (N O N)"};

        // List of all possible operator permutations
        ArrayList<Character[]> permutations = initPermutations();

        int counter = 0; // Initialize a counter variable

        // Create a list iterator and iterate over combinations of cards
        Iterator<Integer[]> iterator = combinations.iterator();
        while (iterator.hasNext()) {
            // For each combination in the list
            Integer[] combination = iterator.next();
            // Try each pattern with each operator permutation
            for (String pattern : patterns) {
                for (Character[] permutation : permutations) {
                    // Build and evaluate an expression
                    String expression = buildExpression(pattern, permutation, combination);
                    if (evaluateExpression(expression)) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    private static ArrayList<Character[]> initPermutations() {
        char[] operators = new char[]{'+', '-', '*', '/'};
        ArrayList<Character[]> permutations = new ArrayList<>();

        // 64 possible permutations with repetitions exist
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    // Update the permutations array list
                    permutations.add(new Character[]{
                        operators[i], operators[j], operators[k]});
                }
            }
        }

        return permutations;
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param pattern
     * @param ops
     * @param nums
     * @return
     */
    private static String buildExpression(String pattern, Character[] ops, Integer[] nums) {
        String expression = pattern;
        int index = 0;

        // Replace of instances of N with a number
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == 'N') {
                expression = replace(i, expression, nums, index++);
            }
        }

        index = 0; // Reset the index

        // Replace all instances of O with an operator
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == 'O') {
                expression = replace(i, expression, ops, index++);
            }
        }

        return expression;
    }

    /**
     * Returns a string with replaced values of O or N.
     *
     * @param <T>
     * @param i
     * @param expression
     * @param arr
     * @param index
     * @return
     */
    private static <T> String replace(int i, String expression, T[] arr, int index) {
        if (i == 0) {
            expression = arr[index] + expression.substring(i + 1);
        } else {
            expression = expression.substring(0, i)
                    + arr[index] + expression.substring(i + 1);
        }
        return expression;
    }

    /**
     * Inserts blanks around (, ), +, -, /, and *.
     *
     * @param s
     * @return
     */
    private static String insertBlanks(String s) {
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
    private static void processAnOperator(
            Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        double op2 = operandStack.pop();

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

    public static boolean evaluateExpression(String expression) {
        // System.out.println("Verifying " + expression);
        // Create operandStack to store operands
        Stack<Double> operandStack = new Stack<>(); // Operand stack [1 - 13]

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>(); // Operator stack [+-*/()]

        // Add spaces around (, ), +, -, *, / to facilitate regex split
        expression = insertBlanks(expression);
        String[] tokens = expression.split("\\s+");

        // Phase 1: scan tokens
        for (String token : tokens) {
            if (token.length() == 0) { // Blank space
                // Unnecessary continue statement left for ease of understanding
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
                operandStack.push(Double.valueOf(token));
            }
        }

        // Phase 2: process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return true if the processed line results in 24
        return operandStack.pop() == 24.0; // Quod Erat Demonstrandum
    }

}
