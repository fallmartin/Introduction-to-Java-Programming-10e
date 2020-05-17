
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Sort students) Write a program that prompts the user to enter the number of
 * students, the students’ names, and their scores, and prints student names in
 * decreasing order of their scores.
 *
 * @author martinfall
 */
public class SortStudents {

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

        // Declare, create, and initialize a new array
        String[] students = new String[numberOfStudents];
        int[] scores = new int[numberOfStudents];

        // Populate array
        populateArray(students, scores);

        // Print arrays as they are to compare to sorted decreasing results
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(scores));
        
        // Sort the students
        sortDecreasing(students, scores);

        // Print student names in decreasing order of their scores
        // printResults(students, scores) not implemented, but similar to the following
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(scores));
    }

    /**
     * Enter the students’ names and their scores
     *
     * @param students
     * @param scores
     */
    public static void populateArray(String[] students, int[] scores) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < students.length; i++) {
            // Print student number
            System.out.println("Student " + (i + 1));
            System.out.println("------------------");

            // Collect Name
            System.out.print("Name: ");
            students[i] = input.nextLine();

            // Collect score
            System.out.print("Score: ");
            scores[i] = input.nextInt();
            input.nextLine(); // Clear the scanner

            // Print a formatting line
            System.out.println();
        }
    }

    /**
     * Sort student names and scores in decreasing order
     *
     * @param students
     * @param scores
     */
    public static void sortDecreasing(String[] students, int[] scores) {

        // Modified selection sort to sort decreasingly
        for (int i = 0; i < scores.length - 1; i++) { // outer loop 
            int currentMaxIndex = i; // current max index
            int currentMax = scores[i]; // current max

            // for the remainder of the array
            for (int j = i + 1; j < scores.length; j++) { // inner loop
                if (scores[j] > currentMax) { // if the current element is larger that current max
                    currentMaxIndex = j; // new current max index
                    currentMax = scores[j]; // new current max
                }
            }

            // if a larger max is found
            if (currentMaxIndex != i) {
                // Swap scores
                scores[currentMaxIndex] = scores[i];
                scores[i] = currentMax;

                // Swap names
                String temp = students[i];
                students[i] = students[currentMaxIndex];
                students[currentMaxIndex] = temp;
            }
        }
    }
} 
