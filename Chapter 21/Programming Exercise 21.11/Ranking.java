
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Baby name popularity ranking) Use the data files from Programming Exercise
 * 12.31 to write a program that enables the user to select a year, gender, and
 * enter a name to display the ranking of the name for the selected year and
 * gender, as shown in Figure 21.9. To achieve the best efficiency, create two
 * arrays for boy’s names and girl’s names, respectively. Each array has 10
 * elements for 10 years. Each element is a map that stores a name and its
 * ranking in a pair with the name as the key. Assume the data files are stored
 * at www.cs.armstrong .edu/liang/data/babynamesranking2001.txt, . . . , and
 * www.cs.armstrong.edu/liang/data/ babynamesranking2010.txt.
 *
 * @author martinfall
 */
public class Ranking extends Application {

    // Constants
    private static final int numberOfFiles = 10;

    // Data fields
    private ComboBox<Integer> cbYear;
    private ComboBox<String> cbGender;
    private TextField tfName;

    // Create two array data fields for boy’s names and girl’s names
    // Array lists maintain insertion order, so this works for this problem
    private ArrayList<Map<String, Integer>> boys = new ArrayList<>(numberOfFiles);
    private ArrayList<Map<String, Integer>> girls = new ArrayList<>(numberOfFiles);

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override // Override the start method of the Application class
    public void start(Stage stage) throws Exception {
        // Populate the arrays for boy’s names and girl’s names
        populate();

        // Create a GUI
        BorderPane pane = getPane();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene); // Place the scene in the stage
        stage.setTitle("Baby Name Popularity Ranking"); // Set the stage title
        stage.show(); // Display the stage
        stage.setResizable(false); // Make the stage non-resizable
    }

    private BorderPane getPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);

        // Year selection
        Label lblYear = new Label("Select a year:");
        Integer[] years
                = {2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2008, 2010};
        cbYear = new ComboBox<>(FXCollections.observableArrayList(years));
        grid.addRow(0, lblYear, cbYear); // Add to grid

        // Gender selection
        Label lblGender = new Label("Boy or girl?");
        cbGender = new ComboBox<>();
        cbGender.getItems().addAll("Male", "Female");
        grid.addRow(1, lblGender, cbGender); // Add to grid

        // Name input
        Label lblName = new Label("Enter a name:");
        tfName = new TextField();
        tfName.setPrefColumnCount(15);
        grid.addRow(2, lblName, tfName); // Add to grid

        // Find Ranking button
        Button btRank = new Button("Find Ranking");
        grid.add(btRank, 1, 3); // Add to grid

        // Results
        Label lblResults = new Label();

        // Build the border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(grid);
        pane.setBottom(lblResults);
        BorderPane.setAlignment(lblResults, Pos.CENTER);

        // Event handler for the Find Ranking button
        btRank.setOnAction(e -> {
            // Convenience vars for getRank method
            String gender = cbGender.getValue() == "Male" ? "Boy" : "Girl";
            String name = tfName.getText();
            int year = cbYear.getValue();
            int rank = getRank(gender, name, year);

            // Format strings for label
            // If the name is ranked
            String result = String.format("%s name %s is ranked #%d in year %d",
                    gender, name, rank, year);
            // If the name is not ranked
            String fail = String.format("%s name %s is not ranked in year %d",
                    gender, name, year);
            // Update the label
            lblResults.setText(rank == 0 ? fail : result);
        });

        // Return the border pane
        return pane;
    }

    public void populate() throws Exception {
        // Create an array of data files stored locally 
        ArrayList<File> files = new ArrayList<>(numberOfFiles);

        // Populate the array with data files stored locally
        for (int i = 2001; i <= 2010; i++) {
            File file = new File("src/babynamesranking" + i + ".txt");
            if (file.exists()) {
                files.add(file);
                // Uncomment the two lines below to check if file exists
                // System.out.println("File " + file.getName() + " exists.");
            } else {
                // System.out.println("File " + file.getName() + " does not exist.");
            }
        }

        // Iterate over and process the files in the array list
        Iterator<File> iterator = files.iterator();
        while (iterator.hasNext()) {
            // Create hash maps for the boy and girl names for the current year
            Map<String, Integer> boyNames = new HashMap<>();
            Map<String, Integer> girlNames = new HashMap<>();

            // Create a scanner and process the contents of each file
            Scanner scanner = new Scanner(iterator.next());

            // Scan the contents of each file line per line
            while (scanner.hasNext()) {
                // Scan a line, split the string, and remove null elements
                String[] tokens = scanner.nextLine().split("[\\t ]");

                // Create an array of line tokens without null elements
                String[] clean = new String[5];
                int cleanIndex = 0;
                for (String token : tokens) {
                    if (!token.equals("")) {
                        clean[cleanIndex] = token;
                        cleanIndex++;
                    }
                }

                // Array format: rank, boy name, number, girl name, number
                int rank = Integer.parseInt(clean[0]);
                String boy = clean[1];
                String girl = clean[3];

                // Update boy and girl name maps
                boyNames.put(boy, rank);
                girlNames.put(girl, rank);
            }
            boys.add(boyNames);
            girls.add(girlNames);
        }

        // Uncomment the two lines below to check the size of array lists
        // System.out.println(boys.size());
        // System.out.println(girls.size());
    }

    private int getRank(String gender, String name, int year) {
        int yearIndex = (year % 2000) - 1;
        int rank = 0; // Return 0 if the name is not ranked
        
        // If the name is male
        if (gender.equals("Boy")) {
            Map<String, Integer> map = boys.get(yearIndex);
            if (map.containsKey(name)) {
                rank = map.get(name);
            }
        } // If the name is male
        else if (gender.equals("Girl")) {
            Map<String, Integer> map = girls.get(yearIndex);
            if (map.containsKey(name)) {
                rank = map.get(name);
            }
        }

        return rank;
    }
}
