
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Draw lines using the arrow keys) Write a program that draws line segments
 * using the arrow keys. The line starts from the center of the pane and draws
 * toward east, north, west, or south when the right-arrow key, up-arrow key,
 * left-arrow key, or down-arrow key is pressed, as shown in Figure 15.26b.
 *
 * @author martinfall
 */
public class DrawLinesUsingTheArrowKeys extends Application {

    Pane pane = new Pane();
    private double x = 0;
    private double y = 0;
    private double step = 5;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new pane
        // Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        pane.setMinWidth(400);
        pane.setMinHeight(400);
        x = pane.getMinWidth() / 2;
        y = pane.getMinHeight() / 2;
        System.out.println(x);
        System.out.println(y);

        pane.setOnKeyPressed(e -> draw(e.getCode()));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_9"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false);

        pane.requestFocus();
    }

    private void draw(KeyCode keyCode) {
        {
            if (keyCode != null) {
                switch (keyCode) {
                    case UP: // When the UP arrow is pressed
                        System.out.println("UP");
                        if (y - step >= step * 2) {
                            pane.getChildren().add(new Line(x, y, x, y - step));
                            y -= step;
                        }
                        break;
                    case DOWN: // When the DOWN arrow is pressed
                        System.out.println("DOWN");
                        if (y + step <= pane.getMinHeight() - step * 2) {
                            pane.getChildren().add(new Line(x, y, x, y + step));
                            y += step;
                        }
                        break;
                    case LEFT: // When the LEFT arrow is pressed
                        System.out.println("LEFT");
                        if (x - step >= step * 2) {
                            pane.getChildren().add(new Line(x, y, x - step, y));
                            x -= step;
                        }
                        break;
                    case RIGHT: // When the RIGHT arrow is pressed
                        System.out.println("RIGHT");
                        if (x + step <= pane.getMinWidth() - step * 2) {
                            pane.getChildren().add(new Line(x, y, x + step, y));
                            x += step;
                        }
                        break;
                    default:
                        System.out.println("DO NOTHING");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
