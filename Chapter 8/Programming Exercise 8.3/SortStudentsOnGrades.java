
/**
 * (Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to display the
 * students in increasing order of the number of correct answers.
 *
 * Original Output:
 * Student 0's correct count is 7
 * Student 1's correct count is 6
 * Student 2's correct count is 5
 * Student 3's correct count is 4
 * Student 4's correct count is 8
 * Student 5's correct count is 7
 * Student 6's correct count is 7
 * Student 7's correct count is 7
 *
 * Output:
 * Student 3's correct count is 4
 * Student 2's correct count is 5
 * Student 1's correct count is 6
 * Student 0's correct count is 7
 * Student 5's correct count is 7
 * Student 6's correct count is 7
 * Student 7's correct count is 7
 * Student 4's correct count is 8
 *
 * @author martinfall
 */
public class SortStudentsOnGrades {

    public static void main(String[] args) {
        // Students' answers to the questions
        char[][] answers = {
            {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
            {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
            {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
            {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        // Key to the questions
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        int[][] correctAnswers = new int[answers.length][2];

        // Grade all answers
        for (int i = 0; i < answers.length; i++) {
            // Grade one student
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j]) {
                    correctCount++;
                }
            }
            // Update the correct answer array with the number of correct answers
            correctAnswers[i][0] = i;
            correctAnswers[i][1] = correctCount;
        }

        // Sort the array in increasing order of the number of correct answers
        bubbleSort(correctAnswers);

        // Display the result
        for (int i = 0; i < correctAnswers.length; i++) {
            System.out.println("Student " + correctAnswers[i][0]
                    + "'s correct count is " + correctAnswers[i][1]);
        }
    }

    /**
     * Sort the array in increasing order of the number of correct answers.
     *
     */
    public static void sort(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex][1] >= arr[j][1]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int[] temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * Bubble sort the array in increasing order of the number of correct
     * answers.
     *
     * @param arr
     */
    public static void bubbleSort(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j][1] > arr[j + 1][1]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
