
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Geometry: inside a polygon?) Write a program that draws a fixed polygon with
 * points at (40, 20), (70, 40), (60, 80), (45, 45), and (20, 60). Whenever the
 * mouse is moved, display a message indicating whether the mouse point is
 * inside the polygon at the mouse point or outside of it, as shown in Figure
 * 15.27c. To detect whether a point is inside a polygon, use the contains
 * method defined in the Node class.
 *
 * @author martinfall
 */
public class GeometryInsideAPolygon extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the polygon object
        Polygon polygon = new Polygon(
                40.0, 20.0, 70.0, 40.0, 60.0, 80.0, 45.0, 45.0, 20.0, 60.0);
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);

        // Create a new Text object
        Text notification = new Text();

        // Create a new pane
        Pane pane = new Pane();
        pane.getChildren().addAll(polygon, notification);

        // Register an event handler with the pane
        pane.setOnMouseMoved(e -> {
            if (polygon.contains(e.getX(), e.getY())) {
                notification.setText("Mouse point is inside the polygon");
                notification.setX(e.getX());
                notification.setY(e.getY());
            } else {
                notification.setText("Mouse point is outside the polygon");
                notification.setX(e.getX());
                notification.setY(e.getY());
            }
        });

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_15_14"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the primary stage
        primaryStage.setResizable(false); // Make the stage non-resizable
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
