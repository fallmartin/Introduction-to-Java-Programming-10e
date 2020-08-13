
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Display a cylinder) Write a program that draws a cylinder, as shown in
 * Figure 14.45c. You can use the following method to set the dashed stroke for
 * an arc:
 *
 * arc.getStrokeDashArray().addAll(6.0, 21.0);
 *
 * @author martinfall
 */
public class DisplayCylinder extends Application {

    @Override // Override the start method in the Application class
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
        Line rightSide = new Line(250, 100, 250, 300);
        rightSide.setFill(Color.BLACK);
        Line leftSide = new Line(50, 100, 50, 300);
        leftSide.setFill(Color.BLACK);

        // Add nodes to the pane using the addAll method of the pane class
        pane.getChildren().addAll(top, bottomRear, bottomFront, leftSide, rightSide);

        // Create a scene, set the stage title and scene, then display the stage
        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setTitle("Exercise_14_10");
        primaryStage.setScene(scene);
        primaryStage.show();
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
