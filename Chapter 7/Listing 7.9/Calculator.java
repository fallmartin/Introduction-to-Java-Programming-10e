/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
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
        // Check the number of strings passed
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
        System.out.println(args[0] + " " + args[1] + " " + args[2] +
                " = " + result);
    }
}
