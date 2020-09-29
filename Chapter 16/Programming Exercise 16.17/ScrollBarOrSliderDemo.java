
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * (Use ScrollBar and Slider) Write a program that uses scroll bars or sliders
 * to select the color for a text, as shown in Figure 16.43b. Four horizontal
 * scroll bars are used for selecting the colors: red, green, blue, and opacity
 * percentages.
 *
 * @author martinfall
 */
public class ScrollBarOrSliderDemo extends Application {

    // Stack pane and label
    StackPane paneForColor = new StackPane();
    Rectangle background = new Rectangle(300, 100, Color.BLACK);
    Label lblColor = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a new color picker pane
        ColorPicker colorPicker = new ColorPicker();

        // Customize the label for the color being displayed
        lblColor.setText(String.format("(%.2f, %.2f, %.2f, %.2f)",
                colorPicker.getMyColor().getBlue(),
                colorPicker.getMyColor().getGreen(),
                colorPicker.getMyColor().getBlue(),
                colorPicker.getMyColor().getOpacity()));

        lblColor.setBackground(new Background(
                new BackgroundFill(
                        Color.WHITE,
                        CornerRadii.EMPTY,
                        new Insets(10))
        ));
        lblColor.setFont(Font.font("Arial", 20));
        lblColor.setPadding(new Insets(10));

        // Add the label to the stack pane
        paneForColor.getChildren().addAll(background, lblColor);

        // Create a border pane for the color and color picker panes
        BorderPane pane = new BorderPane();
        pane.setTop(paneForColor);
        pane.setCenter(colorPicker);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("LabelPropertiesDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable
    }

    private class ColorPicker extends GridPane {

        // Create the labels
        private final Label lblRed = new Label("Red");
        private final Label lblGreen = new Label("Green");
        private final Label lblBlue = new Label("Blue");
        private final Label lblOpacity = new Label("Opacity");

        // Create the sliders
        private CustomSlider sbRed = new CustomSlider(0.0);
        private CustomSlider sbGreen = new CustomSlider(0.0);
        private CustomSlider sbBlue = new CustomSlider(0.0);
        private CustomSlider sbOpacity = new CustomSlider(1.0);

        // Custom color data field
        private Color myColor = Color.BLACK;

        public ColorPicker() {

            // UI tweaks
            setPadding(new Insets(10));
            setHgap(10);
            setVgap(10);
            setAlignment(Pos.CENTER);

            // Create a new grid pane
            addColumn(0, lblRed, lblGreen, lblBlue, lblOpacity);
            addColumn(1, sbRed, sbGreen, sbBlue, sbOpacity);

            // Invalidation listener
            InvalidationListener listener = il -> {
                myColor = Color.color(
                        sbRed.getValue(),
                        sbGreen.getValue(),
                        sbBlue.getValue(),
                        sbOpacity.getValue());

                lblColor.setText(
                        String.format("(%.2f, %.2f, %.2f, %.2f)",
                                myColor.getRed(),
                                myColor.getGreen(),
                                myColor.getBlue(),
                                myColor.getOpacity()));

                background.setFill(myColor);
            };

            sbRed.valueProperty().addListener(listener);
            sbGreen.valueProperty().addListener(listener);
            sbBlue.valueProperty().addListener(listener);
            sbOpacity.valueProperty().addListener(listener);
        }

        public Color getMyColor() {
            return myColor;
        }
    }

    private class CustomSlider extends Slider {

        public CustomSlider(double value) {
            setValue(value);
            setMin(0);
            setMax(1);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
