
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Geometry: pendulum) Write a program that animates a pendulum swinging, as
 * shown in Figure 15.35. Press the UP arrow key to increase the speed and the
 * DOWN key to decrease it. Press the S key to stop animation and the R key to
 * resume it.
 *
 * @author martinfall
 */
public class Pendulum extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        double width = 300;
        double height = 200;
        final double RADIUS = 10;
        final Color PAINT = Color.RED;

        // Create an arc shape
        Arc bobTrajectory = new Arc(150, 25, 150, 150, 320, -100);
        bobTrajectory.setType(ArcType.OPEN);
        bobTrajectory.setFill(Color.TRANSPARENT);
        bobTrajectory.setStroke(Color.GRAY);
        bobTrajectory.setOpacity(0.2);
        bobTrajectory.getStrokeDashArray().addAll(5d, 5d);

        // Create the pandulum
        Circle massiveBob = new Circle(RADIUS, PAINT);

        // Create the anchor
        Circle anchor = new Circle(RADIUS / 3, Color.BLACK);
        anchor.setCenterX(150);
        anchor.setCenterY(25);

        // Create the pandulum swing string
        Line rod = new Line();
        rod.setStartX(150);
        rod.setStartY(25);
        rod.endXProperty().bind(massiveBob.translateXProperty());
        rod.endYProperty().bind(massiveBob.translateYProperty());

        // Create a new pane and add all nodes
        Pane pane = new Pane();
        pane.getChildren().addAll(bobTrajectory, massiveBob, rod, anchor);
        rod.toBack(); // Put the line behind the ball

        // Path transition animation
        PathTransition pt = new PathTransition();
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.setDuration(Duration.millis(1000));
        pt.setPath(bobTrajectory);
        pt.setNode(massiveBob);
        pt.play();

        /**
         * Press the UP arrow key to increase the speed and the DOWN key to
         * decrease it. Press the S key to stop animation and the R key to
         * resume it.
         */
        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCode()) {
                    case UP:
                        pt.setRate(pt.getRate() + 0.25);
                        break;
                    case DOWN:
                        if (pt.getRate() >= 1) { // Minimum rate
                            pt.setRate(pt.getRate() - 0.25);
                        }
                        break;
                    case S:
                        if (pt.getStatus() == Animation.Status.RUNNING) {
                            pt.pause();
                        }
                        break;
                    case R:
                        if (pt.getStatus() == Animation.Status.PAUSED) {
                            pt.play();
                        }
                        break;
                    default:
                        System.out.println("No key function");
                        break;
                }
            }
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Exercise_15_24"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

        pane.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
