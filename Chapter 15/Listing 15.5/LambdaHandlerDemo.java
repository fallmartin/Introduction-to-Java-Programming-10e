
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class LambdaHandlerDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button btNew = new Button("New");
        Button btOpen = new Button("Open");
        Button btSave = new Button("Save");
        Button btPrint = new Button("Print");

        hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);

        // Create and register the handler
        btNew.setOnAction((ActionEvent e) -> {
            System.out.println("Process New");
        });

        btOpen.setOnAction((ActionEvent e) -> {
            System.out.println("Process Open");
        });

        btSave.setOnAction((ActionEvent e) -> {
            System.out.println("Process Save");
        });

        btPrint.setOnAction((ActionEvent e) -> {
            System.out.println("Process Print");
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(hBox, 300, 50);
        primaryStage.setTitle("LambdaHandlerDemo"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
