/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author martinfall
 */
public class Dec2Hex {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a decimal integer
        System.out.print("Enter a  decimal number: ");
        int decimal = input.nextInt();
        
        // Convert decimal to hexadecimal
        String hex = ""; // Empty String object to hold results
        while (decimal != 0) {
            int hexValue = decimal % 16;
            
            // Convert a decimal value to a hex digit        
            char hexDigit = (hexValue >= 0 && hexValue <= 9) ? 
                    (char)(hexValue + '0') : (char)(hexValue - 10 + 'A');
                    
            hex = hexDigit + hex;
            decimal = decimal / 16;
        }
        
        System.out.println("The hex number is " + hex);
    }
}
