
import java.util.Arrays;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

/**
 *
 * @author martinfall
 */
public class BeanMachineComponent extends Pane {

    // UI data fields
    private static final double SIDE = 20;
    private static final double WIDTH = SIDE * 22;
    private static final double HEIGHT = SIDE * 28;
    private static final double RADIUS = SIDE / 3;
    private static final Color BMC_STROKE = Color.rgb(97, 66, 211).darker();

    // Bean machine data fields
    private final BeanMachine beanMachine = new BeanMachine();
    private final int balls = beanMachine.getBalls();
    private final int slots = beanMachine.getSlots();
    private final int[][] paths = beanMachine.getPaths();
    private final int[] ballsInSlot = new int[slots];
    private final int[] ballStopSlot = new int[balls];

    // Animation data fields
    private static final int PATH_DURATION = 1500; // in millis
    private int ballCounter = 0;

    /**
     * No-args constructor for the BeanMachineComponent class.
     */
    public BeanMachineComponent() {
        draw(); // Draw the GUI
    }

    /**
     * Returns a pane containing the bean machine's GUI.
     */
    private final void draw() {
        // Set the minimum width and height of the pane
        setMinWidth(WIDTH);
        setMinHeight(HEIGHT);

        // Draw the outer frame from top left all around to top right CCW
        Polyline frame = new Polyline();
        ObservableList<Double> list = frame.getPoints();
        list.addAll(SIDE * 10, SIDE * 3);
        list.addAll(SIDE * 10, SIDE * 5);
        list.addAll(SIDE * 3, SIDE * 18);
        list.addAll(SIDE * 3, SIDE * 25);
        list.addAll(SIDE * 19, SIDE * 25);
        list.addAll(SIDE * 19, SIDE * 18);
        list.addAll(SIDE * 12, SIDE * 5);
        list.addAll(SIDE * 12, SIDE * 3);

        frame.setStrokeWidth(3);
        frame.setStroke(BMC_STROKE);
        getChildren().add(frame); // Frame added to the pane

        // Draw the 7 pegs
        double numberOfPegs = 7;
        double startX = SIDE * 5;
        double startY = SIDE * 18;
        double pegLength = SIDE * 7;
        double spacing = SIDE * 2;

        for (int i = 0; i < numberOfPegs; i++) {
            Line peg = new Line(startX, startY, startX, startY + pegLength);
            peg.setStrokeWidth(3);
            peg.setStroke(BMC_STROKE);
            getChildren().add(peg);
            // Update startX
            startX += spacing;
        }

        // Draw the rows of pins
        // Starting y
        double y = SIDE * 6;

        for (int i = 0; i < numberOfPegs; i++) {
            // Starting x coordinate
            double x = WIDTH / 2.0 - SIDE * i;;

            for (int j = 0; j < i + 1; j++) {
                Circle pin = new Circle(x, y, RADIUS, BMC_STROKE); // Create a new pin
                getChildren().add(pin); // Add circle to pane

                // Update x with spacing so circles don't touch in the same row
                x += spacing;
            }
            y += spacing; // Update y to the next row
        }
    }

    /**
     * Starts the animation.
     */
    public void start() {
        // Create a new key frame with duration PATH_DURATION and drop the ball
        KeyFrame keyFrame = new KeyFrame(Duration.millis(PATH_DURATION), e -> {
            dropBall(paths[ballCounter]);
        });

        // Create a new timeline with the key frame
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(balls); // Set the cycle count to the number of balls
        timeline.play(); // Start the animation
    }

