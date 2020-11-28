
import javafx.application.Application;
import javafx.geometry.Insets;
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
 *
 * @author martinfall
 */
public class RecursiveTree extends Application {

    /**
     * Represents a tree in a pane.
     */
    public static class RecursiveTreePane extends Pane {

        // Private data fields
        private static final double WIDTH = 400.0;
        private static final double HEIGHT = 400.0;

        // Constants for the starting angle, angle modifier, factor, and length
        private static final double START_ANGLE = Math.toRadians(90);
        private static final double MOD = Math.toRadians(25);
        private static final double FACTOR = 0.65;
        private static final double LENGTH = 150;

        private int order = 0; // Default order is 0

        /**
         * No-args constructor.
         */
        public RecursiveTreePane() {
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
         * Paints a recursive tree.
         */
        public void paint() {
            Line line = new Line();
            line.setStartX(WIDTH / 2);
            line.setStartY(HEIGHT); // Bottom
            line.setEndX(WIDTH / 2);
            line.setEndY(HEIGHT - LENGTH); // Top

            // Clear the pane before display
            getChildren().clear();
            // tree.clear(); // Clear the tree list

            // Add the trunk to the pane
            getChildren().add(line);

            // Call the recursive method with 
            displayRecursiveTree(line.getEndX(), line.getEndY(),
                    LENGTH * FACTOR, START_ANGLE, order);
        }

        public void displayRecursiveTree(double x, double y,
                double length, double angle, int order) {
            if (order == 0) { // Base case
                // Stop the recursive calls
            } else {
                // End point coordinates for the left line
                double leftEndX = x + length * Math.cos(angle + MOD);
                double leftEndY = y - length * Math.sin(angle + MOD);

                // End point coordinates for the right line
                double rightEndX = x + length * Math.cos(angle - MOD);
                double rightEndY = y - length * Math.sin(angle - MOD);

                // Contruct the two new lines and add them to the pane
                getChildren().add(new Line(x, y, leftEndX, leftEndY));
                getChildren().add(new Line(x, y, rightEndX, rightEndY));

                // Recursive calls for each of the newly constructed lines
                displayRecursiveTree(leftEndX, leftEndY,
                        length * FACTOR, angle + MOD, order - 1);
                displayRecursiveTree(rightEndX, rightEndY,
                        length * FACTOR, angle - MOD, order - 1);
            }
        }

    }

    @Override // Override the start method of the Application class
    public void start(Stage stage) throws Exception {
        // Create a new recursive tree pane
        RecursiveTreePane treePane = new RecursiveTreePane();

        // TextField control and event handler
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(5);
        tfOrder.setAlignment(Pos.CENTER);

        tfOrder.setOnAction(e -> {
            treePane.setOrder(Integer.parseInt(tfOrder.getText()));
        });

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        // Create a new border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(treePane);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(treePane, new Insets(50));

        // Create a new scene and place it in the stage
        Scene scene = new Scene(borderPane);
        stage.setTitle("Recursive Tree"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
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
