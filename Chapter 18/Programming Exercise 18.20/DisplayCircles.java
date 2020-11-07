
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Display circles) Write a Java program that displays ovals, as shown in
 * Figure 18.12b. The circles are centered in the pane. The gap between two
 * adjacent circles is 10 pixels, and the gap between the border of the pane and
 * the largest circle is also 10.
 *
 * @author martinfall
 */
public class DisplayCircles extends Application {

    public class CirclesPane extends StackPane {

        // Data fields
        private static final double SIDE = 200;

        /**
         * No-args constructor.
         */
        public CirclesPane() {
            setWidth(SIDE);
            setHeight(SIDE);

            paint();
        }

        private void paint() {
            // Clear the pane before redisplaying
            this.getChildren().clear();

            // Repaint the stack pane
            paint(new Circle(0));
        }

        private void paint(Circle circle) {
            // Set stroke and fill properties of circle
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.TRANSPARENT);

            // Clear the pane before redisplaying
            this.getChildren().add(circle);

            if (circle.getRadius() + 10 < (getWidth() - 10) / 2
                    && circle.getRadius() + 10 < (getHeight() - 10) / 2) {
                paint(new Circle(circle.getRadius() + 10.0));
            }
        }
    }

    @Override // Override the start method in the Application class.
    public void start(Stage primaryStage) throws Exception {
        CirclesPane pane = new CirclesPane();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Display Circles"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Use invalidation listeners to repaint the scene as it changes.
        scene.widthProperty().addListener(ov -> {
            pane.paint();
        });

        scene.heightProperty().addListener(ov -> {
            pane.paint();
        });
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
