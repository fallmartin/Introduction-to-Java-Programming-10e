
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * (Random points on a circle) Modify Programming Exercise 4.6 to create five
 * random points on a circle, form a polygon by connecting the points clockwise,
 * and display the circle and the polygon, as shown in Figure 14.51b.
 *
 * @author martinfall
 */
public class RandomPointsOnACircle extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Variable declarations
        final double RADIUS = 150;
        final Color FILL = Color.TRANSPARENT;
        final Color STROKE = Color.BLACK;
        final int NUMBER_OF_RANDOM_POINTS = 5;
        final int WIDTH = 400;
        final int HEIGHT = 400;
        final double X = WIDTH / 2.0;
        final double Y = HEIGHT / 2.0;

        // Create a circle
        Circle circle = new Circle(X, Y, RADIUS, FILL);
        circle.setStroke(STROKE);

        // Create a polygon and an observable list for the random points
        Polygon polygon = new Polygon();
        polygon.setFill(FILL);
        polygon.setStroke(Color.RED);
        ObservableList<Double> list = polygon.getPoints();

        // Create an array of split angles
        double[] angles = splitRandomAngles(NUMBER_OF_RANDOM_POINTS);
        System.out.println(Arrays.toString(angles));

        // Initial angle before we start adding angles inside the loop
        double angle = 0;

        // Create the random points using sin and cos methods of Math class
        for (int i = 0; i < NUMBER_OF_RANDOM_POINTS; i++) {
            angle += angles[i];
            System.out.println(angle);

            // Calculate x and y
            double x = circle.getCenterX() + RADIUS * Math.cos(Math.toRadians(angle));
            double y = circle.getCenterY() + RADIUS * Math.sin(Math.toRadians(angle));

            // Add x and y to the list of points
            list.addAll(x, y);
        }

        // Sort the points in the list clockwise
        // Create a stack pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        pane.setMinWidth(WIDTH);
        pane.setMinHeight(HEIGHT);
        pane.getChildren().addAll(circle, polygon);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_25"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    /**
     * Returns an array of angles that add up to a full circle.
     *
     * @param points
     * @return
     */
    public static double[] splitRandomAngles(int points) {
        // Create an array of angles to return to the caller method
        double[] angles = new double[points];
        // Create an array of weights to divide by their sum before multiplying by 360
        double[] weights = new double[points];

        // Populate weights with random numbers between 0 and 100 (exclusive)
        for (int i = 0; i < points; i++) {
            // Random object r
            Random r = new Random();
            // Bounded random integer
            weights[i] = r.nextInt(100);
        }

        // Declare a variable sum and set it to 0
        double sum = 0;

        // Calculate the sum of all the weights in the array
        for (double w : weights) {
            sum += w;
        }

        // Populate angles with the weight * 360
        for (int i = 0; i < points; i++) {
            angles[i] = 360 * weights[i] / sum;
        }

        // The sum of each angle in angles adds up to a full circle
        return angles;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
