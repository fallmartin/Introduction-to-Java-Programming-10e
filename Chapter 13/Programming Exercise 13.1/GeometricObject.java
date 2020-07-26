
import java.util.Date;

/**
 * (Triangle class) Design a new Triangle class that extends the abstract
 * GeometricObject class. Draw the UML diagram for the classes Triangle and
 * GeometricObject and then implement the Triangle class. Write a test program
 * that prompts the user to enter three sides of the triangle, a color, and a
 * Boolean value to indicate whether the triangle is filled. The program should
 * create a Triangle object with these sides and set the color and filled
 * properties using the input. The program should display the area, perimeter,
 * color, and true or false to indicate whether it is filled or not.
 *
 * @author martinfall
 */
public abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /**
     * Constructs a default geometric object.
     */
    protected GeometricObject() {
        dateCreated = new Date();
    }

    /**
     * Constructs a geometric object with color and filled value.
     *
     * @param color
     * @param filled
     */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }

    /**
     * Returns color.
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color.
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean, the get method is named isFilled.
     *
     * @return
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled.
     *
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated.
     *
     * @return
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated
                + "\ncolor: " + color + " and filled: " + filled;
    }

    /**
     * Abstract method getArea.
     *
     * @return
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter.
     *
     * @return
     */
    public abstract double getPerimeter();
}
