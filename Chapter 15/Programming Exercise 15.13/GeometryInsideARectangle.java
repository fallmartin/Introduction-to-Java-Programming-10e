
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Geometry: inside a rectangle?) Write a program that draws a fixed rectangle
 * centered at (100, 60) with width 100 and height 40. Whenever the mouse is
 * moved, display a message indicating whether the mouse point is inside the
 * rectangle at the mouse point or outside of it, as shown in Figure 15.27b. To
 * detect whether a point is inside a polygon, use the contains method defined
 * in the Node class.
 *
 * @author martinfall
 */
public class GeometryInsideARectangle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        double x = 100;
        double y = 60;
        double width = 100;
        double height = 40;

        // Create the rectangle at (x, y) with specified width and height
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        // Two text objects
        Text notification = new Text();

        // Create a new pane
        Pane pane = new Pane();
        pane.getChildren().addAll(rectangle, notification);

        //
        pane.setOnMouseMoved(e -> {
            if (rectangle.contains(e.getX(), e.getY())) {
                notification.setText("Mouse point is inside the rectangle");
                notification.setX(e.getX());
                notification.setY(e.getY());
            } else {
                notification.setText("Mouse point is outside the rectangle");
                notification.setX(e.getX());
                notification.setY(e.getY());
            }
        });

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, 400, 120);
        primaryStage.setTitle("Exercise_15_13"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false); // Make the stage not resizable
        primaryStage.show(); // Display the primary stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
