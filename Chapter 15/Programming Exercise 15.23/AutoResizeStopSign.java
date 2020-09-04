
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class AutoResizeStopSign extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Local variable declarations
        double width = 300.0;
        double height = 300.0;

        // Create a new pane
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(10));

        // Use a listener to update the stop sign when pane is changed
        // https://www.dummies.com/programming/java/javafx-how-to-use-property-events/
        InvalidationListener listener = (ov) -> {
            pane.getChildren().clear(); // Clear the pane
            drawSign(pane, pane.getWidth(), pane.getHeight()); // Redraw the stop sign
        };

        // Register the change listener with the pane's width and height properties
        pane.widthProperty().addListener((ov) -> { // Using a Lambda expression
            pane.getChildren().clear(); // Clear the pane
            drawSign(pane, pane.getWidth(), pane.getHeight()); // Redraw the stop sign
        });

        pane.heightProperty().addListener(listener); // Using the listener we defined above

        // Draw the initial instance of the stop sign
        drawSign(pane, width, height);

        // Create a new Scene and place it in the stage
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Exercise_15_23"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void drawSign(StackPane pane, double w, double h) {
        // Preserve the sign's equal sides during the resizing process
        if (w < h) {
            h = w;
        } else {
            w = h;
        }

        // Create a new sign and paint it red
        Polygon sign = new Polygon();
        double angle = 22.5; // Initial angle
        for (int i = 0; i < 8; i++, angle += 45) {
            sign.getPoints().add((w / 2) + (w / 2) * Math.cos(Math.toRadians(angle)));
            sign.getPoints().add((h / 2) + (h / 2) * Math.sin(Math.toRadians(angle)));
        }
        sign.setFill(Color.RED); // Paint it red

        // Create the STOP stop for the sign
        Text stop = new Text("STOP");
        stop.setFont(Font.font("Arial", FontWeight.BOLD, w / 4));
        stop.setFill(Color.WHITE);

        // Add the sign and stop lettering to the pane
        pane.getChildren().addAll(sign, stop);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
