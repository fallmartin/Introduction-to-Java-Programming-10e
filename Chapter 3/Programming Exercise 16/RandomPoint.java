
/**
 * (Random point) Write a program that displays a random coordinate in a
 * rectangle. The rectangle is centered at (0, 0) with width 100 and height 200.
 */
/**
 *
 * @author martinfall
 */
public class RandomPoint {

    public static void main(String[] args) {
        // The rectange is centered at (0, 0) with width 100 and height 200
        for (int i = 0; i < 100; i++) { // Loop through 100 coordinates for testing
            // Reminder: (Math.random() * ((max - min) + 1)) + min
            // Generate x such that -50 <= x <= 50
            int x = (int) ((Math.random() * 101) - 50);

            // Generate y such that -100 <= y <= 100
            int y = (int) (Math.random() * 201) - 100;

            // Display the random coordinate in the rectangle
            System.out.println("(" + x + ", " + y + ")");
        }
    }
}
