
import java.awt.Point;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Two movable vertices and their distances) Write a program that displays two
 * circles with radius 10 at location (40, 40) and (120, 150) with a line
 * connecting the two circles, as shown in Figure 15.28b. The distance between
 * the circles is displayed along the line. The user can drag a circle. When
 * that happens, the circle and its line are moved and the distance between the
 * circles is updated.
 *
 * @author martinfall
 */
public class TwoMovableVerticesAndTheirDistances extends Application {

    private final double radius = 10;
    private double centerX1 = 40;
    private double centerY1 = 40;
    private double centerX2 = 120;
    private double centerY2 = 150;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the first point
        Circle point1 = new Circle(centerX1, centerY1, radius);
        point1.setFill(Color.WHITE);
        point1.setStroke(Color.BLACK);
        point1.setStrokeWidth(3);

        // Create the second point
        Circle point2 = new Circle(centerX2, centerY2, radius);
        point2.setFill(Color.WHITE);
        point2.setStroke(Color.BLACK);
        point2.setStrokeWidth(3);

        // Create the connecting line
        Line line = new Line();
        line.startXProperty().bind(point1.centerXProperty());
        line.startYProperty().bind(point1.centerYProperty());
        line.endXProperty().bind(point2.centerXProperty());
        line.endYProperty().bind(point2.centerYProperty());

        // Create a text variable to hold the distance
        Text text = new Text("distance");
        updateDistanceMessage(text, point1, point2);

        // Create a new pane and add the nodes to it
        Pane pane = new Pane(line, point1, point2, text);

        // Register an event handler with point1 with a Lambda expression
        point1.setOnMouseDragged(e -> {
            point1.setCenterX(e.getX());
            point1.setCenterY(e.getY());
            updateDistanceMessage(text, point1, point2);
        });

        // Register an event handler with point2 with an anonymous inner class
        point2.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                point2.setCenterX(t.getX());
                point2.setCenterY(t.getY());
                updateDistanceMessage(text, point1, point2);
            }
        });

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Exercise_15_16"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the primary stage
        primaryStage.setResizable(false); // Make the stage non-resizable
        primaryStage.show(); // Display the stage
    }

    private void updateDistanceMessage(Text text, Circle point1, Circle point2) {
        text.setX((point1.getCenterX() + point2.getCenterX()) / 2);
        text.setY((point1.getCenterY() + point2.getCenterY()) / 2);
        text.setText(getDistance(point1, point2));
    }

    private static String getDistance(Circle point1, Circle point2) {
        double distance = Point.distance(
                point1.getCenterX(), point1.getCenterY(),
                point2.getCenterX(), point2.getCenterY());
        return String.format("%.2f", distance);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
