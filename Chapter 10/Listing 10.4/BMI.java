/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class BMI {

    private String name; // The name of the person.
    private int age; // The age of the person.
    private double weight; // The weight of the person in pounds.
    private double height; // The height of the person in inches.
    // Constants
    public static final double KILOGRAMS_PER_POUND = 0.45359237;
    public static final double METERS_PER_INCH = 0.0254;

    /**
     * Creates a BMI object with the specified name, age, weight, and height.
     *
     * @param name
     * @param age
     * @param weight
     * @param height
     */
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    /**
     * Creates a BMI object with the specified name, weight, height, and a
     * default age 20.
     *
     * @param name
     * @param weight
     * @param height
     */
    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height);
    }

    /**
     * Returns the person's name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the person's age in years..
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the persons weight in pounds.
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the person's height in inches.
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the BMI.
     *
     * @return
     */
    public double getBMI() {
        double bmi = getWeight() * KILOGRAMS_PER_POUND
                / (Math.pow(getHeight() * METERS_PER_INCH, 2));
        return Math.round(bmi * 100) / 100.0;
    }

    /**
     * Returns the BMI status (e.g., normal, overweight, etc.).
     *
     * @return
     */
    public String getStatus() {
        double bmi = getBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
