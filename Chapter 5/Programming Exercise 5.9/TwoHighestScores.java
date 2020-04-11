
import java.util.Scanner;

/**
 * ﻿(Find the two highest scores) Write a program that prompts the user to enter
 * the number of students and each student’s name and score, and finally
 * displays the student with the highest score and the student with the
 * second-highest score.
 *
 */
/**
 *
 * @author martinfall
 */
public class TwoHighestScores {

    public static void main(String[] args) {
        // Declare variables 
        int topScore1 = 0, topScore2 = 0;
        String topName1 = "", topName2 = "";

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        input.nextLine(); // advance the Scanner to the next line

        for (int i = 0; i < numberOfStudents; i++) {
            // Prompt the user to enter student name
            System.out.print("Enter the student's name: ");
            String tempName = input.nextLine();

            // Prompt the user to enter student score
            System.out.print("Enter the student's score: ");
            int tempScore = input.nextInt();

            if (tempScore > topScore1) {
                if (tempScore > topScore2) {
                    topScore2 = topScore1;
                    topName2 = topName1;
                }
                topScore1 = tempScore;
                topName1 = tempName;

            } else if (tempScore > topScore2) { //must use if/else if pattern here
                // if multiple if pattern is used, the result is a logic error
                // 12 > 10 & 12 > 3, therefore 12 would be assigned to two vars
                topScore2 = tempScore;
                topName2 = tempName;
            }

            input.nextLine(); // advance the Scanner to the next line
        }

        System.out.println();
        System.out.println("Top Student Name 1: " + topName1);
        System.out.println("Top Student Score 1: " + topScore1);
        System.out.println();
        System.out.println("Top Student Name 2: " + topName2);
        System.out.println("Top Student Score 2: " + topScore2);
    }
}
