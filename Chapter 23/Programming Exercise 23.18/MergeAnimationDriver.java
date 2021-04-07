package mergeanimation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Merge animation) Write a program that animates the merge of two sorted
 * lists. Create two arrays, list1 and list2, each of which consists of 8 random
 * numbers from 1 to 999. The array elements are displayed, as shown in Figure
 * 23.22a. Clicking the Step button causes the program to move an element from
 * list1 or list2 to temp. Clicking the Reset button creates two new random
 * arrays for a new start. When the algorithm is finished, clicking the Step
 * button displays a message to inform the user.
 *
 * @author martinfall
 */
public class MergeAnimationDriver extends Application {

    /**
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override // Override the start method of the Application class
    public void start(Stage stage) throws Exception {

        // Create a new scene and add it to the stage
        Scene scene = new Scene(new MergeAnimationPane());
        stage.setScene(scene); // Add the scene to the stage
        stage.setTitle("Merge Animation"); // Set the stage title
        stage.show(); // Display the stage
        stage.setResizable(true); // Set the resizable property to stage to false
    }
}
