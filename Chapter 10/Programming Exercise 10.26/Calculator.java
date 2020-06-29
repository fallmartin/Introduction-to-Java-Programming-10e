
/**
 * (Calculator) Revise Listing 7.9, Calculator.java, to accept an expression as
 * a string in which the operands and operator are separated by zero or more
 * spaces. For example, 3+4 and 3 + 4 are acceptable expressions. Here is a
 * sample run:
 *
 * @author martinfall
 */
public class Calculator {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Convert args to a string and remove all spaces
        String str = "";
        
        for (int i = 0; i < args.length; i++) {
            str = str + args[i].replaceAll(" ", "");
        }
        
        // Replace OPERATOR with #OPERATOR# in the string we created
        str = str.replaceAll("[+]", "#+#");
        str = str.replaceAll("[-]", "#-#");
        str = str.replaceAll("[*]", "#*#");
        str = str.replaceAll("[/]", "#/#");
        // Split str and assign the resulting array back to args.
        args = str.split("#");

        // The remaining of the program remains unchanged.
        // Check the number of strings passed.
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
        }

        // The result of the operation
        int result = 0;

        // Determine the operator
        switch (args[1].charAt(0)) {
            // Addition
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;

            // Subtraction
            case '-':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;

            // Multiplication
            case '.':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;

            // Division
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                break;
        }

        // Display the result
        System.out.println(args[0] + " " + args[1] + " " + args[2]
                + " = " + result);
    }
}
