
import java.util.Collections;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.*;

/**
 * (Remove the largest ball first) Modify Listing 20.6, MultipleBallApp.java to
 * assign a random radius between 2 and 20 when a ball is created. When the -
 * button is clicked, one of largest balls is removed.
 *
 * @author martinfall
 */
public class MultipleBounceBall extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);

        // Add or remove a ball
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setMin(10);
        // ballPane.rateProperty().bind(sbSpeed.valueProperty());
        // The use of bind can be implemented with listeners on the value property
        sbSpeed.valueProperty().addListener(ov -> {
            ballPane.animation.setRate(sbSpeed.getValue());
        });

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private class MultipleBallPane extends Pane {

        private Timeline animation;

        public MultipleBallPane() {
            // Create an animation for moving the ball
            animation = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play(); // Start animation
        }

        public void add() {
            Color color = Color.color(
                    Math.random(), Math.random(), Math.random(), 0.5);
            double x = 30;
            double y = 30;
            double radius = 2 + Math.random() * 21; // [2, 20]
            getChildren().add(new Ball(x, y, radius, color));
        }

        public void subtract() {
            // Create a new array list
            List<Ball> list = new ArrayList<>();

            // Build a list of Ball objects in the pane
            for (Iterator it = getChildren().iterator(); it.hasNext();) {
                Object o = it.next();
                if (o instanceof Ball) {
                    list.add((Ball) o);
                }
            }

            // Sort the array list in descending order of radius
            Collections.sort(list,
                    Comparator.comparing(Ball::getRadius).reversed());

            // If there are any balls in the pane, remove the largest from the
            // array list and from the pane's children
            if (getChildren().size() > 0) {
                getChildren().remove(list.remove(0));
            }
        }

        public void play() {
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.1);
        }

        public void decreaseSpeed() {
            animation.setRate(
                    animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        }

        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }

        private void moveBall() {
            for (Node node : getChildren()) {
                Ball ball = (Ball) node;
                // Check boundaries
                if (ball.getCenterX() < ball.getRadius()
                        || ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1; // Change the ball move direction
                }

                if (ball.getCenterY() < ball.getRadius()
                        || ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1;
                }

                // Adjust ball position
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
        }
    }

    class Ball extends Circle {

        private double dx = 1;
        private double dy = 1;

        public Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            setFill(color); // Set ball color
        }
    }
}
