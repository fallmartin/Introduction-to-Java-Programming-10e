
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Control a group of fans) Write a program that displays three fans in a
 * group, with control buttons to start and stop all of them, as shown in Figure
 * 16.44.
 *
 * @author martinfall
 */
public class FanClub extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create three fans
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        Fan fan3 = new Fan();

        // Greate a grid pane and add the fans to it
        GridPane fanGrid = new GridPane();
        fanGrid.setPadding(new Insets(10));
        fanGrid.addRow(0, fan1, fan2, fan3);
        fanGrid.setHgap(10);

        // Event listeners
        fan1.setOnMouseClicked(e -> {
            fan1.requestFocus();
        });
        fan2.setOnMouseClicked(e -> {
            fan2.requestFocus();
        });
        fan3.setOnMouseClicked(e -> {
            fan3.requestFocus();
        });
        
        // Create the start all and stop all buttons
        Button btStartAll = new Button("Start All");
        Button btStopAll = new Button("Stop All");
        
        // Event handlers for the start all and stop all buttons
        btStartAll.setOnAction(e -> {
            fan1.start();
            fan2.start();
            fan3.start();
        });
        
        btStopAll.setOnAction(e -> {
            fan1.stop();
            fan2.stop();
            fan3.stop();
        });

        // Add the start all and stop all buttons to an HBox
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btStartAll, btStopAll);
        
        // Create a border pane to hold the fan grid and global start/stop buttons
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setCenter(fanGrid);
        pane.setBottom(hBox);
        
        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("FanClub"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
