
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * (Move the ball) Write a program that moves the ball in a pane. You should
 * define a pane class for displaying the ball and provide the methods for
 * moving the ball left, right, up, and down, as shown in Figure 15.24c. Check
 * the boundary to prevent the ball from moving out of sight completely.
 *
 * @author martinfall
 */
public class BallPane extends Pane {

    double width = 350;
    double height = 300;
    double radius = 20;
    Circle ball = new Circle(width / 2, height / 2, radius);
    double step = 5;

    public BallPane() {
        setMinWidth(width);
        setMinHeight(height);
        ball.setFill(Color.RED);
        ball.setStroke(Color.BLACK);
        getChildren().add(ball);
    }

    public void moveLeft() {
        if (ball.getCenterX() > ball.getRadius()) {
            ball.setCenterX(ball.getCenterX() - step);
        }
    }

    public void moveRight() {
        if (ball.getCenterX() < getWidth() - radius) {
            ball.setCenterX(ball.getCenterX() + step);
        }
    }

    public void moveUp() {
        if (ball.getCenterY() > radius) {
            ball.setCenterY(ball.getCenterY() - step);
        }
    }

    public void moveDown() {
        if (ball.getCenterY() < (getHeight() - radius)) {
            ball.setCenterY(ball.getCenterY() + step);
        }
    }
}
