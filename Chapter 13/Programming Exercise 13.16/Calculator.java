
/**
 * (Create a rational-number calculator) Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in
 * Figure 13.10a. You will need to use the split method in the String class,
 * introduced in Section 10.10.3, Replacing and Splitting Strings, to retrieve
 * the numerator string and denominator string, and convert strings into
 * integers
 * using the Integer.parseInt method.
 *
 * FIGURE 13.10 (a) The program takes three arguments (operand1, operator, and
 * operand2) from the command line and displays the expression and the result of
 * the arithmetic operation. (b) A complex number can be interpreted as a point
 * in a plane.
 *
 * @author martinfall
 */
public class Calculator {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check number of strings passed
        if (args.length != 1) {
            System.out.println(
                    "Usage: java Calculator \"operand1 operator operand2\"");
            System.exit(1);
        }

        // Split args[0] into operand1, operator, and operand2 using ws delim
        String[] split = args[0].split(" ");

        // Split each operand using the / delimiter
        String[] operand1 = split[0].split("/");
        String[] operand2 = split[2].split("/");

        // Construct two Rational objects from user input
        Rational r1 = new Rational(
                Long.parseLong(operand1[0]),
                Long.parseLong(operand1[1]));

        Rational r2 = new Rational(
                Long.parseLong(operand2[0]),
                Long.parseLong(operand2[1]));

        // Operand
        char operand = split[1].charAt(0);

        // The result of the operation
        Rational result = new Rational();

        // Perform the operation and assign the returned Rational obj to result
        switch (operand) {
            case '+':
                result = r1.add(r2);
                break;
            case '-':
                result = r1.subtract(r2);
                break;
            case '*':
                result = r1.multiply(r2);
                break;
            case '/':
                result = r1.divide(r2);
        }

        // Display result
        System.out.println(r1 + " " + operand + " " + r2 + " = " + result);
    }
}
