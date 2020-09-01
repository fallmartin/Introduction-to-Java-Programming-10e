
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Move a circle using keys) Write a program that moves a circle up, down,
 * left, or right using the arrow keys.
 *
 * @author martinfall
 */
public class MoveCircleUsingKeys extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Variable declaration
        final double W = 400;
        final double H = 400;
        double radius = 20;
        double x = W / 2;
        double y = H / 2;
        Circle circle = new Circle(x, y, radius);
        double step = 10;

        // Create a new stack pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));

        // UI tweaks for the circle object
        circle.setRadius(radius);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        circle.setFill(Color.YELLOW);

        // Register an event handler object with event source object circle
        circle.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    System.out.println("UP");
                    circle.setCenterY(
                            circle.getCenterY() - step > radius
                            ? circle.getCenterY() - step
                            : circle.getCenterY()
                    );
                    break;
                case DOWN:
                    System.out.println("DOWN");
                    circle.setCenterY(
                            circle.getCenterY() + step < H - radius
                            ? circle.getCenterY() + step
                            : circle.getCenterY()
                    );
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    circle.setCenterX(
                            circle.getCenterX() - step > radius
                            ? circle.getCenterX() - step
                            : circle.getCenterX()
                    );
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    circle.setCenterX(
                            circle.getCenterX() + step < W - radius
                            ? circle.getCenterX() + step
                            : circle.getCenterX()
                    );
                    break;
                default:
                    System.out.println("NOT A VALID KEY");
                    break;
            }
        });

        // Add the circle to the stack pane
        pane.getChildren().add(circle);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, W, H);
        primaryStage.setTitle("Exercise_15_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false); // Make the stage not resizable
        primaryStage.show(); // Display the primary stage

        circle.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
