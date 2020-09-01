
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Geometry: add and remove points) Write a program that lets the user click on
 * a pane to dynamically create and remove points (see Figure 15.28a). When the
 * user left-clicks the mouse (primary button), a point is created and displayed
 * at the mouse point. The user can remove a point by pointing to it and
 * right-clicking the mouse (secondary button).
 *
 * @author martinfall
 */
public class GeometryAddRemovePoints extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();
        pane.setPadding(Insets.EMPTY);

        // Create the point
//        Circle point = new Circle(5);
//        point.setFill(Color.TRANSPARENT);
//        point.setStroke(Color.BLACK);
//        point.setStrokeWidth(2);
        pane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                // Display the button in console
                System.out.println("PRIMARY");

                // Create a new point
                Circle point = new Circle(5); // Radius is 5
                point.setFill(Color.TRANSPARENT); // Fill is transparent
                point.setStroke(Color.BLACK); // Stroke is black
                point.setStrokeWidth(2); // Stroke width is 2

                // Set the center of the point at the mouse clicked position
                point.setCenterX(e.getX());
                point.setCenterY(e.getY());

                // Add the point to the pane
                pane.getChildren().add(point);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                // Display the button in console
                System.out.println("SECONDARY");
                // Create a circle object 
                Circle tagged = new Circle();

                // Iterate through the observable list returned by getChildren
                for (Node n : pane.getChildren()) {
                    // If the target of the mouse event is a node in the list
                    if (e.getTarget() == n) {
                        // Assign that circle to the reference variable tagged
                        tagged = (Circle) e.getTarget();
                    }
                }
                // Remove tagged from pane
                pane.getChildren().remove(tagged);
            }
        });

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Exercise_15_15"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the primary stage
        primaryStage.setResizable(false); // Make the stage non-resizable
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
