
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * (Pick four cards) Write a program that lets the user click the Refresh button
 * to display four cards from a deck of 52 cards, as shown in Figure 15.24a.
 * (See the hint in Programming Exercise 14.3 on how to obtain four random
 * cards.)
 *
 * @author martinfall
 */
public class PickFourCards extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new card pane
        CardPane pane = new CardPane();
        pane.setPadding(new Insets(20, 20, 20, 20));

        // Create the refrech button
        Button btRefresh = new Button("Refresh");

        // Place the card pane and button in a border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(btRefresh);

        // Alignment
        BorderPane.setAlignment(pane, Pos.CENTER);
        BorderPane.setAlignment(btRefresh, Pos.TOP_CENTER);

        // Register an anonymous event handler with the button
        btRefresh.setOnAction(e -> borderPane.setCenter(new CardPane()));

        // Create a new scene and place it in the stage
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Exercise_15_1"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the primary stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
