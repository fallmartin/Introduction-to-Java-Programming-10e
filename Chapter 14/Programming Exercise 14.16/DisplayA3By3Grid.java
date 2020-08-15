
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Display a 3 * 3 grid) Write a program that displays a 3 * 3 grid, as shown
 * in Figure 14.47c. Use red color for vertical lines and blue for horizontals.
 * The lines are automatically resized when the window is resized.
 *
 * @author martinfall
 */
public class DisplayA3By3Grid extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create  a new pane
        Pane pane = new Pane();
        
        // Colors
        Color vColor = Color.RED;
        Color hColor = Color.BLUE;
        
        // Top horizontal line
        Line hLine1 = new Line(0, 100, 300, 100);
        hLine1.setStroke(hColor);
        hLine1.setStrokeWidth(2);
        hLine1.getStrokeDashArray().addAll(2d, 21d); // Dashed line
        // Property binding
        hLine1.startYProperty().bind(pane.heightProperty().divide(3));
        hLine1.endXProperty().bind(pane.widthProperty());
        hLine1.endYProperty().bind(pane.heightProperty().divide(3));
        
        // Bottom horizontal line
        Line hLine2 = new Line(0, 200, 300, 200);
        hLine2.setStroke(hColor);
        hLine2.setStrokeWidth(2);
        hLine2.getStrokeDashArray().addAll(2d, 21d); // Dashed line
        // Property binding
        hLine2.startYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        hLine2.endXProperty().bind(pane.widthProperty());
        hLine2.endYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        
        // Left vertical line
        Line vLine1 = new Line(100, 0, 100, 300);
        vLine1.setStroke(vColor);
        vLine1.setStrokeWidth(2);
        vLine1.getStrokeDashArray().addAll(2d, 21d); // Dashed line
        // Property binding
        vLine1.startXProperty().bind(pane.widthProperty().divide(3));
        vLine1.endXProperty().bind(pane.widthProperty().divide(3));
        vLine1.endYProperty().bind(pane.heightProperty());
        
        // Right vertical line
        Line vLine2 = new Line(200, 0, 200, 300);
        vLine2.setStroke(vColor);
        vLine2.setStrokeWidth(2);
        vLine2.getStrokeDashArray().addAll(2d, 21d); // Dashed line
        // Property binding
        vLine2.startXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        vLine2.endXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        vLine2.endYProperty().bind(pane.heightProperty());

        // All all nodes to the pane and set min width and height to 300 x 300
        pane.getChildren().addAll(hLine1, hLine2, vLine1, vLine2);
        // Set the min height and width of the pane
        pane.setMinWidth(300);
        pane.setMinHeight(300);
        
        // Create a new scene
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_16"); // Set the title of the stage
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Show the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
