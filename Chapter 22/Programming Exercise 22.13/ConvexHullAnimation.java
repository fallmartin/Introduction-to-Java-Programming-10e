package convexhullanimation;

import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
 * (Geometry: convex hull animation) Programming Exercise 22.11 finds a convex
 * hull for a set of points entered from the console. Write a program that
 * enables the user to add/remove points by clicking the left/right mouse
 * button, and displays a convex hull, as shown in Figure 22.8c.
 *
 * Program assumptions:
 * - No convex hull will be displayed for less than 3 points.
 * - Clicking on the pane with the primary mouse button adds a point to the
 * pane.
 * - Clicking on a point with the secondary mouse button removes the point from
 * the pane.
 *
 * Output:
 * Primary button
 * [(84.0, 208.0)]
 * 3 points minimum required to create a convex hull.
 *
 * Primary button
 * [(84.0, 208.0), (349.0, 173.0)]
 * 3 points minimum required to create a convex hull.
 *
 * Primary button
 * [(84.0, 208.0), (349.0, 173.0), (277.0, 409.0)]
 * The rightmost lowest point is (277.0, 409.0)
 *
 * S: [(277.0, 409.0), (349.0, 173.0), (84.0, 208.0)]
 *
 * H: [(277.0, 409.0), (349.0, 173.0), (84.0, 208.0)]
 *
 * Finding the convex hull...
 *
 * Done: [(277.0, 409.0), (349.0, 173.0), (84.0, 208.0)]
 *
 * Secondary button
 * Clicking on a point.
 * [(277.0, 409.0), (84.0, 208.0)]
 * 3 points minimum required to create a convex hull.
 *
 * @author martinfall
 */
public class ConvexHullAnimation extends Application {

    // Data fields and constants
    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;

    // Create an array list to hold the points created during program execution
    private static final ArrayList<ConvexHull.MyPoint> points = new ArrayList<>();

    // Create a new pane to hold clickable area and instructions
    private static Pane pane = new Pane();

    // Create a new line array to update at each point added on the pane
    private static Line[] hull = new Line[0];

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
        stage.setTitle("Convex Hull Animation"); // Set the stage title
        stage.setScene(scene); // Specify the scene to be used on this stage
        stage.show(); // Set the visibility of stage to true to display window
        stage.setResizable(false); // The stage is not resizable by the user

        pane.requestFocus(); // Focus on the pane

        // Add a listener to the pane
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // Override the handle method of the EventHandler functional interface
            @Override
            public void handle(MouseEvent t) {
                // If the primary button (RIGHT) is pressed
                if (t.getButton() == MouseButton.PRIMARY) {
                    // Console output
                    System.out.println("Primary button");

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
                        ConvexHull.MyPoint point = new ConvexHull.MyPoint(x, y);

                        // Add the point to the points array list
                        points.add(point);

                        // Add the point to the scene
                        pane.getChildren().removeAll(points);
                        pane.getChildren().addAll(points);
                    }

                    System.out.println(points); // Display to console
                } // If the secondary button (LEFT) is pressed
                else {
                    // Console output
                    System.out.println("Secondary button");

                    for (Node node : pane.getChildren()) {
                        if (node.contains(t.getX(), t.getSceneY())) {
                            System.out.println("Clicking on a point.");
                            ((ConvexHull.MyPoint) node).keep = false;
                        }
                    }

                    // Remove the points from the stage
                    pane.getChildren().removeAll(points);

                    // Sanitize the points array
                    ArrayList<ConvexHull.MyPoint> copy = new ArrayList<>(points);
                    for (ConvexHull.MyPoint point : copy) {
                        if (point.keep == false) {
                            points.remove(point);
                        }
                    }

                    // Update the points on the stage
                    pane.getChildren().addAll(points);

                    System.out.println(points); // Display to console
                }

                // Convex hull sorcery from Graham's Algorithm
                if (points.size() >= 3) {
                    ArrayList<ConvexHull.MyPoint> convexHull
                            = ConvexHull.getConvexHull(points);
                    paint(convexHull); // Paint the convex hull on the pane
                } else {
                    pane.getChildren().removeAll(hull);
                    System.out.println("3 points minimum required to create a convex hull.");
                }
            }

            /**
             * Helper method that paints the convex hull at each point addition.
             */
            private void paint(ArrayList<ConvexHull.MyPoint> convexHull) {

                // Remove the line array from the pane
                pane.getChildren().removeAll(hull);

                // The line approach
                hull = new Line[convexHull.size()];
                for (int i = 0; i < convexHull.size(); i++) {
                    // Construct a new line
                    Line line = new Line();

                    // Set the line's start coordinates
                    line.setStartX(convexHull.get(i).x);
                    line.setStartY(convexHull.get(i).y);

                    // Set the line's end coordinates
                    if (i == convexHull.size() - 1) {
                        line.setEndX(convexHull.get(0).x);
                        line.setEndY(convexHull.get(0).y);
                    } else {
                        line.setEndX(convexHull.get(i + 1).x);
                        line.setEndY(convexHull.get(i + 1).y);
                    }

                    hull[i] = line;
                }

                // Add the line array back to the pane
                pane.getChildren().addAll(hull);
                toBack();
            }
        });
    }

    /**
     * Helper method to send lines to the back, so they sit under the points in
     * the pane.
     */
    public static void toBack() {
        for (Line line : hull) {
            line.toBack();
        }
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
