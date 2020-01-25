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
public class SentinelValue {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Read an initial data
        System.out.print("Enter an integer (the input ends if it is 0): ");
        
        // Collect input from the user
        int data = input.nextInt();
        
        // Declare a variable to hold the sum of integers
        int sum = 0;
        
        // Keep reading data until input is 0
        while (data != 0) {
            sum += data;
            
            // Read the next data
            System.out.print("Enter an integer (the input ends if it is 0): ");
            data = input.nextInt();
        }
        
        System.out.println("The sum is " + sum);
    }
}
