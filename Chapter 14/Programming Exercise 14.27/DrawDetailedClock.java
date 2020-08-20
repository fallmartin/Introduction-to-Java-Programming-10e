
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * (Draw a detailed clock) Modify the ClockPane class in Section 14.12 to draw
 * the clock with more details on the hours and minutes, as shown in Figure
 * 14.52a.
 *
 * @author martinfall
 */
public class DrawDetailedClock extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a new grid pane
        Pane pane = new Pane();
        
        pane.getChildren().add(new ClockPane());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        stage.setTitle("Exercise_14_26"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        // stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
