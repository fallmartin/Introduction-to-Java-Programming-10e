
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Display images) Write a program that displays four images in a grid pane, as
 * shown in Figure 14.43a.
 *
 * @author martinfall
 */
public class DisplayImages extends Application {
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a grid pane
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);

        // Create four images and their corresponding views
        Image uk = new Image("image/uk.gif");
        Image canada = new Image("image/canada.gif");
        Image china = new Image("image/china.gif");
        Image us = new Image("image/us.gif");

        // UK
        ImageView ivUK = new ImageView(uk);
        ivUK.setFitWidth(141);
        ivUK.setFitHeight(84);

        // Canada
        ImageView ivCA = new ImageView(canada);
        ivCA.setFitWidth(141);
        ivCA.setFitHeight(84);

        // China
        ImageView ivCH = new ImageView(china);
        ivCH.setFitWidth(141);
        ivCH.setFitHeight(84);

        // US
        ImageView ivUS = new ImageView(us);
        ivUS.setFitWidth(141);
        ivUS.setFitHeight(84);

        // Place all four image views in the grid pane, and add to scene
        pane.add(ivUK, 0, 0);
        pane.add(ivCA, 1, 0);
        pane.add(ivCH, 0, 1);
        pane.add(ivUS, 1, 1);
        Scene scene = new Scene(pane);

        // Add the pane to the scene, set the stage title and scene, and show the stage
        primaryStage.setTitle("Exercise 14.1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
