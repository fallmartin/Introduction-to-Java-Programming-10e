package selectionsort;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents a single bar in the histogram.
 *
 * @author martinfall
 */
public class Bar extends StackPane {

    // Private data fields
    private final Label label;
    private final Rectangle rectangle;
    private static final double WIDTH = 20;

    /**
     * Constructs a default bar object with a number parameter.
     *
     * @param number
     */
    public Bar(int number) {

        // Initialize the label
        label = new Label(Integer.toString(number));

        // Initialize the Rectangle
        rectangle = new Rectangle(WIDTH, WIDTH * number / 2);

        // Set the graphic and content display properties of the label object
        label.setGraphic(rectangle);
        label.setContentDisplay(ContentDisplay.BOTTOM);

        // Align nodes to the bottom of the stack pane
        setAlignment(Pos.BOTTOM_CENTER);

        // Add the label and rectangle to the pane
        getChildren().addAll(label, rectangle);
    }

    /**
     * Highlight the current bar.
     */
    protected void highlight() {
        rectangle.setFill(Color.RED);
    }
}
