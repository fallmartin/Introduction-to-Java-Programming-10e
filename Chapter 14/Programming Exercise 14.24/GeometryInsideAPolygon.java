
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Geometry: Inside a polygon?) Write a program that prompts the user to enter
 * the coordinates of five points from the command line. The first four points
 * form a polygon, and the program displays the polygon and a text that
 * indicates whether the fifth point is inside the polygon, as shown in Figure
 * 14.51a. Hint: Use the Node’s contains method to test whether a point is
 * inside a node.
 *
 * Sample testing values: 100 50 200 45 67 90 53 48 100 100 (not inside)
 * Sample testing values: 100 50 200 45 67 90 53 48 110 60 (inside)
 *
 * @author martinfall
 */
public class GeometryInsideAPolygon extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a new scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the coordinates of five points
        System.out.println("Enter the coordinates x and y of five points: ");

        // Create an array of points
        double[][] pointsArray = new double[5][2];

        // Populate the array
        for (int i = 0; i < pointsArray.length; i++) {
            for (int j = 0; j < pointsArray[i].length; j++) {
                pointsArray[i][j] = input.nextDouble();
            }
        }

        // Build the polygon
        Polygon polygon = new Polygon();
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        // lenght - 1 because the last set of coordinates is the point we're testing
        for (int i = 0; i < pointsArray.length - 1; i++) {
            for (int j = 0; j < pointsArray[i].length; j++) {
                list.add(pointsArray[i][j]);
            }
        }

        // Build a circle centered at the last set of coordinate points
        Circle point = new Circle();
        point.setCenterX(pointsArray[pointsArray.length - 1][0]);
        point.setCenterY(pointsArray[pointsArray.length - 1][1]);
        point.setRadius(5);

        // Create a new pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));

        // Add rectangles to pane
        pane.getChildren().addAll(polygon, point);

        // Create a new border pane
        BorderPane outerPane = new BorderPane();
        outerPane.setPadding(new Insets(10));
        
        // Add pane to center of outerPane
        outerPane.setCenter(pane);

        // Build message
        String message = "The point is"
                + ((polygon.contains(point.getCenterX(), point.getCenterY()) ? " " : " not "))
                + "inside the polygon";

        // Add message to bottom of outerPane
        outerPane.setBottom(new Text(message));

        // Create a scene and place it in the stage
        Scene scene = new Scene(outerPane, 400, 300);
        stage.setTitle("Exercise_14_24"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
