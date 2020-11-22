
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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (H-tree fractal) An H-tree (introduced at the beginning of this chapter in
 * Figure 18.1) is a fractal defined as follows:
 *
 * 1. Begin with a letter H. The three lines of the H are of the same length, as
 * shown in Figure 18.1a.
 *
 * 2. The letter H (in its sans-serif form, H) has four endpoints. Draw an H
 * centered at each of the four endpoints to an H-tree of order 1, as shown in
 * Figure 18.1b. These Hs are half the size of the H that contains the four
 * endpoints.
 *
 * 3. Repeat Step 2 to create an H-tree of order 2, 3, . . . , and so on, as
 * shown in Figure 18.1c–d.
 *
 * Write a program that draws an H-tree, as shown in Figure 18.1.
 *
 * @author martinfall
 */
public class HTreeFractalDriver extends Application {

    /**
     * Represents an instance of an H-tree as described in the program
     * requirements.
     */
    public class HTreeFractal extends Pane {

        // Data fields for width, height, and order
        private static final double WIDTH = 500;
        private static final double HEIGHT = 500;
        private int order = 0;

        /**
         * No-args constructor.
         */
        public HTreeFractal() {
            setPrefSize(WIDTH, HEIGHT);
        }

        /**
         * Set a new order.
         *
         * @param order
         */
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        /**
         * Paints the H-tree to the pane.
         */
        public void paint() {
            int L = 150; // Local convenience var

            // Declare three lines (left, middle, and right)
            Line left = new Line(L, L, L, getHeight() - L);
            Line middle = new Line(L, getHeight() / 2, getWidth() - L, getHeight() / 2);
            Line right = new Line(getWidth() - L, L, getWidth() - L, getHeight() - L);

            getChildren().clear(); // Clear the pane before redisplay

            displayHTree(order, left, middle, right); // Call the recursive method
        }

        /**
         * Recursive method that displays the H-tree to the pane.
         *
         * @param order
         * @param left
         * @param middle
         * @param right
         */
        public void displayHTree(int order, Line left, Line middle, Line right) {
            if (order == 0) { // Base case
                getChildren().addAll(left, middle, right); // Add lines to pane
            } else {
                // Add the lines at the current order
                getChildren().addAll(left, middle, right);

                // Obtain the length of one of three congruent lines
                double distance = new Point2D(left.getStartX(), left.getStartY())
                        .distance(new Point2D(left.getEndX(), left.getEndY()));

                // Top-left endpoint
                Line[] TLE = getLines(left.getStartX(), left.getStartY(), distance);
                displayHTree(order - 1, TLE[0], TLE[1], TLE[2]);

                // Bottom-left endpoint
                Line[] BLE = getLines(left.getEndX(), left.getEndY(), distance);
                displayHTree(order - 1, BLE[0], BLE[1], BLE[2]);

                // Top-right endpoint
                Line[] TRE = getLines(right.getStartX(), right.getStartY(), distance);
                displayHTree(order - 1, TRE[0], TRE[1], TRE[2]);

                // Bottom-right endpoint
                Line[] BRE = getLines(right.getEndX(), right.getEndY(), distance);
                displayHTree(order - 1, BRE[0], BRE[1], BRE[2]);
            }
        }

        /**
         * Returns an array of left, middle and right lines from a coordinate
         * pair x and y, and the distance of the congruent lines at current
         * order.
         *
         * @param X
         * @param Y
         * @param D
         * @return
         */
        public Line[] getLines(double X, double Y, double D) {
            double d = D / 4; // Local var
            
            // Construct three congruent lines
            Line left = new Line(X - d, Y - d, X - d, Y + d);
            Line middle = new Line(X - d, Y, X + d, Y);
            Line right = new Line(X + d, Y - d, X + d, Y + d);

            // Return left, middle, and right as an array
            return new Line[]{left, middle, right};
        }
    }

    @Override // Override the start method of the Application class
    public void start(Stage primaryStage) throws Exception {
        // Construct a new HTreeFractal object
        HTreeFractal hTree = new HTreeFractal();

        // TextField control and event handler
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(5);
        tfOrder.setAlignment(Pos.CENTER);

        tfOrder.setOnAction(e -> {
            hTree.setOrder(Integer.parseInt(tfOrder.getText()));
        });

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        // Create a new border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hTree);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("H Tree Fractals"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
