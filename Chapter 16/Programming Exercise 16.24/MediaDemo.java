
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Revise Listing 16.14 MediaDemo.java) Add a slider to enable the user to set
 * the current time for the video and a label to display the current time and
 * the total time for the video. As shown in Figure 16.47a, the total time is 5
 * minutes and 3 seconds and the current time is 3 minutes and 58 seconds. As
 * the video plays, the slider value and current time are continuously updated.
 *
 * @author martinfall
 */
public class MediaDemo extends Application {

    // String of the web video resource
    private static final String MEDIA_URL
            = "https://liveexample.pearsoncmg.com/common/sample.mp4";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create media, media player, and media view objects
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(1); // Play 1 time
        mediaPlayer.setAutoPlay(false); // No auto-play
        MediaView mediaView = new MediaView(mediaPlayer);

        // Create the play button
        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                playButton.setText("||");
                mediaPlayer.play();
            } else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });

        // Create the time slider
        Slider slTime = new Slider();
        slTime.setPrefWidth(150);
        slTime.setMaxWidth(Region.USE_PREF_SIZE);
        slTime.setMinWidth(30);
        slTime.setMin(0);

        // Add a listener to the current time property of media player
        // Create the volume slider
        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

        // Create the duration label
        Label lblTime = new Label();

        // Add a listener to the current time property of the media player object
        mediaPlayer.currentTimeProperty().addListener(ov -> {
            // Local variables for the current time and total duration
            double currentTime = (int) mediaPlayer.getCurrentTime().toMillis();
            double totalTime = (int) mediaPlayer.getCycleDuration().toMillis();

            // Set the value and max of time slider
            slTime.setValue(currentTime);
            slTime.setMax(totalTime);
            
            // Update the text of the time label
            lblTime.setText(formatTime((int) currentTime)
                    + "/" + formatTime((int) totalTime));
        });

        // Add an invalidation listener to the value property of the time slider
        slTime.valueProperty().addListener(ov -> {
            if (slTime.isValueChanging()) { // If the value is changing
                // Set the parameters of seek to the new value duration
                mediaPlayer.seek(new Duration(slTime.getValue()));
            }
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(
                playButton,
                new Label("Time"), slTime,
                // Continue here
                lblTime,
                new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        mediaView.fitWidthProperty().bind(pane.widthProperty());
        mediaView.fitHeightProperty().bind(pane.heightProperty().
                subtract(hBox.heightProperty()));

        // System.out.println(formatTime(303000));
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("MediaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private String formatTime(int millis) {

        // Get time in seconds
        int totalSeconds = millis / 1000;
        int currentSeconds = totalSeconds % 60;

        // Get minutes
        int totalMinutes = totalSeconds / 60;
        int currentMinutes = totalMinutes % 60;

        // Get hours
        int totalHours = totalMinutes / 60;

        return String.format("%02d:%02d:%02d",
                totalHours, currentMinutes, currentSeconds);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
