
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Game: bean-machine animation) Write a program that animates the bean machine
 * introduced in Programming Exercise 7.21. The animation terminates after ten
 * balls are dropped, as shown in Figure 15.36b and c.
 *
 * Sample Console Output:
 * Ball 1 path LRRLLRL
 * Ball 2 path RRLLLLR
 * Ball 3 path LLLLRLL
 * Ball 4 path LRLLLLL
 * Ball 5 path LRRLLRL
 * Ball 6 path RRRLLRL
 * Ball 7 path LLLLRRR
 * Ball 8 path RLRRLRL
 * Ball 9 path LRRRLLL
 * Ball 10 path RRLLRRR
 *
 * @author martinfall
 */
public class BeanMachineApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BeanMachineComponent bmc = new BeanMachineComponent();
        bmc.start();

        // Create a scene and place it in the stage
        Scene scene = new Scene(bmc);
        stage.setTitle("Exercise_15_33"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
