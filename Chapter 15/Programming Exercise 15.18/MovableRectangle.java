
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Move a rectangle using mouse) Write a program that displays a rectangle. You
 * can point the mouse inside the rectangle and drag (i.e., move with mouse
 * pressed) the rectangle wherever the mouse goes. The mouse point becomes the
 * center of the rectangle.
 *
 * @author martinfall
 */
public class MovableRectangle extends Application {

    private final double WIDTH = 500;
    private final double HEIGHT = 500;
    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new rectangle
        Rectangle r = new Rectangle();
        r.setWidth(150);
        r.setHeight(75);
        r.setFill(Color.CORNFLOWERBLUE);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(1.5);

        // Assign x and y so that the rectangle is randomly placed in the pane
        r.setX((WIDTH - r.getWidth()) * Math.random());
        r.setY((HEIGHT - r.getHeight()) * Math.random());

        // Register an event handler of type mouse event with r
        r.setOnMouseDragged(e -> {
            if (e.getX() >= 0 && e.getX() <= (WIDTH - r.getWidth())) {
                r.setX(e.getX());
            }

            if (e.getY() >= 0 && e.getY() <= (HEIGHT - r.getHeight())) {
                r.setY(e.getY());
            }

        });

        // Add the rectangle to the pane
        pane.getChildren().add(r);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the primary stage
        primaryStage.setResizable(false); // Make the stage non-resizable
        primaryStage.show(); // Display the stage

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
