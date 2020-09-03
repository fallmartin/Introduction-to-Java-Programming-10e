
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Geometry: find the bounding rectangle) Write a program that enables the user
 * to add and remove points in a two-dimensional plane dynamically, as shown in
 * Figure 15.29a. A minimum bounding rectangle is updated as the points are
 * added and removed. Assume that the radius of each point is 10 pixels.
 *
 * @author martinfall
 */
public class GeometryFindTheBoundingRectangle extends Application {

    final double WIDTH = 600.0;
    final double HEIGHT = 300.0;
    final double RADIUS = 10.0;

    ArrayList<Double> xCoordinates = new ArrayList<>();
    ArrayList<Double> yCoordinates = new ArrayList<>();

    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        // Pane UI tweaks
        pane.setPadding(new Insets(10, 10, 10, 10)); // Padding

        // Create the instructions pane
        StackPane instructions = new StackPane();
        instructions.getChildren().add(new Text("INSTRUCTION\n"
                + "Add: Left Click\nRemove: Right Click"));
        instructions.setPadding(new Insets(5));
        instructions.setStyle("-fx-border-color : black; -fx-border-width : 1 ");

        // Event handler object to register with each instance of Circle
        EventHandler<MouseEvent> removePoint = e -> {
            // If the right mouse button is pressed
            if (e.getButton().equals(MouseButton.SECONDARY)) {
                // Create a new circle from the event source object
                Circle point = (Circle) e.getSource();

                // Remove x and y from respective lists
                xCoordinates.remove(point.getCenterX());
                yCoordinates.remove(point.getCenterY());

                // Remove point from the pane
                pane.getChildren().remove(point);

                // Remove the old rectangle from the pane
                removeRectangle();

                // If x and y arrays are not empty
                if (!xCoordinates.isEmpty() && !yCoordinates.isEmpty()) {
                    // Create a new minimum bounding rectangle and add to pane
                    Rectangle r = getNewRectangle();
                    pane.getChildren().add(r);
                    r.toBack(); // Send it to the back to keep points clickable
                }
            }
        };

        // Event handler to register with the pane to add points on click
        EventHandler<MouseEvent> addPoint = e -> {
            // If the left mouse button is pressed
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                // Create a new point
                Circle point = new Circle(e.getX(), e.getY(), RADIUS);
                point.setFill(Color.WHITE);
                point.setStroke(Color.BLACK);
                point.setOnMouseClicked(removePoint); // Handler registered with each point

                // Update and sort the x- and y- double arrays
                xCoordinates.add(e.getX());
                yCoordinates.add(e.getY());
                Collections.sort(xCoordinates);
                Collections.sort(yCoordinates);

                // Remove the old rectangle from the pane
                removeRectangle();

                // Create a new minimum bounding rectangle and add to pane
                Rectangle r = getNewRectangle();
                pane.getChildren().addAll(point, r);
                r.toBack(); // Send it to the back to keep points clickable
            }
        };

        // Register the addPoint handler with the pane
        pane.setOnMouseClicked(addPoint);
        pane.getChildren().add(instructions);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_17"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the primary stage
        primaryStage.setResizable(false); // Make the stage non-resizable
        primaryStage.show(); // Display the stage
    }

    public Rectangle getNewRectangle() {
        // Construct a new Rectangle object
        Rectangle r = new Rectangle();

        // Local vars for convenience
        double minX = xCoordinates.get(0) - RADIUS;
        double minY = yCoordinates.get(0) - RADIUS;
        double maxX = xCoordinates.get(xCoordinates.size() - 1) + RADIUS;
        double maxY = yCoordinates.get(yCoordinates.size() - 1) + RADIUS;

        // Set x, y, width, and height of new min bounding rectangle
        r.setX(minX);
        r.setY(minY);
        r.setWidth(maxX - minX);
        r.setHeight(maxY - minY);
        r.setId("removable"); // string identifier for finding this node within the scene

        // UI tweaks
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.RED);
        return r;
    }

    public void removeRectangle() {
        // Iterate through the nodes in the pane
        for (int i = 0; i < pane.getChildren().size(); i++) {
            if (pane.getChildren().get(i) instanceof Rectangle
                    && pane.getChildren().get(i).getId().equals("removable")) {
                pane.getChildren().remove(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
