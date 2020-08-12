
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Create four fans) Write a program that places four fans in a GridPane with
 * two rows and two columns, as shown in Figure 14.45b.
 *
 * @author martinfall
 */
public class FourFans extends Application {

    @Override // Override the start method in the Application 
    public void start(Stage primaryStage) throws Exception {
        // Create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        // gridPane.setGridLinesVisible(true);

        // Create four fan GUI components and add them to the grid pane
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                Pane fanPane = getFan();
                gridPane.add(fanPane, column, row);
            }
        }

        // Create a scene and add the grid pane to it
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Exercise_14_09"); // Set the title
        primaryStage.setScene(scene); // Set the scene in the stage
        primaryStage.setResizable(false); // Set resizable to false on stage
        primaryStage.show(); // Show the stage
    }

    /**
     * Build a single fan GUI component.
     *
     * @return
     */
    public Pane getFan() {
        // Declare the radius
        final int RADIUS = 50;

        // Create a stack pane
        StackPane stackPane = new StackPane();

        // Create the outer circle and add it to the stack pane
        Circle circle = new Circle(RADIUS, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.YELLOW);
        stackPane.getChildren().add(circle);

        // Start angle for the series of 4 arcs separated by 90 degrees
        int startAngle = 30;

        Pane pane = new Pane();

        for (int i = 0; i < 4; i++) {
            Arc arc = new Arc(RADIUS, RADIUS, RADIUS * 0.9, RADIUS * 0.9, startAngle, 35);
            arc.setFill(Color.BLACK);
            arc.setType(ArcType.ROUND);

            // Add the current arc to the pane
            pane.getChildren().add(arc);

            // Update the start angle 
            startAngle += 90;
        }

        // Add the pane to the stack pane
        stackPane.getChildren().add(pane);

        // Return the pane to the calling method
        return stackPane;
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
