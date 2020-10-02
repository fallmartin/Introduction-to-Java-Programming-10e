
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Racing cars) Write a program that simulates four cars racing, as shown in
 * Figure 16.47b. You can set the speed for each car, with maximum 100.
 *
 * @author martinfall
 */
public class RacingCars extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 200;
    private static final int PREF_COLUMN_COUNT = 3;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        // Create four racing lanes
        RacingLane lane1 = new RacingLane();
        RacingLane lane2 = new RacingLane();
        RacingLane lane3 = new RacingLane();
        RacingLane lane4 = new RacingLane();

        // Create the four labels 
        Label lblCar1 = new Label("Car 1");
        Label lblCar2 = new Label("Car 2");
        Label lblCar3 = new Label("Car 3");
        Label lblCar4 = new Label("Car 4");

        // Create the four text fields to set the speed of each car
        TextField tfSpeed1
                = new TextField(Double.toString(lane1.car.timeline.getRate()));
        TextField tfSpeed2
                = new TextField(Double.toString(lane2.car.timeline.getRate()));
        TextField tfSpeed3
                = new TextField(Double.toString(lane3.car.timeline.getRate()));
        TextField tfSpeed4
                = new TextField(Double.toString(lane4.car.timeline.getRate()));

        // Customize the text fields
        tfSpeed1.setPrefColumnCount(PREF_COLUMN_COUNT);
        tfSpeed2.setPrefColumnCount(PREF_COLUMN_COUNT);
        tfSpeed3.setPrefColumnCount(PREF_COLUMN_COUNT);
        tfSpeed4.setPrefColumnCount(PREF_COLUMN_COUNT);

        // Create an HBox to display the labels and text fields
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(
                lblCar1, tfSpeed1,
                lblCar2, tfSpeed2,
                lblCar3, tfSpeed3,
                lblCar4, tfSpeed4);

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(5));
        pane.setVgap(5);

        // Add the controls, lanes, and cars to the pane
        pane.addColumn(0, hBox, lane1, lane2, lane3, lane4);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("RacingCars"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

        // Event handlers for all text fields
        tfSpeed1.setOnAction(e -> { // Car 1
            if (isValidSpeed(tfSpeed1.getText())) {
                lane1.car.timeline.setRate(Double.parseDouble(tfSpeed1.getText()));
            } else {
                System.out.println("Maximum speed: 100");
            }
        });

        tfSpeed2.setOnAction(e -> { // Car 2
            if (isValidSpeed(tfSpeed2.getText())) {
                lane2.car.timeline.setRate(Double.parseDouble(tfSpeed2.getText()));
            } else {
                System.out.println("Maximum speed: 100");
            }
        });

        tfSpeed3.setOnAction(e -> { // Car 3
            if (isValidSpeed(tfSpeed3.getText())) {
                lane3.car.timeline.setRate(Double.parseDouble(tfSpeed3.getText()));
            } else {
                System.out.println("Maximum speed: 100");
            }
        });

        tfSpeed4.setOnAction(e -> { // Car 4
            if (isValidSpeed(tfSpeed4.getText())) {
                lane4.car.timeline.setRate(Double.parseDouble(tfSpeed4.getText()));
            } else {
                System.out.println("Maximum speed: 100");
            }
        });

        pane.requestFocus();
    }

    private boolean isValidSpeed(String speed) {
        return Double.parseDouble(speed) <= 100.0;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    class RacingLane extends Pane {

        private static final double WIDTH = 500;
        private static final double HEIGHT = 50;
        private Rectangle lane = new Rectangle(WIDTH, HEIGHT);
        private Car car = new Car(0, HEIGHT);

        public RacingLane() {
            lane.setFill(Color.TRANSPARENT);
            lane.setStroke(Color.BLACK);

            getChildren().addAll(lane, car);
        }

        public Car getCar() {
            return car;
        }
    };

    class Car extends Pane {

        private Timeline timeline;

        public Car(double x, double y) {

            // Validate x and y
            if (x > WIDTH - 50) {
                x = WIDTH - 50;
            }

            if (y < 30) {
                y = 30;
            }

            // Top
            Polygon top = new Polygon(
                    x + 10, y - 20,
                    x + 20, y - 30,
                    x + 30, y - 30,
                    x + 40, y - 20
            );
            top.setFill(Color.GRAY);
            top.setOpacity(0.5);
            top.setStroke(Color.BLACK);

            // Body
            Rectangle body = new Rectangle(x, y - 20, 50, 10);
            body.setFill(Color.color(Math.random(), Math.random(), Math.random(), 1.0));

            // Left wheel
            Circle leftWheel = new Circle(x + 15, y - 5, 5);
            leftWheel.setFill(Color.BLACK);

            // Right wheel
            Circle rightWheel = new Circle(x + 35, y - 5, 5);
            rightWheel.setFill(Color.BLACK);

            // Create a new group of nodes
            Group car = new Group(top, body, leftWheel, rightWheel);

            // Add the group to the pane
            getChildren().addAll(car);

            // Create a timeline animation
            timeline = new Timeline(
                    new KeyFrame(Duration.millis(5), e -> {
                        if (car.getLayoutX() < WIDTH - car.getLayoutBounds().getWidth()) {
                            // Increment layout x by 1 until it reaches the finish line
                            car.setLayoutX(car.getLayoutX() + 1);
                        } else {
                            // Reset the car's position to the start line
                            car.setLayoutX(0);
                        }
                    }));

            // Animatino cycle count, rate, and play
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setRate(1);
            timeline.play();
        }
    }
}
