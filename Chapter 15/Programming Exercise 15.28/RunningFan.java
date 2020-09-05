
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Display a running fan) Write a program that displays a running fan, as shown
 * in Figure 15.33c. Use the Pause, Resume, Reverse buttons to pause, resume,
 * and reverse fan running.
 *
 * @author martinfall
 */
public class RunningFan extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the three buttons
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");

        // Create a new HBox
        HBox buttons = new HBox(10, btPause, btResume, btReverse);
        buttons.setPadding(new Insets(10));
        buttons.setAlignment(Pos.CENTER);

        // Create the fan pane
        StackPane fan = new StackPane();
        fan.setMinWidth(300);
        fan.setMinHeight(300);

        // Build the fan in the fan pane
        // Outer circle
        Circle circle = new Circle();
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        circle.setRadius(fan.getMinWidth() / 2.5);
        circle.setCenterX(fan.getMinWidth() / 2);
        circle.setCenterY(fan.getMinHeight() / 2);

        // Fan blades
        Arc blade1 = buildBlade(fan, circle);
        blade1.setStartAngle(0);

        Arc blade2 = buildBlade(fan, circle);
        blade2.setStartAngle(90);

        Arc blade3 = buildBlade(fan, circle);
        blade3.setStartAngle(180);

        Arc blade4 = buildBlade(fan, circle);
        blade4.setStartAngle(270);

        Group fanGroup = new Group(circle, blade1, blade2, blade3, blade4);

        fan.getChildren().addAll(fanGroup);

        // Create a border pane and add the fan and button controls to it
        BorderPane pane = new BorderPane();
        pane.setCenter(fan);
        pane.setBottom(buttons);

        RotateTransition rt = new RotateTransition(Duration.millis(3000), fan);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(false);
        rt.setByAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

        // Register event hanlders with each button
        btPause.setOnAction(e -> {
            if (rt.getStatus() == Animation.Status.RUNNING) {
                System.out.println("Pause");
                rt.pause();
            }
        });
        btResume.setOnAction(e -> {
            if (rt.getStatus() == Animation.Status.PAUSED) {
                System.out.println("Resume");
                rt.play();
            }
        });
        btReverse.setOnAction(e -> {
            System.out.println("Reverse");
            if (rt.getStatus() == Animation.Status.RUNNING) {
                rt.setRate(rt.getRate() > 0 ? -1 : 1);
            }
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_28"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    private Arc buildBlade(Pane fan, Circle circle) {
        Arc blade = new Arc();

        blade.setCenterX(fan.getMinWidth() / 2);
        blade.setCenterY(fan.getMinHeight() / 2);

        blade.setRadiusX(circle.getRadius() * 0.95);
        blade.setRadiusY(circle.getRadius() * 0.95);

        blade.setLength(30);
        blade.setType(ArcType.ROUND);
        blade.setFill(Color.MEDIUMPURPLE);

        return blade;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
