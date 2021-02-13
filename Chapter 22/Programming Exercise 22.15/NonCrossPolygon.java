package noncrosspolygon;

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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class NonCrossPolygon extends Application {

    // Data fields and constants
    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;

    // Create an array list to hold the points created during program execution
    private static final ArrayList<MyPoint> points = new ArrayList<>();

    // Create a new pane to hold clickable area and instructions
    private static Pane pane = new Pane();

    // Create a new line array to update at each point added on the pane
    private static Line[] polygon = new Line[0];

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
        stage.setTitle("Geometry: Non-Cross Polygon"); // Set the stage title
        stage.setScene(scene); // Specify the scene to be used on this stage
        stage.show(); // Set the visibility of stage to true to display window
        stage.setResizable(false); // The stage is not resizable by the user

        pane.requestFocus(); // Focus on the pane

        // Add a listener to the pane
        pane.setOnMouseClicked(t -> {
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
                    MyPoint point = new MyPoint(x, y);

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

                // Mark clicked point for deletion
                for (Node node : pane.getChildren()) {
                    if (node.contains(t.getX(), t.getSceneY())) {
                        System.out.println("Clicking on a point.");
                        ((MyPoint) node).keep = false;
                    }
                }

                // Remove the points from the stage
                pane.getChildren().removeAll(points);

                // Sanitize the points array
                ArrayList<MyPoint> copy = new ArrayList<>(points);
                for (MyPoint point : copy) {
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
                ArrayList<MyPoint> nonCrossPolygon = getNonCrossPolygon(points);
                paint(nonCrossPolygon); // Paint the convex hull on the pane
            } else {
                pane.getChildren().removeAll(polygon);
                System.out.println("3 points minimum required to draw a polygon");
            }
        });
    }

    /**
     * Helper method that paints the convex hull at each point addition.
     */
    private void paint(ArrayList<MyPoint> nonCrossPolygon) {

        // Remove the line array from the pane
        pane.getChildren().removeAll(polygon);

        // The line approach
        polygon = new Line[nonCrossPolygon.size()];
        for (int i = 0; i < nonCrossPolygon.size(); i++) {
            // Construct a new line
            Line line = new Line();

            // Set the line's start coordinates
            line.setStartX(nonCrossPolygon.get(i).x);
            line.setStartY(nonCrossPolygon.get(i).y);

            // Set the line's end coordinates
            if (i == nonCrossPolygon.size() - 1) {
                line.setEndX(nonCrossPolygon.get(0).x);
                line.setEndY(nonCrossPolygon.get(0).y);
            } else {
                line.setEndX(nonCrossPolygon.get(i + 1).x);
                line.setEndY(nonCrossPolygon.get(i + 1).y);
            }

            polygon[i] = line;
        }

        // Add the line array back to the pane
        pane.getChildren().addAll(polygon);
        toBack();
    }

    /**
     * Helper method to send lines to the back, so they sit under the points in
     * the pane.
     */
    public static void toBack() {
        for (Line line : polygon) {
            line.toBack();
        }
    }

    /**
     * Return the points that form a non-cross polygon.
     *
     * @param S
     * @return
     */
    public static ArrayList<MyPoint> getNonCrossPolygon(ArrayList<MyPoint> S) {
        /**
         * Step 1: Given a set of points S, select the rightmost lowest point p0
         * in the set S and name it p0.
         */
        // Select the rightmost lowest point and name it p0
        MyPoint p0 = getRightMostLowestPoint(S);

        // Remove p0 from S
        S.remove(p0);

        // Display p0 to the console
        System.out.println("The rightmost lowest point is " + p0);

        // Set the rightMostLowestPoint value in each remaining point
        for (MyPoint p : S) {
            p.setRightMostLowestPoint(p0);
        }

        /**
         * Step 2: Sort the points in S angularly along the x-axis
         * with p0 as the center. If there is a tie and two points have the same
         * angle, the one that is closer to p0 is considered greater. The points
         * in S are now sorted as p0, p1, p2, ..., pn-1.
         */
        // Sort the array list S
        Collections.sort(S);

        // Insert p0 at the start of the list S as required
        S.add(0, p0);

        /**
         * Step 3: The sorted points form a non-cross polygon.
         */
        // Print the sorted array list to the console
        System.out.println("\nS: " + S);

        return S;
    }

    /**
     * Returns the rightmost lowest element in the array list of MyPoint
     * objects.
     *
     * @param S
     * @return
     */
    private static MyPoint getRightMostLowestPoint(ArrayList<MyPoint> S) {
        // Sort S list according to the order induced by the comparator
        S.sort(new Comparator<MyPoint>() {
            @Override
            public int compare(MyPoint o1, MyPoint o2) {
                if (o1.y > o2.y) {
                    return -1;
                } else if (o1.y < o2.y) {
                    return 1;
                } else {
                    if (o1.x > o2.x) {
                        return -1;
                    } else if (o1.x < o2.x) {
                        return 1;
                    }
                }
                return 0;
            }
        });

        // Return the first element in the sorted list
        return S.get(0);
    }

    /**
     * MyPoint is a static inner class representing a point in the pane.
     */
    protected static class MyPoint
            extends Circle // Extends the Circle class of JavaFX
            implements Comparable<MyPoint> { // Implements comparable<MyPoint>

        double x, y;
        boolean keep; // keep if true, discard if false

        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
            keep = true;

            // Circle constructor
            setCenterX(x);
            setCenterY(y);
            setRadius(5);
        }

        public void setRightMostLowestPoint(MyPoint p) {
            rightMostLowestPoint = p;
        }

        /**
         * Returns the measure of the angle formed by the x-axis and the point
         * in degrees.
         *
         * @return
         */
        public double getTheta() {
            double dy = rightMostLowestPoint.y - y; // delta y
            double dx = x - rightMostLowestPoint.x; // delta x
            double theta = Math.atan2(dy, dx);
            theta *= 180 / Math.PI;
            return theta;
        }

        public double getDistance() {
            double x2 = rightMostLowestPoint.x;
            double y2 = rightMostLowestPoint.y;
            return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        }

        @Override // Override the compareTo method of the Comparable interface
        public int compareTo(MyPoint o) {
            // If the current theta is less than the theta at point o
            if (getTheta() < o.getTheta()) {
                return -1;
            } // If the current theta is greater than the theta at point o
            else if (getTheta() > o.getTheta()) {
                return 1;
            } else { // If two points have the same theta
                // the one that is closer to p0 is considered greater
                return getDistance() > o.getDistance() ? 1 : -1;
            }
        }

        @Override // Override the toString method of the Object class
        public String toString() {
            return String.format("(%.1f, %.1f)", x, y);
        }
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Launch the standalone application
        Application.launch(args);
    }
}
