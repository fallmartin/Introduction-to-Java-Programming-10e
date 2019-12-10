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
public class AdditionQuiz {

    public static void main(String[] args) {
        // Generate 2 random integers using the currentTimeMillis method
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() / 7 % 10);
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user for the answer
        System.out.println("What is " + number1 + " + " +
                number2 + "? ");
        
        // Collect the user's answer
        int answer = input.nextInt();
        
        // Test the user's input for veracity
        System.out.println(number1 + " + " + number2 + " = " + answer + 
                " is " + (number1 + number2 == answer));
    }
}
