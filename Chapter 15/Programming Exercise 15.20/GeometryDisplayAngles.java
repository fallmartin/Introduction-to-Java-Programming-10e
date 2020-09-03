
import java.awt.geom.Point2D;
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
 * (Geometry: display angles) Write a program that enables the user to drag the
 * vertices of a triangle and displays the angles dynamically as the triangle
 * shape changes, as shown in Figure 15.30a. The formula to compute angles is
 * given in Listing 4.1.
 *
 * @author martinfall
 */
public class GeometryDisplayAngles extends Application {

    private final double WIDTH = 500;
    private final double HEIGHT = 500;
    private final double RADIUS = 10;

    @Override
    public void start(Stage stage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();

        // Create the triangle's three vertices
        Circle a = createVertex();
        Circle b = createVertex();
        Circle c = createVertex();

        // Create the triangle's three edges
        Line ab = new Line();
        Line bc = new Line();
        Line ac = new Line();

        // Bind the edges start and end points to the vertices
        ab.startXProperty().bind(a.centerXProperty());
        ab.startYProperty().bind(a.centerYProperty());
        ab.endXProperty().bind(b.centerXProperty());
        ab.endYProperty().bind(b.centerYProperty());

        bc.startXProperty().bind(b.centerXProperty());
        bc.startYProperty().bind(b.centerYProperty());
        bc.endXProperty().bind(c.centerXProperty());
        bc.endYProperty().bind(c.centerYProperty());

        ac.startXProperty().bind(a.centerXProperty());
        ac.startYProperty().bind(a.centerYProperty());
        ac.endXProperty().bind(c.centerXProperty());
        ac.endYProperty().bind(c.centerYProperty());

        // Create the three dynamic angle displays
        Text angleA = new Text(getAngle(bc, ac, ab));
        Text angleB = new Text(getAngle(ac, bc, ab));
        Text angleC = new Text(getAngle(ab, ac, bc));

        // Send the text to back to prevent interference with vertex mouse drag
        angleA.toBack();
        angleB.toBack();
        angleC.toBack();

        // Bind the dynamic angle displays to the each vertex
        // Angle 1 at vertex 1
        angleA.xProperty().bind(a.centerXProperty().add(10));
        angleA.yProperty().bind(a.centerYProperty().add(10));

        // Angle 2 at vertex 2
        angleB.xProperty().bind(b.centerXProperty().add(10));
        angleB.yProperty().bind(b.centerYProperty().add(10));

        // Angle 3 at vertex 3
        angleC.xProperty().bind(c.centerXProperty().add(10));
        angleC.yProperty().bind(c.centerYProperty().add(10));

        // Event handler for mouse drag on circle node
        EventHandler<MouseEvent> dragVertex = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // Update x and y of current source node
                Circle c = (Circle) e.getSource();
                c.setCenterX(e.getX());
                c.setCenterY(e.getY());

                // Update the angles in the pane
                angleA.setText(getAngle(bc, ac, ab));
                angleB.setText(getAngle(ac, bc, ab));
                angleC.setText(getAngle(ab, ac, bc));
            }
        };

        // Register the handler with each vertex node
        a.setOnMouseDragged(dragVertex); // Vertex 1
        b.setOnMouseDragged(dragVertex); // Vertex 2
        c.setOnMouseDragged(dragVertex); // Vertex 3

        // Add vertices and edges to the pane
        pane.getChildren().addAll(a, b, c, // Vertices
                ab, bc, ac, // Edges
                angleA, angleB, angleC); // Angles

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setTitle("Exercise_15_20"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
        stage.setResizable(false); // Make the stage non-resizable
    }

    private Circle createVertex() {
        return new Circle(
                (WIDTH - RADIUS) * Math.random(), // x
                (HEIGHT - RADIUS) * Math.random(), // y
                RADIUS, // radius
                Color.BLACK); // fill color
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
