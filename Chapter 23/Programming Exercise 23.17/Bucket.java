package radixsorter;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Lays out a single Bucket with its contents and label.
 *
 * @author martinfall
 */
public class Bucket extends BorderPane {

    /**
     * Data fields of the Bucket class.
     *
     * @param bucket - array list of integers in the bucket
     * 
     * @param paneForBucket - a VBox holding the contents of bucket as labels
     * @param labelForBucket - a label that contains the bucket's index
     * @param boderForBucket - a border that encases the contents of bucket
     */
    private ArrayList<Integer> bucket;
    
    private VBox paneForBucket;
    private final Label labelForBucket;
    private final Border borderForBucket = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));

    /**
     * Default constructor of the Bucket class.
     *
     * @param bucketIndex
     * @param bucket
     */
    public Bucket(int bucketIndex, ArrayList<Integer> bucket) {
        // Initialize the bucket index and list data fields
        this.bucket = bucket;

        // Initialize the label for the current bucket
        labelForBucket = new Label("bucket [" + bucketIndex + "]");

        // Initiialize the pane for bucket
        paneForBucket = new VBox();
        paneForBucket.setAlignment(Pos.TOP_LEFT); // Align the pane's content
        paneForBucket.setBorder(borderForBucket);
        paneForBucket.setPadding(new Insets(5));
        paneForBucket.setPrefHeight(200);

        // Add the numbers in the bucket to the pane for bucket as labels
        bucket.forEach(element -> {
            Label labelForElement = new Label(Integer.toString(element));
            paneForBucket.getChildren().add(labelForElement);
        });

        // Set the bucket's pane in the center and the label at the bottom
        setCenter(paneForBucket);
        setBottom(labelForBucket);

        // Set the value of the property padding to 10
        setPadding(new Insets(10));
    }

    /**
     * Instance method that highlights the element at the specified index.
     *
     * @param bucketElementIndex
     */
    public void highlight(int bucketElementIndex) {
        // Clear the pane for bucket
        paneForBucket.getChildren().clear();

        for (int i = 0; i < bucket.size(); i++) {
            // Create new lebel from the element at index i in bucket array list
            Label labelForElement = new Label(Integer.toString(bucket.get(i)));

            // Highlight the current number in the bucket
            if (i == bucketElementIndex) {
                labelForElement.setTextFill(Color.RED);
                labelForElement.setFont(Font.font(Font.getDefault().getName(),
                        FontWeight.EXTRA_BOLD, Font.getDefault().getSize()));
            }

            // Add the label to the pane for bucket
            paneForBucket.getChildren().add(labelForElement);
        }

        // Add the updated pane for bucket to the center of the borderpane
        setCenter(paneForBucket);
    }
}