    private void dropBall(int[] path) {
        // Create the ball being dropped and add it to the pane
        Circle ball = new Circle(RADIUS);
        // Random color for the balls
        ball.setFill(
                Color.color(Math.random(), Math.random(), Math.random(), 1.0));
        ball.setStroke(Color.BLACK);
        ball.setStrokeWidth(3);
        getChildren().add(ball);

        // Generate the path as a polyline
        Polyline ballPath = generateBallPath(path);

        // Create the ball's path transition
        PathTransition pt = new PathTransition(
                Duration.millis(PATH_DURATION), // duration
                ballPath, // path
                ball); // node

        pt.setInterpolator(Interpolator.EASE_IN);
        pt.setCycleCount(1); // Default is 1, but I wanted it here to test it
        pt.play(); // Play the ball drop path transition

        // Ball path in console
        System.out.print("Ball " + (ballCounter + 1) + " path ");
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] == 0 ? "L" : "R");
        }

        // Track the number of balls in each slot at the bottom in console
        System.out.println(); // Formatting line
        // System.out.println(Arrays.toString(ballStopSlot)); // to console
        // System.out.println(); // Formatting line

        // Increment the ball counter
        ballCounter++;
    }

    private int setBallsInSlot(int[] path) {
        int position = 0;

        for (int i = 0; i < path.length; i++) {
            position += path[i];
        }

        ballsInSlot[position]++; // Update the ball position array
        // System.out.println(Arrays.toString(ballsInSlot)); // to console

        return position;
    }

    private int getBallsInSlot(int slot) {
        return ballsInSlot[slot];
    }

    private Polyline generateBallPath(int[] path) {

        ballStopSlot[ballCounter] = setBallsInSlot(path);
        Polyline ballPath = new Polyline();

        // Path of the ball to the first pin
        double x = WIDTH / 2;
        double y = 0;
        ballPath.getPoints().addAll(x, y);

        // On top of the first pin
        y = SIDE * 6 - (RADIUS * 2);
        ballPath.getPoints().addAll(x, y);

        // Path of the ball through the body of the bean machine
        Point2D pointAfterBounce;

        for (int i = 0; i < path.length; i++) {
            pointAfterBounce = path[i] == 1
                    ? bounceRight(ballPath)
                    : bounceLeft(ballPath);
            ballPath.getPoints().addAll(
                    pointAfterBounce.getX(), pointAfterBounce.getY());
        }

        // Starting x,y coordinates for last path segment
        x = ballPath.getPoints().get(ballPath.getPoints().size() - 2);
        y = ballPath.getPoints().get(ballPath.getPoints().size() - 1)
                + (SIDE * 7) // The length of the peg
                - (RADIUS * 3); // Offset for the previous drop

        // Draw drop to the bottom of the machine or on top of another ball
        if (getBallsInSlot(ballStopSlot[ballCounter]) > 0) {
            y -= RADIUS * 2 * getBallsInSlot(ballStopSlot[ballCounter]);
        }

        ballPath.getPoints().addAll(x, y);

        return ballPath;
    }

    private Point2D bounceRight(Polyline ballPath) {
        // Current end x, y coordinates of the ball path polyline
        double startX = ballPath.getPoints().get(ballPath.getPoints().size() - 2);
        double startY = ballPath.getPoints().get(ballPath.getPoints().size() - 1);

        // x, y coordinates of next pin
        double endX = startX + SIDE;
        double endY = startY + (SIDE * 2);

        for (int i = 270; i <= 360; i++) {
            double x = endX + Math.cos(Math.toRadians(i));
            double y = endY - (SIDE * 2) + Math.sin(Math.toRadians(i));
            ballPath.getPoints().addAll(x, y);
        }

        return new Point2D(endX, endY);
    }

    private Point2D bounceLeft(Polyline ballPath) {
        // Current end x, y coordinates of the ball path polyline
        double startX = ballPath.getPoints().get(ballPath.getPoints().size() - 2);
        double startY = ballPath.getPoints().get(ballPath.getPoints().size() - 1);

        // x, y coordinates of next pin
        double endX = startX - SIDE;
        double endY = startY + (SIDE * 2);

        for (int i = 270; i <= 360; i++) {
            double x = endX + Math.cos(Math.toRadians(i));
            double y = endY - (SIDE * 2) + Math.sin(Math.toRadians(i));
            ballPath.getPoints().addAll(x, y);
        }

        return new Point2D(endX, endY);
    }
}
