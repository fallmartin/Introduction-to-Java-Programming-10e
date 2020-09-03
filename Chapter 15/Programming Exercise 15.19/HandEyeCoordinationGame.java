
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Game: eye-hand coordination) Write a program that displays a circle of
 * radius 10 pixels filled with a random color at a random location on a pane,
 * as shown in Figure 15.29b. When you click the circle, it disappears and a new
 * random-color circle is displayed at another random location. After twenty
 * circles are clicked, display the time spent in the pane, as shown in Figure
 * 15.29c.
 *
 * @author martinfall
 */
public class HandEyeCoordinationGame extends Application {

    private final double WIDTH = 300;
    private final double HEIGHT = 200;
    private final double RADIUS = 10.0;
    private int TURNS = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Start and end time
        long startTime = System.currentTimeMillis();

        // Create a new pane
        Pane pane = new Pane();

        // Create a new circle
        Circle c = new Circle(RADIUS,
                Color.color(Math.random(), Math.random(), Math.random()));

        // Assign valid random values to x and y
        c.setCenterX((WIDTH - RADIUS) * Math.random());
        c.setCenterY((HEIGHT - RADIUS) * Math.random());

        // Register the event handler with c
        c.setOnMouseClicked(e -> {
            if (TURNS < 19) { // Total number of turns needed - the first placed c
                // pane.getChildren().remove(c);
                c.setFill(Color.color(
                        Math.random(), Math.random(), Math.random(), 1.0));
                c.setCenterX((WIDTH - RADIUS) * Math.random());
                c.setCenterY((HEIGHT - RADIUS) * Math.random());
                TURNS++;
            } else {
                long endTime = System.currentTimeMillis();
                String time = "Time spent is "
                        + Duration.millis(endTime - startTime) + " milliseconds";
                pane.getChildren().clear();
                pane.getChildren().add(new Text(20, 20, time));
            }
        });

        // Add the circle to the pane
        pane.getChildren().add(c);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the primary stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage nonresizable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
