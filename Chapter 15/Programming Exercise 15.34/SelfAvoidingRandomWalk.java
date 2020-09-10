
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * (Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is
 * a path from one point to another that does not visit the same point twice.
 * Self-avoiding walks have applications in physics, chemistry, and mathematics.
 * They can be used to model chain-like entities such as solvents and polymers.
 * Write a program that displays a random path that starts from the center and
 * ends at a point on the boundary, as shown in Figure 15.37a or ends at a
 * dead-end point (i.e., surrounded by four points that have already been
 * visited), as shown in Figure 15.37b. Assume the size of the lattice is 16 by
 * 16.
 *
 * Output:
 * Possible valid steps from [8, 8]:
 * [7, 8]
 * [9, 8]
 * [8, 7]
 * [8, 9]
 * Random next step: [9, 8]
 *
 * Possible valid steps from [9, 8]:
 * [10, 8]
 * [9, 7]
 * [9, 9]
 * Random next step: [9, 7]
 *
 * Possible valid steps from [9, 7]:
 * [8, 7]
 * [10, 7]
 * [9, 6]
 * Random next step: [9, 6]
 *
 * Possible valid steps from [9, 6]:
 * [8, 6]
 * [10, 6]
 * [9, 5]
 * Random next step: [9, 5]
 *
 * Possible valid steps from [9, 5]:
 * [8, 5]
 * [10, 5]
 * [9, 4]
 * Random next step: [10, 5]
 *
 * Possible valid steps from [10, 5]:
 * [11, 5]
 * [10, 4]
 * [10, 6]
 * Random next step: [10, 4]
 *
 * Possible valid steps from [10, 4]:
 * [9, 4]
 * [11, 4]
 * [10, 3]
 * Random next step: [10, 3]
 *
 * Possible valid steps from [10, 3]:
 * [9, 3]
 * [11, 3]
 * [10, 2]
 * Random next step: [9, 3]
 *
 * Possible valid steps from [9, 3]:
 * [8, 3]
 * [9, 2]
 * [9, 4]
 * Random next step: [9, 4]
 *
 * Possible valid steps from [9, 4]:
 * [8, 4]
 * Random next step: [8, 4]
 *
 * Possible valid steps from [8, 4]:
 * [7, 4]
 * [8, 3]
 * [8, 5]
 * Random next step: [8, 5]
 *
 * Possible valid steps from [8, 5]:
 * [7, 5]
 * [8, 6]
 * Random next step: [7, 5]
 *
 * Possible valid steps from [7, 5]:
 * [6, 5]
 * [7, 4]
 * [7, 6]
 * Random next step: [7, 4]
 *
 * Possible valid steps from [7, 4]:
 * [6, 4]
 * [7, 3]
 * Random next step: [6, 4]
 *
 * Possible valid steps from [6, 4]:
 * [5, 4]
 * [6, 3]
 * [6, 5]
 * Random next step: [6, 5]
 *
 * Possible valid steps from [6, 5]:
 * [5, 5]
 * [6, 6]
 * Random next step: [5, 5]
 *
 * Possible valid steps from [5, 5]:
 * [4, 5]
 * [5, 4]
 * [5, 6]
 * Random next step: [5, 4]
 *
 * Possible valid steps from [5, 4]:
 * [4, 4]
 * [5, 3]
 * Random next step: [4, 4]
 *
 * Possible valid steps from [4, 4]:
 * [3, 4]
 * [4, 3]
 * [4, 5]
 * Random next step: [4, 5]
 *
 * Possible valid steps from [4, 5]:
 * [3, 5]
 * [4, 6]
 * Random next step: [3, 5]
 *
 * Possible valid steps from [3, 5]:
 * [2, 5]
 * [3, 4]
 * [3, 6]
 * Random next step: [2, 5]
 *
 * Possible valid steps from [2, 5]:
 * [1, 5]
 * [2, 4]
 * [2, 6]
 * Random next step: [2, 6]
 *
 * Possible valid steps from [2, 6]:
 * [1, 6]
 * [3, 6]
 * [2, 7]
 * Random next step: [2, 7]
 *
 * Possible valid steps from [2, 7]:
 * [1, 7]
 * [3, 7]
 * [2, 8]
 * Random next step: [1, 7]
 *
 * Possible valid steps from [1, 7]:
 * [0, 7]
 * [1, 6]
 * [1, 8]
 * Random next step: [1, 6]
 *
 * Possible valid steps from [1, 6]:
 * [0, 6]
 * [1, 5]
 * Random next step: [0, 6]
 *
 * Possible valid steps from [0, 6]:
 * [0, 5]
 * [0, 7]
 * We've hit a boundary! Walk done!
 *
 * @author martinfall
 */
public class SelfAvoidingRandomWalk extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Create a lattice
        Lattice lattice = new Lattice();

        // Create the start button and place it in an HBox
        Button btStart = new Button("Start");

        BorderPane pane = new BorderPane();
        pane.setCenter(lattice);
        pane.setBottom(btStart);
        BorderPane.setAlignment(lattice, Pos.CENTER);
        BorderPane.setAlignment(btStart, Pos.CENTER);
        BorderPane.setMargin(btStart, new Insets(10));
        pane.setPadding(new Insets(10, 10, 0, 10));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_15_34"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage

        // Register the event handler with the start button
        btStart.setOnAction(e -> lattice.walk());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
