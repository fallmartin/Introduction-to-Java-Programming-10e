
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Racing car) Write a program that simulates car racing, as shown in Figure
 * 15.34a. The car moves from left to right. When it hits the right end, it
 * restarts from the left and continues the same process. You can use a timer to
 * control animation. Redraw the car with a new base coordinates (x, y), as
 * shown in Figure 15.34b. Also let the user pause/resume the animation with a
 * button press/release and increase/decrease the car speed by pressing the UP
 * and DOWN arrow keys.
 *
 * @author martinfall
 */
public class RacingCar extends Application {

    final int WIDTH = 500;
    final int HEIGHT = 200;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a new pane
        Pane pane = new Pane();

        // Register a Lambda expresson event handler with the pane
        pane.setOnMouseClicked(e -> {

            // Clear the pane
            pane.getChildren().clear();

            // Create a new car object at x, y
            Car car = new Car(e.getX(), e.getY());
            // Change e.getY() to HEIGHT to put the car on the "floor"

            // Add it to the pane
            pane.getChildren().add(car);

            // Create a timeline animation
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(5), eh -> {
                        // Increment layout x by 1 on finished
                        car.setLayoutX(
                                (car.getLayoutX() > WIDTH - e.getX())
                                ? (-e.getX())
                                : car.getLayoutX() + 1);
                    }));

            // Animatino cycle count, rate, and play
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setRate(1);
            timeline.play();

            // Register event handler with pane to control the animation rate
            pane.setOnKeyPressed(eh -> {
                switch (eh.getCode()) {
                    // If the UP key is pressed
                    case UP:
                        System.out.println("ZOOM ZOOM");
                        timeline.setRate(timeline.getRate() + 0.1);
                        pane.requestFocus(); // Request focus on the pane
                        break;
                    // If the DOWN key is pressed
                    case DOWN:
                        System.out.println("SLOW DOWN!");
                        timeline.setRate(timeline.getRate() > 0.15
                                ? timeline.getRate() - 0.1
                                : 0.15); // Minimum rate
                        pane.requestFocus(); // Request focus on the pane
                        break;
                    case P:
                        if (timeline.getStatus() == Animation.Status.RUNNING) {
                            timeline.pause();
                        }
                        break;
                    // If any other key is pressed
                    default:
                        System.out.println("KEY NOT DEFINED");
                        break;
                }
            });

            pane.setOnKeyReleased(eh -> {
                if (eh.getCode() == KeyCode.P) {
                    if (timeline.getStatus() == Animation.Status.PAUSED) {
                        timeline.play();
                    }
                }
            });
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_29"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

        pane.requestFocus(); // Request focus on the pane
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    class Car extends Pane {

        public Car(double x, double y) {

            // Validate x and y
            if (x > WIDTH - 50) {
                x = WIDTH - 50;
            }

            if (y < 30) {
                y = 30;
            }

            // Top
            Polygon top = new Polygon(
                    x + 10, y - 20,
                    x + 20, y - 30,
                    x + 30, y - 30,
                    x + 40, y - 20
            );
            top.setFill(Color.GRAY);
            top.setOpacity(0.5);
            top.setStroke(Color.BLACK);

            // Body
            Rectangle body = new Rectangle(x, y - 20, 50, 10);
            body.setFill(Color.color(Math.random(), Math.random(), Math.random(), 1.0));

            // Left wheel
            Circle leftWheel = new Circle(x + 15, y - 5, 5);
            leftWheel.setFill(Color.BLACK);

            // Right wheel
            Circle rightWheel = new Circle(x + 35, y - 5, 5);
            rightWheel.setFill(Color.BLACK);

            // Create a new group of nodes
            Group car = new Group(top, body, leftWheel, rightWheel);

            // Add the group to the pane
            getChildren().addAll(car);
        }
    }
}
