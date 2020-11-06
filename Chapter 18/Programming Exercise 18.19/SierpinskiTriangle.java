
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * (Sierpinski triangle) Revise Listing 18.9 to develop a program that lets the
 * user use the + and – buttons to increase or decrease the current order by 1,
 * as shown in Figure 18.12a. The initial order is 0. If the current order is 0,
 * the Decrease button is ignored.
 *
 * @author martinfall
 */
public class SierpinskiTriangle extends Application {

    @Override // Override the start method in the Application class.
    public void start(Stage primaryStage) {
        // Recursive triangle pane
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();

        // Create + and - buttons
        Button btMinus = new Button("-");
        Button btPlus = new Button("+");

        // Pane to hold the buttons
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btMinus, btPlus);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(trianglePane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Use invalidation listeners to repaint the scene as it changes.
        scene.widthProperty().addListener(ov -> {
            trianglePane.paint();
        });

        scene.heightProperty().addListener(ov -> {
            trianglePane.paint();
        });

        // Event handler registrations for the - and + buttons
        btMinus.setOnAction(e -> {
            trianglePane.setOrder(trianglePane.getOrder() - 1 >= 0
                    ? trianglePane.getOrder() - 1
                    : trianglePane.getOrder());
        });

        btPlus.setOnAction(e -> {
            trianglePane.setOrder(trianglePane.getOrder() + 1);
        });
    }

    public static class SierpinskiTrianglePane extends Pane {

        // Data field order (default at 0)
        private int order = 0;

        /**
         * No-args constructor.
         */
        public SierpinskiTrianglePane() {
        }

        /**
         * Set a new order.
         *
         * @param order
         */
        public void setOrder(int order) {
            this.order = order;
            paint(); // Repaint the Sierpinski triangle pane after order change
        }

        /**
         * Returns the value of order.
         *
         * @return
         */
        public int getOrder() {
            return order;
        }

        protected void paint() {
            // Select three points in proportion to the pane size
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            // Clear the pane before redisplaying
            this.getChildren().clear();

            displayTriangles(order, p1, p2, p3);
        }

        private void displayTriangles(
                int order, Point2D p1, Point2D p2, Point2D p3) {
            if (order == 0) {
                // Draw a triangle to connect three points
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(
                        p1.getX(), p1.getY(),
                        p2.getX(), p2.getY(),
                        p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);

                this.getChildren().add(triangle);
            } else {
                // Get the midpoint on each edge in the triangle
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                // Recursively display three triangles
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);
            }
        }
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
