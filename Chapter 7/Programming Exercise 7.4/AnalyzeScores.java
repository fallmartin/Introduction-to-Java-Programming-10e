
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Analyze scores) Write a program that reads an unspecified number of scores
 * and determines how many scores are above or equal to the average and how many
 * scores are below the average. Enter a negative number to signify the end of
 * the input. Assume that the maximum number of scores is 100.
 *
 * @author martinfall
 */
public class AnalyzeScores {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare, create, and initialize an int array to hold the scores
        double[] scores = new double[100];

        // Since 0 is an acceptable score, populate array with -1
        Arrays.fill(scores, -1);

        // Populate the array
        populateArray(scores);

        // Determine average score
        double average = calculateAverage(scores);

        // Display the results
        displayResults(scores, average);
    }

    /**
     * Populate the array with user-entered scores
     *
     * @param scores
     */
    public static void populateArray(double[] scores) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the scores
        System.out.println("Enter scores separated by whitespace (enter a negative integer to end input collection): ");

        // Loop through the array and populate it with user input
        for (int i = 0; i < 100; i++) {
            double temp = input.nextDouble();
            if (temp >= 0) { // Accounting for 0 as a possible score
                scores[i] = temp; // Add score to array
            } else {
                break; // Break out fo the for loop
            }
        }
    }

    /**
     * Calculate the average score
     *
     * @param scores
     * @return
     */
    public static double calculateAverage(double[] scores) {
        int numberOfScores = 0;
        int sum = 0;

        for (double score : scores) {
            if (score >= 0) {
                numberOfScores++;
                sum += score;
            }
        }
        return sum / numberOfScores;
    }

    /**
     * Display the average score and the number of scores above and below
     * average
     *
     * @param scores
     * @param average
     */
    public static void displayResults(double[] scores, double average) {
        int scoresBelowAverage = 0;
        int scoresAboveAverage = 0;

        for (double score : scores) {
            if (score >= 0) {
                if (score < average) {
                    scoresBelowAverage++;
                } else { // If the score is >= average
                    scoresAboveAverage++;
                }
            }
        }
        System.out.println("Average score: " + average);
        System.out.println("Scores below average: " + scoresBelowAverage);
        System.out.println("Scores above average: " + scoresAboveAverage);
    }
}
