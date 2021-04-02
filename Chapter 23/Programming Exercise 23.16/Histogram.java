package bubblesort;

import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

/**
 * Represents a histogram in a flow pane.
 *
 * @author martinfall
 */
public class Histogram extends FlowPane {

    /**
     * Constructs a default histogram with an array and the index of the current
     * node highlighted.
     *
     * @param index
     * @param array
     */
    public Histogram(int index, int[] array) {
        setHgap(1); // 1 pixel horizontal gap

        // Construct the histogram bar by bar
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            Bar bar = new Bar(element);

            // Highlight the current bar
            if (i == array.length - index - 1) {
                bar.highlight();
            }

            // Add the bar to the pane
            getChildren().add(bar);
        }

        // Set the alignment and preferred size properties
        setAlignment(Pos.CENTER);
        setPrefSize(500, 300);
    }
}
