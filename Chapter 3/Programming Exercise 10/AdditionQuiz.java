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
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Generate two single-digit integers into number1 and number2.
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);

        // Prompt the student to answer, "What is number1 – number2?"
        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        // Check the student’s answer and display whether the answer is correct.
        if (number1 + number2 == answer) {
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Your answer is wrong.");
            System.out.println(number1 + " + " + number2 + " should be "
                    + (number1 + number2));
        }
    }
}
