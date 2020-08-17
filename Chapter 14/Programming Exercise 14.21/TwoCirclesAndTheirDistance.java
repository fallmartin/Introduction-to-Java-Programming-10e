
import java.awt.geom.Point2D;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Two circles and their distance) Write a program that draws two filled
 * circles with radius 15 pixels, centered at random locations, with a line
 * connecting the two circles. The distance between the two centers is displayed
 * on the line, as shown in Figure 14.49b.
 *
 * @author martinfall
 */
public class TwoCirclesAndTheirDistance extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Variable declarations
        double paneWidth = 400;
        double paneHeight = 300;
        double radius = 15;
        Color paint = Color.GREY;

        // Create a new pane
        Pane pane = new Pane();
        pane.setMinWidth(paneWidth);
        pane.setMinHeight(paneHeight);
        pane.setPadding(new Insets(10, 5, 10, 5));

        // Create the two circles
        Circle circle1 = new Circle(radius, paint);
        circle1.setCenterX(Math.random() * paneWidth);
        circle1.setCenterY(Math.random() * paneHeight);

        Circle circle2 = new Circle(radius, paint);
        circle2.setCenterX(Math.random() * paneWidth);
        circle2.setCenterY(Math.random() * paneHeight);

        // Draw a line connecting the two circles
        Line line = new Line();
        line.setStartX(circle1.getCenterX());
        line.setStartY(circle1.getCenterY());
        line.setEndX(circle2.getCenterX());
        line.setEndY(circle2.getCenterY());
        line.setStroke(paint);

        // Calculate the distance between the two centers
        double distance = Point2D.distance(line.getStartX(), line.getStartY(),
                line.getEndX(), line.getEndY());

        // Text coordinates
        double xDelta = Math.abs(circle1.getCenterX() - circle2.getCenterX());
        double yDelta = Math.abs(circle1.getCenterY() - circle2.getCenterY());

        // Find x for text placement
        double x = (circle1.getCenterX() > circle2.getCenterX())
                ? circle1.getCenterX() - (xDelta / 2)
                : circle1.getCenterX() + (xDelta / 2);
        
        // Find y for text placement
        double y = (circle1.getCenterY() > circle2.getCenterY())
                ? circle1.getCenterY() - (yDelta / 2)
                : circle1.getCenterY() + (yDelta / 2);

        Text text = new Text(distance + "");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial"));
        text.setX(x);
        text.setY(y);

        // All all nodes to pane
        pane.getChildren().addAll(circle1, circle2, line, text);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_21"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
