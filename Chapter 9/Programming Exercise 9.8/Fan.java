
/**
 * (The Fan class) Design a class named Fan to represent a fan. The class contains:
 *
 * ■ Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to
 * denote the fan speed.
 * ■ A private int data field named speed that specifies the speed of the fan (the
 * default is SLOW).
 * ■ A private boolean data field named on that specifies whether the fan is on (the
 * default is false).
 * ■ A private double data field named radius that specifies the radius of the fan
 * (the default is 5).
 * ■ A string data field named color that specifies the color of the fan (the default
 * is blue).
 * ■ The accessor and mutator methods for all four data fields.
 * ■ A no-arg constructor that creates a default fan.
 * ■ A method named toString() that returns a string description for the fan. If
 * the fan is on, the method returns the fan speed, color, and radius in one combined
 * string. If the fan is not on, the method returns the fan color and radius
 * along with the string “fan is off” in one combined string.
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that creates two Fan objects. Assign maximum speed, radius 10, color
 * yellow, and turn it on to the first object. Assign medium speed, radius 5, color
 * blue, and turn it off to the second object. Display the objects by invoking their
 * toString method.
 *
 * @author martinfall
 */
public class Fan {

    // Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to
    // denote the fan speed.
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;

    // A private int data field named speed that specifies the speed of the fan (the
    // default is SLOW).
    private int speed;

    // A private boolean data field named on that specifies whether the fan is on (the
    // default is false).
    private boolean on;

    // A private double data field named radius that specifies the radius of the fan
    // (the default is 5).
    private double radius;

    // A string data field named color that specifies the color of the fan (the default
    // is blue).
    private String color;

    // A no-arg constructor that creates a default fan.
    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    // The accessor and mutator methods for all four data fields.
    // Accessor methods
    public int getSpeed() {
        return this.speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    // Mutators
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // A method named toString() that returns a string description for the fan. If
    // the fan is on, the method returns the fan speed, color, and radius in one 
    // combined string. If the fan is not on, the method returns the fan color and
    // radius along with the string “fan is off” in one combined string.
    @Override
    public String toString() {
        String str = "";
        if (this.isOn()) {
            str += "speed: " + getSpeed()
                    + "\ncolor: " + getColor()
                    + "\nradius: " + getRadius();
        } else {
            str += "\ncolor: " + getColor()
                    + "\nradius: " + getRadius()
                    + "\nfan is off";
        }
        return str;
    }
}
