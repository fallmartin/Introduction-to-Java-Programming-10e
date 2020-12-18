
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Store numbers in a linked list) Write a program that lets the user enter
 * numbers from a graphical user interface and displays them in a text area, as
 * shown in Figure 20.17a. Use a linked list to store the numbers. Do not store
 * duplicate numbers. Add the buttons Sort, Shuffle, and Reverse to sort,
 * shuffle, and reverse the list.
 *
 * @author martinfall
 */
public class StoreNumbers extends Application {

    // Data fields
    private TextField tfInput = new TextField(); // Text field for input
    private TextArea textArea = new TextArea(); // Text area for display
    private List<Integer> list = new ArrayList<>(); // List for storing numbers

    @Override // Override the start method in the Application class.
    public void start(Stage primaryStage) throws Exception {

        // Create the pane for input
        Label lbInput = new Label("Enter a number: ");
        HBox paneForInput = new HBox(10);
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.setPadding(new Insets(10));
        paneForInput.getChildren().addAll(lbInput, tfInput);

        // Create the text area for displaying the numbers
        textArea.setPrefColumnCount(30);
        textArea.setPrefRowCount(10);
        textArea.setWrapText(false);
        ScrollPane scrollPane = new ScrollPane(textArea);

        // Create a pane for the sort, shuffle, and reverse buttons
        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        HBox paneForButtons = new HBox(10);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(10));
        paneForButtons.getChildren().addAll(btSort, btShuffle, btReverse);

        // Create a border pane for pane for input, text area, and buttons pane
        BorderPane pane = new BorderPane();
        pane.setTop(paneForInput);
        pane.setCenter(textArea);
        pane.setBottom(paneForButtons);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("Exercise20_02"); // Set the stage title
        primaryStage.show(); // Display the stage

        /**
         * Event handlers for tfInput, btSort, btShuffle, btReverse
         */
        tfInput.setOnAction(e -> {
            // Add the integer to the list and clear the text field
            list.add(Integer.parseInt(tfInput.getText()));
            tfInput.clear();
            updateTextArea();
        });

        btSort.setOnAction(e -> {
            Collections.sort(list);
            updateTextArea();
        });

        btShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            updateTextArea();
        });

        btReverse.setOnAction(e -> {
            Collections.reverse(list);
            updateTextArea();
        });
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Updates the contents of the text area.
     */
    public void updateTextArea() {
        // Create an empty string
        String listString = "";

        // Clear the text area
        textArea.clear();

        // Iterate through and display the contents of list 
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            listString += iterator.next() + " ";
        }
        // Update the text area's contents
        textArea.setText(listString);
    }
}
