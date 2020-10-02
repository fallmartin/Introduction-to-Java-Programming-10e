
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * (Display country flag and flag description) Listing 16.4, ComboBoxDemo.java,
 * gives a program that lets the user view a country’s flag image and
 * description by selecting the country from a combo box. The description is a
 * string coded in the program. Rewrite the program to read the text description
 * from a file. Suppose that the descriptions are stored in the files
 * description0.txt, . . . , and description8.txt under the text directory for
 * the nine countries Canada, China, Denmark, France, Germany, India, Norway,
 * United Kingdom, and United States, in this order.
 *
 * @author martinfall
 */
public class CountryFlagDescription extends Application {

    // Declare an array of strings for the flag titles
    private String[] flagTitles = {
        "Canada",
        "China",
        "Denmark",
        "France",
        "Germany",
        "India",
        "Norway",
        "United Kingdom",
        "United States of America"};

    // Declare an image view array for the national flags of 9 countries
    private ImageView[] flagImages = {
        new ImageView("images/ca.gif"),
        new ImageView("images/china.gif"),
        new ImageView("images/denmark.gif"),
        new ImageView("images/fr.gif"),
        new ImageView("images/germany.gif"),
        new ImageView("images/india.gif"),
        new ImageView("images/norway.gif"),
        new ImageView("images/uk.gif"),
        new ImageView("images/us.gif"),};

    // Declare an array of files for the flag descriptions
    private File[] flagDescriptions = new File[9];

    // Create and declare a description pane
    private DescriptionPane descriptionPane = new DescriptionPane();

    // Create a combo box for selecting countries
    private ComboBox<String> cbo = new ComboBox<>();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Set the first country (Canada) for display
        setDisplay(0);

        // Add combo box and description pane to the border pane
        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);

        BorderPane pane = new BorderPane();
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        ObservableList<String> items
                = FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        // Display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("CountryFlagDescription"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void setDisplay(int index) {
        try {
            //
            Path path = new File("/Users/martinfall/NetBeansProjects/"
                    + "Programming_Exercise_16_27/src/text/description"
                    + index + ".txt").toPath();
            descriptionPane.setTitle(flagTitles[index]);
            descriptionPane.setImageView(flagImages[index]);
            descriptionPane.setDescription(Files.readString(path));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
