
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Use the ClockPane class) Write a program that displays two clocks. The hour,
 * minute, and second values are 4, 20, 45 for the first clock and 22, 46, 15
 * for the second clock, as shown in Figure 14.51c.
 *
 * @author martinfall
 */
public class ClockPaneTest extends Application {

    @Override // Override the start method in the Applicatino class
    public void start(Stage stage) throws Exception {
        // Create a new grid pane
        GridPane pane = new GridPane();

        // Create the first clock with hour, minute, and second values are 4, 20, 45
        ClockPane clock1 = new ClockPane(4, 20, 45);

        // Create the second clock with hour, minute, and second values are 22, 46, 15
        ClockPane clock2 = new ClockPane(22, 46, 15);

        // Add the clocks to the grid pane
        pane.add(clock1, 0, 0);
        pane.add(clock2, 1, 0);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 250);
        stage.setTitle("Exercise_14_26"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        // stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
