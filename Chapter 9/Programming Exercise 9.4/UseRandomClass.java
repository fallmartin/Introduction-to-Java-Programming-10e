
import java.util.Random;

/**
 * (Use the Random class) Write a program that creates a Random object with seed
 * 1000 and displays the first 50 random integers between 0 and 100 using the
 * nextInt(100) method.
 *
 * Output:
 * r.nextInt(100) = 87
 * r.nextInt(100) = 35
 * r.nextInt(100) = 76
 * r.nextInt(100) = 24
 * r.nextInt(100) = 92
 * r.nextInt(100) = 49
 * r.nextInt(100) = 41
 * r.nextInt(100) = 45
 * r.nextInt(100) = 64
 * r.nextInt(100) = 50
 * r.nextInt(100) = 79
 * r.nextInt(100) = 59
 * r.nextInt(100) = 72
 * r.nextInt(100) = 83
 * r.nextInt(100) = 36
 * r.nextInt(100) = 75
 * r.nextInt(100) = 46
 * r.nextInt(100) = 2
 * r.nextInt(100) = 23
 * r.nextInt(100) = 41
 * r.nextInt(100) = 22
 * r.nextInt(100) = 71
 * r.nextInt(100) = 89
 * r.nextInt(100) = 2
 * r.nextInt(100) = 93
 * r.nextInt(100) = 42
 * r.nextInt(100) = 49
 * r.nextInt(100) = 42
 * r.nextInt(100) = 35
 * r.nextInt(100) = 76
 * r.nextInt(100) = 32
 * r.nextInt(100) = 0
 * r.nextInt(100) = 52
 * r.nextInt(100) = 95
 * r.nextInt(100) = 87
 * r.nextInt(100) = 31
 * r.nextInt(100) = 99
 * r.nextInt(100) = 18
 * r.nextInt(100) = 79
 * r.nextInt(100) = 2
 * r.nextInt(100) = 91
 * r.nextInt(100) = 5
 * r.nextInt(100) = 55
 * r.nextInt(100) = 84
 * r.nextInt(100) = 71
 * r.nextInt(100) = 95
 * r.nextInt(100) = 58
 * r.nextInt(100) = 87
 * r.nextInt(100) = 77
 * r.nextInt(100) = 38
 *
 * @author martinfall
 */
public class UseRandomClass {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Random object with seed 1000
        Random r = new Random(1000);

        // Display the first 50 random integers between 0 and 100 using the
        // nextInt(100) method
        for (int i = 0; i < 50; i++) {
            System.out.println("r.nextInt(100) = " + r.nextInt(100));
        }
    }
}
