/**
 * Write a program that prompts the user to enter an integer between 0 and 15 and
 * displays its corresponding hex number. Here are some sample runs:
 * 
 * Enter a decimal value (0 to 15): 11
 * The hex value is B
 * 
 * Enter a decimal value (0 to 15): 5
 * The hex value is 5
 * 
 * Enter a decimal value (0 to 15): 31
 * 31 is an invalid input
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class DecimalToHex {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a decimal value
        System.out.print("Enter a decimal value (0 to 15): ");
        int decimal = input.nextInt();
        
        // Hex doesn't differentiate between b and B
        // System.out.println(Integer.parseInt("b",16));
        
        // Check the input for 0 <= decimal <= 15
        if (decimal >= 0 && decimal <= 15) {
            System.out.println("The hex value is " + Integer.toHexString(decimal));
        } else {
            System.out.println(decimal + " is an invalid input");
        }
    }
}
