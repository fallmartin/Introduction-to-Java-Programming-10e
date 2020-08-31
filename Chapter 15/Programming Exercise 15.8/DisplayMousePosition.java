
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Display the mouse position) Write two programs, such that one displays the
 * mouse position when the mouse button is clicked (see Figure 15.26a) and the
 * other displays the mouse position when the mouse button is pressed and ceases
 * to display it when the mouse button is released.
 *
 * @author martinfall
 */
public class DisplayMousePosition extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a pane
        Pane pane = new Pane();

        // Register the event handler with the mousePosition text object
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                // Clear the pane
                pane.getChildren().clear();
                
                // Get X and Y and create a new Text object at (x, y)
                double x = t.getX();
                double y = t.getY();
                Text message = new Text(x, y, String.format("(%.1f, %.1f)", x, y));
                
                // Add the new text object to the pane
                pane.getChildren().add(message);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Exercise_15_8"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
