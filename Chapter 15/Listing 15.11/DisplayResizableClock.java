
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class DisplayResizableClock extends Application {
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a clock and a label
        ClockPane clock = new ClockPane();
        String timeString
                = clock.getHour() + ":"
                + clock.getMinute() + ":"
                + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayResizableClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
        pane.heightProperty().addListener(ov -> clock.setH(pane.getHeight()));
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
