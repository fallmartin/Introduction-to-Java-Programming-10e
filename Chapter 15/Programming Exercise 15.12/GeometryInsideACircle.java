
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Geometry: inside a circle?) Write a program that draws a fixed circle
 * centered at (100, 60) with radius 50. Whenever the mouse is moved, display a
 * message indicating whether the mouse point is inside the circle at the mouse
 * point or outside of it, as shown in Figure 15.27a.
 *
 * @author martinfall
 */
public class GeometryInsideACircle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        double centerX = 100;
        double centerY = 60;
        double radius = 50;

        // Create the circle at (x, y) with specified radius
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        // Two text objects
        Text notification = new Text();

        // Create a new pane
        Pane pane = new Pane();
        pane.getChildren().addAll(circle, notification);

        //
        pane.setOnMouseMoved(e -> {
            if (circle.contains(e.getX(), e.getY())) {
                notification.setText("Mouse point is inside the circle");
                notification.setX(e.getX());
                notification.setY(e.getY());
            } else {
                notification.setText("Mouse point is outside the circle");
                notification.setX(e.getX());
                notification.setY(e.getY());
            }
        });

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, 400, 120);
        primaryStage.setTitle("Exercise_15_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false); // Make the stage not resizable
        primaryStage.show(); // Display the primary stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
