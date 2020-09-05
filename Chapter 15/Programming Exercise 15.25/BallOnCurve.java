
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Animation: ball on curve) Write a program that animates a ball moving along
 * a sine curve, as shown in Figure 15.32. When the ball gets to the right
 * border, it starts over from the left. Enable the user to resume/pause the
 * animation with a click on the left/right mouse button.
 *
 * @author martinfall
 */
public class BallOnCurve extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Local variable declarations
        final double WIDTH = 450;
        final double HEIGHT = 200;
        String pi = "\u03c0";

        // Create a new pane
        Pane pane = new Pane();

        // Create a new cartesian plane
        CoordinatePlane plane = new CoordinatePlane(WIDTH, HEIGHT);

        // Create the ball that moves along the sine curve
        Circle ball = new Circle(10, Color.GREEN);

        // Create the sine curve
        Polyline sineCurve = new Polyline();
        for (double angle = -360; angle <= 360; angle++) {
            sineCurve.getPoints().addAll(angle, Math.sin(Math.toRadians(angle)));
            if (angle % 180 == 0) {
                pane.getChildren().add(new Text(
                        (WIDTH / 4) * (angle / 180) + HEIGHT,
                        HEIGHT / 2 + 10,
                        angle / 180 + pi
                ));
            }
        }
        sineCurve.setTranslateX(225);
        sineCurve.setTranslateY(100);
        sineCurve.setScaleX(0.6);
        sineCurve.setScaleY(50);
        sineCurve.setStrokeWidth(1.0 / 50);

        // Create the path transition
        PathTransition pt = new PathTransition(Duration.seconds(3), sineCurve, ball);
        pt.setAutoReverse(false);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setRate(0.5);
        pt.play();

        // resume/pause the animation with a click on the left/right mouse button
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.getButton() == MouseButton.PRIMARY) {
                    pt.pause();
                } else if (t.getButton() == MouseButton.SECONDARY) {
                    pt.play();
                }
            }
        });

        // Add all nodes to the pane
        pane.getChildren().addAll(plane, sineCurve, ball);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_25"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
