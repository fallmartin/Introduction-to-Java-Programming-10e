
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Connect two circles) Write a program that draws two circles with radius
 * 15 pixels, centered at random locations, with a line connecting the two
 * circles. The line should not cross inside the circles, as shown in Figure
 * 14.49c.
 *
 * @author martinfall
 */
public class ConnectTwoCircles extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        double paneWidth = 400;
        double paneHeight = 300;
        double radius = 15;
        Color paint = Color.LIGHTGREEN;

        // Create a new pane
        Pane pane = new Pane();
        pane.setMaxWidth(paneWidth);
        pane.setMaxHeight(paneHeight);
        pane.setPadding(new Insets(10, 5, 10, 5));

        // Create circle 1
        Circle circle1 = new Circle(radius, paint);
        circle1.setCenterX(Math.random() * paneWidth);
        circle1.setCenterY(Math.random() * paneHeight);
        circle1.setStroke(Color.BLACK);
        Text t1 = new Text(circle1.getCenterX(), circle1.getCenterY(), "1");

        // Create circle 2
        Circle circle2 = new Circle(radius, paint);
        circle2.setCenterX(Math.random() * paneWidth);
        circle2.setCenterY(Math.random() * paneHeight);
        circle2.setStroke(Color.BLACK);
        Text t2 = new Text(circle2.getCenterX(), circle2.getCenterY(), "2");

        // If circle1 is to the right of circle2
        if (circle1.getCenterX() > circle2.getCenterX()) {
            // Create a throwaway circle object and copy circle 
            Circle temp = new Circle();
            temp.setCenterX(circle1.getCenterX());
            temp.setCenterY(circle1.getCenterY());

            // Copy circle2 into circle1
            circle1.setCenterX(circle2.getCenterX());
            circle1.setCenterY(circle2.getCenterY());

            // Copy temp into circle2
            circle2.setCenterX(temp.getCenterX());
            circle2.setCenterY(temp.getCenterY());
        }

        // Declare variables for the line constructor parameters
        double startX = circle1.getCenterX();
        double startY = circle1.getCenterY();
        double endX = circle2.getCenterX();
        double endY = circle2.getCenterY();

        // Calculate the slope of the line
        double slope = (((double) startY) - ((double) endY))
                / (((double) startX) - ((double) endX));
        System.out.println(slope); // Display the slope on the console

        // Calculate the arctangent of the angle
        double angle = Math.atan(slope);

        startX += Math.cos(angle) * radius;
        startY += Math.sin(angle) * radius;
        endX -= Math.cos(angle) * radius;
        endY -= Math.sin(angle) * radius;

        Line line = new Line(startX, startY, endX, endY);

        // All all nodes to pane
        pane.getChildren().addAll(circle1, circle2, t1, t2, line);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 400);
        stage.setTitle("Exercise_14_21"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
