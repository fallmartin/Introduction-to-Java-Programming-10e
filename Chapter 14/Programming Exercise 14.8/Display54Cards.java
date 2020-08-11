
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Display 54 cards) Expand Exercise 14.3 to display all 54 cards (including
 * two jokers), nine per row. The image files are jokers and are named 53.jpg
 * and 54.jpg.
 *
 * @author martinfall
 */
public class Display54Cards extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // Card counter variable
        int card = 1;

        // Loop through a 9 x 6 matrix and add image view to pane
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 9; column++) {
                ImageView imageView = new ImageView("cards/" + card + ".png");
                pane.add(imageView, column, row);
                card++;
            }
        }

        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_8");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
