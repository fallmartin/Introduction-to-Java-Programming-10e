
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Display a rectanguloid) Write a program that displays a rectanguloid, as
 * shown in Figure 14.47a. The cube should grow and shrink as the window grows
 * or shrinks.
 *
 * @author martinfall
 */
public class DisplayRectanguloid extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        // Create a new pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        // Front of the rectanguloid
        Rectangle front = new Rectangle(10, 100, 200, 150);
        front.setFill(Color.TRANSPARENT);
        front.setStroke(Color.BLACK);
        front.widthProperty().bind(pane.widthProperty().subtract(60));
        front.heightProperty().bind(pane.heightProperty().subtract(120));
        
        // Rear of the rectanguloid
        Rectangle rear = new Rectangle(40, 10, 200, 150);
        rear.setFill(Color.TRANSPARENT);
        rear.setStroke(Color.BLACK);
        rear.widthProperty().bind(pane.widthProperty().subtract(60));
        rear.heightProperty().bind(pane.heightProperty().subtract(120));
        
        // Top left line
        Line line1 = new Line(40, 10, 10, 100);
        line1.setFill(Color.BLACK);
        
        
        // Top right line
        Line line2 = new Line(240, 10, 210, 100);
        line2.setFill(Color.BLACK);
        line2.startXProperty().bind(rear.widthProperty().add(40));
        line2.endXProperty().bind(front.widthProperty().add(10));
        
        // Bottom left line
        Line line3 = new Line(40, 160, 10, 250);
        line3.setFill(Color.BLACK);
        line3.startXProperty().bind(rear.xProperty());
        line3.startYProperty().bind(rear.yProperty().add(rear.heightProperty()));
        line3.endXProperty().bind(front.xProperty());
        line3.endYProperty().bind(front.yProperty().add(front.heightProperty()));
        
        // Bottom right line
        Line line4 = new Line(240, 160, 210, 250);
        line4.setFill(Color.BLACK);
        line4.startXProperty().bind(rear.xProperty().add(rear.widthProperty()));
        line4.startYProperty().bind(rear.yProperty().add(rear.heightProperty()));
        line4.endXProperty().bind(front.xProperty().add(front.widthProperty()));
        line4.endYProperty().bind(front.yProperty().add(front.heightProperty()));

        // Add all nodes to the pane
        pane.getChildren().addAll(front, rear, line1, line2, line3, line4);

        // Set the scene, add it to the stage, and display the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_14_14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
