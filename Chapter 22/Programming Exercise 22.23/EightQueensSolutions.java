package eightqueens;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class EightQueensSolutions extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EightQueens eightQueens = new EightQueens();
        ArrayList<Integer[]> solutions = eightQueens.getSolutions();

        HBox paneForSolutions = new HBox(10);
        
        Iterator<Integer[]> iterator = solutions.iterator();
        int solutionCounter = 1;

        while (iterator.hasNext()) {
            Label lblSolution = new Label("Solution " + solutionCounter++);
            EightQueensPane eightQueensPane
                    = new EightQueensPane(iterator.next());

            BorderPane solutionPane = new BorderPane();
            solutionPane.setTop(lblSolution);
            solutionPane.setCenter(eightQueensPane);
            BorderPane.setAlignment(lblSolution, Pos.CENTER);
            solutionPane.setPadding(new Insets(5));

            paneForSolutions.getChildren().add(solutionPane);
        }

        ScrollPane scrollPane = new ScrollPane(paneForSolutions);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefViewportWidth(1000);

        Scene scene = new Scene(scrollPane);
        stage.setTitle("Eight Queens");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
