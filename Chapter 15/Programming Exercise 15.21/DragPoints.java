
import java.awt.geom.Point2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Drag points) Draw a circle with three random points on the circle. Connect
 * the points to form a triangle. Display the angles in the triangle. Use the
 * mouse to drag a point along the perimeter of the circle. As you drag it, the
 * triangle and angles are redisplayed dynamically, as shown in Figure 15.30b.
 * For computing angles in a triangle, see Listing 4.1.
 *
 * @author martinfall
 */
public class DragPoints extends Application {

    // Data fields
    private final double WIDTH = 500;
    private final double HEIGHT = 500;
    private double RADIUS = 150;
    private double POINT_RADIUS = 10;

    // Outer circle
    Circle c = new Circle(WIDTH / 2, HEIGHT / 2, RADIUS, Color.TRANSPARENT);

    // Three vertices of a triangle
    Circle p1 = getPoint(c);
    Circle p2 = getPoint(c);
    Circle p3 = getPoint(c);

    // Three connecting lines
    Line p1p2 = new Line();
    Line p2p3 = new Line();
    Line p1p3 = new Line();

    // Three angles at p1, p2, and p3
    Text angleP1 = new Text();
    Text angleP2 = new Text();
    Text angleP3 = new Text();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a c 
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);

        // Bind the start and end points of the line to p1 and p2
        p1p2.startXProperty().bind(p1.centerXProperty());
        p1p2.startYProperty().bind(p1.centerYProperty());
        p1p2.endXProperty().bind(p2.centerXProperty());
        p1p2.endYProperty().bind(p2.centerYProperty());

        // Bind the start and end points of the line to p2 and p3
        p2p3.startXProperty().bind(p2.centerXProperty());
        p2p3.startYProperty().bind(p2.centerYProperty());
        p2p3.endXProperty().bind(p3.centerXProperty());
        p2p3.endYProperty().bind(p3.centerYProperty());

        // Bind the start and end points of the line to p1 and p3
        p1p3.startXProperty().bind(p1.centerXProperty());
        p1p3.startYProperty().bind(p1.centerYProperty());
        p1p3.endXProperty().bind(p3.centerXProperty());
        p1p3.endYProperty().bind(p3.centerYProperty());

        // Create the three dynamic angle displays
        angleP1.setText(getAngle(p2p3, p1p3, p1p2));
        angleP2.setText(getAngle(p1p3, p2p3, p1p2));
        angleP3.setText(getAngle(p1p2, p1p3, p2p3));

        // Send the text to back to prevent interference with vertex mouse drag
        angleP1.toBack();
        angleP2.toBack();
        angleP3.toBack();

        // Bind the dynamic angle displays to the each vertex
        // Angle 1 at vertex 1
        angleP1.xProperty().bind(p1.centerXProperty().add(10));
        angleP1.yProperty().bind(p1.centerYProperty().add(10));

        // Angle 2 at vertex 2
        angleP2.xProperty().bind(p2.centerXProperty().add(10));
        angleP2.yProperty().bind(p2.centerYProperty().add(10));

        // Angle 3 at vertex 3
        angleP3.xProperty().bind(p3.centerXProperty().add(10));
        angleP3.yProperty().bind(p3.centerYProperty().add(10));

        // Create a new Pane
        Pane pane = new Pane();

        // Add the nodes to the pane
        pane.getChildren().addAll(c, p1, p2, p3, p1p2, p2p3, p1p3);
        // Add the angles to the pane
        pane.getChildren().addAll(angleP1, angleP2, angleP3);

        // Send the lines to the back
        p1p2.toBack();
        p2p3.toBack();
        p1p3.toBack();

        // Create a new scene and add it to the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_21"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    private Circle getPoint(Circle c) {

        double a = Math.random() * 2 * Math.PI;
        double x = c.getCenterX() + RADIUS * Math.cos(a);
        double y = c.getCenterY() + RADIUS * Math.sin(a);
        Color paint = Color.GREEN;

        Circle point = new Circle(x, y, POINT_RADIUS, paint);

        point.setOnMouseDragged(e -> {
            // System.out.println("Moving point...");
            double angle = Math.atan2(e.getY() - c.getCenterY(), e.getX() - c.getCenterX());
            point.setCenterX(c.getCenterX() + RADIUS * Math.cos(angle));
            point.setCenterY(c.getCenterY() + RADIUS * Math.sin(angle));

            angleP1.setText(getAngle(p2p3, p1p3, p1p2));
            angleP2.setText(getAngle(p1p3, p2p3, p1p2));
            angleP3.setText(getAngle(p1p2, p1p3, p2p3));
        });

        return point;
    }

    private static double getDistance(Line line) {
        return Point2D.distance(
                line.getStartX(), line.getStartY(), // x1, y1
                line.getEndX(), line.getEndY()); // x2, y2
    }

    private static String getAngle(Line l1, Line l2, Line l3) {
        double d1 = getDistance(l1);
        double d2 = getDistance(l2);
        double d3 = getDistance(l3);
        double angle = Math.toDegrees(Math.acos((d1 * d1 - d2 * d2 - d3 * d3) / (-2 * d2 * d3)));

        return String.format("%.2f", angle);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
