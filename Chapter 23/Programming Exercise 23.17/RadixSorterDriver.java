package radixsorter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Radix sort animation) Write a program that animates the radix sort
 * algorithm. Create an array that consists of 20 random numbers from 0 to
 * 1,000. The array elements are displayed, as shown in Figure 23.21. Clicking
 * the Step button causes the program to place a number in a bucket. The number
 * that has just been placed is displayed in red. Once all the numbers are
 * placed in the buckets, clicking the Step button collects all the numbers from
 * the buckets and moves them back to the array. When the algorithm is finished,
 * clicking the Step button displays a message to inform the user. Clicking the
 * Reset button creates a new random array for a new start.
 *
 * @author martinfall
 */
public class RadixSorterDriver extends Application {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Launch the standalone application
        Application.launch(args);
    }

    @Override // Override the starte method of the Application class
    public void start(Stage stage) throws Exception {
        
        // Create a new scene and place it in the stage
        Scene scene = new Scene(new RadixSorterPane());
        stage.setScene(scene); // Place the scene in the stage
        stage.setTitle("Radix Sort Animation"); // Set the stage title
        stage.show(); // Display the stage
        stage.setResizable(false); // Make the stage nonresizable
    }
}
