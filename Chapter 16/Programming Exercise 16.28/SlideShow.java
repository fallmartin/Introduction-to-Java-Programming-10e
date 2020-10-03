
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Slide show) Programming Exercise 15.30 developed a slide show using images.
 * Rewrite that program to develop a slide show using text files. Suppose ten
 * text files named slide0.txt, slide1.txt, . . . , and slide9.txt are stored in
 * the text directory. Each slide displays the text from one file. Each slide is
 * shown for one second, and the slides are displayed in order. When the last
 * slide finishes, the first slide is redisplayed, and so on. Use a text area to
 * display the slide.
 *
 * Original Program Requirements:
 * (Slide show) Twenty-five slides are stored as image files (slide0.jpg,
 * slide1.jpg, . . . , slide24.jpg) in the image directory downloadable along
 * with the source code in the book. The size of each image is 800 * 600. Write
 * a program that automatically displays the slides repeatedly. Each slide is
 * shown for two seconds. The slides are displayed in order. When the last slide
 * finishes, the first slide is redisplayed, and so on. Click to pause if the
 * animation is currently playing. Click to resume if the animation is currently
 * paused.
 *
 * @author martinfall
 */
public class SlideShow extends Application {

    // Constants
    private final static int WIDTH = 800; // Pane width
    private final static int HEIGHT = 600; // Pane height

    // Duration per slide
    private final static Duration DURATION = Duration.seconds(1);

    // Total number of slides
    private final static int NUMBER_OF_SLIDES = 10;

    // Global index for retrieving slides from image view array
    private int index = 0;

    // Create an array of files
    private File[] files = new File[NUMBER_OF_SLIDES];

    // Create a text area data field
    TextArea taSlide = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a new pane
        Pane pane = new Pane();
        pane.setPrefWidth(WIDTH);
        pane.setPrefHeight(HEIGHT);

        // Populate the file array
        for (int i = 0; i < NUMBER_OF_SLIDES; i++) {
            // /Users/martinfall/NetBeansProjects/Programming_Exercise_16_28/src/text/slide0.txt
            files[i] = new File("/Users/martinfall/NetBeansProjects/"
                    + "Programming_Exercise_16_28/src/text/slide" + i + ".txt");
        }

        // Set text area properties
        taSlide.setWrapText(true);
        taSlide.setEditable(false);
        
        // Set the text area to fill the pane fully
        taSlide.prefWidthProperty().bind(pane.prefWidthProperty());
        taSlide.prefHeightProperty().bind(pane.prefHeightProperty());

        // Place the content of slide0.txt in the text area
        taSlide.setText(Files.readString(files[0].toPath()));

        // Place the first slide in the pane 
        pane.getChildren().add(taSlide);
        System.out.println("Displaying slide " + index); // Console
        index++; // Increment the global index

        // Create a new keyframe
        KeyFrame keyFrame = new KeyFrame(DURATION, e -> {
            // If the index is greater than the number of slides
            if (index >= NUMBER_OF_SLIDES) {
                index = 0; // Start from the beginning
            }

            try {
                taSlide.setText(Files.readString(files[index].toPath()));
            } catch (IOException ex) {
                System.out.println(ex);
            }

            System.out.println("Displaying slide " + index); // Console
            index++; // Increment the global index

        });

        // Create a new timeline animation
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Event handler for mouse click (pause/resume)
        EventHandler<MouseEvent> onClick = e -> {
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.pause();
                System.out.println("Paused");
            } else {
                timeline.play();
                System.out.println("Playing");
            }
        };

        // Register onClick with the text area
        taSlide.setOnMouseClicked(onClick);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("SlideShow"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

        taSlide.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
