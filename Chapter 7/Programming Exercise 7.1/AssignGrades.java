
import java.util.Scanner;

/**
 * Write a program that reads student scores, gets the best score, and then
 * assigns grades based on the following scheme:
 *
 * Grade is A if score is >= best - 10 Grade is B if score is >= best - 20;
 * Grade is C if score is >= best - 30; Grade is D if score is >= best - 40;
 * Grade is F otherwise.
 *
 * The program prompts the user to enter the total number of students, then
 * prompts the user to enter all of the scores, and concludes by displaying the
 * grades. Here is a sample run: (See textbook for sample).
 *
 * Output: 
 * Enter the number of students: 4 
 * Enter 4 scores: 40 55 70 58 
 * Student 0 score is 40 and grade is C 
 * Student 1 score is 55 and grade is B 
 * Student 2 score is 70 and grade is A 
 * Student 3 score is 58 and grade is B
 *
 * @author martinfall
 */
public class AssignGrades {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Prompt the user to enter individual scores for the number of students
        System.out.print("Enter " + numberOfStudents + " scores: ");

        // Create an array of integers and populate with scores
        int[] scores = new int[numberOfStudents];

        // Populate the array with a for loop
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i] = input.nextInt();
        }

        // Find the best score
        int best = findBest(scores);

        // Print the student index, score, and grade
        printScores(best, scores);
    }

    /**
     * Find the best score in the array
     *
     * @param scores
     * @return
     */
    public static int findBest(int[] scores) {
        // Create a variable for the best score
        int best = scores[0];

        // Loop through the entire array to find the best grade
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > best) {
                best = scores[i];
            }
        }

        return best;
    }

    /**
     * Print the individual score of each student
     *
     * @param best
     * @param scores
     */
    public static void printScores(int best, int[] scores) {
        String format = "Student %d score is %d and grade is %s%n";
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= best - 10) { // A
                System.out.printf(format, i, scores[i], "A");

            } else if (scores[i] >= best - 20) { // B
                System.out.printf(format, i, scores[i], "B");
            } else if (scores[i] >= best - 30) { // C
                System.out.printf(format, i, scores[i], "C");
            } else if (scores[i] >= best - 40) { // D
                System.out.printf(format, i, scores[i], "D");
            } else { // F
                System.out.printf(format, i, scores[i], "F");
            }
        }
    }
}
