
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * (Random time) Modify the ClockPane class with three new Boolean properties—
 * hourHandVisible, minuteHandVisible, and secondHandVisible—and their
 * associated accessor and mutator methods. You can use the set methods to make
 * a hand visible or invisible. Write a test program that displays only the hour
 * and minute hands. The hour and minute values are randomly generated. The hour
 * is between 0 and 11, and the minute is either 0 or 30, as shown in Figure
 * 14.52b.
 *
 * @author martinfall
 */
public class RandomTime extends Application {
    
    @Override // Override the start method in the Application class
    public void start(Stage stage) {
        // Create a new grid pane
        Pane pane = new Pane();

        // Generate a random hour between 0 and 11
        int hour = (int) (Math.random() * 12);

        // Generate a random minute either 0 or 30
        int minute = (Math.random() * 2 > 1) ? 30 : 0;
        
        // Create a new clock pane and set hour and minute
        ClockPane clock = new ClockPane(); // Current time
        clock.setSecondHandVisible(false); // Set secondHandVisible to false
        clock.setHour(hour);
        clock.setMinute(minute);
        
        // Add the clock pane to the pane
        pane.getChildren().add(clock);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        stage.setTitle("Exercise_14_28"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        // stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
