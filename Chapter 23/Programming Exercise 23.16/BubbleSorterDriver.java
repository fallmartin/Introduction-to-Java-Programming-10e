package bubblesort;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class BubbleSorterDriver extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args); // Launch the standalone application
    }

    @Override // Override the start method of the Application class
    public void start(Stage stage) throws Exception {

        BubbleSorterPane pane = new BubbleSorterPane();

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene); // Set the scene on the stage
        stage.setTitle("Bubble Sort Animation"); // Set the stage title
        stage.setResizable(false); // Set the stage to nonresizable
        stage.show(); // Display the stage
    }
}
