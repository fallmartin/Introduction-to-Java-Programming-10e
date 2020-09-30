
import java.io.File;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 * (Play, loop, and stop a sound clip) Write a program that meets the following
 * requirements:
 * ■ Get an audio file from the class directory using AudioClip.
 * ■ Place three buttons labeled Play, Loop, and Stop, as shown in Figure
 * 16.46a.
 * ■ If you click the Play button, the audio file is played once. If you click
 * the Loop button, the audio file keeps playing repeatedly. If you click the
 * Stop button, the playing stops.
 *
 * @author martinfall
 */
public class AudioClipDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Construct an audio clip object
        String url = "/Users/martinfall/Downloads/1399.wav";
        File file = new File(url);
        AudioClip clip = new AudioClip(file.toURI().toString());
        clip.setCycleCount(1);

        // Create the three buttons
        Button btPlay = new Button("Play");
        ToggleButton btLoop = new ToggleButton("Loop");
        Button btStop = new Button("Stop");

        // Event handlers for the three buttons
        btPlay.setOnAction(e -> {
            clip.play();
        });

        btLoop.setOnAction(e -> {
            // Clip is playing sentinel
            boolean isPlaying = clip.isPlaying();

            if (isPlaying) {
                clip.stop();
            }

            if (clip.getCycleCount() == 1) {
                clip.setCycleCount(Timeline.INDEFINITE);
            } else {
                clip.setCycleCount(1);
            }

            // Continue playing if it was initially playing
            if (isPlaying) {
                clip.play();
            }
        });

        btStop.setOnAction(e -> {
            clip.stop();
        });

        // Create an HBox and place the three buttons in it
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(btPlay, btLoop, btStop);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("CountDownStopwatch"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
