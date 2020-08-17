
import java.awt.geom.Point2D;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * (Draw an arrow line) Write a static method that draws an arrow line from a
 * starting point to an ending point in a pane using the following method
 * header:
 *
 * public static void drawArrowLine(double startX, double startY,
 * double endX, double endY, Pane pane)
 *
 * Write a test program that randomly draws an arrow line, as shown in Figure
 * 14.49a.
 *
 * @author martinfall
 */
public class ArrowLine extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));

        double paneWidth = 400;
        double paneHeight = 250;

        for (int i = 0; i < 10; i++) {
            double x1 = Math.random() * (paneWidth - 12);
            double y1 = Math.random() * (paneHeight - 12);
            double x2 = Math.random() * (paneWidth - 12);
            double y2 = Math.random() * (paneHeight - 12);

            drawArrowLine(x1, y1, x2, y2, pane);
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        stage.setTitle("Exercise_14_20"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

    }

    public static void drawArrowLine(
            double startX, double startY, double endX, double endY, Pane pane) {
        // Generate a random color
        Color c = Color.color(Math.random(), Math.random(), Math.random());

        // Create the line
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(c);

        // Initial x and y starting points
        double x = endX;
        double y = endY;

        // Create a new group Math.cos(Math.atan(slope) + set45)
        Group arrow = new Group();
        Line left = new Line(x, y, x - 10, y + 10);
        Line middle = new Line(x, y, x, y + 10);
        Line right = new Line(x, y, x + 10, y + 10);
        left.setStroke(c);
        middle.setStroke(c);
        right.setStroke(c);

        // Calculate the slope of the line
        double slope = (((double) startY) - ((double) endY))
                / (((double) startX) - ((double) endX));

        // Calculate the arctangent of the angle
        double arctan = Math.atan(slope);

        // Instantiate a new Rotate object and set its pivot x, y, and angle
        Rotate rotate = new Rotate();
        rotate.setPivotX(line.getEndX());
        rotate.setPivotY(line.getEndY());
        rotate.setAngle(Math.toDegrees(arctan) + ((startX < endX) ? 90 : 270));
        arrow.getTransforms().add(rotate);

        // Add left, middle, and right to the arrow group
        arrow.getChildren().addAll(left, middle, right);
        // Add line and arrow to the pane
        pane.getChildren().addAll(line, arrow);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
