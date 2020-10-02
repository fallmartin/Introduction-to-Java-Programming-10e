
import java.io.File;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Simulation: raise flag and play anthem) Write a program that displays a flag
 * rising up, as shown in Figure 15.14. As the national flag rises, play the
 * national anthem. (You may use a flag image and anthem audio file from Listing
 * 16.15.)
 *
 * @author martinfall
 */
public class FlagRisingAnimation extends Application {

    private static final double WIDTH = 300;
    private static final double HEIGHT = 500;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new image view for the flag
        ImageView imageView = new ImageView("us.gif");
        imageView.setX((WIDTH - imageView.getLayoutBounds().getWidth()) / 2);
        imageView.setY(HEIGHT - imageView.getLayoutBounds().getHeight());
        
        // Create the transition path
        // Divide the height of the flag by two to raise the flag from
        // floor to ceiling without any space at each extremity
        Line path = new Line(
                WIDTH / 2, HEIGHT - (imageView.getLayoutBounds().getHeight()), 
                WIDTH / 2, imageView.getLayoutBounds().getHeight());
        
        // Create the new animation
        PathTransition pathTransition = new PathTransition(
                Duration.seconds(10), 
                path, 
                imageView);
        pathTransition.setAutoReverse(false);
        pathTransition.setCycleCount(1);
        pathTransition.setInterpolator(Interpolator.EASE_BOTH);
        pathTransition.setRate(1);

        // Create the audio clip
        File file = new File("/Users/martinfall/NetBeansProjects/"
                + "Programming_Exercise_16_26/src/us.mp3");
        AudioClip audioClip = new AudioClip(file.toURI().toString());

        // Create a new pane
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.setPadding(new Insets(10));

        // Add the image to the pane
        pane.getChildren().add(imageView);
        
        // Play the animation and the audio clip
        pathTransition.play();
        audioClip.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
