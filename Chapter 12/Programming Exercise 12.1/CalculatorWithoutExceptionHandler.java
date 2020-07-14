
/**
 * (NumberFormatException) Listing 7.9, Calculator.java, is a simple command-line
 * calculator. Note that the program terminates if any operand is nonnumeric.
 * Write a program with an exception handler that deals with nonnumeric operands;
 * then write another program without using an exception handler to achieve the
 * same objective. Your program should display a message that informs the user of
 * the wrong operand type before exiting (see Figure 12.12).
 *
 * @author martinfall
 */
public class CalculatorWithoutExceptionHandler {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check number of strings passed
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        // The result of the operation
        int result = 0;

        int[] operands = extractOperands(args);
        int operand1 = operands[0];
        int operand2 = operands[1];

        // Determine the operator
        switch (args[1].charAt(0)) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '.':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    System.out.println("Wrong Input: / by zero");
                    System.exit(4);
                }
                result = operand1 / operand2;
        }

        // Display result
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                + " = " + result);
    }

    /**
     * Returns an int array of operands
     *
     * @param args
     * @return
     */
    public static int[] extractOperands(String[] args) {
        int[] operands = new int[2];
        String regex = "\\d+"; // + means "one or more times" and \d means "a digit"

        // Process the first operand
        if (args[0].matches(regex)) {
            operands[0] = Integer.parseInt(args[0]);
        } else {
            System.out.println("Wrong Input: " + args[0]);
            System.exit(2);
        }
        // Process the second operand
        if (args[2].matches(regex)) {
            operands[1] = Integer.parseInt(args[2]);
        } else {
            System.out.println("Wrong Input: " + args[2]);
            System.exit(3);
        }

        return operands;
    }
}
