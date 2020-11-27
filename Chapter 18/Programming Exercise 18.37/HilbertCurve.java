
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * (Hilbert curve) The Hilbert curve, first described by German mathematician
 * David Hilbert in 1891, is a space-filling curve that visits every point in a
 * square grid with a size of 2 * 2, 4 * 4, 8 * 8, 16 * 16, or any other power
 * of 2. Write a program that displays a Hilbert curve for the specified order,
 * as shown in Figure 18.19.
 *
 * I used a geometric approach to solve this problem. I was able to recreate the
 * Hilbert curve by using a series of geometric scale, rotate, and translate
 * transformations. This approach does not cover solving the problem using
 * algebra, but it fulfills the recursion requirement.
 * https://i.pinimg.com/originals/de/88/7d/de887d5596d555fa645d27d5a719ddb8.jpg
 *
 * @author martinfall
 */
public class HilbertCurve extends Application {

    /**
     * Represents the Hilbert Curve in a pane.
     */
    public class HilbertCurvePane extends Pane {

        // Private data field for width, height, and order
        private static final double WIDTH = 400.0;
        private static final double HEIGHT = WIDTH;
        private int order = 0; // Default order is 0

        /**
         * No-args constructor.
         */
        public HilbertCurvePane() {
            setPrefWidth(WIDTH);
            setPrefHeight(HEIGHT);
        }

        /**
         * Sets a new order.
         *
         * @param order
         */
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        /**
         * Paints the Hilbert curve.
         */
        public void paint() {

            // Create a polyline for Hilbert curve at order 0
            Polyline shape = new Polyline();
            ObservableList<Double> points = shape.getPoints();
            points.addAll(
                    WIDTH / 4, HEIGHT / 4, // Top left
                    WIDTH / 4, 3 * HEIGHT / 4, // Bottom left
                    3 * WIDTH / 4, 3 * HEIGHT / 4, // Bottom right
                    3 * WIDTH / 4, HEIGHT / 4); // Top right

            // Clear the pane before display
            getChildren().clear();

            // Call the recursive method
            displayHilbertCurve(order, shape);
        }

        /**
         * Recursive method for displaying the Hilbert curve.
         *
         * @param order
         * @param shape
         */
        public void displayHilbertCurve(int order, Polyline shape) {
            if (order == 0) { // Base case or stopping condition
                getChildren().addAll(shape);
            } else { // Recursive call

                // Create a new polyline and scale it down by a factor of 0.5
                Polyline p = new Polyline();
                double factor = 1.0 / 2;

                // Affine transformation objects
                Scale scale = new Scale(factor, factor);
                Rotate rotate = new Rotate();
                Translate translate = new Translate();

                // Add the transformation objects to the shape
                shape.getTransforms().addAll(scale, rotate, translate);

                // First transformation to top left corner
                rotate.setPivotX(getWidth() / 2);
                rotate.setPivotY(getHeight() / 2);
                rotate.setAngle(-90);

                // Add the new points obtained by the transforms to a points array
                double[] points = shape.getPoints().stream()
                        .mapToDouble(Number::doubleValue).toArray();
                points = reverse(points);
                shape.getLocalToParentTransform().transform2DPoints(
                        points, 0, points, 0, points.length / 2);

                // Add the points array to the new polyline p
                addPointsToShape(points, p);

                //Second transformation to bottom left corner
                rotate.setAngle(0);
                translate.setY((Math.pow(factor, -1) - 1) * getHeight());

                // Add the new points obtained by the transforms to a points array
                points = shape.getPoints().stream()
                        .mapToDouble(Number::doubleValue).toArray();
                shape.getLocalToParentTransform().transform2DPoints(
                        points, 0, points, 0, points.length / 2);

                // Add the points array to the new polyline p
                addPointsToShape(points, p);

                // Third transformation to bottom right corner
                translate.setX((Math.pow(factor, -1) - 1) * getWidth());

                // Add the new points obtained by the transforms to a points array
                points = shape.getPoints().stream()
                        .mapToDouble(Number::doubleValue).toArray();
                shape.getLocalToParentTransform().transform2DPoints(
                        points, 0, points, 0, points.length / 2);

                // Add the points array to the new polyline p
                addPointsToShape(points, p);

                // Fourth transformation to top right corner
                rotate.setAngle(90);
                translate.setX(0);
                translate.setY(-(Math.pow(factor, -1) - 1) * getWidth());

                // Add the new points obtained by the transforms to a points array
                points = shape.getPoints().stream()
                        .mapToDouble(Number::doubleValue).toArray();
                points = reverse(points);
                shape.getLocalToParentTransform().transform2DPoints(
                        points, 0, points, 0, points.length / 2);

                // Add the points array to the new polyline p
                addPointsToShape(points, p);

                // Recursive call
                displayHilbertCurve(order - 1, p);
            }
        }

        /**
         * Add the points in the array to the polyline.
         *
         * @param points
         * @param p
         */
        public void addPointsToShape(double[] points, Polyline p) {
            for (double d : points) {
                p.getPoints().add(d);
            }
        }

        /**
         * Returns a reversed array of coordinate pairs.
         *
         * @param points
         * @return
         */
        public double[] reverse(double[] points) {
            double[] reverseArray = new double[points.length];
            int j = 0;

            for (int i = points.length - 1; i >= 0; i = i - 2) {
                reverseArray[j] = points[i - 1];
                reverseArray[j + 1] = points[i];
                j = j + 2;
            }

            return reverseArray;
        }
    }

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        HilbertCurvePane hilbertCurvePane = new HilbertCurvePane();

        // TextField control and event handler
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(5);
        tfOrder.setAlignment(Pos.CENTER);

        tfOrder.setOnAction(e -> {
            hilbertCurvePane.setOrder(Integer.parseInt(tfOrder.getText()));
        });

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        // Create a new border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hilbertCurvePane);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(hilbertCurvePane, new Insets(50));

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane);
        stage.setScene(scene); // Place the scene in the stage
        stage.setTitle("Hilbert Curve Pane"); // Set the stage title
        stage.show(); // Display the stage
        stage.setResizable(false); // Make the stage non-resizable
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
