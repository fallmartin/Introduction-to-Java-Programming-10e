
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Auto resize cylinder) Rewrite Programming Exercise 14.10 so that the
 * cylinder’s width and height are automatically resized when the window is
 * resized.
 *
 * @author martinfall
 */
public class AutoResizeCylinder extends Application {

    private double WIDTH = 300;
    private double HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();

        // Create the top ellipse
        Ellipse top = new Ellipse(150, 100, 100, 50);
        top.setFill(Color.TRANSPARENT);
        top.setStroke(Color.BLACK);

        // Create the rear and front arcs of the bottom ellipse
        Arc bottomRear = new Arc(150, 300, 100, 50, 0, 180);
        bottomRear.getStrokeDashArray().addAll(6.0, 21.0);
        bottomRear.setFill(Color.TRANSPARENT);
        bottomRear.setStroke(Color.BLACK);

        Arc bottomFront = new Arc(150, 300, 100, 50, 180, 180);
        bottomFront.setFill(Color.TRANSPARENT);
        bottomFront.setStroke(Color.BLACK);

        // Create the sides of the ellipse
        Line leftSide = new Line(50, 100, 50, 300);
        leftSide.setFill(Color.BLACK);
        Line rightSide = new Line(250, 100, 250, 300);
        rightSide.setFill(Color.BLACK);

        // Bind the left and rigth side to the pane height
        rightSide.endYProperty().bind(pane.heightProperty().subtract(100));
        leftSide.endYProperty().bind(pane.heightProperty().subtract(100));

        // Bind the bottom front and bottom rear ellise center x, y to pane height
        bottomFront.centerYProperty().bind(pane.heightProperty().subtract(100));
        bottomRear.centerYProperty().bind(pane.heightProperty().subtract(100));

        // Add nodes to the pane using the addAll method of the pane class
        pane.getChildren().addAll(top, bottomRear, bottomFront, leftSide, rightSide);

        // Create a scene, set the stage title and scene, then display the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_22"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
