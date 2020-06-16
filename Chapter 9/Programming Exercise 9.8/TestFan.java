
/**
 * Write a test program that creates two Fan objects. Assign maximum speed,
 * radius 10, color yellow, and turn it on to the first object. Assign medium
 * speed, radius 5, color blue, and turn it off to the second object. Display the
 * objects by invoking their toString method.
 *
 * Output:
 * speed: 3
 * color: yellow
 * radius: 10.0
 *
 * color: blue
 * radius: 5.0
 * fan is off
 *
 * @author martinfall
 */
public class TestFan {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Write a test program that creates two Fan objects
        Fan f1 = new Fan();
        Fan f2 = new Fan();

        // Assign maximum speed, radius 10, color yellow, and turn it on to the 
        // first object
        f1.setSpeed(Fan.FAST);
        f1.setRadius(10);
        f1.setColor("yellow");
        f1.setOn(true);

        // Assign medium speed, radius 5, color blue, and turn it off to the 
        // second object
        f2.setSpeed(Fan.MEDIUM);

        // The following three method calls are not needed because those are
        // default values
        // f2.setRadius(5);
        // f2.setColor("blue");
        // f2.setOn(false);
        // Display the objects by invoking their toString method.
        System.out.println(f1);
        System.out.println(f2);
    }
}
