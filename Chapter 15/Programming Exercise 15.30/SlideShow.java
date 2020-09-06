
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Slide show) Twenty-five slides are stored as image files (slide0.jpg,
 * slide1.jpg, . . . , slide24.jpg) in the image directory downloadable along
 * with the source code in the book. The size of each image is 800 * 600. Write
 * a program that automatically displays the slides repeatedly. Each slide is
 * shown for two seconds. The slides are displayed in order. When the last slide
 * finishes, the first slide is redisplayed, and so on. Click to pause if the
 * animation is currently playing. Click to resume if the animation is currently
 * paused.
 *
 * @author martinfall
 */
public class SlideShow extends Application {

    // Constants
    private final static int WIDTH = 800; // Pane width
    private final static int HEIGHT = 600; // Pane height
    // Duration per slide
    private final static Duration DURATION = Duration.seconds(2);
    // Total number of slides
    private final static int NUMBER_OF_SLIDES = 25;
    // Global index for retrieving slides from image view array
    private int index = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();

        // Place the first slide in the pane 
        pane.getChildren().add(new ImageView("slides/slide" + index + ".jpg"));
        System.out.println("Displaying slide " + index); // Console
        index++; // Increment the global index

        // Construct an array of image views holding the slides
        ImageView[] slides = new ImageView[NUMBER_OF_SLIDES];

        // Populate the array with images from the slides folder
        for (int i = 0; i < slides.length; i++) {
            slides[i] = new ImageView("slides/slide" + i + ".jpg");
        }

        // Create a new keyframe
        KeyFrame keyFrame = new KeyFrame(DURATION, e -> {
            // If the index is greater than the number of slides
            if (index >= slides.length) {
                index = 0; // Start from the beginning
            }

            pane.getChildren().clear(); // Clear the pane
            pane.getChildren().add(slides[index]); // Add the next slide
            System.out.println("Displaying slide " + index); // Console
            index++; // Increment the global index

        });

        // Create a new timeline animation
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Event handler for mouse click (pause/resume)
        EventHandler<MouseEvent> onClick = e -> {
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.pause();
                System.out.println("Paused");
            } else {
                timeline.play();
                System.out.println("Playing");
            }
        };

        // Register onClick with the pane
        pane.setOnMouseClicked(onClick);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_30"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
