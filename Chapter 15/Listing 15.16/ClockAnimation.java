
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author martinfall
 */
public class ClockAnimation extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a clock and a label
        ClockPane clock = new ClockPane();

        // Create a handler for the animation
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
        };

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler)
        );

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        // Create a scene and place it in the stage
        Scene scene = new Scene(clock, 250, 250);
        primaryStage.setTitle("ClockAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
