
import java.io.File;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Create an image animator with audio) Create animation in Figure 16.46b to
 * meet the following requirements:
 * ■ Allow the user to specify the animation speed in a text field.
 * ■ Get the number of images and image’s file-name prefix from the user. For
 * example, if the user enters n for the number of images and L for the image
 * prefix, then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume that
 * the images are stored in the image directory, a subdirectory of the program’s
 * class directory. The animation displays the images one after the other.
 * ■ Allow the user to specify an audio file URL. The audio is played while the
 * animation runs.
 *
 * Sample sound: https://freewavesamples.com/files/Ensoniq-ZR-76-03-Dope-85.wav
 *
 * @author martinfall
 */
public class ImageAnimatorWithAudio extends Application {

    Timeline timeline = new Timeline(); // Timeline animation
    StackPane paneForAnimation = new StackPane(); // Pane for the animation

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the labels and text fields necessary
        Label lblPrompt = new Label("Enter information for animation");
        lblPrompt.setPadding(new Insets(10));

        Label lblAnimationSpeed = new Label("Animation speed in milliseconds");
        TextField tfAnimationSpeed = new TextField();
        tfAnimationSpeed.setPrefColumnCount(40);

        Label lblImageFilePrefix = new Label("Image file prefix");
        TextField tfImageFilePrefix = new TextField();
        tfImageFilePrefix.setPrefColumnCount(40);

        Label lblNumberOfImages = new Label("Number of images");
        TextField tfNumberOfImages = new TextField();
        tfNumberOfImages.setPrefColumnCount(40);

        Label lblAudioFileURL = new Label("Audio file URL");
        TextField tfAudioFileURL = new TextField();
        tfAudioFileURL.setPrefColumnCount(40);

        // Place the label and text field pairs in a grid pane
        GridPane paneForInputs = new GridPane();
        paneForInputs.setPadding(new Insets(10));
        paneForInputs.setHgap(10);

        paneForInputs.addColumn(0,
                lblAnimationSpeed,
                lblImageFilePrefix,
                lblNumberOfImages,
                lblAudioFileURL);

        paneForInputs.addColumn(1,
                tfAnimationSpeed,
                tfImageFilePrefix,
                tfNumberOfImages,
                tfAudioFileURL);

        // Combine the prompt and  label - text field pairs in a border pane
        BorderPane paneForControls = new BorderPane();
        paneForControls.setTop(lblPrompt);
        paneForControls.setCenter(paneForInputs);

        // Customize the stack pane that will hold the animation frames
        paneForAnimation.setPrefSize(600, 300);
        // paneForAnimation.getChildren().add(new ImageView("images/L1.gif"));

        // Create the button to start the animation
        Button btStartAnimation = new Button("Start Animation");
        btStartAnimation.setLayoutX(
                paneForAnimation.getPrefWidth()
                - btStartAnimation.getLayoutBounds().getHeight());
        btStartAnimation.setLayoutY(0);

        // Create a pane for the button and animation pane
        Pane paneForButtonAndAnimation = new Pane();
        paneForButtonAndAnimation.getChildren().addAll(
                paneForAnimation, btStartAnimation);

        // Create a border pane and place the panes for animation/controls in it
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForButtonAndAnimation);
        pane.setBottom(paneForControls);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ImageAnimatorWithAudio"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

        // Event handler for the btStartAnimation button
        btStartAnimation.setOnAction(e -> {

            int millis = Integer.parseInt(tfAnimationSpeed.getText());
            String prefix = tfImageFilePrefix.getText();
            int numberOfImages = Integer.parseInt(tfNumberOfImages.getText());
            String url = tfAudioFileURL.getText();
            AudioClip clip;

            // Determine if the url is a local or web resource and create clip
            if (url.contains("http")) {
                clip = new AudioClip(url);
            } else {
                // Create a new file object
                File file = new File(url);
                clip = new AudioClip(file.toURI().toString());
            }

            // Create an array of key frames
            KeyFrame[] keyFrames = new KeyFrame[numberOfImages];

            // Populate the array
            for (int i = 0; i < keyFrames.length; i++) {
                ImageView imageView
                        = new ImageView("images/" + prefix + (i + 1) + ".gif");

                // new ImageView("images/" + prefix + (i + 1) + ".gif");
                keyFrames[i] = new KeyFrame(Duration.seconds(i + 1),
                        handler -> {
                            paneForAnimation.getChildren().clear();
                            paneForAnimation.getChildren().add(imageView);
                        });
            }

            // Set some properties of timeline and audio clip
            timeline.setRate(millis);
            timeline.getKeyFrames().addAll(keyFrames);
            timeline.setAutoReverse(false);
            timeline.setCycleCount(Timeline.INDEFINITE);
            clip.setCycleCount(Timeline.INDEFINITE);

            // Stop the animation and audio clip if playing
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.stop();
                clip.stop();
            }

            // Play the animation and the audio clip
            timeline.play();
            clip.play();
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
