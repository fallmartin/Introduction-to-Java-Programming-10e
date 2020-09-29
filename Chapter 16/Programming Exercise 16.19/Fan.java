
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author martinfall
 */
public class Fan extends BorderPane {

    private RotateTransition rt = new RotateTransition();
    private final static double WIDTH = 300;
    private final static double HEIGHT = 300;

    public Fan() {
        // Create the three buttons
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");

        // Create a new HBox and add the buttons to it
        HBox buttons = new HBox(10, btPause, btResume, btReverse);
        buttons.setAlignment(Pos.CENTER); // Center the buttons

        // Create the fan pane
        StackPane fan = new StackPane();
        fan.setMinWidth(WIDTH);
        fan.setMinHeight(HEIGHT);

        /**
         * Build the fan in the stack pane
         */
        // Outer circle
        Circle circle = new Circle();
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        circle.setRadius(WIDTH / 2.5);
        circle.setCenterX(WIDTH / 2);
        circle.setCenterY(HEIGHT / 2);

        /**
         * Fan blades
         */
        // Blade 1
        Arc blade1 = buildBlade(fan, circle);
        blade1.setStartAngle(0);

        // Blade 2
        Arc blade2 = buildBlade(fan, circle);
        blade2.setStartAngle(90);

        // Blade 3
        Arc blade3 = buildBlade(fan, circle);
        blade3.setStartAngle(180);

        // Blade 4
        Arc blade4 = buildBlade(fan, circle);
        blade4.setStartAngle(270);

        // Group all components of the fan and add the group to the stack pane
        Group fanGroup = new Group(circle, blade1, blade2, blade3, blade4);
        fan.getChildren().addAll(fanGroup);

        // Create a slider
        Slider slider = new Slider();
        slider.setMin(1);
        slider.setMax(5);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);

        // Add the buttons, fan, and slider controls to the parent pane
        setTop(buttons); // Move the buttons to the top
        setCenter(fan);
        setBottom(slider);
        setPadding(new Insets(10));

        /**
         * Animation rotation
         */
        rt = new RotateTransition(Duration.millis(3000), fan);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(false);
        rt.setByAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

        /**
         * Event handlers and listeners
         */
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
            // if (rt.getStatus() == Animation.Status.RUNNING) {
            rt.setRate(rt.getRate() * (-1));
            // }
        });

        // Add an invalidation listener to the slider's value property
        slider.valueProperty().addListener(il -> {
            int rotationDirection = rt.getRate() > 0 ? 1 : -1;
            rt.setRate(slider.getValue() * rotationDirection);
        });

        // Add a border around the fan
        setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));
    }

    private Arc buildBlade(StackPane fan, Circle circle) {
        Arc blade = new Arc();

        blade.setCenterX(WIDTH / 2);
        blade.setCenterY(HEIGHT / 2);

        blade.setRadiusX(circle.getRadius() * 0.95);
        blade.setRadiusY(circle.getRadius() * 0.95);

        blade.setLength(30);
        blade.setType(ArcType.ROUND);
        blade.setFill(Color.MEDIUMPURPLE);

        return blade;
    }

    /**
     * Start the animation
     */
    public void start() {
        rt.play();
    }

    /**
     * Stop the animation
     */
    public void stop() {
        rt.stop();
    }

}
