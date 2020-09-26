
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Create a histogram for occurrences of letters) Write a program that reads a
 * file and displays a histogram to show the occurrences of each letter in the
 * file, as shown in Figure 16.40b. The file name is entered from a text field.
 * Pressing the Enter key on the text field causes the program to start to read
 * and process the file and displays the histogram. The histogram is displayed
 * in the center of the window. Define a class named Histogram that extends
 * Pane. The class contains the property counts that is an array of 26 elements.
 * counts[0] stores the number of A, counts[1] the number of B, and so on. The
 * class also contains a setter method for setting a new counts and displaying
 * the histogram for the new counts.
 *
 * /Users/martinfall/Downloads/book/Welcome.java
 *
 * @author martinfall
 */
public class LettersHistogram extends Application {

    private class Histogram extends Pane {

        // Data fields
        private static final double WIDTH = 400;
        private static final double HEIGHT = 300;
        private static final double BAR_WIDTH = WIDTH * 0.8 / 26;
        // private double height = 0;
        private int[] counts = new int[26];
        BorderPane pane = new BorderPane(); // For the bars and the letters
        Pane paneForLetters = new Pane();
        Pane paneForBars = new Pane();

        public Histogram() {
            setPrefSize(WIDTH, HEIGHT + 20);
            paneForBars.setPrefSize(WIDTH, HEIGHT);
            paneForLetters.setPrefSize(WIDTH, 20);
        }

        public int[] getCounts() {
            return counts;
        }

        public void setCounts(int[] counts) {
            this.counts = counts;
            display();
        }

        private void display() {
            // Find the letter with the highest occurrence
            int max = 0;
            for (int count : counts) {
                if (max < count) {
                    max = count;
                }
            }

            // Calculate the corresponding height for 1% if max is 100%
            double onePercent = HEIGHT / max;

            // Loop through counts and add bars to the histogram pane
            for (int i = 0; i < counts.length; i++) {
                // Create a new rectangle bar and set w, h, x, y
                Rectangle bar = new Rectangle();
                bar.setWidth(BAR_WIDTH);
                bar.setHeight(onePercent * counts[i]);
                bar.setX(i * (WIDTH / 26));
                bar.setY(HEIGHT - (onePercent * counts[i]));

                // UI Tweaks
                bar.setFill(Color.TRANSPARENT);
                bar.setStroke(Color.BLACK);
                // Add the bar to the histogram pane
                paneForBars.getChildren().add(bar);
            }

            // Loop through the letters of the alphabet and build the bottom legend
            for (int i = 0; i < 26; i++) {
                String letter = (char) ('A' + i) + "";
                // Build the label
                Label lblLetter = new Label();
                lblLetter.setText(letter);
                lblLetter.setLayoutX(i * (WIDTH / 26));
                lblLetter.setLayoutY(paneForLetters.getPrefHeight() / 3);
                
                // Add the label to the pane
                paneForLetters.getChildren().add(lblLetter);
            }
            
            // Add both panes to the border pane
            pane.setCenter(paneForBars);
            pane.setBottom(paneForLetters);
            
            // Add the border pane to the histogram
            getChildren().add(pane);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Local variable declarations and initializations
        Histogram histogram = new Histogram();

        // Label for the input pane
        Label lblFilename = new Label("Filename");

        // Text field for file input
        TextField tfInput = new TextField();
        tfInput.setPrefWidth(250);

        // Button to load the file in the viewer
        Button btView = new Button("View");

        /**
         * Inner class for handling action events.
         */
        class HistogramEventHandler implements EventHandler<ActionEvent> {

            @Override
            public void handle(ActionEvent e) {

                // Store the input in a string
                String filePath = tfInput.getText();

                File file = new File(filePath);
                if (!file.exists()) {
                    Label lblNoFileMessage = new Label("File does not exist. Please, try again.");
                    StackPane stackPane = new StackPane(lblNoFileMessage);
                    histogram.getChildren().add(stackPane);
                } else {
                    try {
                        // Create a path to the file
                        Path path = Paths.get(filePath);

                        // Reads all content from file into a string
                        String text = Files.readString(path);

                        // Process the text
                        int[] counts = process(text);

                        // Clear the pane
                        histogram.getChildren().clear();

                        // Set the counts in histogram and display it
                        histogram.setCounts(counts);
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        }

        // Create an instance of the event handler to pass to button and text field
        HistogramEventHandler eventHandler = new HistogramEventHandler();

        // HBox for the bottom of the border pane we're creating next
        HBox paneForInput = new HBox(10);
        paneForInput.setPadding(new Insets(10));
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.getChildren().addAll(lblFilename, tfInput, btView);

        // Border pane to hold the text area, label, text field, and button
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setCenter(histogram);
        pane.setBottom(paneForInput);

        // Event handlers for button and text field
        btView.setOnAction(eventHandler);

        tfInput.setOnAction(new HistogramEventHandler());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("LettersHistogram"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(true); // The stage is not resizable

        tfInput.requestFocus();
    }

    public int[] process(String text) {
        int[] counts = new int[26];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); // Grab a character from the text
            if (Character.isLetter(c)) { // If it is a letter
                c = Character.toUpperCase(c); // Convert to uppercase
                // Update counts at the
                counts[Character.getNumericValue(c) - Character.getNumericValue('A')]++;
            }
        }

        // Uncomment the following line of code to see counts in the console
        // System.out.println(Arrays.toString(counts));
        return counts;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
