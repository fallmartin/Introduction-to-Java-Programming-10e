
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Count-down stopwatch) Write a program that allows the user to enter time in
 * seconds in the text field and press the Enter key to count down the seconds,
 * as shown in Figure 16.45d. The remaining seconds are redisplayed every one
 * second. When the seconds are expired, the program starts to play music
 * continuously.
 *
 * @author martinfall
 */
public class CountDownStopwatch extends Application {

    // Private data fields for the text field and the transition
    private TextField tfCounter = new TextField();
    private Timeline timeline = new Timeline();
    private String url = "/Users/martinfall/NetBeansProjects/"
            + "Programming_Exercise_16_21/src/us.mp3";
    private File file = new File(url);

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Customize the text field
        Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50);
        tfCounter.setAlignment(Pos.CENTER);
        tfCounter.setFont(font);

        // Create a keyframe for the timeline animation
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> {
            int counter = Integer.parseInt(tfCounter.getText()) - 1;

            if (counter >= 0) {
                tfCounter.setText(String.valueOf(counter));

            } else {
                timeline.stop();
                AudioClip clip = new AudioClip(file.toURI().toString());
                clip.setCycleCount(Timeline.INDEFINITE);
                clip.play();
            }
        });

        // Set up the timeline properties
        timeline.getKeyFrames().add(keyFrame);
        timeline.setAutoReverse(false);
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Event handler for the text field action event
        tfCounter.setOnAction(e -> {
            if (tfCounter.getText().length() != 0) {
                timeline.play();
            }
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(tfCounter, 200, 100);
        primaryStage.setTitle("CountDownStopwatch"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
