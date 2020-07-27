/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * (The Colorable interface) Design an interface named Colorable with a void
 * method named howToColor(). Every class of a colorable object must implement
 * the Colorable interface. Design a class named Square that extends
 * GeometricObject and implements Colorable. Implement howToColor to
 * display the message Color all four sides.
 *
 * Draw a UML diagram that involves Colorable, Square, and GeometricObject.
 * Write a test program that creates an array of five GeometricObjects. For each
 * object in the array, display its area and invoke its howToColor method if it
 * is colorable.
 *
 * @author martinfall
 */
public class Square extends GeometricObject implements Colorable {

    double side = 1; // Arbitrary default value

    /**
     * Constructs a Square object with default value.
     */
    public Square() {
    }

    /**
     * Constructs a Square object with side value.
     *
     * @param side
     */
    public Square(double side) {
        this.side = side;
    }

    @Override // Implement the abstract getArea() method of GeometricObject class.
    public double getArea() {
        return side * side;
    }

    @Override // Implement the abstract getPerimeter() method of GeometricObject class.
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

}
