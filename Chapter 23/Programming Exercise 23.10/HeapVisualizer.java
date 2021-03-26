package heapvisualizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Heap visualization) Write a program that displays a heap graphically, as
 * shown in Figure 23.10. The program lets you insert and delete an element from
 * the heap.
 *
 * Sample console output:
 * Heap{list=[12]}
 * Heap{list=[46, 12]}
 * Heap{list=[12]}
 * Heap{list=[]}
 * Please enter an integer.
 * Heap{list=[12]}
 * Heap{list=[43, 12]}
 * Heap{list=[43, 12, 9]}
 * Heap{list=[65, 43, 9, 12]}
 * Heap{list=[65, 43, 9, 12, 30]}
 * Heap{list=[65, 43, 9, 12, 30, 4]}
 * Heap{list=[81, 43, 65, 12, 30, 4, 9]}
 * Heap{list=[81, 43, 65, 12, 30, 4, 9, 0]}
 * Heap{list=[81, 56, 65, 43, 30, 4, 9, 0, 12]}
 * Heap{list=[81, 71, 65, 43, 56, 4, 9, 0, 12, 30]}
 * Heap{list=[81, 71, 65, 43, 56, 4, 9, 0, 12, 30, 10]}
 * Heap{list=[99, 71, 81, 43, 56, 65, 9, 0, 12, 30, 10, 4]}
 * Heap{list=[81, 71, 65, 43, 56, 4, 9, 0, 12, 30, 10]}
 * Heap{list=[71, 56, 65, 43, 30, 4, 9, 0, 12, 10]}
 * Heap{list=[65, 56, 10, 43, 30, 4, 9, 0, 12]}
 * Heap{list=[56, 43, 10, 12, 30, 4, 9, 0]}
 * Heap{list=[43, 30, 10, 12, 0, 4, 9]}
 * Heap{list=[30, 12, 10, 9, 0, 4]}
 * Heap{list=[12, 9, 10, 4, 0]}
 * Heap{list=[10, 9, 0, 4]}
 * Heap{list=[9, 4, 0]}
 * Heap{list=[4, 0]}
 * Heap{list=[0]}
 * Heap{list=[]}
 * Heap{list=[]}
 * Please enter an integer.
 * Please enter an integer.
 * Please enter an integer.
 *
 * @author martinfall
 */
public class HeapVisualizer extends Application {

    /**
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override // Override the start method of the Application class
    public void start(Stage primaryStage) throws Exception {
        HeapPane heapPane = new HeapPane();

        Scene scene = new Scene(heapPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Heap Visualizer");
        primaryStage.show();
    }
}
