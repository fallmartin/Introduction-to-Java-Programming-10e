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
public class RepeatAdditionQuiz {

    public static void main(String[] args) {
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Ask the user to solve an addition problem
        System.out.print("What is " + number1 + " + "
                + number2 + "? ");

        int answer = input.nextInt();

        while (number1 + number2 != answer) {
            System.out.println("Wrong answer. Try again. What is "
                    + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
        }

        System.out.println("You got it!");
    }
}
