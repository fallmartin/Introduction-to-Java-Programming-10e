
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Change opacity) Rewrite Programming Exercise 15.24 so that the ball’s
 * opacity is changed as it swings.
 *
 * @author martinfall
 */
public class ChangeOpacity extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        double width = 300;
        double height = 200;
        final double RADIUS = 10;
        final Color PAINT = Color.CRIMSON;

        // Create an arc shape
        Arc bobTrajectory = new Arc(150, 25, 150, 150, 320, -100);
        bobTrajectory.setType(ArcType.OPEN);
        bobTrajectory.setFill(Color.TRANSPARENT);
        bobTrajectory.setStroke(Color.GRAY);
        bobTrajectory.setOpacity(0.5);
        bobTrajectory.getStrokeDashArray().addAll(5d, 5d);

        // Create the pandulum
        Circle massiveBob = new Circle(RADIUS, PAINT);

        // Create the pandulum swing string
        Line rod = new Line();
        rod.setStartX(150);
        rod.setStartY(25);
        rod.endXProperty().bind(massiveBob.translateXProperty());
        rod.endYProperty().bind(massiveBob.translateYProperty());

        // Create a new pane and add all nodes
        Pane pane = new Pane();
        pane.getChildren().addAll(bobTrajectory, massiveBob, rod);
        rod.toBack(); // Put the line behind the ball

        // Path transition animation
        PathTransition pt = new PathTransition();
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.setDuration(Duration.millis(1500));
        pt.setPath(bobTrajectory);
        pt.setNode(massiveBob);
        pt.play();

        // Fade transition animation
        FadeTransition ft = new FadeTransition();
        ft.setAutoReverse(true);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setDuration(pt.getDuration());
        ft.setByValue(0.1);
        ft.setNode(massiveBob);
        ft.play();

        pane.setOnMousePressed(e -> {
            pt.pause();
            ft.pause();
        });

        pane.setOnMouseReleased(e -> {
            pt.play();
            ft.play();
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Exercise_15_26"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
