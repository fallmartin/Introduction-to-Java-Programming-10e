/*
 * Output:

What is 7 + 6? 13
You are correct!

What is 4 + 3? 7
You are correct!

What is 12 + 12? 24
You are correct!

What is 7 + 13? 20
You are correct!

What is 4 + 12? 16
You are correct!

What is 1 + 13? 14
You are correct!

What is 11 + 3? 14
You are correct!

What is 3 + 3? 6
You are correct!

What is 1 + 1? 2
You are correct!

What is 5 + 10? 15
You are correct!

Correct count is 10
Test time is 29 seconds

7 + 6 = 13 correct
4 + 3 = 7 correct
12 + 12 = 24 correct
7 + 13 = 20 correct
4 + 12 = 16 correct
1 + 13 = 14 correct
11 + 3 = 14 correct
3 + 3 = 6 correct
1 + 1 = 2 correct
5 + 10 = 15 correct
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class AdditionQuizLoop {

    public static void main(String[] args) {
        // Declare a constant variable and initialize it to the number of questions
        final int NUMBER_OF_QUESTIONS = 10;

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
            
            // a + Math.random() * b returns a random integer 
            // between a and a + b, excluding a + b
            // a = 1 , a + b = 16, excluding 16
            
            int number1 = (int) (Math.random() * 15) + 1;
            int number2 = (int) (Math.random() * 15) + 1;

            // This is no longer needed for the addition
            // 2. If number1 < number2, swap number1 with number2
//            if (number1 < number2) {
//                int temp = number1;
//                number1 = number2;
//                number2 = temp;
//            }

            // 3. Prompt the student to answer "What is number1 – number2?"
            System.out.print("What is " + number1 + " + " + number2 + "? ");

            // Collect input from the user
            int answer = input.nextInt();

            // 4. Grade the answer and display the result
            if (number1 + number2 == answer) {
                System.out.println("You are correct!");
                correctCount++; // Increment correctCount to count this as a correct answer
            } else {
                System.out.println("Your answer is wrong.");
                System.out.println(number1 + " + " + number2
                        + " should be " + (number1 + number2));
            }

            // Increase the question count
            count++;

            // New line
            System.out.println();

            // Update the output string
            output += "\n" + number1 + " + " + number2 + " = " + answer
                    + ((number1 + number2 == answer) ? " correct" : " wrong");
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
