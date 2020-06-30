/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class RectangleFromSimpleGeometricObject extends SimpleGeometricObject {

    private double width;
    private double height;

    public RectangleFromSimpleGeometricObject() {

    }

    public RectangleFromSimpleGeometricObject(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public RectangleFromSimpleGeometricObject(double width, double height,
            String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
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

    /**
     * Return area
     *
     * @return
     */
    public double getArea() {
        return width * height;
    }

    /**
     * Return perimeter
     *
     * @return
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
