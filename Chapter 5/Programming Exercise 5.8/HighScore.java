
import java.util.Scanner;


/**
 * ﻿(Find the highest score) Write a program that prompts the user to enter the
 * number of students and each student’s name and score, and finally displays the
 * name of the student with the highest score.
 *
 * Output:
 * Enter the number of students: 
 * 3
 * Enter the student's name: Student 1
 * Enter the student's score: 88
 * Enter the student's name: Student 2
 * Enter the student's score: 76
 * Enter the student's name: Student 3
 * Enter the student's score: 89
 * The student with the highest score is Student 3
 * The student scored 89
 */

/**
 *
 * @author martinfall
 */
public class HighScore {

    public static void main(String[] args) {
        // Declare variables
        int score = 0;
        String name = "";
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the number of students
        System.out.println("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        input.nextLine(); // advance the Scanner to the next line
        
        // Loop through each student using a for loop construct
        for (int i = 0; i < numberOfStudents; i++) {
            // Prompt the user to enter the student's name
            System.out.print("Enter the student's name: ");
            String tempName = input.nextLine();
            
            // Prompt the user to enter the student's score
            System.out.print("Enter the student's score: ");
            int tempScore = input.nextInt();
            input.nextLine(); // advance the Scanner to the next line
            
            // Test the score and only keep the highest score and associated student name
            if (tempScore > score) {
                name = tempName;
                score = tempScore;
            }
        }
        
        System.out.println("The student with the highest score is " + name);
        System.out.println("The student scored " + score);
    }
}
