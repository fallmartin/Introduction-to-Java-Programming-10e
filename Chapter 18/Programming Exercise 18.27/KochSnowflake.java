
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Koch snowflake fractal) The text presented the Sierpinski triangle fractal.
 * In this exercise, you will write a program to display another fractal, called
 * the Koch snowflake, named after a famous Swedish mathematician. A Koch
 * snowflake is created as follows:
 *
 * 1. Begin with an equilateral triangle, which is considered to be the Koch
 * fractal of order (or level) 0, as shown in Figure 18.14a.
 *
 * 2. Divide each line in the shape into three equal line segments and draw an
 * outward equilateral triangle with the middle line segment as the base to
 * create a Koch fractal of order 1, as shown in Figure 18.14b.
 *
 * 3. Repeat Step 2 to create a Koch fractal of order 2, 3, . . . , and so on,
 * as shown in Figure 18.14c–d.
 *
 * @author martinfall
 */
public class KochSnowflake extends Application {

    // Data fields for scene properties
    private static final double WIDTH = 500;
    private static final double HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new Koch snowflake
        KochPane snowflake = new KochPane();

        // Create a new texte field
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.CENTER_RIGHT);

        // Register an event handler with text field object
        tfOrder.setOnAction(e -> {
            snowflake.setOrder(Integer.parseInt(tfOrder.getText()));
        });

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        // Border pane to hold the Koch pane and the hBox controls
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(snowflake);
        borderPane.setBottom(hBox);

        // Create a Scene and place it in the stage
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("Koch Snowflake Fractal"); // Set the stage title
        primaryStage.show(); // Display the stage

        // Resizable scene with listeners that repaint as changes happen
        scene.widthProperty().addListener(ov -> snowflake.paint());
        scene.heightProperty().addListener(ov -> snowflake.paint());
        tfOrder.requestFocus(); // Focus on the text field
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    public class KochPane extends Pane {

        // Default order is 0
        int order = 0;

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
         * Paint the Koch snowflake on the pane.
         */
        public void paint() {
            // Some equilateral triangle geometry vars
            double side = getWidth() * 2 / 3;
            double height = (Math.sqrt(3) * side / 2);
            double x1 = (getWidth() / 2) - (side / 2);
            double y1 = (getHeight() / 2) + (height / 2);

            // Determine the vertices of Koch snowflake of order 0
            Point2D p1 = new Point2D(x1, y1); // Bottom left
            Point2D p2 = new Point2D(x1 + side, y1); // Bottom right
            Point2D p3 = new Point2D(getWidth() / 2, y1 - height); // At height

            // Construct three lines forming the Koch snowflake of order 0
            Line line1 = new Line(x1, y1, x1 + side, y1);
            line1.setStroke(Color.BLACK);
            line1.setFill(Color.RED);

            Line line2 = new Line(x1 + side, y1, getWidth() / 2, y1 - height);
            line2.setStroke(Color.BLACK);
            line2.setFill(Color.RED);

            Line line3 = new Line(getWidth() / 2, y1 - height, x1, y1);
            line3.setStroke(Color.BLACK);
            line3.setFill(Color.RED);

            // Build an array of lines
            Line[] array = new Line[]{line1, line2, line3};

            // Clear the pane before each painting
            this.getChildren().clear();

            // Recursive call
            displaySnowflake(order, array);
        }

        /**
         * Recursive method for processing the Koch snowflake according to the
         * order and array of lines being processed.
         *
         * @param order
         * @param array
         */
        public void displaySnowflake(int order, Line[] array) {
            if (order == 0) {
                this.getChildren().addAll(array);
            } else {
                for (Line line : array) {
                    // Point p1 and p2 are the extremities of the line segment
                    Point2D p1 = new Point2D(line.getStartX(), line.getStartY());
                    Point2D p2 = new Point2D(line.getEndX(), line.getEndY());

                    // Points a and b divide the line in 3 equal segments
                    Point2D a = splitLine(1.0 / 3, p1, p2);
                    Point2D b = splitLine(2.0 / 3, p1, p2);

                    // Point c is the third vertex of the equilateral triangle abc
                    Point2D c = getVertex(a, b);

                    // Construct 4 lines (p1 -> a, a -> c, c -> b, b -> p2)
                    Line line1 = new Line(p1.getX(), p1.getY(), a.getX(), a.getY());
                    Line line2 = new Line(a.getX(), a.getY(), c.getX(), c.getY());
                    Line line3 = new Line(c.getX(), c.getY(), b.getX(), b.getY());
                    Line line4 = new Line(b.getX(), b.getY(), p2.getX(), p2.getY());

                    // Build an array with the lines above and pass it to 
                    // displaySnowflake with order - 1
                    Line[] lineArray = new Line[]{line1, line2, line3, line4};
                    displaySnowflake(order - 1, lineArray);
                }
            }
        }

        /**
         * Returns a point with coordinates x, y that is k of line p1p2, where k
         * is a fraction such as 1/2 or 1/3.
         *
         * @param k
         * @param p1
         * @param p2
         * @return
         */
        public Point2D splitLine(double k, Point2D p1, Point2D p2) {
            double x = p1.getX() + k * (p2.getX() - p1.getX());
            double y = p1.getY() + k * (p2.getY() - p1.getY());

            return new Point2D(x, y);
        }

        /**
         * Returns the third point with coordinates x, y that forms an
         * equilateral triangle with points a and b.
         *
         * @param a
         * @param b
         * @return
         */
        public Point2D getVertex(Point2D a, Point2D b) {
            // Calculate theta
            double startAngle = Math.atan2(a.getY() - b.getY(), a.getX() - b.getX());

            // Calculate x and y
            double x = a.getX() - a.distance(b) * Math.cos(startAngle + Math.toRadians(60));
            double y = a.getY() - a.distance(b) * Math.sin(startAngle + Math.toRadians(60));

            // Return the new point
            return new Point2D(x, y);
        }
    }
}
