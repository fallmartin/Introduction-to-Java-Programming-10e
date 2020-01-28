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
public class TestDoWhile {
    public static void main(String[] args) {
        int data;
        int sum = 0;
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Keep reading data until the input is 0
        do {
            // Read the next data
            System.out.print("Enter an integer (the input ends if it is 0): ");
            data = input.nextInt();
            
            sum += data;
        } while (data != 0);
        
        System.out.println("The sum is " + sum);
    }
}
