
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Control a moving text) Write a program that displays a moving text, as shown
 * in Figure 15.33a and b. The text moves from left to right circularly. When it
 * disappears in the right, it reappears from the left. The text freezes when
 * the mouse is pressed and moves again when the button is released.
 *
 * @author martinfall
 */
public class ControlMovingText extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Local variable declarations
        final int WIDTH = 300;
        final int HEIGHT = 100;

        // Create a new Pane
        Pane pane = new Pane();

        // Create the text node
        Text text = new Text("Programming is fun");
        text.setWrappingWidth(110);
        text.setTextAlignment(TextAlignment.LEFT);

        // Create the line that will be the path for the animation
        Line path = new Line(
                -text.getWrappingWidth(),
                HEIGHT / 2,
                WIDTH + text.getWrappingWidth(),
                HEIGHT / 2);

        // Path transition
        PathTransition pt = new PathTransition(Duration.seconds(5), path, text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        // Add nodes to the pane
        pane.getChildren().add(text);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_27"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
