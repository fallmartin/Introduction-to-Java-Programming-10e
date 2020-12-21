
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Game: hangman) Programming Exercise 7.35 presents a console version of the
 * popular hangman game. Write a GUI program that lets a user play the game. The
 * user guesses a word by entering one letter at a time, as shown in Figure
 * 20.18. If the user misses seven times, a hanging man swings. Once a word is
 * finished, the user can press the Enter key to continue to guess another word.
 *
 * @author martinfall
 */
public class GameHangman extends Application {

    @Override // Override the start method of the Application class
    public void start(Stage primaryStage) {
        HangmanPane hangmanPane = new HangmanPane();
        
        // Create a new scene and add it to the primary stage
        Scene scene = new Scene(hangmanPane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("Hangman");
        primaryStage.setResizable(false); // Make the stage non resizable
        primaryStage.show(); // Display the stage
        
        // Request focus
        hangmanPane.requestFocus();
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
