
import java.util.*;

/**
 * Output:
 * 5 solutions found.
 * ((2 + 7) * 4) - 12
 * ((7 + 2) * 4) - 12
 * (4 * (7 + 2)) - 12
 * (4 * (2 + 7)) - 12
 * 12 / (4 - (7 / 2))
 *
 * 10 solutions found.
 * 3 * (11 - (9 / 3))
 * ((11 - 3) / 3) * 9
 * (11 - 3) / (3 / 9)
 * ((11 - 3) * 9) / 3
 * (11 - 3) * (9 / 3)
 * (11 - (9 / 3)) * 3
 * 9 / (3 / (11 - 3))
 * (9 / 3) * (11 - 3)
 * (9 * (11 - 3)) / 3
 * 9 * ((11 - 3) / 3)
 *
 * @author martinfall
 */
public class TwentyFour {

    private String[] patterns = new String[5];
    private ArrayList<Character[]> permutations = new ArrayList<>();
    private ArrayList<Integer[]> cards = new ArrayList<>();
    private ArrayList<String> solutions = new ArrayList<>();

    /**
     * Parameterized constructor of the TwentyFour class.
     *
     * @param list
     */
    public TwentyFour(ArrayList<Integer> list) {
        // Initialize the nums array from the list parameter
        Integer[] nums = new Integer[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        // Initialize patterns
        initPatterns(false); // Set true for console display

        // Initialize operator permutations 
        initPermutations();

        // Initialize cards array list
        initCards(nums);
    }

    /**
     *
     * @param arr
     */
    private void initCards(Integer[] arr) {
        helper(arr, 0);
    }

    /**
     * https://stackoverflow.com/questions/30387185/print-out-all-permutations-of-an-array
     *
     * @param arr
     * @param index
     */
    private void helper(Integer[] arr, int index) {
        if (index >= arr.length - 1) {
            // System.out.println(Arrays.toString(arr));
            cards.add(arr.clone());
        } else {
            for (int i = 0; i < arr.length; i++) {
                //Swap the elements at indices index and i
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

                // Recurse on the sub array arr[index+1 ... end]
                helper(arr, index + 1);

                //Swap the elements back
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public void solve() {
        Iterator<Integer[]> iterator = cards.iterator();

        while (iterator.hasNext()) {
            Integer[] hand = iterator.next();
            // System.out.println(Arrays.toString(hand));

            for (String pattern : patterns) {
                // System.out.println("Pattern=" + pattern);

                for (Character[] ops : permutations) {
                    String expression = buildExpression(pattern, ops, hand);
                    // System.out.print(expression + " = ");
                    if (evaluateExpression(expression)) {
                        if (!solutions.contains(expression)) {
                            solutions.add(expression);
                        }
                        // System.out.println(expression + " = 24");
                    }
                }
            }
        }

        // Print the solutions to the console
        System.out.println(solutions.size() + " solutions found.");

        solutions.forEach(solution -> {
            System.out.println(solution);
        });
    }

    private String buildExpression(String pattern, Character[] ops, Integer[] nums) {
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

    private <T> String replace(int i, String expression, T[] arr, int index) {
        if (i == 0) {
            expression = arr[index] + expression.substring(i + 1);
        } else {
            expression = expression.substring(0, i)
                    + arr[index] + expression.substring(i + 1);
        }
        return expression;
    }

    private void initPermutations() {
        char[] operators = new char[]{'+', '-', '*', '/'};

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
    }

    /**
     * Returns true if the pattern argument has 4 parenthesis, 4 numbers, and 3
     * operators. This is a helper method to check internal logic.
     *
     * @param pattern
     * @return true
     */
    private boolean checkPattern(String pattern) {
        ArrayList<Integer> par = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> ops = new ArrayList<>();

        for (int i = 0; i < pattern.length(); i++) {
            switch (pattern.charAt(i)) {
                case '(':
                    par.add(i);
                    break;
                case ')':
                    par.add(i);
                    break;
                case 'N':
                    num.add(i);
                    break;
                case 'O':
                    ops.add(i);
                    break;
                default:
                // Do nothing
            }
        }

        System.out.println("Par indices=" + par.toString());
        System.out.println("Num indices=" + num.toString());
        System.out.println("Ops indices=" + ops.toString());

        return par.size() == 4 && num.size() == 4 && ops.size() == 3;
    }

    /**
     * Returns all possible patterns as an array of strings.
     *
     * @param verify
     */
    private void initPatterns(boolean verify) {
        patterns = new String[5];

        // ((1 op 2) op 3) op 4
        patterns[0] = "((N O N) O N) O N";

        // (1 op (2 op 3)) op 4
        patterns[1] = "(N O (N O N)) O N";

        // 1 op ((2 op 3) op 4)
        patterns[2] = "N O ((N O N) O N)";

        // 1 op (2 op (3 op 4))     
        patterns[3] = "N O (N O (N O N))";

        // (1 op 2) op (3 op 4)
        patterns[4] = "(N O N) O (N O N)";

        // Verbose mode is verify is set to true
        if (verify) {
            for (String pattern : patterns) {
                System.out.println("Pattern=" + pattern);
                System.out.println("Length=" + pattern.length());
                System.out.print("Valid=" + checkPattern(pattern));
                System.out.println("\n");
            }
        }
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

    public String getRandomSolution() {
        if (solutions.isEmpty()) {
            return "No solution";
        } else {
            return solutions.get((int) (Math.random() * solutions.size()));
        }
    }
}
