
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as
 * shown in Figure 14.43b. A cell may be X, O, or empty. What to display at each
 * cell is randomly decided. The X and O are images in the files x.gif and
 * o.gif.
 *
 * @author martinfall
 */
public class TicTacToeBoard extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5)); // pane padding
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        // Uncomment the line below to see grid lines and padding in action
        // pane.setGridLinesVisible(true);

        // Nested for loops iterate through 3-by-3 grid and randomly add image or null
        for (int column = 0; column < 3; column++) {
            ImageView imageView = null;

            for (int row = 0; row < 3; row++) {
                // Generate a random integer between 0 and 3 (exclusive)
                int random = new Random().nextInt(3);

                // Switch the random integer
                switch (random) {
                    case 0: // X
                        imageView = new ImageView("image/x.gif");
                        break;
                    case 1: // O
                        imageView = new ImageView("image/o.gif");
                        break;
                    default: // Blank
                        continue;
                }
                // Add the randomly generated image view to the grid pane
                pane.add(imageView, column, row);
            }
        }

        // Create a scene, place it in the stage, and display the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
