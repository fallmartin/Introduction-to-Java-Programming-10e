package quicksort;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Quick sort partition animation) Write a program that animates the partition
 * for a quick sort. The program creates a list that consists of 20 random
 * numbers from 1 to 999. The list is displayed, as shown in Figure 23.22b.
 * Clicking the Step button causes the program to move low to the right or high
 * to the left, or swap the elements at low and high. Clicking the Reset button
 * creates a new list of random numbers for a new start. When the algorithm is
 * finished, clicking the Step button displays a message to inform the user.
 *
 * list=[782, 497, 136, 187, 185, 523, 426, 732, 443, 373, 71, 30, 551, 942,
 * 751, 925, 853, 13, 845, 589]
 *
 * pivots=[782, 373, 589]
 * pivot=589
 * pivotIndex=19
 *
 * List before moving the pivot
 * list=[782, 497, 136, 187, 185, 523, 426, 732, 443, 373, 71, 30, 551, 942,
 * 751, 925, 853, 13, 845, 589]
 *
 * List after moving the pivot
 * list=[589, 497, 136, 187, 185, 523, 426, 732, 443, 373, 71, 30, 551, 942,
 * 751, 925, 853, 13, 845, 782]
 *
 * low=7
 * high=19
 * pivot=589
 * pivotIndex=0
 * list=[589, 497, 136, 187, 185, 523, 426, 732, 443, 373, 71, 30, 551, 942,
 * 751, 925, 853, 13, 845, 782]
 * list[low] <= pivot?
 * 732 is not <= 589
 *
 * low=7
 * high=17
 * pivot=589
 * pivotIndex=0
 * list=[589, 497, 136, 187, 185, 523, 426, 732, 443, 373, 71, 30, 551, 942,
 * 751, 925, 853, 13, 845, 782]
 * list[high] > pivot?
 * 13 is not > 589
 *
 * low=13
 * high=17
 * pivot=589
 * pivotIndex=0
 * list=[589, 497, 136, 187, 185, 523, 426, 13, 443, 373, 71, 30, 551, 942, 751,
 * 925, 853, 732, 845, 782]
 * list[low] <= pivot?
 * 942 is not <= 589
 *
 * low=13
 * high=12
 * pivot=589
 * pivotIndex=0
 * list=[589, 497, 136, 187, 185, 523, 426, 13, 443, 373, 71, 30, 551, 942, 751,
 * 925, 853, 732, 845, 782]
 * list[high] > pivot?
 * 551 is not > 589
 *
 * low=13
 * high=0
 * pivot=589
 * pivotIndex=12
 * list=[551, 497, 136, 187, 185, 523, 426, 13, 443, 373, 71, 30, 589, 942, 751,
 * 925, 853, 732, 845, 782]
 * The pivot 589 has moved to index 12
 * Task completed!
 *
 * @author martinfall
 */
public class QuickSortDriver extends Application {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {

        // Create a new scene and place it in the stage
        Scene scene = new Scene(new QuickSortPane());
        stage.setScene(scene); // Place the scene in the stage
        stage.setTitle("Quick Sort Animation");
        stage.show(); // Display the stage
        stage.setResizable(false); // Set the stage resizable property to false
    }
}
