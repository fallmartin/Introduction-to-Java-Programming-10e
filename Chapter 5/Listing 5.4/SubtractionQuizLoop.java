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
public class SubtractionQuizLoop {

    public static void main(String[] args) {
        // Declare a constant variable and initialize it to the number of questions
        final int NUMBER_OF_QUESTIONS = 5;

        // Count the number of correct answers
        int correctCount = 0;

        // Count the number of questions
        int count = 0;

        // Record start time
        long startTime = System.currentTimeMillis();

        // Output string initially empty
        String output = "";

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // loop continuation condition is while count < NUMBER_OF_QUESTIONS
        while (count < NUMBER_OF_QUESTIONS) {
            // 1. Generate two random single-digit integers
            int number1 = (int) (Math.random() * 10);
            int number2 = (int) (Math.random() * 10);

            // 2. If number1 < number2, swap number1 with number2
            if (number1 < number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }

            // 3. Prompt the student to answer "What is number1 – number2?"
            System.out.print("What is " + number1 + " - " + number2 + "? ");

            // Collect input from the user
            int answer = input.nextInt();

            // 4. Grade the answer and display the result
            if (number1 - number2 == answer) {
                System.out.println("You are correct!");
                correctCount++; // Increment correctCount to count this as a correct answer
            } else {
                System.out.println("Your answer is wrong.");
                System.out.println(number1 + " - " + number2
                        + " should be " + (number1 - number2));
            }

            // Increase the question count
            count++;

            // New line
            System.out.println();
            
            // Update the output string
            output += "\n" + number1 + " - " + number2 + " = " + answer
                    + ((number1 - number2 == answer) ? " correct" : " wrong");
        }

        // Record end time
        long endTime = System.currentTimeMillis();

        // Calculated elapsed time
        long testTime = endTime - startTime;

        // Display the results
        System.out.println("Correct count is " + correctCount);
        System.out.println("Test time is " + testTime / 1000 + " seconds");
        System.out.println(output);
    }
}
