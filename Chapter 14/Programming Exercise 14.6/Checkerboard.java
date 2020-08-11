
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * (Game: display a checkerboard) Write a program that displays a checkerboard
 * in which each white and black cell is a Rectangle with a fill color black or
 * white, as shown in Figure 14.44c.
 *
 * @author martinfall
 */
public class Checkerboard extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        final int BOARD_SIZE = 8;

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true);

        for (int row = 0; row < BOARD_SIZE; row++) {
            
        int cell = row; // Cell counter to alternate black and white cell colors
            for (int column = 0; column < BOARD_SIZE; column++) {
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(30);
                rectangle.setHeight(30);
                rectangle.setFill(cell % 2 == 0 ? Color.WHITE : Color.BLACK);
                pane.add(rectangle, column, row);
                cell++;
            }
        }

        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_06");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
