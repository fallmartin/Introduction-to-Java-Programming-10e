
import java.util.*;
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

/**
 * (Combine colliding bouncing balls) The example in Section 20.7 displays
 * multiple bouncing balls. Extend the example to detect collisions. Once two
 * balls collide, remove the later ball that was added to the pane and add its
 * radius to the other ball, as shown in Figure 20.17b. Use the Suspend button
 * to suspend the animation and the Resume button to resume the animation. Add a
 * mouse pressed handler that removes a ball when the mouse is pressed on the
 * ball.
 *
 * @author martinfall
 */
public class CombineCollidingBouncingBalls extends Application {

    MultipleBallPane ballPane = new MultipleBallPane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        Button btSuspend = new Button("Suspend");
        Button btResume = new Button("Resume");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract, btSuspend, btResume);
        hBox.setAlignment(Pos.CENTER);

        // Add or remove a ball
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        // Pause and resume animation
        btSuspend.setOnAction(e -> ballPane.pause());
        btResume.setOnAction(e -> ballPane.play());

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
        Scene scene = new Scene(pane, 600, 400);
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
            getChildren().add(new Ball(30, 30, 20, color));
        }

        public void subtract() {
            if (getChildren().size() > 0) {
                getChildren().remove(getChildren().size() - 1);
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
            // Use an iterator to traverse the list of nodes returned by getChildren
            for (Iterator<Node> it = getChildren().iterator(); it.hasNext();) {
                // Cast the node to Ball
                Ball ball = (Ball) it.next();

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

                // Traverse the objects in the pane and check for collisions
                for (ListIterator<Node> iterator = getChildren().listIterator();
                        iterator.hasNext();) {
                    Ball currentBall = (Ball) iterator.next();

                    // If the ball is not itself and it collides with another ball
                    if (ball != currentBall
                            && ball.intersects(currentBall.getBoundsInLocal())) {
                        // Update the radius and remove the current ball
                        ball.setRadius(ball.getRadius() + currentBall.getRadius());
                        iterator.remove();
                        // getChildren().remove(currentBall);
                    }
                }
            }
        }
    }

    class Ball extends Circle {

        private double dx = 1;
        private double dy = 1;

        public Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            setFill(color); // Set ball color

            // handler that removes a ball when the mouse is pressed on the ball
            setOnMousePressed(e -> {
                ballPane.getChildren().remove(this);
            });
        }
    }
}
