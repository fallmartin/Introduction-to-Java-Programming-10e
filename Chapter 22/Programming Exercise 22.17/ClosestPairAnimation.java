package closestpairanimation;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Closest-pair animation) Write a program that enables the user to add/remove
 * points by clicking the left/right mouse button, and displays a line that
 * connects the pair of nearest points, as shown in Figure 22.4.
 *
 * @author martinfall
 */
public class ClosestPairAnimation extends Application {

    // Data fields and constants
    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;

    // Create an array list to hold the points created during program execution
    private static final ArrayList<Point> points = new ArrayList<>();

    // Create a new pane to hold clickable area and instructions
    private static Pane pane = new Pane();

    // Create a new line array to update at each point added on the pane
    private static Line line = new Line();

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Instructions text
        String instructions
                = "INSTRUCTIONS:\n"
                + "Add: Left Click\n"
                + "Remove: Right Click";

        // Build the INSTRUCTIONS label
        Label lblInstructions = new Label(instructions);
        lblInstructions.setPadding(new Insets(10)); // Padding
        lblInstructions.setBorder( // Border
                new Border(new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT)));

        // Layout position of label 
        lblInstructions.setLayoutX(10);
        lblInstructions.setLayoutY(10);

        // Place the label in the pane
        pane.getChildren().add(lblInstructions);

        // Create a new Scene and add it to the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setTitle("Closest Pair Animation"); // Set the stage title
        stage.setScene(scene); // Specify the scene to be used on this stage
        stage.show(); // Set the visibility of stage to true to display window
        stage.setResizable(false); // The stage is not resizable by the user

        pane.requestFocus(); // Focus on the pane

        // Add a listener to the pane
        pane.setOnMouseClicked(t -> {
            // If the primary button (RIGHT) is pressed
            if (t.getButton() == MouseButton.PRIMARY) {
                // Console output
                // System.out.println("Primary button");

                // Boolean flag to control adding the same point twice
                boolean exists = false;

                for (Node node : pane.getChildren()) {
                    if (node.contains(t.getX(), t.getSceneY())) {
                        System.out.println("Clicking on an existing point.");
                        exists = true;
                    }
                }

                // If the point doesn't exist already
                if (!exists) {
                    // Create a new MyPoint object
                    double x = t.getX();
                    double y = t.getY();
                    Point point = new Point(x, y);

                    // Add the point to the points array list
                    points.add(point);

                    // Add the point to the scene
                    pane.getChildren().removeAll(points);
                    pane.getChildren().addAll(points);
                }

                // System.out.println(points); // Display to console
            } else {
                // Console output
                // System.out.println("Secondary button");

                // Mark clicked point for deletion
                for (Node node : pane.getChildren()) {
                    if (node.contains(t.getX(), t.getSceneY())) {
                        // System.out.println("Clicking on a point for deletion.");
                        ((Point) node).keep = false;
                    }
                }

                // Remove the points from the stage
                pane.getChildren().removeAll(points);

                // Sanitize the points array
                ArrayList<Point> copy = new ArrayList<>(points);
                for (Point point : copy) {
                    if (point.keep == false) {
                        points.remove(point);
                    }
                }

                // Update the points on the stage
                pane.getChildren().addAll(points);

                // System.out.println(points); // Display to console
            }

            if (points.size() > 1) {
                // Find the closest pair
                Pair closestPair = Pair.getClosestPair(points);

                // Remove the line from the pane
                pane.getChildren().remove(line);

                // Set the line start and end points
                line.setStartX(closestPair.getP1().getX());
                line.setStartY(closestPair.getP1().getY());
                line.setEndX(closestPair.getP2().getX());
                line.setEndY(closestPair.getP2().getY());

                // Add the line to the pane
                pane.getChildren().add(line);
            } else {
                // Remove the line from the pane
                pane.getChildren().remove(line);
            }
        });
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
