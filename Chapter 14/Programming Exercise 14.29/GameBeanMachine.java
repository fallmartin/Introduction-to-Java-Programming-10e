
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * (Game: bean machine) Write a program that displays a bean machine introduced
 * in Programming Exercise 7.21, as shown in Figure 14.52c.
 *
 * @author martinfall
 */
public class GameBeanMachine extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Variable declarations
        double w = 300;
        double h = 400;
        double radius = 5;
        double spacing = 20;
        Color bean = Color.RED;

        // Create a new Pane
        Pane pane = new Pane();
        pane.setMinWidth(w);
        pane.setMinHeight(h);
        pane.setPadding(new Insets(10));

        // Create a loop to print the beans on the screen in a triangle shape
        // Starting y-coordinate
        double Y = 150.0;

        // 7 rows of 1, 2, 3, 4, 5, 6, and 7 beans
        for (int i = 0; i < 7; i++) {
            // Starting x-coordinate
            double X = w / 2.0 - (2 * radius) * i;

            // Inner loop prints i + 1 circles per row
            for (int j = 0; j < i + 1; j++) {
                Circle circle = new Circle(radius); // Create a new circle
                circle.setCenterX(X); // Set center X
                circle.setCenterY(Y); // Set center Y
                circle.setFill(bean); // Fill circle with bean color
                pane.getChildren().add(circle); // Add circle to pane

                // Update X with spacing so circles don't touch in the same row
                X += spacing;
            }
            Y += spacing; // Update Y to the next row
        }

        for (int i = 0; i < 7; i++) {
            double startX = 90 + (4 * radius) * i;
            double startY = 275;
            double endX = 90 + (4 * radius) * i;
            double endY = 315;
            Line line = new Line(startX, startY, endX, endY);

            pane.getChildren().add(line);
        }

        // Paint the remaining of the bean machine line by line
        Line bottom = new Line(70, 315, 230, 315);
        Line leftSide = new Line(70, 265, 70, 315);
        Line rightSide = new Line(230, 265, 230, 315);
        Line leftSlant = new Line(130, 140, 70, 265);
        Line rightSlant = new Line(170, 140, 230, 265);
        Line leftFeed = new Line(130, 100, 130, 140);
        Line rightFeed = new Line(170, 100, 170, 140);

        pane.getChildren().addAll(bottom, rightSide, leftSide,
                leftSlant, rightSlant, leftFeed, rightFeed);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_29"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
