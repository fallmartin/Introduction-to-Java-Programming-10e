
/**
 *
 * @author martinfall
 */
public class Rectangle extends GeometricObject {

    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Return width
     *
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set a new width
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return height
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set a new height
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    /**
     * Return area
     */
    public double getArea() {
        return width * height;
    }

    @Override
    /**
     * Return perimeter
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
