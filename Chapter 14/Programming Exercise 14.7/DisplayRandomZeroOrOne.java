
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Display random 0 or 1) Write a program that displays a 10-by-10 square
 * matrix, as shown in Figure 14.45a. Each element in the matrix is 0 or 1,
 * randomly generated. Display each number centered in a text field. Use
 * TextField’s setText method to set value 0 or 1 as a string.
 *
 * @author martinfall
 */
public class DisplayRandomZeroOrOne extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        final int SIZE = 10;

        // Create a new grid pane
        GridPane pane = new GridPane();

        // Loop through the SIZE x SIZE matrix
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                // Create a text field with random int
                TextField tf = new TextField();
                tf.setText(String.valueOf(new Random().nextInt(2)));
                // Set preferred column cout for text field to 1
                tf.setPrefColumnCount(1);
                // Add it to the pane
                pane.add(tf, column, row);
            }
        }

        Scene scene = new Scene(pane); // Create a scene
        stage.setTitle("Exercise_14_07"); // Set the stage title
        stage.setScene(scene); // Set the scene on the stage
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
